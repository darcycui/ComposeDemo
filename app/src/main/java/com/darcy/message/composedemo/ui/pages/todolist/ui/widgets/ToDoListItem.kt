package com.darcy.message.composedemo.ui.pages.todolist.ui.widgets

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.darcy.message.composedemo.R
import com.darcy.message.composedemo.ui.pages.todolist.bean.Thing

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ToDoListItem(
    modifier: Modifier = Modifier,
    thing: Thing,
    onFinishChanged: (thing: Thing) -> Unit,
    onNameChanged: (thing: Thing) -> Unit,
) {
    val iconId = if (thing.isFinished) {
        R.drawable.yes
    } else {
        R.drawable.no
    }
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        Image(
            painter = painterResource(iconId),
            contentDescription = "是否完成的图标",
            modifier = modifier
                .padding(10.dp)
                .background(color = Color.Gray)
                .combinedClickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = {
                        onFinishChanged(thing)
                    })
        )
        Text(
            thing.thingName,
            fontSize = 20.sp,
            modifier = modifier
                .padding(10.dp)
                .fillMaxWidth()
                .combinedClickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = {
                        onNameChanged(thing)
                    })
        )
    }
}