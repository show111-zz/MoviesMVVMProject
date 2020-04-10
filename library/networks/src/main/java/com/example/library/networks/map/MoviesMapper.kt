package com.example.library.networks.map

import com.example.library.networks.api.Constants.DEFAULT_POSTER_PATH
import com.example.library.networks.model.Movie
import com.example.library.networks.response.MovieItemResponse
import com.example.library.networks.response.MoviesResponse
import javax.inject.Inject

/**
 *  Created by hannah on 2020-02-14
 */
class MoviesMapper @Inject constructor() {

    fun map(moviesResponse: MoviesResponse): List<Movie> =
        moviesResponse.results?.mapNotNull(::mapOrNull) ?: emptyList()

    private fun mapOrNull(movieItemResponse: MovieItemResponse): Movie? {
        val id = movieItemResponse.id ?: return null
        val title = movieItemResponse.title ?: return null
        val overview = movieItemResponse.overview ?: return null
        val posterPath = movieItemResponse.poster_path ?: DEFAULT_POSTER_PATH

        return Movie(
            movieItemResponse.adult,
            movieItemResponse.backdrop_path,
            movieItemResponse.genre_ids,
            id,
            movieItemResponse.original_language,
            movieItemResponse.original_title,
            overview,
            movieItemResponse.popularity,
            posterPath,
            movieItemResponse.release_date,
            title,
            movieItemResponse.video,
            movieItemResponse.vote_average,
            movieItemResponse.vote_count
        )
    }

}
