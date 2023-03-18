package com.lucascoelho.csgomatches.matches

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.lucascoelho.csgomatches.databinding.FragmentMatchListBinding
import com.lucascoelho.csgomatches.matches.view.MatchesAdapter
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MatchListFragment : Fragment() {

    private lateinit var viewModel: MatchListViewModel
    private lateinit var matchesAdapter: MatchesAdapter

    private var _binding: FragmentMatchListBinding? = null
    private val binding get() = _binding!!

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
        setupRecyclerView()
        viewModel.updateMatches()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupRecyclerView() {
        matchesAdapter = MatchesAdapter()
        binding.recyclerViewMatches.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = matchesAdapter
        }
    }

    private fun setupObservers() {
        viewModel.matches.observe(viewLifecycleOwner) {
            matchesAdapter.update(it)
        }
    }
}
