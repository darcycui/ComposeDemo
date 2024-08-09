package com.darcy.message.composedemo.learn.widgets

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.darcy.message.composedemo.learn.ShowHomeContent

@Preview(showBackground = true)
@Composable
fun HomeSlider() {
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
    val progress = remember {
        mutableFloatStateOf(0f)
    }
    Column {

        // 拖动条
        Slider(
            value = progress.value,
            onValueChange = {
                progress.value = it
            },
            colors = SliderDefaults.colors(
                // 滑块颜色
                thumbColor = Color.White,
                // 滑轨颜色
                activeTrackColor = Color(0xFF0079D3)
            ),
            valueRange = 0f..100f,
//        steps = 20
        )
    }

}
