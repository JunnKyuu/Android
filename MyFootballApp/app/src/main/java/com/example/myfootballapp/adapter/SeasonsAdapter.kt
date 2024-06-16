package com.example.myfootballapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myfootballapp.R
import com.example.myfootballapp.model.Season
import com.example.myfootballapp.util.ImageLoader

class SeasonsAdapter : RecyclerView.Adapter<SeasonsAdapter.SeasonViewHolder>() {

    private var seasons: List<Season> = listOf()

    fun setSeasons(seasons: List<Season>) {
        this.seasons = seasons
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeasonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_season, parent, false)
        return SeasonViewHolder(view)
    }

    override fun onBindViewHolder(holder: SeasonViewHolder, position: Int) {
        val season = seasons[position]
        holder.bind(season)
    }

    override fun getItemCount(): Int {
        return seasons.size
    }

    class SeasonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val seasonName: TextView = itemView.findViewById(R.id.seasonName)
        private val seasonWinner: TextView = itemView.findViewById(R.id.seasonWinner)
        private val seasonCrest: ImageView = itemView.findViewById(R.id.seasonCrest)
        private val seasonAddress: TextView = itemView.findViewById(R.id.seasonAddress)
        private val seasonWebsite: TextView = itemView.findViewById(R.id.seasonWebsite)
        private val seasonFounded: TextView = itemView.findViewById(R.id.seasonFounded)
        private val seasonClubColors: TextView = itemView.findViewById(R.id.seasonClubColors)
        private val seasonVenue: TextView = itemView.findViewById(R.id.seasonVenue)

        fun bind(season: Season) {
            seasonName.text = "${season.startDate} ~ ${season.endDate}"
            seasonWinner.text = season.winner?.name ?: "No winner"
            seasonAddress.text = season.winner?.address ?: ""
            seasonWebsite.text = season.winner?.website ?: ""
            seasonFounded.text = season.winner?.founded?.toString() ?: ""
            seasonClubColors.text = season.winner?.clubColors ?: ""
            seasonVenue.text = season.winner?.venue ?: ""
            ImageLoader.loadImage(itemView.context, season.winner?.crest, seasonCrest)
        }
    }
}
