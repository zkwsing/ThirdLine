package com.example.test2.kotlin

import android.content.Context


class Money(val value: Int) {
    operator fun plus(money: Money): Money {
        val sum = value + money.value
        return Money(sum)
    }
    operator fun plus(newValue: Int): Money {
        val sum = value + newValue
        return Money(sum)
    }
}

fun main(args: Array<String>) {
//    val m1 = Money(5)
//    val m2 = Money(15)
//    val m3 = m1+m2
//    println(m3.value)
    val maxNum = max(1.2,3.4,1.1)
    println(maxNum)
    //"a".showToast(context)

}

fun <T:Comparable<T>> max(vararg nums:T):T{
    if(nums.isEmpty())throw RuntimeException("Params can not empty.")
    var maxNum = nums[0]
    for (num in nums){
        if(num>maxNum){
            maxNum = num
        }

    }
    return maxNum
}