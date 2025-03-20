package com.darcy.message.composedemo.learn.containers

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun HomeList() {
    val list = remember {
        mutableListOf<String>()
    }
    list.add("darcy")
    list.add("darcy")
}