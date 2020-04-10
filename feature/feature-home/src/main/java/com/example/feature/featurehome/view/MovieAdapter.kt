package com.example.feature.featurehome.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.feature.featurehome.R
import com.example.library.networks.model.Movie
import javax.inject.Inject

class MovieAdapter @Inject constructor() : RecyclerView.Adapter<MovieViewHolder>() {

    private var movieResults = listOf<Movie>()
    var onItemClick: ((Movie) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val movieView = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_movie_list_item, parent, false)
        return MovieViewHolder(movieView)
    }

    override fun getItemCount(): Int = movieResults.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.showMovie(movieResults[position], onItemClick)
    }

    fun updateList(movies: List<Movie>) {
        this.movieResults = movies
    }

}
