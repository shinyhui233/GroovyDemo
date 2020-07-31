package com.mi.war.groovydemo

import android.app.Activity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : Activity() {
    val TAG = "dream"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MainScope().launch{
            Log.d("dream", "一个人的街，一杯咖啡: ${Thread.currentThread().name}")
            withContext(Dispatchers.IO) {
                Log.d("dream", "等一个人: ${Thread.currentThread().name}")
                delay(5000)
                Log.d("dream", "what's the time now: ${System.currentTimeMillis()}")
            }
            Log.d("dream", "渣男鉴定: ${Thread.currentThread().name}")
            text_view.text = "行不行嘛"
        }

        MainScope().launch {
            Log.d(TAG, "onCreate: ")
            launch(Dispatchers.IO) {
                Log.d(TAG, "一眼万年")
                delay(5000)
                Log.d(TAG, "终于等到你")
            }
            text_view.text = "这都行了吧"
        }
    }

    private suspend fun loadAsync() {
        withContext(Dispatchers.IO) {
            Log.d("dream", "loadAsync: ${Thread.currentThread().name}")
            delay(5000)
            Log.d("dream", "what's the time now: ${System.currentTimeMillis()}")
        }

    }
}