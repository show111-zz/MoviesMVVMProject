package com.example.moviesmvvmproject.movie.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.moviesmvvmproject.R
import com.example.moviesmvvmproject.http.ApiStores.Companion.IMAGE_PREVIOUS_URL
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_movie_detail.*

class MovieDetailFragment : DaggerFragment() {

    private val args by navArgs<MovieDetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieTitle.text = args.movieTitle
        movieDescription.text = args.description
        Glide.with(this)
            .load(IMAGE_PREVIOUS_URL+args.posterUrl)
            .into(imgPoster)
    }


}
