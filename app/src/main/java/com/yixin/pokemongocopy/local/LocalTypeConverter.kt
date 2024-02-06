package com.yixin.pokemongocopy.local

import androidx.room.TypeConverter
import com.google.gson.GsonBuilder
import com.yixin.pokemongocopy.entity.PokemonInfoEntity
import com.yixin.pokemongocopy.ext.fromJson
import com.yixin.pokemongocopy.ext.typedToJson

open class LocalTypeConverter {

    @TypeConverter
    fun json2StatsEntity(src: String): List<PokemonInfoEntity.Stats>? =
        GsonBuilder().create().fromJson(src)

    @TypeConverter
    fun statsEntity2Json(data: List<PokemonInfoEntity.Stats>): String =
        GsonBuilder().create().typedToJson(data)

    @TypeConverter
    fun json2TypeEntity(src: String): List<PokemonInfoEntity.Type>? =
        GsonBuilder().create().fromJson(src)

    @TypeConverter
    fun typeEntity2Json(data: List<PokemonInfoEntity.Type>): String =
        GsonBuilder().create().typedToJson(data)

}