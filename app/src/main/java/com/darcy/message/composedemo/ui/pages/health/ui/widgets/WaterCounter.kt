package com.darcy.message.composedemo.ui.pages.health.ui.widgets

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * 记录喝水次数View
 * 可组合函数应较小并可重复使用
 * 界面和状态在退出组合后的重置过程：
 * 1.count=0 -->不显示 Text 和 WellnessTaskItem
 * 2.点击 Add按钮 count=1 --> 显示 Text 和 WellnessTaskItem (showTask=true)
 * 3.点击 Close按钮 showTask=false --> 不再显示WellnessTaskItem
 * 4.再次点击 Add按钮 count=2 --> 显示 Text 但不显示WellnessTaskItem 因为记忆上次状态showTask=false
 * 5.点击 Clear按钮 count=0 --> 不再调用 Text 和 WellnessTaskItem相关代码
 * 6.再次点击 Add按钮 count=1 --> 显示 Text 和 WellnessTaskItem 因为忘记上次状态showTask=false
 */
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@SuppressLint("AutoboxingStateCreation")
@Composable
fun WaterCounterTest(modifier: Modifier = commonModifier) {

    Column(modifier = modifier.padding(16.dp)) {
        // TODO 使用 remember{mutableStateOf()} 初始化状态
//        val count: MutableState<Int> = remember { mutableStateOf(0) }
        // TODO 状态可以使用 by 属性委托初始化
        var count by remember { mutableStateOf(0) }
        // TODO 状态可以存储在ViewModel的LiveData/StateFlow里 待拓展


        if (count > 0) {
            var showTask by remember { mutableStateOf(true) }
            if (showTask) {
                WellnessTaskItem(
                    taskName = "Have you taken your 15 minute walk today?",
                    onClose = { showTask = false }
                )
            }
            Text(text = "You've had $count glasses.")
        }
        Row(Modifier.padding(top = 8.dp)) {
            Button(
                onClick = { count++ },
                enabled = count < 10
            ) {
                Text(text = "Add one")
            }
            Button(
                onClick = { count = 0 },
                Modifier.padding(start = 8.dp)
            ) {
                Text("Clear water count")
            }
        }

    }
}

@Composable
fun WaterCounter(modifier: Modifier = commonModifier) {
    Column(modifier = modifier.padding(16.dp)) {
        // TODO 在重组后保存状态
//        var count by remember { mutableStateOf(0) }
        // TODO 旋转屏幕等配置修改后仍能状态
        var count by rememberSaveable { mutableStateOf(0) }
        if (count > 0) {
            Text("You've had $count glasses.")
        }
        Button(onClick = { count++ }, Modifier.padding(top = 8.dp), enabled = count < 10) {
            Text("Add one")
        }
    }
}

/**
 * 无状态组合函数
 * 组合函数尽可能定义为无状态的 (推荐)
 * TODO 状态提升： 使用无状态组合函数，将状态变量和事件作为参数提升到调用方声明
 */
@Composable
fun StatelessWaterCounter(count: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            Text("You've had $count glasses.")
        }
        Button(onClick = onIncrement, Modifier.padding(top = 8.dp), enabled = count < 10) {
            Text("Add one")
        }
    }
}

/**
 * 有状态组合函数
 * 如果必须要定义为有状态的，内部状态也要尽可能少
 */
@Composable
fun StatefulWaterCounter(modifier: Modifier = commonModifier) {
    var count by remember { mutableStateOf(0) }
    StatelessWaterCounter(count, { count++ }, modifier)
}