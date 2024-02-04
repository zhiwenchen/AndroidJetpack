package com.yixin.studykotlin

class LambdaTest {

    fun a(s:String, block: () -> String) {

    }

    fun b() {
        a("hello") {
             "world"
        }
    }
}