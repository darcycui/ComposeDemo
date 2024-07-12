package com.darcy.message.composedemo.exts

import android.widget.Toast
import com.darcy.message.composedemo.app.App

fun String.showToast() {
    Toast.makeText(App.context, this, Toast.LENGTH_SHORT).show()
}