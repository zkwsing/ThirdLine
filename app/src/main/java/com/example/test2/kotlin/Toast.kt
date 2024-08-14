package com.example.test2.kotlin

import android.content.Context
import android.widget.Toast
import com.example.test2.MyApplication

fun String.showToast(context:Context){
    Toast.makeText(context,this,Toast.LENGTH_SHORT).show()
}
fun Int.showToast(context:Context){
    Toast.makeText(context,this,Toast.LENGTH_SHORT).show()
}
fun String.showToast(){
    Toast.makeText(MyApplication.context,this,Toast.LENGTH_SHORT).show()
}

fun String.showToast(context:Context,duration:Int  = Toast.LENGTH_SHORT){
    Toast.makeText(context,this,duration).show()
}

fun main(args: Array<String>) {
    val li = listOf("i", "love", "my", "wife")
    val st = listOf("with", "all", "myyy", "heart")
    // 合并，取出li和st中长度为4的元素形成2个集合，再把2个集合中对应的元素经过运算一个新的元素，返回这些元素组成的集合
    val merge =
        li.filter { it.length == 4 }
            .zip(st.filter { it.length == 4 }) { l, s -> l.plus("_").plus(s) }
    println(merge)

}