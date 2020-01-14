package com.example.moviesmvvmproject.movie.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesmvvmproject.http.ApiStores.Companion.IMAGE_PREVIOUS_URL
import com.example.moviesmvvmproject.movie.di.Result
import kotlinx.android.synthetic.main.view_movie_list_item.view.*

class MovieViewHolder(movieView: View) : RecyclerView.ViewHolder(movieView) {

    private var view: View = movieView

    fun showMovie(
        movie: Result,
        onItemClick: ((Result) -> Unit)?
    ) {
        view.movieTitle.text = movie.title
        view.movieDescription.text = movie.overview
        Glide.with(view)
            .load(IMAGE_PREVIOUS_URL + movie.poster_path)
            .into(view.imgPoster)
        view.setOnClickListener {
            onItemClick?.invoke(movie)
        }
    }
}
