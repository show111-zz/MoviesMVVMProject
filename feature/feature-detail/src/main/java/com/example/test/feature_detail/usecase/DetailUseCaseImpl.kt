package com.example.test.feature_detail.usecase

import com.example.library.networks.api.BaseAPIRepositoryImpl
import com.example.library.networks.api.Constants.API_KEY
import com.example.library.networks.model.Detail
import io.reactivex.Single
import javax.inject.Inject

/**
 *  Created by hannah on 2020-01-27
 */
class DetailUseCaseImpl @Inject constructor(private var baseAPIRepositoryImpl: BaseAPIRepositoryImpl) : DetailUseCase() {

    override fun getDetails(id: Int): Single<Detail>  = baseAPIRepositoryImpl.loadDetail(id, API_KEY)

}
