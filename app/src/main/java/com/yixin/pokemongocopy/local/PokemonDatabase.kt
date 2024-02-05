package com.yixin.pokemongocopy.local

import androidx.room.RoomDatabase

abstract class PokemonDatabase: RoomDatabase() {

    abstract fun pokemonDao():PokemonDao
}