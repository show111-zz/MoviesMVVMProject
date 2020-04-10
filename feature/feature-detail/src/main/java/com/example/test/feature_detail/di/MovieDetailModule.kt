package com.example.test.feature_detail.di

import androidx.lifecycle.ViewModel
import com.example.library.networks.api.BaseAPIRepositoryImpl
import com.example.library.networks.di.qualifiers.ViewModelKey
import com.example.test.feature_detail.usecase.DetailUseCase
import com.example.test.feature_detail.usecase.DetailUseCaseImpl
import com.example.test.feature_detail.viewmodel.DetailVM
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

/**
 *  Created by hannah on 2020-02-27
 */
@Module
class MovieDetailModule {

    @Provides
    @IntoMap
    @ViewModelKey(DetailVM::class)
    fun bindViewModel(vm: DetailVM): ViewModel {
        return vm
    }

    @Provides
    fun provideDetailUseCase(apiService: BaseAPIRepositoryImpl): DetailUseCase {
        return DetailUseCaseImpl(apiService)
    }
}
