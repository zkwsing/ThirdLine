package com.example.test2.kotlin


fun String.lettersCount(): Int {//顶层方法 扩展函数
    var count = 0
    for (char in this) {
        if(char.isLetter()){
            count++
        }
    }
    return count
}




