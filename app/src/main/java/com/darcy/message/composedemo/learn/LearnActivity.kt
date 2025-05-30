package com.darcy.message.composedemo.learn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.darcy.message.composedemo.R
import com.darcy.message.composedemo.learn.ui.theme.ComposeDemoTheme
import com.darcy.message.composedemo.learn.widgets.HomeButton
import com.darcy.message.composedemo.learn.widgets.HomeCard
import com.darcy.message.composedemo.learn.widgets.HomeDialog
import com.darcy.message.composedemo.learn.widgets.HomeFloatingActionButton
import com.darcy.message.composedemo.learn.widgets.HomeIcon
import com.darcy.message.composedemo.learn.widgets.HomeIconButtons
import com.darcy.message.composedemo.learn.widgets.HomeImage
import com.darcy.message.composedemo.learn.widgets.HomeIndicator
import com.darcy.message.composedemo.learn.widgets.HomeSlider
import com.darcy.message.composedemo.learn.widgets.HomeText
import com.darcy.message.composedemo.learn.widgets.HomeTextField

class LearnActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            /**
             * 设置主题
             */
            ComposeDemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ShowHomeContent(innerPadding)

                }
            }
        }
    }

}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ShowHomeContent(innerPadding: PaddingValues = PaddingValues.Absolute()) {
    val showListPage = remember {
        mutableStateOf(false)
    }
    if (showListPage.value) {
        ConversationPreview()
        return
    }
    val showHomeDialog = remember {
        mutableStateOf(false)
    }
    if (showHomeDialog.value) {
        HomeDialog()
        return
    }
    val showHomeButton = remember {
        mutableStateOf(false)
    }
    if (showHomeButton.value) {
        HomeButton()
        return
    }
    val showHomeCard = remember {
        mutableStateOf(false)
    }
    if (showHomeCard.value) {
        HomeCard()
        return
    }
    val showHomeFAB = remember {
        mutableStateOf(false)
    }
    if (showHomeFAB.value) {
        HomeFloatingActionButton()
        return
    }
    val showHomeIcon = remember {
        mutableStateOf(false)
    }
    if (showHomeIcon.value) {
        HomeIcon()
        return
    }
    val showHomeIconButton = remember {
        mutableStateOf(false)
    }
    if (showHomeIconButton.value) {
        HomeIconButtons()
        return
    }
    val showHomeImage = remember {
        mutableStateOf(false)
    }
    if (showHomeImage.value) {
        HomeImage()
        return
    }
    val showHomeSlider = remember {
        mutableStateOf(false)
    }
    if (showHomeSlider.value) {
        HomeSlider()
        return
    }
    val showHomeIndicator = remember {
        mutableStateOf(false)
    }
    if (showHomeIndicator.value) {
        HomeIndicator()
        return
    }
    val showHomeText = remember {
        mutableStateOf(false)
    }
    if (showHomeText.value) {
        HomeText()
        return
    }
    val showHomeTextField = remember {
        mutableStateOf(false)
    }
    if (showHomeTextField.value) {
        HomeTextField()
        return
    }
    Column {

        MessageCard(
            message = Message(
                "Tom&Jerry",
                "Welcome to our museum.\nWelcome to our museum."
            ),
            modifier = Modifier.padding(innerPadding)
        )

        Spacer(modifier = Modifier.size(4.dp))

        // 自动换行的Row
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            /**
             * 按钮控件
             */
            /**
             * 按钮控件
             */
            Button(onClick = {
                // 改变状态的值, 从而触发Compose函数的重绘(刷新UI)
                showListPage.value = showListPage.value.not()
            }) {
                Text(text = "详情列表")
            }
            Button(onClick = { showHomeDialog.value = showHomeDialog.value.not() }) {
                Text(text = "弹窗")
            }
            Button(onClick = { showHomeButton.value = showHomeButton.value.not() }) {
                Text(text = "按钮")
            }
            Button(onClick = { showHomeCard.value = showHomeCard.value.not() }) {
                Text(text = "卡片")
            }
            Button(onClick = { showHomeFAB.value = showHomeFAB.value.not() }) {
                Text(text = "FAB")
            }
            Button(onClick = { showHomeIcon.value = showHomeIcon.value.not() }) {
                Text(text = "小图标")
            }
            Button(onClick = { showHomeIconButton.value = showHomeIconButton.value.not() }) {
                Text(text = "小图标(可点击)")
            }
            Button(onClick = { showHomeImage.value = showHomeImage.value.not() }) {
                Text(text = "图片")
            }
            Button(onClick = { showHomeSlider.value = showHomeSlider.value.not() }) {
                Text(text = "拖动条")
            }
            Button(onClick = { showHomeIndicator.value = showHomeIndicator.value.not() }) {
                Text(text = "进度条")
            }
            Button(onClick = { showHomeText.value = showHomeText.value.not() }) {
                Text(text = "文本相关")
            }
            Button(onClick = { showHomeTextField.value = showHomeTextField.value.not() }) {
                Text(text = "输入框")
            }
        }
    }
}

