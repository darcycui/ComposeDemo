package com.darcy.message.composedemo.ui.pages.todolist.viewmodel

import androidx.lifecycle.ViewModel
import com.darcy.message.composedemo.ui.pages.todolist.bean.Thing
import com.darcy.message.composedemo.ui.pages.todolist.data.ToDoListData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ToDoListViewModel : ViewModel() {
    private var isSelectedAllFlag = false
    private val _isSelectedAllFlow = MutableStateFlow(false)
    val isSelectedAllFlow = _isSelectedAllFlow.asStateFlow()
    private val _things = ToDoListData.things.toMutableList()

    val things: List<Thing>
        get() = _things

    suspend fun selectAllChanged() {
        if (isSelectedAllFlag) {
            unSelectAll()
        } else {
            selectAll()
        }
        isSelectedAllFlag = !isSelectedAllFlag
        _isSelectedAllFlow.emit(isSelectedAllFlag)
    }

    private fun selectAll() {
        for (item in _things) {
            item.isFinished = true
        }
    }

    private fun unSelectAll() {
        for (item in _things) {
            item.isFinished = false
        }
    }

    fun updateOneThingFinish(item: Thing) {
        item.isFinished = !item.isFinished
    }

    fun updateOneThingName(item: Thing) {
        item.thingName += "A"
    }
}