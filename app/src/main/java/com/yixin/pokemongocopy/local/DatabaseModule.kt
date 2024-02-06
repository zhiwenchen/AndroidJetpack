package com.yixin.pokemongocopy.local

import android.app.Application
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(applicationContext: Application):PokemonDatabase {
        return Room.databaseBuilder(applicationContext, PokemonDatabase::class.java,"pokemondb").build()
    }

}