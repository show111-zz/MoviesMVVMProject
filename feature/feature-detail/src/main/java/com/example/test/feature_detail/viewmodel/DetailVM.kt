package com.example.test.feature_detail.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.library.networks.model.Detail
import com.example.test.feature_detail.usecase.DetailUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 *  Created by hannah on 2020-01-27
 */
class DetailVM @Inject constructor(private val detailUseCase: DetailUseCase, private var id: Int) : ViewModel() {

    val detailState: MutableLiveData<DetailState> = MutableLiveData(
        DetailState.DetailLoading
    )

    val detail =  detailUseCase.getDetails(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeBy(
        onSuccess = {details -> getDetailDataSuccess(details)},
        onError = { throwable -> throwable.printStackTrace() }
    )

    private fun getDetailDataSuccess(detail: Detail) {
        detailState.value =
            DetailState.DetailLoaded(detail)
    }

    sealed class DetailState {
        data class DetailLoaded(val detailItem: Detail) : DetailState()
        object DetailLoading : DetailState()
        object DetailError : DetailState()
    }

}
