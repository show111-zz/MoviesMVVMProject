package com.example.moviesmvvmproject.http

import com.example.moviesmvvmproject.model.MoviesBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


/**
 * all of the request url
 */
interface ApiStores {

    companion object {
        val API_SERVER_URL = "https://api.themoviedb.org/3/movie/"
    }

    @GET("popular")
    fun loadData(@Query("api_key") api_key: String): Observable<MoviesBean>

}