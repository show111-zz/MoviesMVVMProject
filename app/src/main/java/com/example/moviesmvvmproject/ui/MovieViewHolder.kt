package com.example.moviesmvvmproject.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesmvvmproject.model.Result
import kotlinx.android.synthetic.main.view_movie_list_item.view.*

class MovieViewHolder (movieView : View): RecyclerView.ViewHolder(movieView){

    private var view : View = movieView

    fun showMovie(movie : Result){
        view.movieTitle.text = movie.title

    }



}