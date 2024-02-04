package com.yixin.pokemongocopy.remote

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun providePokemonApi(): PokemonService = buildRetrofit(buildOkHttpClient()).create(PokemonService::class.java)


    private fun buildOkHttpClient(): OkHttpClient.Builder {
        return OkHttpClient.Builder()
            .connectTimeout(Companion.CONNECTION_TIME_OUT, TimeUnit.SECONDS)
            .readTimeout(Companion.READ_TIME_OUT, TimeUnit.SECONDS)
    }

    private fun buildRetrofit(builder: OkHttpClient.Builder): Retrofit {
        val client = builder.build()

        return Retrofit.Builder()
            .baseUrl(Base_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client).build()
    }

    companion object {
        private const val CONNECTION_TIME_OUT = 10L
        private const val READ_TIME_OUT = 10L
        private const val Base_URL = "https://pokeapi.co/api/v2/"

    }
}