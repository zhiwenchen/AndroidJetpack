package com.yixin.pokemongocopy.ui.base

import android.util.SparseIntArray
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class ListAdapter<VM : BaseViewModel<*, *>> : RecyclerView.Adapter<BaseViewHolder>() {

    protected val layouts: SparseIntArray by lazy(LazyThreadSafetyMode.NONE) { SparseIntArray() }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return BaseViewHolder(LayoutInflater.from(parent.context).inflate(layouts[viewType], parent, false))
    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        layouts.append(item.itemViewType, item.layoutRes)
        return item.itemViewType
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val item = getItem(position)
        item.onBindView(this)
    }

    abstract fun getItem(position: Int): VM
}
