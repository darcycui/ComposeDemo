package com.darcy.message.composedemo.exts

import android.util.Log

const val LOG_TAG = "Darcy"
fun Any?.logD(tag: String? = LOG_TAG) {
    Log.d(tag, "$tag: $this")
}
fun Any?.logE(tag: String? = LOG_TAG) {
    Log.e(tag, "$tag: $this")
}
fun Any?.logI(tag: String? = LOG_TAG) {
    Log.i(tag, "$tag: $this")
}
fun Any?.logV(tag: String? = LOG_TAG) {
    Log.v(tag, "$tag: $this")
}
fun Any?.logW(tag: String? = LOG_TAG) {
    Log.w(tag, "$tag: $this")
}