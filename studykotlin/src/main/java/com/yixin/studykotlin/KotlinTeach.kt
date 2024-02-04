package com.yixin.studykotlin

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.net.URL

class KotlinTeach:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val imageView: ImageView = findViewById(R.id.imageView)
        Thread {
            val bitmap = downloadImage("https://www.tst.com")
            runOnUiThread {
                imageView.setImageBitmap(bitmap)
            }
        }.start()

        runBlocking {
            launch {

            }
        }

        lifecycleScope.launch(Dispatchers.Main){
            val bitmap:Bitmap? = withContext(Dispatchers.IO) {
                downloadImage("")
            }
            imageView.setImageBitmap(bitmap)
        }
    }
    fun onCreate() {
    }

    fun downloadImage(imageUrl: String): Bitmap? {
        var bitmap: Bitmap?
        val connection = URL(imageUrl).openConnection()
        // use是对closable对象的扩展函数，表示自动关闭资源
        connection.inputStream.use {
            bitmap = BitmapFactory.decodeStream(it)
        }
        return bitmap
    }
}