/**
 * 使用@Compose注解定义Compose函数
 * Compose函数名首字母大写
 * Compose函数只能在另一个Compose函数中调用，否则会报错
 *
 */
@Composable
fun MessageCard(message: Message, modifier: Modifier = Modifier) {
    // 是否展开 标记位
    val isExpanded = remember {
        mutableStateOf(false)
    }
    // 背景色(根据展开状态来设置背景色)
    val backgroundColor = if (isExpanded.value) {
        // 设置颜色
        Color(0xFFCCCCCC)
    } else {
        MaterialTheme.colorScheme.surface
    }

    /**
     * 卡片形状
     */
    Surface(
        // 使用Material自带的形状
        shape = MaterialTheme.shapes.medium,
        tonalElevation = 5.dp,
        shadowElevation = 5.dp,
        color = backgroundColor,
        modifier = Modifier
            .padding(all = 8.dp)
            .clickable {
                // 设置点击事件
                // 点击后，改变标记位的值
                isExpanded.value = !isExpanded.value
            }
    ) {

        /**
         * Row 水平地排列元素
         */
        Row(modifier = Modifier.padding(all = 8.dp)) {
            /**
             * 图片控件
             */
            Image(
                painterResource(id = R.drawable.aa),
                contentDescription = "无障碍描述字符串",
                modifier = Modifier
                    .size(60.dp)
                    // 设置圆形
                    .clip(CircleShape)
                    // 设置圆形描边
                    .border(
                        width = 0.5.dp,
                        color = MaterialTheme.colorScheme.secondary,
                        shape = CircleShape
                    )
            )
            /**
             * Spacer 空白控件
             */
            Spacer(modifier = Modifier.size(8.dp))

            /**
             * Column 垂直地排列元素
             */
            Column {
                /**
                 * 文本控件
                 */
                Text(
                    text = message.author,
                    // 字体颜色
                    color = MaterialTheme.colorScheme.primary,
                    // 字体样式
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = modifier
                )

                /**
                 * Spacer 空白控件
                 */
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = message.body,
                    style = MaterialTheme.typography.bodySmall,
                    // 根据标记位的值设置最大行数
                    maxLines = if (isExpanded.value) Int.MAX_VALUE else 1,
                    modifier = modifier
                )
            }
        }
    }
}

/**
 * Compose函数可以使用@Preview注解预览
 * 要预览的函数不能有待确定的参数
 */
@Preview(
    showBackground = true,
    // 深色模式
//    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun MessageCardPreview() {
    /**
     * 设置主题
     */
    ComposeDemoTheme {
        ShowHomeContent()
//        MessageCard(Message("Jetpack Compose 博物馆", "我们开始更新啦"))
    }
}

data class Message(val author: String = "Default Author", val body: String = "Default Body")