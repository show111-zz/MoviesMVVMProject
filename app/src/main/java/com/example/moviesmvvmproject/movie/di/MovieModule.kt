package com.example.moviesmvvmproject.movie.di

import androidx.lifecycle.ViewModel
import com.example.moviesmvvmproject.movie.viewmodel.MovieVM
import dagger.Binds
import dagger.Module

@Module
abstract class MovieModule {
    @Binds
    abstract fun bindViewModel(vm: MovieVM): ViewModel
}


