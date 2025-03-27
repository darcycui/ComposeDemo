package com.darcy.message.composedemo.ui.pages.todolist.data

import com.darcy.message.composedemo.ui.pages.todolist.bean.Thing

class ToDoListData {
    companion object {
        val things = listOf(
            Thing("Wake up", true),
            Thing("Take a shower", true),
            Thing("Have breakfast", false),
            Thing("Go to work", false),
            Thing("Have lunch", false),
            Thing("Go to home", false),
            Thing("Have dinner", false),
            Thing("Watch TV", false),
            Thing("Have dinner", false),
            Thing("Watch TV", false),
            Thing("Go to sleep", false),

        )
    }
}