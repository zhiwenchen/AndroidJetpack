package com.yixin.pokemongocopy.ui

import androidx.recyclerview.widget.DiffUtil
import com.yixin.pokemongocopy.model.PokemonItemModel

class PokemonItemCallback: DiffUtil.ItemCallback<PokemonItemModel>() {

    // 判断主键是否相同
    override fun areItemsTheSame(oldItem: PokemonItemModel, newItem: PokemonItemModel): Boolean {
        return oldItem.name.equals(newItem.name)
    }

    // 判断内容是否相同
    override fun areContentsTheSame(oldItem: PokemonItemModel, newItem: PokemonItemModel): Boolean {
        return oldItem.name.equals(newItem.name)
                && oldItem.url.equals(newItem.url)
    }
}