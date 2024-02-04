package com.yixin.pokemongocopy.ui.base;

import androidx.annotation.LayoutRes;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseViewModel<M, VH extends RecyclerView.ViewHolder> {

    public M model;
    public VH viewHolder;

    public abstract void onBindView(RecyclerView.Adapter<?> adapter);

    int getItemViewType() {
        return getLayoutRes();
    }

    @LayoutRes
    public abstract int getLayoutRes();

}
