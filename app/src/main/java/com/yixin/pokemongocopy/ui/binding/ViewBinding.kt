package com.yixin.pokemongocopy.ui.binding

import android.app.Activity
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import com.yixin.pokemongocopy.R
import com.yixin.pokemongocopy.model.PokemonItemModel
import com.yixin.pokemongocopy.ui.JProgressView
import com.yixin.pokemongocopy.ui.details.DetailsActivity

// 自定义databinding功能
@BindingAdapter("bindingAvator")
fun bindingAvator(imageView: ImageView, url: String) {
    imageView.load(url) {
        crossfade(true)
        placeholder(R.mipmap.ic_launcher_round)
    }
}

@BindingAdapter("bindSmallImage")
fun bindingSmallImage(imageView: ImageView, url: String) {
    imageView.load(url) {
        crossfade(true)
        placeholder(R.mipmap.ic_launcher_round)
        size(280, 280)
    }
}

//@BindingAdapter("bindLoading")
//fun bindingLoading(swipe: SwipeRefreshLayout, isLoading: Boolean) {
//    Timber.tag("bindingLoading").e(" isLoading = ${isLoading}")
//    swipe.isRefreshing = isLoading
//    if (!isLoading) swipe.isEnabled = false
//}

@BindingAdapter("bindProgressValue", "bindProgressMaxValue")
fun bindingProgressView(progress: JProgressView, progressValue: Int, maxProgressValue: Int) {
    progress
        .setProgress(progressValue.toFloat())
        .setMaxProgress(maxProgressValue)
        .startAnimal()
}

@BindingAdapter("bindFinish")
fun bindingFinish(view: View, finish: Boolean) {
    val ctx = view.context
    if (ctx is Activity && finish) {
        view.setOnClickListener { ctx.finish() }
    }
}

@BindingAdapter("bindClick")
fun bindingClick(view: View, model: PokemonItemModel) {
    view.setOnClickListener {
        DetailsActivity.jumpAcrtivity(view.context, model)
    }
}

//@BindingAdapter("bindAdapter", "bindData")
//fun bindingAdapter(
//    recyclerView: RecyclerView,
//    albumAdapter: AlbumAdapter,
//    data: List<PokemonInfoModel.AlbumModel>?
//) {
//    data?.let {
//        recyclerView.adapter = albumAdapter
//        albumAdapter.submitList(data)
//        albumAdapter.notifyDataSetChanged()
//    }
//
//}