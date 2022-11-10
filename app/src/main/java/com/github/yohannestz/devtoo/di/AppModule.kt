package com.github.yohannestz.devtoo.di

import com.github.yohannestz.devtoo.common.Constants
import com.github.yohannestz.devtoo.data.remote.DevToArticlesApi
import com.github.yohannestz.devtoo.data.repository.ArticleRepositoryImpl
import com.github.yohannestz.devtoo.domain.repository.ArticleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDevArticlesApi(): DevToArticlesApi {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC)

        val client: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(DevToArticlesApi::class.java)
    }

    @Provides
    @Singleton
    fun provideArticlesRepository(api: DevToArticlesApi): ArticleRepository {
        return ArticleRepositoryImpl(api)
    }

}