package com.yixin.pokemongocopy.repository

import com.yixin.pokemongocopy.remote.PokemonService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideTasksRepository(
        api: PokemonService,
    ): Repository {
        return PokemonRepositoryImpl(api)
    }
}