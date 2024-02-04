package com.yixin.pokemongocopy.remote

import com.yixin.pokemongocopy.entity.ListingResponse
import com.yixin.pokemongocopy.entity.NetWorkPokemonInfo
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonService {

    // 获取pokemon数据列表
    @GET("pokemon")
    suspend fun fetchPokemonList(@Query("limit") limit: Int = 20,
                                  @Query("offset") offset: Int = 0) : Response<ListingResponse>;

    @GET("pokemon")
    suspend fun fetchPokemonInfo(@Query("name") name: String) : Response<NetWorkPokemonInfo>;
}