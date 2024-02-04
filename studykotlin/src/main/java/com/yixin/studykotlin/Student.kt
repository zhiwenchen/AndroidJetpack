package com.yixin.studykotlin

class Student(var name: String) {
    private var id: Int = 0

    constructor(name: String, id: Int):this(name) {
        this.id = id
    }

    fun show() {
        println("id $id, name $name")
    }

    fun test() {
        val intSet = listOf(21, 40, 11, 33, 78)
        val resultSet = mutableSetOf<Int>()
        intSet.forEach {
            if (it % 3 == 0) {
                resultSet.add(it)
            }
        }
        val filter: List<Int> = intSet.filter { i -> i % 3 == 0 }


    }


}