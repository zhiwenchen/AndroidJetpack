package com.yixin.pokemongocopy.ui

import android.content.Context
import android.util.SparseArray
import android.view.View
import androidx.annotation.IdRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.yixin.pokemongocopy.databinding.RecyclerItemPokemonBinding
import com.yixin.pokemongocopy.model.PokemonItemModel

class PokemonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val mBinding: RecyclerItemPokemonBinding = DataBindingUtil.bind(view)!!

    fun bindData(data: PokemonItemModel, position: Int) {
        mBinding.apply {
            data.id = "#${position + 1}"
            pokemon = data
            executePendingBindings()
        }
    }

    //    View view
    init {

    }
}