package com.yixin.studykotlin.delegate

class Boss(private val employee: Employee) : Work by employee {

    fun main() {
        val boss = Boss(Employee())
        boss.app()
    }


}