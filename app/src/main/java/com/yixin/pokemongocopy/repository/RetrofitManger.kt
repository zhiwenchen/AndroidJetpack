package com.yixin.pokemongocopy.repository

import com.yixin.pokemongocopy.remote.PokemonService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitManger {

    val pokemonApi: PokemonService = buildRetrofit(buildOkHttpClient()).create(PokemonService::class.java)

    private const val CONNECTION_TIME_OUT = 10L
    private const val READ_TIME_OUT = 10L

    private val baseUrl = "https://pokeapi.co/api/v2/"


    private fun buildOkHttpClient(): OkHttpClient.Builder {
        return OkHttpClient.Builder()
            .connectTimeout(CONNECTION_TIME_OUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIME_OUT, TimeUnit.SECONDS)
    }

    private fun buildRetrofit(builder: OkHttpClient.Builder): Retrofit {
        val client = builder.build()

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client).build()
    }
}
