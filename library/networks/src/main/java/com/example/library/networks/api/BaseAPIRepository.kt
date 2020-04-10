package com.example.library.networks.api

import com.example.library.networks.model.Detail
import com.example.library.networks.model.Movie
import io.reactivex.Single

/**
 *  Created by hannah on 2020-01-30
 */
interface BaseAPIRepository {

    fun loadData(api_key: String): Single<List<Movie>>

    fun loadDetail(id: Int, api_key: String): Single<Detail>

}
