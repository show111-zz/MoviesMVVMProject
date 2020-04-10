package com.example.library.networks.di

import com.example.library.networks.api.ApiService
import com.example.library.networks.api.BaseAPIRepository
import com.example.library.networks.api.BaseAPIRepositoryImpl
import com.example.library.networks.api.Constants
import com.example.library.networks.di.qualifiers.ForBaseApi
import com.example.library.networks.di.qualifiers.MyOkHttpClient
import com.example.library.networks.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 *  Created by hannah on 2020-02-26
 */
@Module
class BaseApiModule {

    @Provides
    @ApplicationScope
    fun provideBaseApiRepository(baseAPIRepository: BaseAPIRepositoryImpl): BaseAPIRepository = baseAPIRepository


    @Provides
    @ApplicationScope
    fun provideBaseApiService(@ForBaseApi retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)


    @Provides
    @ApplicationScope
    @ForBaseApi
    fun provideRetrofit(@MyOkHttpClient okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(Constants.API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()

}
