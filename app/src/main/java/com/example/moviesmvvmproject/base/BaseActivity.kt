package com.example.moviesmvvmproject.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Subscriber

open class BaseActivity : AppCompatActivity() {

    val mCompositeSubscription: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        if (mCompositeSubscription.isDisposed) {
            mCompositeSubscription.clear()
        }
        super.onDestroy()
    }

    protected fun Disposable.disposeOnDestroy() = mCompositeSubscription.add(this)

}