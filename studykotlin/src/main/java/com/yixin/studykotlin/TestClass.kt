package com.yixin.studykotlin

class TestClass private constructor(var name: String) {

    constructor(name: String, id: Int): this(name) {

    }

    fun test(name:String): TestClass {
        return TestClass(name)
    }

    fun area(width: Int, height: Int): Int {
        return width * height
    }

    fun area1(width: Int, height: Int): Int = width * height

    // 默认参数
    fun sayHi(name: String = "world") = println("Hi $name")

    fun login(user: String, password: String) {
        require(user.isNotEmpty()){""}

        if (user.isEmpty()) {
            throw IllegalArgumentException("")
        }
        if (password.isEmpty()) {
            throw IllegalArgumentException("")
        }

        fun validate(value: String) {
            if (value.isEmpty()) {
                throw IllegalArgumentException("")
            }
        }
        validate(user)
        validate(password)
    }

    fun stringTest() {
        val name = "worlid"
        println("Hi ${name.length}")
    }

    // 创建数组
    val strs: Array<String> = arrayOf("a","b","c")
    // 集合，有 List、Set、Map
    fun collectionTest() {
        val strList = listOf("a","b","c")
        strList.forEach { i ->
            print("$i ")
        }

        val anys:List<Any> = strList

        var strSet = setOf("a","b","c")

        val strMap = mapOf("key1" to 1, "key2" to 2)
        val value1 = strMap.get("key1")
        val value2 = strMap["key2"]

        val mutableMap = mutableMapOf<String, Int>("key1" to 1)
        mutableMap["key2"] = 2

        val toMutableMap = strMap.toMutableMap()
        toMutableMap["key3"] = 3

        sequenceOf("a","b","c")

        val sequence = generateSequence(0) { it + 1 }
    }


    fun test() {
        // 支持方括号+下标的方式
        println(strs[0])
        strs[0] = "b"
    }

    fun conditionTest(a:Int, b: Int, x: Int) {
        val max = if (a > b) a else b
        val max1 = if (a > b) {
            println("max: a")
            a
        } else {
            println("max: b")
            b
        }

        when(x) {
            1 -> {println("1")}
            2, 3-> {println("2 or 3")}
//            println()
            else -> {println("else")}
        }
    }

    fun nullTest() {
        var str: String? = "Hello"
        val length: Int = str?.length ?: -1
    }

    class User(var id:Int) {
    }

    fun validate(user: User) {
        val id = user.id ?: return
        println(id)
    }
}