package com.darcy.message.composedemo.ui.pages.sample

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.constraintlayout.compose.ConstraintLayout
import com.darcy.message.composedemo.exts.showToast
import com.darcy.message.composedemo.ui.theme.ComposeDemoTheme

class ConstraintLayoutActivity : ComponentActivity() {
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
                    ConstraintLayoutShow("Android")
                }
            }
        }
    }
}

@Composable
fun ConstraintLayoutShow(name: String, modifier: Modifier = Modifier) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray)
    ) {
        val (titleText, button) = createRefs()
        Text(
            text = "Hello $name! 我是文本",
            modifier = Modifier
                .background(color = Color.Gray)
                .fillMaxWidth()
                .height(200.dp)
                .padding(20.dp)
                .clickable {
                    "点击了文本".showToast()
                }
                .constrainAs(titleText) {
                    top.linkTo(parent.top, margin = 10.dp)
                    bottom.linkTo(parent.bottom, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                    end.linkTo(parent.end, margin = 10.dp)
                }
        )
        Button(onClick = { "点击了按钮".showToast() },
            modifier = Modifier.constrainAs(button) {
                top.linkTo(titleText.bottom, margin = 10.dp)
                start.linkTo(parent.start, margin = 10.dp)
                end.linkTo(parent.end, margin = 10.dp)
            }) {
            Text(text = "点击我")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ConstraintLayoutPreview() {
    ComposeDemoTheme {
        ConstraintLayoutShow("Android")
    }
}