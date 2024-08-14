package com.example.test2.kotlin.bean

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class SimWorker(context:Context,params:WorkerParameters):Worker(context,params) {
    override fun doWork(): Result {
       Log.e("kkkkkkk","do word in SimWorker")
        return Result.success()
    }
}