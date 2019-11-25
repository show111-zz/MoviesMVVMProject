package com.example.moviesmvvmproject.http

import android.util.Log
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription
import retrofit2.HttpException

abstract class ApiCallback<M> : Subscriber<M>{

    abstract fun onSuccess(model: M)
    abstract fun onFailure(msg: String?)
    abstract fun onFinish()

    override fun onSubscribe(s: Subscription?) {
        Log.e("hui",s.toString())
    }

    override fun onComplete() {
        onFinish()
    }

    override fun onNext(m: M) {
        onSuccess(m)
    }


    override fun onError(e: Throwable?) {
        if (e is HttpException) {
            val httpException = e
            //httpException.response().errorBody().string()
            Log.d("hui", "code=" + httpException.code() +"msg-->"+ httpException.message)
            onFailure(httpException.message)
        } else {
            onFailure(e.toString())
        }
        onFinish()
    }

}