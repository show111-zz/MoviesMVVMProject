package com.example.moviesmvvmproject.movie.di

import com.example.moviesmvvmproject.movie.navigation.MovieDetailFragment
import com.example.moviesmvvmproject.movie.navigation.MovieMainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 *  Created by hannah on 2020-01-22
 */
@Module
abstract class FragmentBindings {

    @ContributesAndroidInjector(modules = [MovieModule::class])
    abstract fun bindMovieMainFragment(): MovieMainFragment

    @ContributesAndroidInjector()
    abstract fun bindMovieDetailFragment(): MovieDetailFragment

}
