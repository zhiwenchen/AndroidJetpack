package com.yixin.pokemongocopy.repository

import com.yixin.pokemongocopy.model.PokemonInfoModel
import com.yixin.pokemongocopy.model.PokemonItemModel

interface Repository {

    // Kotlin Flow 知识点
    suspend fun fetchPokemonList(): List<PokemonItemModel>

    suspend fun fetchPokemonInfo(name: String): PokemonInfoModel?

    // 通过数据库加载
//    suspend fun fetchPokemonByParameter(parameter: String): Flow<PagingData<PokemonItemModel>>
}