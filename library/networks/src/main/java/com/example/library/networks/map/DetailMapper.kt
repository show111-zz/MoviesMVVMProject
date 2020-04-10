package com.example.library.networks.map

import com.example.library.networks.model.Detail
import com.example.library.networks.response.DetailResponse
import javax.inject.Inject

/**
 *  Created by hannah on 2020-02-14
 */
class DetailMapper @Inject constructor(){

    fun map(detailResponse: DetailResponse): Detail?{

        val title = detailResponse.title ?: return null
        val overview = detailResponse.overview ?: return null
        val date = detailResponse.release_date ?: return null

        return Detail(detailResponse.adult, detailResponse.backdrop_path, detailResponse.budget, detailResponse.homepage,
            detailResponse.id,detailResponse.imdb_id, detailResponse.original_language, detailResponse.original_title, overview,
            detailResponse.popularity,detailResponse.poster_path,date, detailResponse.revenue, detailResponse.runtime, detailResponse.status, title)
    }


}
