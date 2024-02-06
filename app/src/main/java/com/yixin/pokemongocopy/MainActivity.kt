package com.yixin.pokemongocopy

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.yixin.pokemongocopy.databinding.ActivityMainBinding
import com.yixin.pokemongocopy.ui.MainViewModel
import com.yixin.pokemongocopy.ui.PokemonAdapter
import com.yixin.pokemongocopy.ui.PokemonItemCallback
import com.yixin.pokemongocopy.ui.PokemonListAdapter
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.internal.toImmutableList

// 要用AndroidEntryPoint注解，才能使用Hilt实例化有参数的ViewModel
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
//    private val mAdapter = PokemonAdapter()
    private val mAdapter = PokemonListAdapter(PokemonItemCallback())
    // by字的用法
    private val mViewModel:MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 使用DataBinding
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        mViewModel.postData()
        mBinding.apply { // apply 函数
            recyclerView.adapter = mAdapter
        }

        mViewModel.pokemonLiveData.observe(this, Observer {
            mAdapter.submitList(it)
        })

    }
}