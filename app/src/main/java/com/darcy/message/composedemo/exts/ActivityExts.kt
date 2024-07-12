package com.darcy.message.composedemo.exts

import android.app.Activity
import android.content.Context
import android.content.Intent

fun Context.startPage(clazz: Class<out Activity>) {
    this.startActivity(Intent(this, clazz))
}