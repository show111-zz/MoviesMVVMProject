package com.example.moviesmvvmproject.movie.di

import com.example.moviesmvvmproject.movie.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 *  Created by hannah on 2020-01-22
 */
@Module
abstract class ActivityBindings {

    @ContributesAndroidInjector
    abstract fun bindNavigationActivity(): MainActivity

}
