package com.example.moviesmvvmproject.movie.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.signature.ObjectKey
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
        // load image url to image view but now the url is partial
//        Glide.with(view)
//            .load(movie.poster_path)
//            .into(view.imgPoster)

        view.setOnClickListener {
            onItemClick?.invoke(movie)
        }

    }

}