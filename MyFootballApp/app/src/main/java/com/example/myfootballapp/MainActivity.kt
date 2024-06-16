package com.example.myfootballapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myfootballapp.adapter.SeasonsAdapter
import com.example.myfootballapp.api.FootballApiService
import com.example.myfootballapp.api.RetrofitClient
import com.example.myfootballapp.model.CompetitionResponse
import com.example.myfootballapp.util.ImageLoader
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var apiService: FootballApiService
    private lateinit var seasonsRecyclerView: RecyclerView
    private lateinit var seasonsAdapter: SeasonsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        apiService = RetrofitClient.getClient().create(FootballApiService::class.java)
        seasonsRecyclerView = findViewById(R.id.seasonsRecyclerView)
        seasonsRecyclerView.layoutManager = GridLayoutManager(this, 2)
        seasonsAdapter = SeasonsAdapter()
        seasonsRecyclerView.adapter = seasonsAdapter

        getCompetitionDetails()
    }

    private fun getCompetitionDetails() {
        val authToken = "b018b1da7bed4cbda7e4cc0b3bcb8b69"

        val call = apiService.getCompetitionDetails(authToken)
        call.enqueue(object : Callback<CompetitionResponse> {
            override fun onResponse(call: Call<CompetitionResponse>, response: Response<CompetitionResponse>) {
                if (response.isSuccessful) {
                    val competition = response.body()
                    competition?.let { displayCompetitionDetails(it) }
                } else {
                    Toast.makeText(this@MainActivity, "Failed to retrieve data", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<CompetitionResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun displayCompetitionDetails(competition: CompetitionResponse) {
        val competitionName: TextView = findViewById(R.id.competitionName)
        val competitionEmblem: ImageView = findViewById(R.id.competitionEmblem)

        competitionName.text = competition.name
        ImageLoader.loadImage(this, competition.emblem, competitionEmblem)

        seasonsAdapter.setSeasons(competition.seasons)
    }
}
