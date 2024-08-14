package com.example.test2.kotlin.model

import android.view.animation.Transformation
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.switchMap
import com.example.test2.kotlin.bean.User
import com.example.test2.kotlin.lifecycle.Repository
import com.example.test2.kotlin.lifecycle.Repository.refresh

class MainViewModel(countReserved:Int):ViewModel() {
    //var counterOne  = 0
    //var counter  = countReserved
    //因为kotlin为变量提供了默认实现，而如果需要覆盖掉原来的getter，那么就需要进行手动实现，也就是在变量下方写上get() = ...
    val counter : LiveData<Int>get() = _counter
    private val _counter = MutableLiveData<Int>()
    init {
        _counter.value = countReserved
    }
    fun plusOne(){
        val count  = _counter.value?:0
        _counter.value = count+1
    }
    fun clear(){
        _counter.value = 0
    }

    val userLiveData  = MutableLiveData<User>()
    val userName:LiveData<String> = userLiveData.map { user ->
        "${user.firstName} ${user.lastName}"
    }

    private val userIdLiveData = MutableLiveData<String>()

    val user:LiveData<User> = userIdLiveData.switchMap {
        //getUserLiveData(it)
        Repository.getUser(it)
    }
    fun getUserLiveData(userId:String):LiveData<User>{
        return Repository.getUser(userId)
    }
    fun getUser(userId:String){
        userIdLiveData.value = userId
    }

    private val refreshLiveData = MutableLiveData<Any?>()
    val refreshResult = refreshLiveData.switchMap {
        Repository.refresh()
    }
    fun refresh() {
        refreshLiveData.value = refreshLiveData.value
    }
}