package com.darcy.message.composedemo.ui.pages.todolist.ui.widgets

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.darcy.message.composedemo.ui.pages.todolist.viewmodel.ToDoListViewModel

@Composable
fun ToDoList(modifier: Modifier = Modifier, viewmodel: ToDoListViewModel = viewModel()) {
    LazyColumn {
        // 带index的items
        itemsIndexed(viewmodel.things) { index, item ->
            ToDoListItem(
                thing = item,
                onFinishChanged = {
                    viewmodel.updateOneThingFinish(item)
                },
                onNameChanged = {
                    viewmodel.updateOneThingName(item)
                }
            )
        }
    }
}