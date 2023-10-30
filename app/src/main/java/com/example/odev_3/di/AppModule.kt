package com.example.odev_3.di

import com.example.odev_3.data.remote.humanresources.HumanResourcesApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHumanResourcesApi(): HumanResourcesApi {
        return Retrofit.Builder()
            .baseUrl("https://dummy.restapiexample.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }

}