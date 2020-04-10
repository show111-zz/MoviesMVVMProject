package com.example.feature.featurehome.di

import androidx.lifecycle.ViewModel
import com.example.library.networks.di.qualifiers.ViewModelKey
import com.example.feature.featurehome.viewmodel.MovieVM
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 *  Created by hannah on 2020-02-26
 */
@Module
abstract class MovieModule {

    @Binds
    @IntoMap
    @ViewModelKey(MovieVM::class)
    abstract fun bindViewModel(vm: MovieVM): ViewModel

}
