package com.example.library.networks.response

import com.google.gson.annotations.SerializedName

/**
 *  Created by hannah on 2020-02-14
 */
data class DetailResponse(
    @SerializedName("adult") val adult: Boolean?,
    @SerializedName("backdrop_path") val backdrop_path: String?,
    @SerializedName("budget") val budget: Int?,
    @SerializedName("homepage") val homepage: String?,
    @SerializedName("id") val id: Int?,
    @SerializedName("imdb_id") val imdb_id: String?,
    @SerializedName("original_language") val original_language: String?,
    @SerializedName("original_title") val original_title: String?,
    @SerializedName("overview") val overview: String?,
    @SerializedName("popularity") val popularity: Double?,
    @SerializedName("poster_path") val poster_path: String?,
    @SerializedName("release_date") val release_date: String?,
    @SerializedName("revenue") val revenue: Int?,
    @SerializedName("runtime") val runtime: Int?,
    @SerializedName("status") val status: String?,
    @SerializedName("title") var title: String?
)





