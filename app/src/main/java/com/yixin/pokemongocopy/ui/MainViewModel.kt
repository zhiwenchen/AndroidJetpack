package com.yixin.pokemongocopy.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.yixin.pokemongocopy.model.PokemonItemModel
import com.yixin.pokemongocopy.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository): ViewModel() {

    // cachedIn 学习
    // asLiveData 学习
    // Flow 学习：用来替代LiveData，和RxJava类似
    fun postData(){
        //async 带有返回值
        //launch 不带返回值
        viewModelScope.launch {
            val pokemonList = repository.fetchPokemonList()
        }
    }
}