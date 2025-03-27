package com.darcy.message.composedemo.ui.pages.todolist.ui.widgets

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.darcy.message.composedemo.ui.pages.todolist.viewmodel.ToDoListViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SelectAll(modifier: Modifier = Modifier, onSelectAllChanged: () -> Unit) {
    val viewModel: ToDoListViewModel = viewModel()
    val isSelectedAll: Boolean by viewModel.isSelectedAllFlow.collectAsState(initial = false)
    val text = if (isSelectedAll) "取消全选" else "全选"
    // 获取Context 上下文
    val context = LocalContext.current
    // 去除点击效果
    Text(
        text = text,
        fontSize = 20.sp,
        textAlign = TextAlign.Center,
        modifier = modifier
            .padding(horizontal = 16.dp)
            .combinedClickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = {
                    onSelectAllChanged()
                },
                onLongClick = {
                    Toast.makeText(context, "长按了全选", Toast.LENGTH_SHORT).show()
                }
            ))
}