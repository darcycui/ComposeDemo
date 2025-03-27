package com.darcy.message.composedemo.ui.pages.todolist.ui.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.darcy.message.composedemo.ui.pages.todolist.viewmodel.ToDoListViewModel
import kotlinx.coroutines.launch

@Composable
fun ToDoListScreen(modifier: Modifier = Modifier, viewmodel: ToDoListViewModel = viewModel()) {
    val scope = rememberCoroutineScope()
    Column {
        // TODO 不占用 statusBar
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .statusBarsPadding()
        ) {
            ToDoListHeader(modifier = Modifier.weight(1f))

            SelectAll {
                scope.launch {
                    viewmodel.selectAllChanged()
                }
            }
        }
        // TODO 不占用 navigationBar
        ToDoList(modifier = modifier.navigationBarsPadding())
    }
}

@Preview(showBackground = true)
@Composable
fun ToDoListScreenPreview() {
    ToDoListScreen(modifier = Modifier)
}