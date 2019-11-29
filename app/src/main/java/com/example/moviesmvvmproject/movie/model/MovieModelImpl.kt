package com.example.moviesmvvmproject.movie.model

import com.example.moviesmvvmproject.base.BaseLoadListener
import com.example.moviesmvvmproject.http.ApiClient
import com.example.moviesmvvmproject.movie.data.MoviesBean
import com.example.moviesmvvmproject.movie.data.Result
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class MovieModelImpl @Inject constructor() : MovieModel() {

    var movieGlobal = MoviesBean()

    override fun getMovies(loadListener: BaseLoadListener<Result>) {
        ApiClient.retrofit().loadData("c06e14cd13b2c6373fdc8f9f3dd47eb3")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onError = {
                    loadListener.loadFail(it.message)
                },
                onNext = {
                    movieGlobal = it
                },
                onComplete = {
                    loadListener.loadSuccess(movieGlobal.results)
                }
            )
            .disposeOnClear()
    }


}