package com.darcy.message.composedemo.learn.widgets

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.darcy.message.composedemo.exts.showToast
import com.darcy.message.composedemo.learn.ShowHomeContent

@Preview(showBackground = true)
@Composable
fun HomeCard() {
    val showHomePage = remember {
        mutableStateOf(false)
    }
    if (showHomePage.value) {
        ShowHomeContent()
        return
    }

    // 返回按钮
    BackHandler {
        showHomePage.value = showHomePage.value.not()
    }
    Card(
        colors = CardDefaults.cardColors(),
        elevation = CardDefaults.cardElevation(),
        shape = CardDefaults.shape,
        border = null,
        modifier = Modifier
            .fillMaxWidth()
            // 内边距
            .padding(8.dp)
            .clickable {
                "卡片点击".showToast()
            }
    ) {
        Column(
            // 内边距
            modifier = Modifier.padding(8.dp)
        ) {

            // 创建带格式的文本 buildAnnotatedString
            Text(buildAnnotatedString {
                append("欢迎来到 ")
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.W900,
                        color = Color(0xFF4552B8)
                    )
                ) {
                    append("Jetpack Compose 博物馆")
                }
            })

            Text(buildAnnotatedString {
                append("你现在观看的章节是")
                withStyle(style = SpanStyle(fontWeight = FontWeight.W900)) {
                    append("Card.")
                }
            })

        }
    }
}