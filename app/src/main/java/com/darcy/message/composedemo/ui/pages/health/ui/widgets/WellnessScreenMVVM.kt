package com.darcy.message.composedemo.ui.pages.health.ui.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.darcy.message.composedemo.ui.pages.health.data.getWellnessTasks
import com.darcy.message.composedemo.ui.pages.health.viewmodel.WellnessViewModel

// 主屏幕View
@Composable
fun WellnessScreenMVVM(
    modifier: Modifier = commonModifier,
    wellnessViewModel: WellnessViewModel = viewModel() // 使用viewModel()获取ViewModel
) {
    Column(modifier = modifier) {
//    WaterCounter(modifier)
        // 使用有状态组合函数
        StatefulWaterCounter(modifier)
        WellnessTasksList(
            // 任务列表
            list = wellnessViewModel.tasks,
            // 选中、取消选中事件
            onCheckedTask = { task, checked ->
                wellnessViewModel.changeTaskChecked(task, checked)
            },
            // 在点击事件中 从数据源移除item
            onCloseTask = { task -> wellnessViewModel.remove(task) })
    }
}