package com.example.moviesmvvmproject.base

import com.example.moviesmvvmproject.movie.data.Result

interface IBaseView{
    fun loadDataToViewFail(msg: String?)
    fun loadDataToViewSuccess(list: List<Result>)
}