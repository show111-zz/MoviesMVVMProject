package com.example.moviesmvvmproject.movie.view

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import com.example.moviesmvvmproject.R
import com.example.moviesmvvmproject.base.BaseActivity
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_movie_detail)

        var intent : Intent = getIntent()

        var urlImage = intent.getStringExtra("url_image")
        var title = intent.getStringExtra("title")
        var description = intent.getStringExtra("description")

        movieTitle.text = title
        movieDescription.text = description

        Log.d("MovieDetailActivity", "title-->" +title)
        Log.d("MovieDetailActivity", "description-->" +description)

//          Glide.with(this)
//            .load(urlImage)
//            .into(imgPoster)

    }

}