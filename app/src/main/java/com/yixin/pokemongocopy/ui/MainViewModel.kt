package com.yixin.pokemongocopy.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.yixin.pokemongocopy.model.PokemonItemModel
import com.yixin.pokemongocopy.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository): ViewModel() {

    val pokemonLiveData: MutableLiveData<List<PokemonItemModel>> = MutableLiveData()
    val pokemonPageData: MutableLiveData<PagedList<PokemonItemModel>> = MutableLiveData()

    // page分页学习


    // cachedIn 学习
    // asLiveData 学习
    // Flow 学习：用来替代LiveData，和RxJava类似
    fun postData() {
        //async 带有返回值
        //launch 不带返回值
        viewModelScope.launch {
            pokemonLiveData.value = repository.fetchPokemonList()
        }

    }
}