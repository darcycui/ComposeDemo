package com.darcy.message.composedemo.ui.pages.sample

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.darcy.message.composedemo.ui.theme.ComposeDemoTheme

class FrameLayoutActivity : ComponentActivity() {
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
                    FrameLayoutShow("Android")
                }
            }
        }
    }
}

@Composable
fun FrameLayoutShow(name: String, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray)
    ) {
        Text(
            text = "我是文本",
            modifier = Modifier.background(color = Color.Gray)
        )
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.align(Alignment.Center)
        ) {
            Text(text = "我是按钮")
        }
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.align(Alignment.TopEnd)
        ) {
            Text(text = "我是按钮")
        }
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.align(Alignment.BottomStart)
        ) {
            Text(text = "我是按钮")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun FrameLayoutPreview() {
    ComposeDemoTheme {
        FrameLayoutShow("Android")
    }
}