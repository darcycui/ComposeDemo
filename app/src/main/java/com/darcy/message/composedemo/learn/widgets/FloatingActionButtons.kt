package com.darcy.message.composedemo.learn.widgets

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.darcy.message.composedemo.exts.showToast
import com.darcy.message.composedemo.learn.ShowHomeContent

@Preview(showBackground = true)
@Composable
fun HomeFloatingActionButton() {
    val showHomePage = remember {
        mutableStateOf(false)
    }
    if (showHomePage.value) {
        ShowHomeContent()
        return
    }

    // 返回按键
    BackHandler {
        showHomePage.value = showHomePage.value.not()
    }

    Column {
        // FAB
        FloatingActionButton(onClick = { "FAB点击".showToast() }) {
            Icon(Icons.Filled.Home, contentDescription = "无障碍描述")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // 带文字的FAB
        ExtendedFloatingActionButton(
            text = { Text(text = "回首页") },
            onClick = { "带文字FAB点击".showToast() },
            icon = { Icon(Icons.Filled.Home, contentDescription = "无障碍描述") })
    }
}