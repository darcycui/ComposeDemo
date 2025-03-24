package com.darcy.message.composedemo.ui.pages.health.ui.widgets

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.darcy.message.composedemo.ui.pages.health.bean.WellnessTask

@Composable
fun WellnessTasksList(
    modifier: Modifier = Modifier,
    list: List<WellnessTask> = emptyList(),
    onCheckedTask: ((WellnessTask, Boolean) -> Unit)? = null,
    onCloseTask: (WellnessTask) -> Unit,
) {
    LazyColumn(
        modifier = modifier
    ) {
        // TODO 使用 key 标记数据源与 UI 元素的对应关系，在数据源发生增、删时，UI元素可以复用
        items(list, key = { task -> task.id }) { task ->
            WellnessTaskItem(
                taskName = task.label,
                checked = task.checked,
                onCheckedChange = { checked ->
                    if (onCheckedTask != null) {
                        onCheckedTask(task, checked)
                    }
                },
                onClose = { onCloseTask(task) })
        }
    }
}