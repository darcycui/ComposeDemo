package com.darcy.message.composedemo.learn.widgets

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.darcy.message.composedemo.R
import com.darcy.message.composedemo.exts.showToast
import com.darcy.message.composedemo.learn.ShowHomeContent


@Preview(showBackground = true)
@Composable
fun HomeTextField() {
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
    Column(modifier = Modifier.fillMaxSize().background(Color.LightGray)) {
        HomeTextField1()
        Spacer(Modifier.height(30.dp))
        HomeTextField2()
        Spacer(Modifier.height(30.dp))
        HomeTextField3()
    }
}

@Composable
fun HomeTextField1() {
    val text = remember {
        mutableStateOf("")
    }
    val passwordHidden = remember {
        mutableStateOf(false)
    }
    // 输入框(只能按照Material风格配置)
    TextField(
        value = text.value,
        onValueChange = {
            text.value = it
        },
        // 单行
        singleLine = true,

        // 提示文字
        label = {
            Text(text = "邮箱")
        },

        // 左图标
        leadingIcon = {
            Icon(Icons.Filled.Email, null)
        },

        // 右图标
        trailingIcon = {
            // 可点击的Icon
            IconButton(onClick = { passwordHidden.value = passwordHidden.value.not() }) {
                Icon(Icons.Filled.Lock, null)
            }
        },

        // 输入模式:密码模式
        visualTransformation = if (passwordHidden.value) {
            PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        },
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Magenta,
            backgroundColor = Color.White,
        )
    )
}

@Composable
fun HomeTextField2() {
    val text = remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFD3D3D3)),
        contentAlignment = Alignment.Center
    ) {
        // 基本输入框 配置更灵活
        BasicTextField(
            value = text.value,
            onValueChange = {
                text.value = it
            },
            modifier = Modifier
                .background(Color.White, CircleShape)
                .height(35.dp)
                .fillMaxWidth(),
            // 自定义布局在这里设置 decorationBox
            decorationBox = { innerTextField ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 10.dp)
                ) {
                    IconButton(
                        onClick = { }
                    ) {
                        Icon(
                            painterResource(id = R.drawable.icon),
                            contentDescription = null,
                            tint = Color.Unspecified
                        )
                    }
                    Box(
                        modifier = Modifier.weight(1f),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        innerTextField()
                    }
                    IconButton(
                        onClick = { },
                    ) {
                        Icon(Icons.Filled.Send, null)
                    }
                }
            }
        )
    }
}

@Composable
fun HomeTextField3() {
    val text = remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFD3D3D3)),
        contentAlignment = Alignment.Center
    ) {
        BasicTextField(
            value = text.value,
            onValueChange = {
                text.value = it
            },
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth(),
            // 自定义布局在这里设置 decorationBox
            decorationBox = { innerTextField ->
                Column(
                    modifier = Modifier.padding(vertical = 10.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        IconButton(onClick = {}) {
                            Icon(
                                painterResource(id = R.drawable.icon),
                                contentDescription = null,
                                tint = Color.Unspecified
                            )
                        }
                        IconButton(onClick = {}) {
                            Icon(
                                painterResource(id = R.drawable.darcy_dog),
                                contentDescription = null
                            )
                        }
                        IconButton(onClick = {}) {
                            Icon(
                                painterResource(id = R.drawable.icon),
                                contentDescription = null,
                                tint = Color.Unspecified
                            )
                        }
                        IconButton(onClick = {}) {
                            Icon(
                                painterResource(id = R.drawable.darcy_dog),
                                contentDescription = null
                            )
                        }
                    }
                    Box(
                        modifier = Modifier.padding(horizontal = 10.dp)
                    ) {
                        innerTextField()
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End
                    ) {
                        TextButton(onClick = { "发送".showToast() }) {
                            Text("发送")
                        }
                        Spacer(Modifier.padding(horizontal = 10.dp))
                        TextButton(onClick = { "关闭".showToast() }) {
                            Text("关闭")
                        }
                    }
                }
            }
        )
    }
}