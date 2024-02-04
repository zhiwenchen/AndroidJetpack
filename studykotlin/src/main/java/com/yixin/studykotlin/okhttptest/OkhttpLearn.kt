package com.yixin.studykotlin.okhttptest

import okhttp3.*
import java.io.IOException

class OkhttpLearn {

    fun test() {

        val client = OkHttpClient()
        val request =  Request.Builder().url("").build();
        // 同步请求
        val response = client.newCall(request).execute();

        //异步请求
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call, response: Response) {
                TODO("Not yet implemented")
            }

        })

    }
}