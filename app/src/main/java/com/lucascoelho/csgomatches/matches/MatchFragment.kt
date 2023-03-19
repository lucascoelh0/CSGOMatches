package com.lucascoelho.csgomatches.matches

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.lucascoelho.csgomatches.R
import com.lucascoelho.csgomatches.databinding.FragmentMatchBinding
import com.lucascoelho.csgomatches.datasource.matches.entities.model.MatchModel
import com.lucascoelho.csgomatches.matches.view.TeamOneAdapter
import com.lucascoelho.csgomatches.matches.view.TeamTwoAdapter
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MatchFragment : Fragment() {

    private lateinit var viewModel: MatchViewModel
    private lateinit var teamOneAdapter: TeamOneAdapter
    private lateinit var teamTwoAdapter: TeamTwoAdapter
    private val args: MatchFragmentArgs by navArgs()

    private var _binding: FragmentMatchBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = getViewModel()
        _binding = FragmentMatchBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
        setupRecyclerView()
        setupObservers()
        setupViews(args.match)
        viewModel.fetchTeamDetails(args.match.opponents)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupObservers() {
        viewModel.teamOne.observe(viewLifecycleOwner) {
            teamOneAdapter.update(it)
        }
        viewModel.teamTwo.observe(viewLifecycleOwner) {
            teamTwoAdapter.update(it)
        }
    }

    private fun setupListeners() {
        binding.imageViewArrowBack.setOnClickListener {
            try {
                findNavController().navigate(R.id.action_MatchFragment_to_MatchListFragment)
            } catch (ignored: Exception) {
                // TODO: Tratar exceção
            }
        }
    }

    private fun setupRecyclerView() {
        teamOneAdapter = TeamOneAdapter()
        teamTwoAdapter = TeamTwoAdapter()
        binding.recyclerViewTeamOne.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = teamOneAdapter
        }
        binding.recyclerViewTeamTwo.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = teamTwoAdapter
        }
    }

    private fun setupViews(match: MatchModel) {
        binding.textViewMatchTitle.text = binding.root.context.getString(
            R.string.league_serie,
            match.league.name,
            if (match.serie.name.isNullOrEmpty()) "" else "| ${match.serie.name}"
        )
        when (match.opponents.size) {
            1 -> {
                binding.teamInfoContainer.apply {
                    match.opponents[0].opponent.run {
                        textViewFirstTeamName.text = this.name
                        Glide.with(binding.root.context)
                            .load(this.image_url)
                            .placeholder(R.drawable.background_round)
                            .into(imageViewFirstTeam)
                    }
                    textViewSecondTeamName.text = binding.root.context.getString(R.string.tbd)
                    imageViewSecondTeam.setImageDrawable(
                        AppCompatResources.getDrawable(
                            binding.root.context,
                            R.drawable.background_round
                        )
                    )
                }
            }
            2 -> {
                binding.teamInfoContainer.apply {
                    match.opponents[0].opponent.run {
                        textViewFirstTeamName.text = this.name
                        Glide.with(binding.root.context)
                            .load(this.image_url)
                            .placeholder(R.drawable.background_round)
                            .into(imageViewFirstTeam)
                    }
                    match.opponents[1].opponent.run {
                        textViewSecondTeamName.text = this.name
                        Glide.with(binding.root.context)
                            .load(this.image_url)
                            .placeholder(R.drawable.background_round)
                            .into(imageViewSecondTeam)
                    }
                }
            }
        }
    }
}