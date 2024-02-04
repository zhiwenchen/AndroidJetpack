package com.yixin.pokemongocopy

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.yixin.pokemongocopy.databinding.ActivityMainBinding
import com.yixin.pokemongocopy.remote.PokemonService
import com.yixin.pokemongocopy.ui.MainViewModel
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    // by字的用法
    // by viewModels位于androidx.activity:activity-ktx
    private val mViewModel:MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 使用DataBinding
        mBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        mViewModel.postData()
//        mBinding.apply { // apply 函数
//
//        }

    }
}