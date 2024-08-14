package com.example.test2.kotlin.lifecycle

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.test2.kotlin.bean.User

object Repository {
    fun getUser(userId:String):LiveData<User>{
        val liveData = MutableLiveData<User>()
        liveData.value = User(userId,userId,0)
        return liveData
    }

    fun refresh():LiveData<Any?> {
        return  MutableLiveData<Any?>()
    }
}