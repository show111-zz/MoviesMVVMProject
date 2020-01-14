package com.example.moviesmvvmproject.http

import com.example.moviesmvvmproject.movie.di.MoviesBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * all of the request url
 */
interface ApiStores {

    companion object {
        val API_SERVER_URL = "https://api.themoviedb.org/3/movie/"
        val IMAGE_PREVIOUS_URL = "http://image.tmdb.org/t/p/w780"
    }

    @GET("popular")
    fun loadData(@Query("api_key") api_key: String): Observable<MoviesBean>

}
