package com.example.moviesmvvmproject.movie.viewmodel


import androidx.lifecycle.ViewModel
import com.example.moviesmvvmproject.movie.di.Result
import com.example.moviesmvvmproject.movie.model.MovieModel
import io.reactivex.Observable


class MovieVM(private val model: MovieModel) : ViewModel() {

    val movies: Observable<List<Result>> = model.getMovies()

}
