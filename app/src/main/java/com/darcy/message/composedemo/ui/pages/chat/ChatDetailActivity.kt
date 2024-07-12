package com.darcy.message.composedemo.ui.pages.chat

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.darcy.message.composedemo.R
import com.darcy.message.composedemo.ui.pages.sample.itemList
import com.darcy.message.composedemo.ui.theme.ComposeDemoTheme

class ChatDetailActivity : ComponentActivity() {
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
                    ChatDetailShow("Android")
                }
            }
        }
    }
}

@Composable
fun ChatDetailShow(
    name: String,
    onCancelButtonClicked: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray)
    ) {
        val context = LocalContext.current
        Text(
            text = context.getString(R.string.darcy_chat_detail) + name,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 20.dp, bottom = 10.dp)
                .wrapContentSize()
        )
        Button(
            onClick = {
                onCancelButtonClicked()
            },
            modifier = Modifier
                .align(Alignment.TopEnd)
                .wrapContentSize()
        ) {
            Text(text = context.getString(R.string.darcy_click_me))
        }
        LazyColumn(
            modifier = Modifier
                .offset(y = 44.dp)
                .fillMaxSize()
        ) {
            items(itemList.size) {
                MyItemView(itemList[it])
            }
        }


    }
}

@Composable
fun MyItemView(name: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            text = name,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 10.dp, bottom = 10.dp)
                .wrapContentSize()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ChatDetailPreview() {
    ComposeDemoTheme {
        ChatDetailShow("Android")
    }
}