package com.example.moviesmvvmproject

import android.app.Activity
import android.app.Application
import com.example.moviesmvvmproject.movie.di.ActivityBindings
import com.example.moviesmvvmproject.movie.di.FragmentBindings
import com.example.moviesmvvmproject.movie.di.MovieModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.*
import javax.inject.Inject
import javax.inject.Singleton

class MyApplication : Application(), HasActivityInjector{

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>


    override fun activityInjector(): AndroidInjector<Activity>  = activityInjector


    override fun onCreate() {
        super.onCreate()

        DaggerMyAppComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }


}

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        MovieModule::class,
        ActivityBindings::class,
        FragmentBindings::class
    ]
)
interface MyAppComponent: AndroidInjector<MyApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): MyAppComponent
    }

    override fun inject(application: MyApplication)
}
