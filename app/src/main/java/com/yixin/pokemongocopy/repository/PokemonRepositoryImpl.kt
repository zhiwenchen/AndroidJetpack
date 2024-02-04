package com.yixin.pokemongocopy.repository

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.yixin.pokemongocopy.entity.ListingData
import com.yixin.pokemongocopy.entity.ListingResponse
import com.yixin.pokemongocopy.model.PokemonInfoModel
import com.yixin.pokemongocopy.model.PokemonItemModel
import com.yixin.pokemongocopy.remote.PokemonService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val pokemonApi: PokemonService
) : Repository {

    override suspend fun fetchPokemonList(): ListingResponse {

        val response = pokemonApi.fetchPokemonList()
        if (response.isSuccessful) {
            val pokemonList = response.body()
            pokemonList?.results?.forEach{
                Log.d(TAG,"${it.name},${it.url}")
            }
            return ListingResponse(emptyList<ListingData>())
        }
        return ListingResponse(emptyList<ListingData>())
    }

    companion object {
        private val TAG = "PokemonRepositoryImpl"
    }
}