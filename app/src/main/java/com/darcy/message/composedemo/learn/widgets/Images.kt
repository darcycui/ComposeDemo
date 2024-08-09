package com.darcy.message.composedemo.learn.widgets

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.darcy.message.composedemo.R
import com.darcy.message.composedemo.learn.ShowHomeContent

@Preview(showBackground = true)
@Composable
fun HomeImage() {
    val showHomePage = remember {
        mutableStateOf(false)
    }
    if (showHomePage.value) {
        ShowHomeContent()
        return
    }
    BackHandler {
        showHomePage.value = showHomePage.value.not()
    }
    Column {
        // 加载本地图片
        Image(
            painter = painterResource(id = R.drawable.cat),
            contentDescription = "",
            // 设置图片缩放类型 Crop忽略图片自身宽高比
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(200.dp)
                // 圆形
                .clip(CircleShape)
                // 边框
                .border(1.dp, Color.Green, CircleShape),
        )
        val dataUrl = remember {
            "https://avatars.githubusercontent.com/u/20441547?s=200&v=4"
        }
        Spacer(modifier = Modifier.height(10.dp))

        // 加载网络图片
        Image(
            // 使用coil提供的Painter加载网络图片
            painter = rememberAsyncImagePainter(dataUrl),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
                .border(1.dp, Color.Yellow, CircleShape),
        )

    }
}