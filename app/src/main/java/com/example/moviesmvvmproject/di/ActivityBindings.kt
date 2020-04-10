package com.example.moviesmvvmproject.di

import com.example.moviesmvvmproject.movie.MainActivity
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
