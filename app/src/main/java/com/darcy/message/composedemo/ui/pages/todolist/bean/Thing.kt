package com.darcy.message.composedemo.ui.pages.todolist.bean

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class Thing(
    initThingName: String = "Todo",
    initIsFinished: Boolean = false
) {
    // TODO 名称是状态 使用变量委托初始化
    var thingName: String by mutableStateOf(initThingName)
    // 是否完成也是状态 使用变量委托初始化
    var isFinished: Boolean by mutableStateOf(initIsFinished)
}
