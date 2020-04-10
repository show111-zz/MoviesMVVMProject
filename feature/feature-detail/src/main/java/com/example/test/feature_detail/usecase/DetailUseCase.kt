package com.example.test.feature_detail.usecase

import com.example.library.networks.model.Detail
import io.reactivex.Single

abstract class DetailUseCase {
    abstract fun getDetails(id: Int): Single<Detail>
}
