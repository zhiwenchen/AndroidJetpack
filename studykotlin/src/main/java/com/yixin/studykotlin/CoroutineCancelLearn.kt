package com.yixin.studykotlin

import kotlinx.coroutines.*

class CoroutineCancelLearn {
    fun testCancel1() {
        runBlocking {
            val job = launch(Dispatchers.IO) {
                println("job1 start")
                Thread.sleep(200)
                var count = 0
                while (count < 1000000000) {
                    count++
                }
                println("job1 end count:$count")
            }
            Thread.sleep(100)
            println("start cancel job")
            // 不会中断协程
            job.cancel()
            println("end cancel job")
        }
    }

    fun testCancel2() {
        runBlocking {
            val job = launch(Dispatchers.IO) {
                println("job1 start")
                try {
                    delay(3000)
                } catch (e : Exception) {
                    println("delay exception:$e")
                }
                println("job1 end")
            }
            Thread.sleep(100)
            println("start cancel job")
            // 不会中断协程
            job.cancel()
            println("end cancel job")
        }
    }

    fun testException1() {
        val coroutineExceptionHandler =
            CoroutineExceptionHandler { _, exception -> println("handle exception:$exception") }
        runBlocking {
            val scope = CoroutineScope(Job() + coroutineExceptionHandler)
            scope.launch(Dispatchers.IO) {
                println("job1 start")
                1/0
                println("job1 end")

            }
        }
    }

}