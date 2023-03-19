package com.lucascoelho.csgomatches.matches.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lucascoelho.csgomatches.R
import com.lucascoelho.csgomatches.databinding.ItemPlayerTeamOneBinding
import com.lucascoelho.csgomatches.datasource.matches.entities.Player

class TeamOneAdapter : RecyclerView.Adapter<TeamOneAdapter.TeamOneViewHolder>() {

    private var playerList = mutableListOf<Player>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TeamOneViewHolder {
        val binding = ItemPlayerTeamOneBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TeamOneViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TeamOneAdapter.TeamOneViewHolder, position: Int) {
        holder.onBind(playerList[position])
    }

    override fun getItemCount(): Int {
        return playerList.size
    }

    inner class TeamOneViewHolder(
        private val binding: ItemPlayerTeamOneBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(player: Player) {
            binding.apply {
                textViewNickname.text = player.name
                textViewPlayerName.text = player.first_name
                Glide.with(root.context)
                    .load(player.image_url)
                    .placeholder(R.drawable.background_avatar)
                    .into(imageViewPlayerAvatar)
            }
        }
    }

    fun update(newList: List<Player>) {
        playerList.clear()
        playerList.addAll(newList.take(5))
        notifyDataSetChanged()
    }
}
