package com.darcy.message.composedemo.learn.widgets

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.darcy.message.composedemo.R
import com.darcy.message.composedemo.learn.ShowHomeContent

@Preview(showBackground = true)
@Composable
fun HomeIcon() {
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

    Row {
        // 矢量图创建Icon
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.darcy_dog),
            contentDescription = "",
            // 着色器着色
            tint = Color.Black
        )
        Spacer(modifier = Modifier.width(8.dp))
        // 图片资源创建Icon
        Icon(
            bitmap = ImageBitmap.imageResource(id = R.drawable.icon),
            contentDescription = "",
            // png图片设置不着色 否则图片显示黑色
            tint = Color.Unspecified,
        )
        Spacer(modifier = Modifier.width(8.dp))
        // 其他资源创建Icon(也支持以上两种资源)
        Icon(
            painter = painterResource(id = R.drawable.icon),
            contentDescription = "",
            tint = Color.Unspecified,
        )
        Spacer(modifier = Modifier.width(8.dp))
        Icon(
            painter = painterResource(id = R.drawable.darcy_dog),
            contentDescription = "",
            tint = Color.Green,
        )
    }
}
