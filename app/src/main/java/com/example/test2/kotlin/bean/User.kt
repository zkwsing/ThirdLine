package com.example.test2.kotlin.bean

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(var firstName:String,var lastName:String,var age:Int) {
    @PrimaryKey(autoGenerate = true)//设置主键并自动生成
    var id:Long = 0
}