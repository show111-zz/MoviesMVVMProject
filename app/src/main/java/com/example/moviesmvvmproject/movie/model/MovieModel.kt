package com.example.moviesmvvmproject.movie.model


import com.example.moviesmvvmproject.movie.di.Result
import io.reactivex.Observable


abstract class MovieModel{

    abstract fun getMovies(): Observable<List<Result>>

}