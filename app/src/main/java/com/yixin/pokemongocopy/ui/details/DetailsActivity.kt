package com.yixin.pokemongocopy.ui.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.yixin.pokemongocopy.R
import com.yixin.pokemongocopy.databinding.ActivityDetailsBinding
import com.yixin.pokemongocopy.databinding.ActivityMainBinding
import com.yixin.pokemongocopy.model.PokemonInfoModel
import com.yixin.pokemongocopy.model.PokemonItemModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsActivity:AppCompatActivity() {

    private val detailsViewModel: DetailsViewModel by viewModels()
    private lateinit var mBinding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_details)

        mBinding.viewModel = detailsViewModel

        intent.extras?.let {
            val name = it.getString("name")!!
            val url = it.getString("url")!!
            val pokemonInfo = PokemonItemModel("",name,url)
            mBinding.pokemonListModel = pokemonInfo

            detailsViewModel.fechPokemonInfo("bulbasaur")
        }
        mBinding.lifecycleOwner = this

    }

    companion object {
        fun jumpAcrtivity(act: Context, params: PokemonItemModel) {
            val intent = Intent(act, DetailsActivity::class.java)
            intent.putExtra("name", params.name)
            intent.putExtra("url", params.url)
            act.startActivity(intent)
        }
    }
}