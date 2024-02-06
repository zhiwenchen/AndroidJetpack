package com.yixin.pokemongocopy.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.yixin.pokemongocopy.entity.PokemonInfoEntity

@Database(
    entities = arrayOf(PokemonInfoEntity::class),
    version = 1, exportSchema = false
)
@TypeConverters(value = arrayOf(LocalTypeConverter::class))
abstract class PokemonDatabase: RoomDatabase() {

    abstract fun pokemonDao():PokemonDao
}