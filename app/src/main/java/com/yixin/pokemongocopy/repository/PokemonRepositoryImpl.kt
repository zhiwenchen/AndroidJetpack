package com.yixin.pokemongocopy.repository

import com.yixin.pokemongocopy.entity.ListingData
import com.yixin.pokemongocopy.entity.ListingResponse
import com.yixin.pokemongocopy.entity.PokemonInfoEntity
import com.yixin.pokemongocopy.local.PokemonDao
import com.yixin.pokemongocopy.local.PokemonDatabase
import com.yixin.pokemongocopy.logD
import com.yixin.pokemongocopy.mapper.InfoEntity2InfoModelMapper
import com.yixin.pokemongocopy.model.PokemonInfoModel
import com.yixin.pokemongocopy.model.PokemonItemModel
import com.yixin.pokemongocopy.remote.PokemonService

class PokemonRepositoryImpl(
    private val pokemonApi: PokemonService,
    private val pokemonDatebase: PokemonDatabase
) : Repository {

    override suspend fun fetchPokemonList(): List<PokemonItemModel> {

        // 从数据库中获取缓存
        val response = pokemonApi.fetchPokemonList()
        if (response.isSuccessful) {
            val pokemonList = response.body() ?: return emptyList()
            // 插入到数据库中
            return pokemonList.results.asSequence()
                .map { PokemonItemModel(name = it.name, url = it.getImageUrl()) }
                .toList()
//            pokemonList.results.forEach{
//                logD("${it.name},${it.url}")
//            }
        }
        return emptyList()
    }

    override suspend fun fetchPokemonInfo(name: String): PokemonInfoModel? {
        // 先从数据库中获取缓存数据
        val pokemonDao = pokemonDatebase.pokemonDao()
        val pokemonByName = pokemonDao.queryPokemonByName(name)

        // 再联网拉取数据
        val response = pokemonApi.fetchPokemonInfo(name)
        if (response.isSuccessful) {
            val netWorkPokemonInfo = response.body()!!
            // 将网路请求的数据，换转成的数据库的 model，之后插入数据库
            val infoModel = PokemonInfoEntity.convert2PokemonInfoEntity(netWorkPokemonInfo)
            // 插入更新数据库
//            pokemonDao.insertPokemon(infoModel)

            // 将数据源的 model 转换成上层用到的 model，
            // ui 不能直接持有数据源，防止数据源的变化，影响上层的 ui
            val model = InfoEntity2InfoModelMapper().map(infoModel)
            return model
        }
        return null
    }

}