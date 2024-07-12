package com.darcy.message.composedemo.ui.pages.chat

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.darcy.message.composedemo.R
import com.darcy.message.composedemo.exts.logD
import com.darcy.message.composedemo.exts.logE
import com.darcy.message.composedemo.exts.logI
import com.darcy.message.composedemo.exts.startPage
import com.darcy.message.composedemo.ui.theme.ComposeDemoTheme

class ChatListActivity : ComponentActivity() {
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
                    ChatListShow("Android")
                }
            }
        }
    }
}

@Composable
fun ChatListShow(
    name: String,
    onNextButtonClicked: () -> Unit = {},
    modifier: Modifier = Modifier
) {

    LaunchedEffect(key1 = "ChatListShow") {
        logI("ChatListShow init")
    }
    SideEffect {
        val a = 10
        a.logD("ChatListShow: update")
    }
    DisposableEffect(key1 = "") {
        onDispose {
            logE("ChatListShow remove")
        }
    }
//    val count = remember {
//        mutableIntStateOf(0)
//    }
    val count = rememberSaveable(stateSaver = Saver(
        save = { it },
        restore = { it }
    )) {
        mutableIntStateOf(0)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray)
    ) {
        val context = LocalContext.current

        Text(
            text = context.getString(R.string.darcy_chat_list),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.TopCenter)
        )
        Button(
            onClick = { count.value++ },
            modifier = Modifier.align(Alignment.Center)
        ) {
            Text(text = context.getString(R.string.darcy_click_count_inc))
        }
        Button(
            onClick = {
                onNextButtonClicked()
            },
            modifier = Modifier
                .align(Alignment.Center)
                .offset(0.dp, 50.dp)
        ) {
            Text(text = context.getString(R.string.darcy_go_detail_page))
        }
        Text(
            text = context.getString(R.string.darcy_click_count, count.value),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(0.dp, 30.dp)
        )
//        if (isClicked.value) {
//            ChatDetailShow(name = "Detail")
//        }

    }
}

@Preview(showBackground = true)
@Composable
fun ChatListPreview() {
    ComposeDemoTheme {
        ChatListShow("Android")
    }
}