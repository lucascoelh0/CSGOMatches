package com.lucascoelho.csgomatches.matches

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.lucascoelho.csgomatches.common.extensions.setGone
import com.lucascoelho.csgomatches.common.extensions.setVisible
import com.lucascoelho.csgomatches.databinding.FragmentMatchListBinding
import com.lucascoelho.csgomatches.datasource.matches.entities.model.MatchModel
import com.lucascoelho.csgomatches.matches.view.MatchesAdapter
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MatchListFragment : Fragment() {

    private lateinit var viewModel: MatchListViewModel
    private lateinit var matchesAdapter: MatchesAdapter

    private var _binding: FragmentMatchListBinding? = null
    private val binding get() = _binding!!

    private val onMatchClicked: (MatchModel) -> Unit = { match ->
        if (match.opponents.isNotEmpty()) {
            val action = MatchListFragmentDirections.actionMatchListFragmentToMatchFragment(match)
            try {
                findNavController().navigate(action)
            } catch (ignored: Exception) {
                // TODO: Tratar exceção
            }
        } else {
            Toast.makeText(
                requireContext(),
                "Os times desta partida ainda não foram definidos.",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = getViewModel()
        _binding = FragmentMatchListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        setupListeners()
        setupRecyclerView()
        viewModel.fetchMatches()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupObservers() {
        viewModel.matches.observe(viewLifecycleOwner) {
            matchesAdapter.update(it)
            binding.apply {
                progressBarLoading.setGone()
                swipeRefreshLayoutMatchDetailsContainer.setVisible()
                swipeRefreshLayoutMatchDetailsContainer.isRefreshing = false
            }
        }
    }

    private fun setupListeners() {
        binding.swipeRefreshLayoutMatchDetailsContainer.setOnRefreshListener {
            viewModel.fetchMatches()
        }
    }

    private fun setupRecyclerView() {
        matchesAdapter = MatchesAdapter(onMatchClicked)
        binding.recyclerViewMatches.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = matchesAdapter
        }
    }
}
