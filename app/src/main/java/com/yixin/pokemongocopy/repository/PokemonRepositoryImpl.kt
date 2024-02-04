package com.yixin.pokemongocopy.repository

import com.yixin.pokemongocopy.entity.ListingData
import com.yixin.pokemongocopy.entity.ListingResponse
import com.yixin.pokemongocopy.logD
import com.yixin.pokemongocopy.model.PokemonItemModel
import com.yixin.pokemongocopy.remote.PokemonService

class PokemonRepositoryImpl(
    private val pokemonApi: PokemonService
) : Repository {

    override suspend fun fetchPokemonList(): List<PokemonItemModel> {

        val response = pokemonApi.fetchPokemonList()
        if (response.isSuccessful) {
            val pokemonList = response.body() ?: return emptyList()
            return pokemonList.results.asSequence()
                .map { PokemonItemModel(name = it.name, url = it.getImageUrl()) }
                .toList()
//            pokemonList.results.forEach{
//                logD("${it.name},${it.url}")
//            }
        }
        return emptyList()
    }

}