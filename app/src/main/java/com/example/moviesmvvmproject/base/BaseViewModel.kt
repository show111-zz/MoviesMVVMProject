package com.example.moviesmvvmproject.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.addTo

abstract class BaseViewModel  : ViewModel(){

    private val compositeDisposable = CompositeDisposable()

    protected fun Disposable.disposeOnClear() = addTo(compositeDisposable)

    override fun onCleared() {
        compositeDisposable.clear()
    }

}