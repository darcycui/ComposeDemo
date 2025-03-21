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
        items(list) { task ->
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