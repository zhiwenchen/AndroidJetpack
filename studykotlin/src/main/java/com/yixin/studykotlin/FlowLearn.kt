package com.yixin.studykotlin

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

class FlowLearn {

    fun simple(): List<Int> = listOf(1, 2, 3)

    fun main() {
        simple().forEach { value -> println(value) }
    }

    // 序列的好处体现在链式调用的操作
// 使用Sequence，可以延迟执行这些操作，直到需要结果时才计算
// sequence是一个挂起函数，可以产生一个延迟计算的序列，
// 使用yield或者yieldAll来产生序列中的元素
    fun simple2(): Sequence<Int> = sequence {
        for(i in 1..3) {

            Thread.sleep(100)
            yield(i)
        }
    }

    fun main2() {
        // 这种情况会阻塞调用的线程
        simple2().forEach{value -> println(value)}
        // take操作，取前n个元素
        simple2().take(10).forEach {  }
    }

    suspend fun simple3(): List<Int> {
        delay(1000)
        return listOf(1,2,3)
    }
    fun main3() = runBlocking<Unit> {
        simple3().forEach{value -> println(value)}
    }

    fun simple4(): Flow<Int> = flow {
        for(i in 1..3) {
            delay(100)
            // 使用emit用来发送下一个值，类似yield
            emit(i)
        }
    }

    fun main4() = runBlocking {
        // 流使用collect用来收集数据
        simple4().collect{ value -> println("main4 $value") }
        println("main4 after simle4")
        withTimeoutOrNull(250) {
            simple4().collect(){value -> println("main4 $value")}
        }
        println("Done")
    }
    // 其他的流构建器
    fun main5() = runBlocking {
        // 将整数区间使用asFlow转化为流
        (1..3).asFlow().collect{value -> println(value)}
    }
    // 过渡流操作符，这些操作符中的代码可以调用挂起函数
    suspend fun performRequest(request: Int): String {
        delay(1000)
        return "response $request"
    }

    fun main6() = runBlocking {
        (1..3).asFlow()
                // map函数：操作后返回
            .map {request->performRequest(request)}
            .collect { response -> println(response)}
    }

    // 转换操作符
    // 例如transform，可以实现自定义的转换
    fun main7() = runBlocking {
        (1..3).asFlow()
            .transform { request ->
                emit("Making request $request")
                emit(performRequest(request))
            }
            .collect{ response -> println(response)}
    }

    // 限长操作符（如 take），取消操作会通过抛出异常来处理，所以try finally会执行finally的部分
    fun numbers(): Flow<Int> = flow {
        try {
            emit(1)
            emit(2)
            println("This line will not execute")
            emit(3)
        } finally {
            println("Finally in numbers")
        }
    }

    fun main8() = runBlocking {
        numbers().take(2).collect{value -> println(value)}
    }

    // 末端流操作符
    // collect是最基础的末端操作符，还有一些更方便的操作符
    // 转化为各种集合：如toList和toSet
    // 获取第一个值的操作符（first），每次只发射一个值的操作符（single）
    // reduce与fold操作符
    fun main9() = runBlocking {
        (1..5).asFlow()
            .map{ it * it}
            .reduce{ a,b -> a + b}
    }

    // 流是连续的，意思是只要处理了一个值，就会发送给下一个值，而不是处理完所有的值再发送给下一个值
    fun main10() = runBlocking {
        (1..5).asFlow()
            .filter {
                println("Filter $it")
                it %2 == 0
            }
            .map{
                println("Map $it")
                "string $it"
            }
            .collect {
                println("Collect $it")
            }
    }
    // 输出
//```kotlin
//    Filter 1
//    Filter 2
//    Map 2
//    Collect string 2
//    Filter 3
//    Filter 4
//    Map 4
//    Collect string 4
//    Filter 5
//```
//
}