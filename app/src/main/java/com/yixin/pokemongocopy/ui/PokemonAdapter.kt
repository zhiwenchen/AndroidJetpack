package com.yixin.pokemongocopy.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.yixin.pokemongocopy.R
import com.yixin.pokemongocopy.model.PokemonItemModel

class PokemonAdapter: RecyclerView.Adapter<PokemonViewHolder>() {

    private var dataList : List<PokemonItemModel>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = inflateView(parent, R.layout.recycler_item_pokemon)
        return PokemonViewHolder(view)
    }

    fun submitList(list:List<PokemonItemModel>) {
        dataList = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return dataList?.size ?: 0
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        if (dataList == null) return
//        DataBindingUtil.bind()
        holder.bindData(dataList!![position], position)
    }

    private fun inflateView(viewGroup: ViewGroup, @LayoutRes viewType: Int): View {
        val layoutInflater = LayoutInflater.from(viewGroup.context)
        return layoutInflater.inflate(viewType, viewGroup, false)
    }
}