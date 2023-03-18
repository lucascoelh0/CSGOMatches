package com.lucascoelho.csgomatches.matches.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lucascoelho.csgomatches.databinding.ItemMatchBinding
import com.lucascoelho.csgomatches.datasource.matches.entities.Match

class MatchesAdapter: RecyclerView.Adapter<MatchesAdapter.MatchesViewHolder>() {

    private var matchesList = mutableListOf<Match>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchesViewHolder {
        val binding = ItemMatchBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MatchesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MatchesViewHolder, position: Int) {
        holder.onBind(matchesList[position])
    }

    override fun getItemCount(): Int {
        return matchesList.size
    }

    inner class MatchesViewHolder(private val binding: ItemMatchBinding): RecyclerView.ViewHolder(binding.root) {

        fun onBind(match: Match) {
        }
    }

    fun update(newList: List<Match>) {
        matchesList.clear()
        matchesList.addAll(newList)
        notifyDataSetChanged()
    }
}
