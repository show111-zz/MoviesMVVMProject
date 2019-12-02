package com.example.moviesmvvmproject.movie.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesmvvmproject.R
import com.example.moviesmvvmproject.movie.di.Result
import javax.inject.Inject

class MovieAdapter @Inject constructor() : RecyclerView.Adapter<MovieViewHolder>() {

    private var movieResults = listOf<Result>()
    var onItemClick: ((Result) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val movieView = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_movie_list_item, parent, false)
        return MovieViewHolder(movieView)
    }

    override fun getItemCount(): Int = movieResults.size


    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.showMovie(movieResults[position], onItemClick)
    }

    fun updateList(movies: List<Result>) {
        this.movieResults = movies
    }

}