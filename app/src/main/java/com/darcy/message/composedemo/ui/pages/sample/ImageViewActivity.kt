package com.darcy.message.composedemo.ui.pages.sample

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.darcy.message.composedemo.R
import com.darcy.message.composedemo.ui.theme.ComposeDemoTheme

class ImageViewActivity : ComponentActivity() {
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
                    ImageViewShow("Android")
                }
            }
        }
    }
}

@Composable
fun ImageViewShow(name: String, modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Green)
            .padding(8.dp)
    ) {
        Surface(
            // 圆形
            shape = CircleShape,
            color = Color.Yellow, modifier = Modifier.size(100.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.icon),
                contentDescription = "icon",
                modifier = Modifier.size(100.dp, 100.dp)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth(1.0f)
                .padding(start = 10.dp)
                .background(color = Color.LightGray)
        ) {
            Text(
                text = "我是文本",
                modifier = modifier
                    .background(color = Color.Gray)
                    .fillMaxWidth()
            )
            Text(
                text = "我是文本",
                modifier = modifier
                    .padding(top = 20.dp)
                    .background(color = Color.Gray)
                    .fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ImageViewPreview() {
    ComposeDemoTheme {
        ImageViewShow("Android")
    }
}