package com.example.test2.kotlin

import android.util.Log
import kotlinx.coroutines.CoroutineName
import kotlin.concurrent.thread
import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.createCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

fun main(args: Array<String>) {
    val b = suspend {
        val a = hello2()
        a
    }
    b.createCoroutine(MyContinuation()).resume(Unit)
}
suspend fun hello2() = suspendCoroutine<Int> {
    thread{
        println("开始时间${System.currentTimeMillis()}")
        Thread.sleep(5000)
        println("结束时间${System.currentTimeMillis()}")
        it.resume(10086)
    }
}
class MyContinuation() : Continuation<Int> {
    override val context: CoroutineContext = CoroutineName("Co-01")
    override fun resumeWith(result: Result<Int>) {
      println("MyContinuation resumeWith 结果 = ${result.getOrNull()}")
    }
}