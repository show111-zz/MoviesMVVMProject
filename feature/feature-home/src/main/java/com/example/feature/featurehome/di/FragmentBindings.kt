package com.example.feature.featurehome.di

import com.example.feature.featurehome.view.MovieMainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 *  Created by hannah on 2020-01-22
 */
@Module
abstract class FragmentBindings {

    @ContributesAndroidInjector(modules = [MovieModule::class])
    abstract fun bindMovieMainFragment(): MovieMainFragment


}
