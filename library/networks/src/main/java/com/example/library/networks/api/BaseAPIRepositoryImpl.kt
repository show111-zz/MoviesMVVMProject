package com.example.library.networks.api

import com.example.library.networks.map.DetailMapper
import com.example.library.networks.map.MoviesMapper
import com.example.library.networks.model.Detail
import com.example.library.networks.model.Movie
import io.reactivex.Single
import javax.inject.Inject

/**
 *  Created by hannah on 2020-01-30
 */
class BaseAPIRepositoryImpl @Inject constructor(private val apiService: ApiService, private val moviesMapper: MoviesMapper, private val detailMapper: DetailMapper) :
    BaseAPIRepository {

    override fun loadData(api_key: String): Single<List<Movie>> =
        apiService.loadData(api_key).map(moviesMapper::map)

    override fun loadDetail(id: Int, api_key: String): Single<Detail> =
        apiService.loadDetail(id, api_key).map(detailMapper::map)
}
