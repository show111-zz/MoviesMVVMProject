package com.example.moviesmvvmproject.movie.model

import com.example.moviesmvvmproject.base.BaseLoadListener
import com.example.moviesmvvmproject.base.BaseModel
import com.example.moviesmvvmproject.movie.data.Result

abstract class MovieModel :  BaseModel(){

    abstract fun getMovies(loadListener: BaseLoadListener<Result>)

}