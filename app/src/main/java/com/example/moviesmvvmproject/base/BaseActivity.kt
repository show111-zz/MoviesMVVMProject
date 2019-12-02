package com.example.moviesmvvmproject.base

import androidx.appcompat.app.AppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseActivity: AppCompatActivity() {

    private val disposeBag = CompositeDisposable()

    protected fun Disposable.add() = disposeBag.add(this)

    override fun onStop() {
        super.onStop()
        disposeBag.clear()
    }
}