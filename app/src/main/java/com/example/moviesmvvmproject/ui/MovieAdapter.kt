package com.example.moviesmvvmproject.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesmvvmproject.R
import com.example.moviesmvvmproject.model.Result

class MovieAdapter : RecyclerView.Adapter<MovieViewHolder>(){

    private var movieResults = listOf<Result>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val movieView = LayoutInflater.from(parent.context).inflate(R.layout.view_movie_list_item, parent, false)
        return MovieViewHolder(movieView)
    }

    override fun getItemCount(): Int  = movieResults.size


    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.showMovie(movieResults[position])
    }


    fun updateList(movies: List<Result>) {
        this.movieResults = movies
    }

}