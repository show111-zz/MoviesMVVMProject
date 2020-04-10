package com.example.feature.featurehome.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.feature.featurehome.usecase.MovieUseCase
import com.example.library.networks.model.Movie
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MovieVM @Inject constructor(private val movieUseCase: MovieUseCase) : ViewModel() {

    val movieState: MutableLiveData<MovieState> = MutableLiveData(
        MovieState.Loading
    )

    val movies = getMovies()

    fun getMovies(){
        movieUseCase.getMovies()
            .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeBy(
            onError = {throwable -> throwable.printStackTrace() },
            onSuccess = { movies -> getMoviesDataSuccess(movies) }
        )
    }

    private fun getMoviesDataSuccess(movies: List<Movie>) {
        movieState.value =
            MovieState.MovieLoaded(movies)
    }

    sealed class MovieState {
        data class MovieLoaded(val items: List<Movie>) : MovieState()
        object Loading : MovieState()
        object Error : MovieState()
    }

}
