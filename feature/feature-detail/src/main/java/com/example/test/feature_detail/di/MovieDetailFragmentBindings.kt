package com.example.test.feature_detail.di

import com.example.test.feature_detail.view.MovieDetailFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 *  Created by hannah on 2020-01-22
 */
@Module
abstract class MovieDetailFragmentBindings {

    @ContributesAndroidInjector(modules = [MovieDetailModule::class])
    abstract fun bindMovieDetailFragment(): MovieDetailFragment

}
