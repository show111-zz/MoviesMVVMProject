package com.example.moviesmvvmproject.di

import android.app.Application
import com.example.feature.featurehome.di.FragmentBindings
import com.example.library.networks.di.scope.ApplicationScope
import com.example.moviesmvvmproject.MyApplication
import com.example.test.feature_detail.di.MovieDetailFragmentBindings
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

/**
 *  Created by hannah on 2020-02-26
 */
@ApplicationScope
@Component(
    modules = [
        AppModule::class,
        ActivityBindings::class,
        FragmentBindings::class,
        AndroidInjectionModule::class,
        MovieDetailFragmentBindings::class
    ]
)
interface AppComponent : AndroidInjector<MyApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    override fun inject(application: MyApplication)
}
