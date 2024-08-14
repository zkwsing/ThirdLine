package com.example.test2.kotlin

class Obj {
    operator fun plus(obj:Obj){

    }
}

fun main(args: Array<String>) {
    val obj1 = Obj()
    val obj2 = Obj()
    val obj3 = obj1+obj2
}
