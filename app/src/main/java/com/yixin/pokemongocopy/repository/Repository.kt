package com.yixin.pokemongocopy.repository

import androidx.paging.PagingData
import com.yixin.pokemongocopy.entity.ListingResponse
import com.yixin.pokemongocopy.model.PokemonInfoModel
import com.yixin.pokemongocopy.model.PokemonItemModel
import kotlinx.coroutines.flow.Flow

interface Repository {

    // Kotlin Flow 知识点
    suspend fun fetchPokemonList(): ListingResponse

//    suspend fun fetchPokemonInfo(name: String): Flow<PokemonResult<PokemonInfoModel>>

    // 通过数据库加载
//    suspend fun fetchPokemonByParameter(parameter: String): Flow<PagingData<PokemonItemModel>>
}