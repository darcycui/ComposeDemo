package com.darcy.message.composedemo.learn.widgets

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.darcy.message.composedemo.R
import com.darcy.message.composedemo.exts.showToast
import com.darcy.message.composedemo.learn.ShowHomeContent

@Preview(showBackground = true)
@Composable
fun HomeText() {
    val showHomePage = remember {
        mutableStateOf(false)
    }
    if (showHomePage.value) {
        ShowHomeContent()
        return
    }
    // 返回按键监听
    BackHandler {
        showHomePage.value = showHomePage.value.not()
    }

    Column(modifier = Modifier.fillMaxWidth(),
        // 水平对齐方式
        horizontalAlignment = Alignment.Start) {
        Text(
            text = stringResource(id = R.string.darcy_title),
            // 样式(大小 颜色 粗体等)
            style = MaterialTheme.typography.titleLarge,
        )
        Text(
            text = stringResource(id = R.string.darcy_detail),
            // 样式(大小 颜色 粗体等)
            style = MaterialTheme.typography.bodyLarge,
        )
        Text(
            text = stringResource(id = R.string.darcy_content),
            // 自定义style
            style = TextStyle(
                // 大小
                fontSize = 20.sp,
                // 颜色
                color = Color.Magenta,
                // 粗体
                fontWeight = FontWeight.W900,
                // 字间距
                letterSpacing = 5.5.sp
            ),
            // 行数
            maxLines = 1,
            // 超出部分省略号
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = "今天的天气不错",
            modifier = Modifier.fillMaxWidth(),
            // 文字对齐方式 左对齐
            textAlign = TextAlign.Left,
        )
        Text(
            text = "今天的天气不错",
            modifier = Modifier.fillMaxWidth(),
            // 文字对齐方式 居中
            textAlign = TextAlign.Center,
        )
        Text(
            text = "今天的天气不错",
            modifier = Modifier.fillMaxWidth(),
            // 文字对齐方式 右对齐
            textAlign = TextAlign.Right,
        )
        Text(text = "两面包夹芝士".repeat(8))
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "两面包夹芝士".repeat(8),
            // 设置行高
            lineHeight = 30.sp
        )
        Text(
            text = "Hello World 你好世界",
            // 设置字体
            fontFamily = FontFamily.Serif
        )
        Text(
            text = "Hello World 你好世界",
            // 设置字体
            fontFamily = FontFamily.SansSerif
        )
//        Text(
//            text = "Hello World 你好世界",
//            // 自定义res/font字体
//            fontFamily = FontFamily(Font(R.font.stkaiti, FontWeight.Normal))
//        )
        val interactionSource = remember {
            MutableInteractionSource()
        }
        Text(
            text = "确认编辑",
            // 点击事件
            modifier = Modifier.clickable(
                // 去除点击波纹
                indication = null,
                interactionSource = interactionSource
            ) {
                "点击了编辑".showToast()
            }
        )
        // 富文本
        Text(text = buildAnnotatedString {
            append("你现在观看的章节是 ")
            withStyle(
                style = SpanStyle(color = Color.Red, fontWeight = FontWeight.Bold, fontSize = 20.sp)
            ) {
                append("第 1 章")
            }
        })

        // 富文本点击
        val annotatedText = buildAnnotatedString {
            append("勾选即代表同意")
            // 开始annotation设置
            pushStringAnnotation(
                // 设置tag
                tag = "tag",
                annotation = "一个用户协议啦啦啦，内容内容"
            )
            withStyle(
                style = SpanStyle(
                    color = Color(0xFF0E9FF2),
                    fontWeight = FontWeight.Bold
                )
            ) {
                append("用户协议")
            }
            // 结束annotation设置
            pop()
        }
        // 使用可点击的Text
        ClickableText(
            text = annotatedText,
            onClick = { offset ->
                // 判断点击的位置
                annotatedText.getStringAnnotations(
                    // 查找annotation的tag
                    tag = "tag",
                    start = offset,
                    end = offset
                ).firstOrNull()?.let { annotation ->
                    "点击：${annotation.item}".showToast()
                }
            })

        // 可复制
        SelectionContainer {
            Text(text = "可复制文本".repeat(8))
        }
        // Text控件wrap 水平居中
        Column {
            Text("123")
            Text("456")
            Box(
                modifier = Modifier.fillMaxWidth(),
                // 水平居中
                contentAlignment = Alignment.Center
            ) {
                Text(text = "789居中")
            }
        }

    }
}