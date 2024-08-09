package com.darcy.message.composedemo.learn.widgets

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.darcy.message.composedemo.R
import com.darcy.message.composedemo.exts.showToast
import com.darcy.message.composedemo.learn.ShowHomeContent

@Preview(showBackground = true)
@Composable
fun HomeIconButtons() {
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

    Row {
        // 可以点击的Icon
        IconButton(onClick = { "点击了Icon".showToast() }) {
            Icon(
                bitmap = ImageBitmap.imageResource(id = R.drawable.icon),
                contentDescription = "",
                // png需要设置着色模式 Unspecified
                tint = Color.Unspecified
            )
        }
        Spacer(modifier = Modifier.size(8.dp))
        IconButton(onClick = {
            "back".showToast()
            // 修改状态 触发重绘
            showHomePage.value = showHomePage.value.not()
        }) {
            Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "back")
        }
        Spacer(modifier = Modifier.size(8.dp))
        IconButton(onClick = { "forward".showToast() }) {
            Icon(imageVector = Icons.Filled.ArrowForward, contentDescription = "back")
        }
        Spacer(modifier = Modifier.size(8.dp))
        IconButton(onClick = { "close".showToast() }) {
            Icon(imageVector = Icons.Filled.Close, contentDescription = "back")
        }
        Spacer(modifier = Modifier.size(8.dp))
        IconButton(onClick = { "search".showToast() }) {
            Icon(imageVector = Icons.Filled.Search, contentDescription = "back")
        }
    }
}