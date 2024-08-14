package com.example.test2

import kotlin.math.max

class LearnKotlin {

}

fun main(args: Array<String>) {
    println(largerNumber(55,10))
}

fun largerNumber(num1:Int,num2:Int):Int{
    return  max(num1,num2)
}
fun largerNumber2(num1:Int,num2:Int):Int = max(num1,num2)
fun largerNumber3(num1:Int,num2:Int) = max(num1,num2)