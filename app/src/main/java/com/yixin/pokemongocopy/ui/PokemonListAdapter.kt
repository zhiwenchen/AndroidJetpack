package com.yixin.pokemongocopy.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.ListAdapter
import com.yixin.pokemongocopy.R
import com.yixin.pokemongocopy.model.PokemonItemModel

class PokemonListAdapter(private val callback: PokemonItemCallback): ListAdapter<PokemonItemModel,PokemonViewHolder>(callback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = inflateView(parent, R.layout.recycler_item_pokemon)
        return PokemonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bindData(getItem(position),position)
    }

    private fun inflateView(viewGroup: ViewGroup, @LayoutRes viewType: Int): View {
        val layoutInflater = LayoutInflater.from(viewGroup.context)
        return layoutInflater.inflate(viewType, viewGroup, false)
    }
}