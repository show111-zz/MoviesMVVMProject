package com.example.moviesmvvmproject.movie.model


import com.example.moviesmvvmproject.http.ApiClient
import com.example.moviesmvvmproject.movie.di.Result
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class MovieModelImpl @Inject constructor() : MovieModel() {

    override fun getMovies(): Observable<List<Result>> {
        return ApiClient.retrofit().loadData("c06e14cd13b2c6373fdc8f9f3dd47eb3")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { it.results }
    }


}