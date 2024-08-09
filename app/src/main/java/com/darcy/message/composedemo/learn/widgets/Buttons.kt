package com.darcy.message.composedemo.learn.widgets

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.darcy.message.composedemo.exts.showToast

data class ButtonStyle(
    var text: String,
    var textColor: Color,
    var buttonColor: Color
)

@Preview(showBackground = true)
@Composable
fun HomeButton() {
    // 按钮的交互状态
    val interactionState = remember {
        MutableInteractionSource()
    }
    // darcyRefactor: 使用解构方法初始化
    val (text, textColor, buttonColor) = when {
        // 按下状态
        interactionState.collectIsPressedAsState().value -> ButtonStyle(
            "Pressed",
            Color.White,
            Color.Red
        )

        interactionState.collectIsDraggedAsState().value -> ButtonStyle(
            "Dragged",
            Color.White,
            Color.Green
        )

        interactionState.collectIsFocusedAsState().value -> ButtonStyle(
            "Focused",
            Color.White,
            Color.Yellow
        )

        interactionState.collectIsHoveredAsState().value -> ButtonStyle(
            "Hovered",
            Color.White,
            Color.Cyan
        )

        else -> ButtonStyle("Button", Color.White, Color.Blue)

    }
    Button(
        onClick = { "点击了".showToast() },
        // 这里设置交互状态
        interactionSource = interactionState,
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor,
        ),
        modifier = Modifier
            .width(IntrinsicSize.Min)
            .height(IntrinsicSize.Min)
    ) {
        // 添加图标
        Icon(
            Icons.Filled.Favorite,
            contentDescription = "",
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(modifier = Modifier.width(ButtonDefaults.IconSpacing))

        Text(text = text, color = textColor)
    }
}
