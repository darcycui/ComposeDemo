package com.darcy.message.composedemo.ui.pages.sample

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.darcy.message.composedemo.ui.theme.ComposeDemoTheme

class RelativeLayoutActivity : ComponentActivity() {
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
                    RelativeLayoutShow("Android")
                }
            }
        }
    }
}

@Composable
fun RelativeLayoutShow(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.LightGray)
    ) {

        Text(
            text = "Hello $name! 我是文本",
            modifier = Modifier
                .background(color = Color.Gray)
                .fillMaxWidth()
                .height(50.dp)
        )
        Row(
            modifier = Modifier
                // 外边距
                .padding(10.dp)
                .fillMaxWidth()
                // 指定背景色
                .background(color = Color.Green)
                // 内边距
                .padding(10.dp)
        ) {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    // 外边距
                    .padding(10.dp)
                    .background(Color.Yellow)
                    // 内边距
                    .padding(10.dp)
            ) {
                Text(text = "按钮1")
            }
            Button(
                onClick = { /*TODO*/ },
            ) {
                Text(text = "按钮2")
            }
            Button(
                onClick = { /*TODO*/ },
            ) {
                Text(text = "按钮3")
            }
        }
        Text(
            text = "第二行文本",
            modifier = Modifier
                .padding(10.dp)
                .background(Color.Cyan)
                .padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RelativeLayoutPreview() {
    ComposeDemoTheme {
        RelativeLayoutShow("Android")
    }
}