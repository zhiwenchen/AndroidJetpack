package com.yixin.studykotlin

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*
import java.net.HttpURLConnection
import java.net.URL

const val imageUrl1 = "https://825y.com/wp-content/uploads/2023/01/8c925c40064b6adb973f8d237e4d9729.jpeg"
const val imageUrl = "https://825y.com/wp-content/uploads/2023/01/8c925c40064b6adb973f8d237e4d9729.jpeg"
class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG: String = "Coroutine"
    }

    private lateinit var imageView: ImageView
    private lateinit var imageView2: ImageView
    private lateinit var textView:TextView
    private val mainScope = MainScope()
    var s: String ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.text_view)
        imageView = findViewById(R.id.imageView)
        imageView2 = findViewById(R.id.imageView2)

        GlobalScope.launch(Dispatchers.IO) {
            Log.e(TAG, "Coroutine")
        }
        Log.e(TAG, "Hello")

        var flowLearn = FlowLearn()
        flowLearn.main4()
//        lifecycleScope.launch {
//            async(Dispatchers.Main) {
//                Log.e(TAG, "onCreate: launch begin")
//                delay(1000)
//                Log.e(TAG, "onCreate: launch after")
//            }
//            Log.e(TAG, "onCreate: after async")
//            withContext(Dispatchers.Main) {
//                delay(1000)
//                Log.e(TAG, "withContext")
//            }
//            Log.e(TAG, "after withContext")
//        }
        lifecycleScope.launch(Dispatchers.Main) {
            Log.e(TAG, "before withContext,threadName:${Thread.currentThread().name}")
            withContext(Dispatchers.IO) {
                Log.e(TAG, "in withContext start,threadName:${Thread.currentThread().name}")
                delay(1000)
                Log.e(TAG, "in withContext end,threadName:${Thread.currentThread().name}")
            }
            Log.e(TAG, "after withContext,threadName:${Thread.currentThread().name}")
        }

//        Log.e(TAG, "onCreate")


//        Glide.with(this).load(imageUrl1).into(imageView)
//
//
//
//        val list = listOf("Apple","Banana","Pear")
//        val maxLengthFruit = list.maxBy{it.length}
//
//        val cancelLearn = CoroutineCancelLearn()
//        cancelLearn.testException1()
//
//        val channelTest = ChannelTest()
//        channelTest.channelTest1()
    }

    override fun onDestroy() {
        super.onDestroy()
        // 取消协程
        mainScope.cancel()
    }

    fun setTest() {
//        lifecycleScope.rea {  }
        lifecycleScope.launch(Dispatchers.Main){
            val result = getImage("")
            launch {

            }
            runBlocking {

            }
            textView.setText("图片下载完成")
            imageView.setImageBitmap(result)
        }
        textView.setText("Hello Kotlin Application")
    }

    fun asyncLearn() {
        lifecycleScope.launch(Dispatchers.Main) {
            val logoJob: Deferred<Bitmap?>  = async {
                getImage(imageUrl)
            }
            val logo:Bitmap? = logoJob.await()
            imageView.setImageBitmap(logo)
        }

    }

    fun asyncTest() {



        GlobalScope.launch(Dispatchers.Main) {
            val avatar: Deferred<Bitmap?> = async { getImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSnrfvIAsFg_X2uVat8mw7DJWkUAwR3LHZ_wtZHaY6u5g&s") }
            val logo = async { getImage(imageUrl1) }
            delay(1000)
            textView.setText("图片下载中")

            imageView.setImageBitmap(avatar.await())
            imageView2.setImageBitmap(logo.await())
            textView.setText("图片下载完成")

        }
    }



    fun exercise() {
        lifecycleScope.launch(Dispatchers.Main) {
            val logo = downloadImageWithIO(imageUrl)
            imageView.setImageBitmap(logo)
        }
        lifecycleScope.launch(block = block1)
    }

    private val block1: CoroutineScope.() -> Unit = {
        println("Hello, world!")
        launch {

        }
    }


    // 下载图片，转为位图
    suspend fun getImage(imageUrl: String): Bitmap? = withContext(Dispatchers.IO) {
            delay(5000)
            downloadImage(imageUrl)
    }

    suspend fun downloadImageWithIO(imageUrl: String): Bitmap? = withContext(Dispatchers.IO) {
        var myBitmap: Bitmap?
        val connection = URL(imageUrl).openConnection()
        connection.inputStream.use {
            myBitmap = BitmapFactory.decodeStream(it)
        }
        myBitmap
    }

    fun downloadImage(imageUrl: String): Bitmap?{
        var myBitmap:Bitmap? = null
        var connection = URL(imageUrl).openConnection()
        connection.inputStream.use {
            myBitmap = BitmapFactory.decodeStream(it)
        }

        try {
            val url = URL(imageUrl)

            connection = url.openConnection() as HttpURLConnection
            val myInput = connection.inputStream
            myInput.use {
                BitmapFactory.decodeStream(it)
            }
            myBitmap = BitmapFactory.decodeStream(myInput)
            myInput.close()
        } catch (e:Exception) {
            e.printStackTrace()
        }
        return myBitmap
    }

    // launch 执行没有返回值
    fun testLaunch() {
        println("before launch${Thread.currentThread()}")
        // 原理就是放到线程池中执行
        var job = GlobalScope.launch {
            println("launch thread:${Thread.currentThread()}")
            Thread.sleep(2000)
            println("launch end")
        }
        // 先执行这里，再执行launcher
//        job.join()
        println("after launch${Thread.currentThread()}")

    }

    fun testLaunchJoin() {
        runBlocking {
            val job = GlobalScope.launch {
                println("launching")
                Thread.sleep(10000)
                println("launch end")
            }
            job.join()
            println("after launch")
        }
    }

}


