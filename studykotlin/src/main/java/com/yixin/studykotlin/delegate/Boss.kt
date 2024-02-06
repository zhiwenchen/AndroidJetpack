package com.yixin.studykotlin.delegate

// 类委托，将Work的实现委托给employee
class Boss(private val employee: Employee) : Work by employee {

    fun main() {
        val boss = Boss(Employee())
        boss.app()
    }


}