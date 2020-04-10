package com.example.library.networks.api

import com.example.library.networks.response.DetailResponse
import com.example.library.networks.response.MoviesResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * all of the request url
 */
interface ApiService {

    // movie list
    @GET("3/movie/popular")
    fun loadData(@Query("api_key") api_key: String): Single<MoviesResponse>

    // movie detail
    @GET("3/movie/{id}")
    fun loadDetail(@Path("id") id: Int, @Query("api_key") api_key: String): Single<DetailResponse>

}
