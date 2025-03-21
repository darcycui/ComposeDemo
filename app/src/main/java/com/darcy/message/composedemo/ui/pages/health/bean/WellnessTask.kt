package com.darcy.message.composedemo.ui.pages.health.bean

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

class WellnessTask(
    val id: Int,
    val label: String,
    initialChecked: Boolean = false
) {
    // TODO 这里 checked 必须是状态变量 否则选中item 无法刷新UI
    var checked: Boolean by mutableStateOf(initialChecked)
}