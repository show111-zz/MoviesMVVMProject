package com.example.moviesmvvmproject.movie.viewmodel

import com.example.moviesmvvmproject.base.BaseLoadListener
import com.example.moviesmvvmproject.base.IBaseView
import com.example.moviesmvvmproject.movie.data.Result
import com.example.moviesmvvmproject.movie.model.MovieModelImpl

class MovieVM : BaseLoadListener<Result> {

    var mMovieView: IBaseView
    var movieModel = MovieModelImpl()

    constructor(movieView: IBaseView) {
        mMovieView = movieView
        getMovieData()
    }

    fun getMovieData() {
        movieModel.getMovies(this)
    }

    // baseLoadListener
    override fun loadSuccess(list: List<Result>) {
        mMovieView.loadDataToViewSuccess(list)
    }

    // baseLoadListener
    override fun loadFail(msg: String?) {
        mMovieView.loadDataToViewFail(msg)
    }


}