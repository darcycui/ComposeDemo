package com.darcy.message.composedemo.ui.pages.sample

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.darcy.message.composedemo.exts.showToast
import com.darcy.message.composedemo.ui.theme.ComposeDemoTheme

class TextViewActivity : ComponentActivity() {
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
                    TextViewShow("TextViewActivity")
                }
            }
        }
    }

}

@Composable
fun TextViewShow(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.LightGray)
    ) {
        // 借助Box实现垂直居中
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.height(200.dp),
        ) {
            Text(
                text = "Text",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Max)
                    .background(color = Color.Gray),
                textAlign = TextAlign.Center
            )
        }
        Text(
            text = "Hello $name! 我是文本",
            modifier = Modifier
                .background(color = Color.Gray)
                .fillMaxWidth()
                .padding(10.dp)
                .clickable {
                    "点击了文本".showToast()
                },
            textAlign = TextAlign.Center,
            color = Color.Blue,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TextViewPreview() {
    ComposeDemoTheme {
        TextViewShow("Android")
    }
}