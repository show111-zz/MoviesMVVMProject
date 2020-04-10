package com.example.feature.featurehome.usecase

import com.example.library.networks.api.BaseAPIRepositoryImpl
import com.example.library.networks.api.Constants.API_KEY
import com.example.library.networks.model.Movie
import io.reactivex.Single
import javax.inject.Inject

class MovieUseCaseImpl @Inject constructor(private var baseAPIRepositoryImpl:  BaseAPIRepositoryImpl) : MovieUseCase() {

    override fun getMovies(): Single<List<Movie>> = baseAPIRepositoryImpl.loadData(API_KEY)

}
