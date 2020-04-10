package com.example.feature.featurehome.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.library.networks.api.Constants.IMAGE_PREFIX_URL
import kotlinx.android.synthetic.main.view_movie_list_item.view.*

class MovieViewHolder(movieView: View) : RecyclerView.ViewHolder(movieView) {

    private var view: View = movieView

    fun showMovie(
        movie: com.example.library.networks.model.Movie,
        onItemClick: ((com.example.library.networks.model.Movie) -> Unit)?
    ) {
        view.movieTitle.text = movie.title
        view.movieDescription.text = movie.overview
        Glide.with(view)
            .load(IMAGE_PREFIX_URL + movie.poster_path)
            .into(view.imgPoster)
        view.setOnClickListener {
            onItemClick?.invoke(movie)
        }
    }
}
