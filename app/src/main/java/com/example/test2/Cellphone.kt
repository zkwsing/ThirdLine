package com.example.test2

data class Cellphone(val a:String,val b:Double)

fun main() {
    val a = Cellphone("aaa",123.99);
    val b = Cellphone("aaa",123.99);
    println(a)
    println(b)
    println(a==b)
}