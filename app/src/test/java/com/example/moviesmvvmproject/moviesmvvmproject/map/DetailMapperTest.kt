package com.example.moviesmvvmproject.map

import com.example.test.network.map.DetailMapper
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by hannah on 2020-02-18
 * using MockK library
 */
class DetailMapperTest {

    private companion object{
        private const val ADULT = false
        private const val BACKDROP_PATH = "backdrop_path"
        private const val BUDGET = 1
        private const val HOMEPAGE = "home_page"
        private const val ID = 1
        private const val IMDB_ID = "imdb_id"
        private const val ORIGINAL_LANGUAGE = "english"
        private const val ORIGINAL_TITLE = "origin_title"
        private const val OVERVIEW = "overview"
        private const val POPULARITY = 0.0
        private const val POSTER_PATH = "poster_path"
        private const val RELEASE_DATE = "2020-02-24"
        private const val REVENUE = 1
        private const val RUNTIME = 1
        private const val STATUS = "status"
        private const val TITLE = "title"
    }

    private lateinit var detailMappped: com.example.library.networks.model.Detail

    private val detailMapper = DetailMapper()

    private val detailSource = com.example.library.networks.model.Detail(
        ADULT,
        BACKDROP_PATH,
        BUDGET,
        HOMEPAGE,
        ID,
        IMDB_ID,
        ORIGINAL_LANGUAGE,
        ORIGINAL_TITLE,
        OVERVIEW,
        POPULARITY,
        POSTER_PATH,
        RELEASE_DATE,
        REVENUE,
        RUNTIME,
        STATUS,
        TITLE
    )
    private val detailResponse = com.example.library.networks.response.DetailResponse(
        ADULT,
        BACKDROP_PATH,
        BUDGET,
        HOMEPAGE,
        ID,
        IMDB_ID,
        ORIGINAL_LANGUAGE,
        ORIGINAL_TITLE,
        OVERVIEW,
        POPULARITY,
        POSTER_PATH,
        RELEASE_DATE,
        REVENUE,
        RUNTIME,
        STATUS,
        TITLE
    )


    @Test
    fun mapSuccess() {
        whenMap()
        thenMoviesAreMapped()
    }

    private fun whenMap() {
        detailMappped = detailMapper.map(detailResponse) ?: return
    }

    private fun thenMoviesAreMapped() {
        assertEquals(detailSource, detailMappped)

        assertEquals(ADULT, detailMappped.adult)
        assertEquals(BACKDROP_PATH, detailMappped.backdrop_path)
        assertEquals(BUDGET, detailMappped.budget)
        assertEquals(HOMEPAGE, detailMappped.homepage)
        assertEquals(ID, detailMappped.id)
        assertEquals(IMDB_ID, detailMappped.imdb_id)
        assertEquals(ORIGINAL_LANGUAGE, detailMappped.original_language)
        assertEquals(ORIGINAL_TITLE, detailMappped.original_title)
        assertEquals(OVERVIEW, detailMappped.overview)
        assertEquals(POPULARITY, detailMappped.popularity)
        assertEquals(POSTER_PATH, detailMappped.poster_path)
        assertEquals(RELEASE_DATE, detailMappped.release_date)
        assertEquals(REVENUE, detailMappped.revenue)
        assertEquals(RUNTIME, detailMappped.runtime)
        assertEquals(STATUS, detailMappped.status)
        assertEquals(STATUS, detailMappped.status)
        assertEquals(TITLE, detailMappped.title)
    }

}
