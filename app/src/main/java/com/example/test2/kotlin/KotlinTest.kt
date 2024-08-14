package com.example.test2.kotlin

class KotlinTest {

    val list = listOf("1","22","333","4444","55555");
    val lab = {listItem:String -> listItem.length};

}

fun main() {
    val list = listOf("1","22","333","4444","55555");
    val lab = {listItem:String -> listItem.length};
    val maxLength = list.maxBy(lab)

    list.maxBy(){listItem:String -> listItem.length}
    list.maxBy{listItem:String -> listItem.length}
    list.maxBy{listItem -> listItem.length}
    list.maxBy{it.length}
    println("打印$maxLength ${maxLength.length}")

    val builser =  StringBuilder()
    builser.append("Start eating fruits.\n")
    for (fruit in list){
        builser.append(fruit).append("\n")
    }
    builser.append("Ate all fruits")
    val result = builser.toString()
    println(result)

    val result1 = with(StringBuilder()){
      append("Start eating fruits.\n")
        for (fruit in list){
            append(fruit).append("\n")
        }
        append("Ate all fruits")
        toString()
    }
//    fun ClassName.methodName(param1:Int,param2:Int):Int{
//            return 0
//    }



}
fun main(args: Array<String>) {
    val count = "123456qq@@@".lettersCount()

    println(count)

}
