package com.darcy.message.composedemo.ui.pages.sample

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.darcy.message.composedemo.exts.showToast
import com.darcy.message.composedemo.ui.theme.ComposeDemoTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager

class ViewPagerActivity : ComponentActivity() {
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
                    ViewPagerShow("Android")
                }
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ViewPagerShow(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.LightGray)
    ) {
        Text(
            text = "Hello $name! 我是文本",
            modifier = modifier
                .background(color = Color.Gray)
                .fillMaxWidth()
                .height(IntrinsicSize.Max)
                .padding(10.dp)
                .clickable {
                    "点击了文本".showToast()
                }
        )
        HorizontalPager(
            count = 5,
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
        ) {
            Text(
                text = "Page $it",
                modifier = modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Max)
                    .padding(10.dp)
                    .background(color = Color.LightGray),
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ViewPagerPreview() {
    ComposeDemoTheme {
        ViewPagerShow("Android")
    }
}