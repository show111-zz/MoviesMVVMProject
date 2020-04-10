package com.example.feature.featurehome.usecase

import com.example.library.networks.model.Movie
import io.reactivex.Single

abstract class MovieUseCase{

    abstract fun getMovies(): Single<List<Movie>>

}
