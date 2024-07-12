package com.darcy.message.composedemo.ui.pages.sample

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.darcy.message.composedemo.R
import com.darcy.message.composedemo.exts.showToast
import com.darcy.message.composedemo.ui.theme.ComposeDemoTheme

class LinearLayoutActivity : ComponentActivity() {
    private val context: Context by lazy {
        this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LinearLayoutShow(resources.getString(R.string.darcy_app_name))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LinearLayoutShow(name: String, modifier: Modifier = Modifier) {

    // todo 输入框 需要使用State保存输入的值
    //初始化文本变量
    val inputText = remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.LightGray),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = name,
            fontWeight = FontWeight.Bold,
            color = Color.Red,
            fontSize = 14.sp,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(8.dp)
        )
        // 获取string.xml中的值
        val clickMe = stringResource(id = R.string.darcy_click_me)
        val clickMe2 = stringResource(id = R.string.darcy_click_me2)
        Button(onClick = { clickMe.showToast()  })  {
            Text(text = "Click Me")
        }
        Button(onClick = { clickMe2.showToast()   }) {
            Text(text = "Click Second")
        }
        TextField(
            value = inputText.value,
            placeholder = { Text("Enter your name") },
            // 设置输入框的颜色
            colors = TextFieldDefaults.colors(
                // 获取焦点后的颜色
                focusedContainerColor = Color.Cyan,
                unfocusedContainerColor = Color.White,
                // 去掉底部横线
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            onValueChange = {
                inputText.value = it
            },
            modifier = Modifier
                .fillMaxWidth()
                // 获取color.xml中的值
                .border(1.dp, colorResource(id = R.color.darcy_teal_200), RoundedCornerShape(8.dp))
//                .background(Color.White, RoundedCornerShape(8.dp))
                ,
            // 圆角背景
            shape = RoundedCornerShape(8.dp)
        )

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLinearlayout() {
    ComposeDemoTheme {
        LinearLayoutShow("Android")
    }
}