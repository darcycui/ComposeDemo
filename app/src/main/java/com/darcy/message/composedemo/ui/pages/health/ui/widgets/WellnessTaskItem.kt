package com.darcy.message.composedemo.ui.pages.health.ui.widgets

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

/**
 * 无状态组合函数
 */
@Composable
fun WellnessTaskItem(
    taskName: String,
    checked: Boolean,  // 状态提升：选中状态
    onCheckedChange: ((Boolean) -> Unit)? = null, // 状态提升：选中状态改变
    onClose: () -> Unit,
    modifier: Modifier = commonModifier
) {
    Row(
        modifier = modifier, verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .weight(1f) // 权重1 占满剩余空间
                .padding(start = 16.dp),
            text = taskName
        )
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
        IconButton(onClick = onClose) {
            Icon(Icons.Filled.Close, contentDescription = "Close")
        }
    }
}

/**
 * 有状态组合函数
 */
@Composable
fun WellnessTaskItem(taskName: String, onClose: () -> Unit, modifier: Modifier = Modifier) {
    // 使用remember保存item选中状态 item滑出屏幕后 状态重置
//    var checkedState by remember { mutableStateOf(false) }
    // TODO 使用 rememberSaveable 保存状态 否则item滑出屏幕后 状态重置
    var checkedState by rememberSaveable { mutableStateOf(false) }

    WellnessTaskItem(
        taskName = taskName,
        checked = checkedState,
        onCheckedChange = { newValue -> checkedState = newValue },
        onClose = onClose, // we will implement this later!
        modifier = modifier,
    )
}