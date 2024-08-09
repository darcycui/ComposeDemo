package com.darcy.message.composedemo.learn.widgets

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.darcy.message.composedemo.learn.ShowHomeContent

@Preview(showBackground = true)
@Composable
fun HomeIndicator() {

    val showHomePage = remember {
        mutableStateOf(false)
    }
    if (showHomePage.value) {
        ShowHomeContent()
        return
    }
    // 返回按键监听
    BackHandler {
        showHomePage.value = showHomePage.value.not()
    }

    Column {
        LinearProgressIndicator()
        Spacer(modifier = Modifier.height(10.dp))
        CircularProgressIndicator()
    }
}