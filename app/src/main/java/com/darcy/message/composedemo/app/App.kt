package com.darcy.message.composedemo.app

import android.app.Application
import android.content.Context

class App : Application() {
    // 初始化
    companion object {
        lateinit var context: Context
    }
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        context = this
    }

    override fun onCreate() {
        super.onCreate()
    }
}