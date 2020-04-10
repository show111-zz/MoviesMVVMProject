package com.example.moviesmvvmproject.di

import com.example.library.networks.api.BaseAPIRepository
import com.example.library.networks.api.BaseAPIRepositoryImpl
import com.example.library.networks.di.NetworkModule
import com.example.library.networks.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        NetworkModule::class
    ]
)
class AppModule {

    @Provides
    @ApplicationScope
    fun provideBaseAPIRepository(baseAPIRepository: BaseAPIRepositoryImpl): BaseAPIRepository = baseAPIRepository

}


