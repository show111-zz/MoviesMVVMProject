package com.example.moviesmvvmproject.map

import com.example.test.network.map.MoviesMapper
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by hannah on 2020-02-18
 */
class MoviesMapperTest {

    private companion object{
        private const val CURRENT_PAGE =  1
        private const val TOTAL_PAGES =  4
        private const val TOTAL_RESULTS =  20

        private const val ADULT = false
        private const val BACKDROP_PATH = "backdrop_path"
        private val GENRE_IDS = emptyList<Int>()
        private const val ID = 1
        private const val ORIGINAL_LANGUAGE = "english"
        private const val ORIGINAL_TITLE = "origin_title"
        private const val OVERVIEW = "overview"
        private const val POPULARITY = 0.0
        private const val POSTER_PATH = "poster_path"
        private const val RELEASE_DATE = "2020-02-20"
        private const val TITLE = "title"
        private const val VIDEO = false
        private const val VOTE_AVERAGE = 0.0
        private const val VOTE_COUNT = 2
    }

    private var moviesMapper = MoviesMapper()

    private var mappedMovies = listOf<com.example.library.networks.model.Movie>()

    private val movieItemMock = com.example.library.networks.response.MovieItemResponse(
        ADULT,
        BACKDROP_PATH,
        GENRE_IDS,
        ID,
        ORIGINAL_LANGUAGE,
        ORIGINAL_TITLE,
        OVERVIEW,
        POPULARITY,
        POSTER_PATH,
        RELEASE_DATE,
        TITLE,
        VIDEO,
        VOTE_AVERAGE,
        VOTE_COUNT
    )

    private var moviesResponseMock: com.example.library.networks.response.MoviesResponse =
        com.example.library.networks.response.MoviesResponse(
            CURRENT_PAGE,
            listOf(movieItemMock, movieItemMock),
            TOTAL_PAGES,
            TOTAL_RESULTS
        )

    @Test
    fun whenMap_thenMoviesAreMapped() {
        whenMap()
        thenMoviesAreMapped()
    }

    private fun whenMap() {
        mappedMovies = moviesMapper.map(moviesResponseMock)
    }

    private fun thenMoviesAreMapped() {
        assertEquals(2, mappedMovies.size)
        assertEquals(mappedMovies[0].adult, movieItemMock.adult)
        assertEquals(mappedMovies[0].backdrop_path, movieItemMock.backdrop_path)
        assertEquals(mappedMovies[0].genre_ids, movieItemMock.genre_ids)
        assertEquals(mappedMovies[0].id, movieItemMock.id)
        assertEquals(mappedMovies[0].original_language, movieItemMock.original_language)
        assertEquals(mappedMovies[0].original_title, movieItemMock.original_title)
        assertEquals(mappedMovies[0].overview, movieItemMock.overview)
        assertEquals(mappedMovies[0].popularity, movieItemMock.popularity)
        assertEquals(mappedMovies[0].poster_path, movieItemMock.poster_path)
        assertEquals(mappedMovies[0].release_date, movieItemMock.release_date)
        assertEquals(mappedMovies[0].title, movieItemMock.title)
        assertEquals(mappedMovies[0].video, movieItemMock.video)
        assertEquals(mappedMovies[0].vote_average, movieItemMock.vote_average)
        assertEquals(mappedMovies[0].vote_count, movieItemMock.vote_count)
    }

}
