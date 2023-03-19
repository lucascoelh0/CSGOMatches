package com.lucascoelho.csgomatches.matches.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lucascoelho.csgomatches.R
import com.lucascoelho.csgomatches.common.utils.TimeUtils
import com.lucascoelho.csgomatches.databinding.ItemMatchBinding
import com.lucascoelho.csgomatches.datasource.matches.entities.MatchStatus
import com.lucascoelho.csgomatches.datasource.matches.entities.model.MatchModel

class MatchesAdapter : RecyclerView.Adapter<MatchesAdapter.MatchesViewHolder>() {

    private var matchesList = mutableListOf<MatchModel>()

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

    inner class MatchesViewHolder(private val binding: ItemMatchBinding) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(match: MatchModel) {
            if (match.status == MatchStatus.RUNNING) {
                binding.textViewMatchTime.setLive(true)
            } else {
                binding.textViewMatchTime.setLive(false)
                binding.textViewMatchTime.text = match.scheduledAt
            }
            setupOpponents(match)
            setupLeague(match)
            binding.textViewMatchTime.text = TimeUtils.formatDateStringToLocalDateString(match.scheduledAt)
        }

        private fun setupOpponents(match: MatchModel) {
            when (match.opponents.size) {
                0 -> {
                    binding.teamInfoContainer.apply {
                        textViewFirstTeamName.text = binding.root.context.getString(R.string.tbd)
                        textViewSecondTeamName.text = binding.root.context.getString(R.string.tbd)
                        imageViewFirstTeam.setImageDrawable(
                            AppCompatResources.getDrawable(
                                binding.root.context,
                                R.drawable.background_round
                            )
                        )
                        imageViewSecondTeam.setImageDrawable(
                            AppCompatResources.getDrawable(
                                binding.root.context,
                                R.drawable.background_round
                            )
                        )
                    }
                }
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
                else -> {
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

        private fun setupLeague(match: MatchModel) {
            binding.textViewLeagueName.text = binding.root.context.getString(
                R.string.league_serie,
                match.league.name,
                if (match.serie.name.isNullOrEmpty()) "" else "| ${match.serie.name}"
            )
            match.league.image_url.run {
                Glide.with(binding.root.context)
                    .load(this)
                    .placeholder(R.drawable.background_round)
                    .into(binding.imageViewLeague)
            }
        }
    }

    fun update(newList: List<MatchModel>) {
        matchesList.clear()
        matchesList.addAll(newList)
        notifyDataSetChanged()
    }
}
