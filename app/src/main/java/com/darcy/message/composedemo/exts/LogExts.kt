package com.darcy.message.composedemo.exts

import android.util.Log

const val LOG_TAG = "DarcyLog"
fun Any?.logD(message: String, tag: String? = LOG_TAG) {
    Log.d(tag, "$tag: $message")
}

fun Any?.logE(message: String, tag: String? = LOG_TAG) {
    Log.e(tag, "$tag: $message")
}

fun Any?.logI(message: String, tag: String? = LOG_TAG) {
    Log.i(tag, "$tag: $message")
}

fun Any?.logV(message: String, tag: String? = LOG_TAG) {
    Log.v(tag, "$tag: $message")
}

fun Any?.logW(message: String, tag: String? = LOG_TAG) {
    Log.w(tag, "$tag: $message")
}