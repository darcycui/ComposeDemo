package com.darcy.message.composedemo.ui.pages.health.ui.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import com.darcy.message.composedemo.ui.pages.health.data.getWellnessTasks

// 为所有可组合函数提供默认的 Modifier，从而提高可重用性
val commonModifier: Modifier = Modifier

// 主屏幕View
@Composable
fun WellnessScreen(modifier: Modifier = commonModifier) {
    Column(modifier = modifier) {
//    WaterCounter(modifier)
        // 使用有状态组合函数
        StatefulWaterCounter(modifier)
        // 任务列表 TODO 使用 toMutableStateList() 转为compose可观察的list
        val list = remember { getWellnessTasks().toMutableStateList() }
        WellnessTasksList(
            list = list,
            // 在点击事件中 从数据源移除item
            onCloseTask = { task -> list.remove(task) })
    }
}