package  com.example.library.networks.di

import com.example.library.networks.BuildConfig
import com.example.library.networks.di.qualifiers.LoggingInterceptor
import com.example.library.networks.di.qualifiers.MyOkHttpClient
import com.example.library.networks.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor

/**
 *  Created by hannah on 2020-02-25
 */
@Module(
    includes = [
        BaseApiModule::class
    ]
)
class NetworkModule {

    @Provides
    @ApplicationScope
    @LoggingInterceptor
    fun provideHttpLoggingInterceptor(): Interceptor {
        return if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        } else {
            object : Interceptor {
                override fun intercept(chain: Interceptor.Chain): Response {
                    return chain.proceed(chain.request())
                }
            }
        }
    }

    @Provides
    @ApplicationScope
    @MyOkHttpClient
    fun provideOkHttpClient(@LoggingInterceptor httpLoggingInterceptor: Interceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addNetworkInterceptor(httpLoggingInterceptor)
            .build()

}
