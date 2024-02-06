package com.yixin.pokemongocopy.ui.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yixin.pokemongocopy.model.PokemonInfoModel
import com.yixin.pokemongocopy.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

// 详情界面的数据
@HiltViewModel
class DetailsViewModel @Inject constructor(private val repository: Repository): ViewModel() {

    val pokemon: MutableLiveData<PokemonInfoModel> = MutableLiveData<PokemonInfoModel>()

    fun fechPokemonInfo(name: String) {
        viewModelScope.launch {
            val pokemonInfo = viewModelScope.async (Dispatchers.IO) {// 在异步线程获取数据
                repository.fetchPokemonInfo(name)
            }
            // 在主线程更新
            pokemon.value = pokemonInfo.await()
        }
    }

}