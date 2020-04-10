package com.example.library.networks.model

import java.io.Serializable

data class Detail(
    var adult: Boolean?,
    var backdrop_path: String?,
    var budget: Int?,
    var homepage: String?,
    var id: Int?,
    var imdb_id: String?,
    var original_language: String?,
    var original_title: String?,
    var overview: String?,
    var popularity: Double?,
    var poster_path: String?,
    var release_date: String?,
    var revenue: Int?,
    var runtime: Int?,
    var status: String?,
    var title: String?
): Serializable
