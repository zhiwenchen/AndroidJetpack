package com.yixin.pokemongocopy

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.yixin.pokemongocopy.databinding.ActivityMainBinding
import com.yixin.pokemongocopy.ui.MainViewModel
import com.yixin.pokemongocopy.ui.PokemonAdapter
import dagger.hilt.android.AndroidEntryPoint

// 要用AndroidEntryPoint注解，才能实例化有参数的ViewModel
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private val mAdapter = PokemonAdapter()
    // by字的用法
    // by viewModels位于androidx.activity:activity-ktx
    private val mViewModel:MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 使用DataBinding
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        mViewModel.postData()
        mBinding.apply { // apply 函数
            mBinding.recyclerView.adapter = mAdapter
        }

        mViewModel.pokemonLiveData.observe(this, Observer {

        })

    }
}