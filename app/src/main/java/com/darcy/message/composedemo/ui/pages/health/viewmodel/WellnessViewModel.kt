package com.darcy.message.composedemo.ui.pages.health.viewmodel

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.darcy.message.composedemo.ui.pages.health.bean.WellnessTask
import com.darcy.message.composedemo.ui.pages.health.data.getWellnessTasks

/**
 * 使用 ViewModel 管理页面状态
 */
class WellnessViewModel : ViewModel() {
    private val _tasks = getWellnessTasks().toMutableStateList()
    val tasks: List<WellnessTask>
        get() = _tasks

    fun remove(item: WellnessTask) {
        _tasks.remove(item)
    }

    fun changeTaskChecked(item: WellnessTask, checked: Boolean) {
        _tasks.find { it.id == item.id }?.let { task ->
            task.checked = checked
        }
    }
}