package com.example.moviesmvvmproject.base

interface BaseLoadListener<T> {

    fun loadSuccess(list : List<T>)

    fun loadFail(meg : String?)

}