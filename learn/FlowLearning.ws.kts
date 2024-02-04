fun simple(): List<Int> = listOf(1, 2, 3)

fun main() {
    simple().forEach { value -> println(value) }
}

main()

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
main2()

suspend fun simple3(): List<Int> {
    delay(1000)
    return listOf(1,2,3)
}
fun main3() = runBlocking<Unit> {
    simple3().forEach{value -> println(value)}
}

fun simple3()
