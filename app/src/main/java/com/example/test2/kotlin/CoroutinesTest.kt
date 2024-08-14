package com.example.test2.kotlin

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlin.coroutines.suspendCoroutine

fun main(args: Array<String>) {
//    GlobalScope.launch {
//        println("codeone")
//        delay(1500)
//        println("codetwo")
//    }
//    runBlocking  {
//        launch {
//            println("codeone")
//            delay(1000)
//            println("codetwo")
//        }
//       launch {
//           println("111")
//           delay(1000)
//           println("222")
//       }
//    }
    //Thread.sleep(1000)
    //println("4444444")
//    val start  = System.currentTimeMillis()
//    runBlocking {
//        repeat(100000){
//            launch {
//                println(".")
//            }
//        }
//    }
//    val end  = System.currentTimeMillis()
//    println(end - start)
    // printDot()

//     runBlocking {//coroutineScope携程作用域构建器创建 553页携程作用域
//         val result = async {
//             5+98
//         }.await()
//         println("结果$result")
//     }

    runBlocking {
        val result = withContext(Dispatchers.Default) {//Dispatchers.Default、Dispatchers.IO和 Dispatchers.Main。
            5 + 5
        }
        println(result)
    }



    //协程是一种轻量级的线程的概念
    //async同步函数
    //withContext挂起函数

}
suspend fun request(address:String):String{
    return suspendCoroutine { continuation ->

    }
}

suspend fun printDot() = coroutineScope {
    launch {
        println(".")
        delay(1000)
    }
}

fun a() {
    val job = Job()
    val coroutineScope = CoroutineScope(job)
    coroutineScope.launch {
        delay(1000)
    }
    job.cancel()
}
