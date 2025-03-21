package com.darcy.message.composedemo.ui.pages.health.data

import com.darcy.message.composedemo.ui.pages.health.bean.WellnessTask

/**
 * 模拟业务逻辑
 */
fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }