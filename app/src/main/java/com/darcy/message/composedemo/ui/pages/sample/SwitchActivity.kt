package com.darcy.message.composedemo.ui.pages.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.darcy.message.composedemo.exts.showToast
import com.darcy.message.composedemo.ui.pages.ui.theme.ComposeDemoTheme

class SwitchActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SwitchesShow("Android")
                }
            }
        }
    }
}

@Composable
fun SwitchesShow(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(Color.Cyan)
    ) {
        SwitchItem()
    }
}

@Composable
private fun SwitchItem() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Yellow),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "开关选项1",
            modifier = Modifier
                .padding(start = 10.dp)
                .weight(1f)
        )
        Spacer(modifier = Modifier.width(16.dp))
        // 记录开关状态
        val state = remember {
            mutableStateOf(true)
        }
        Switch(
            checked = state.value,
            modifier = Modifier
                .padding(end = 10.dp),
            onCheckedChange = {
                state.value = it
                val tips = if (it) "开" else "关"
                tips.showToast()
            })
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    ComposeDemoTheme {
        SwitchesShow("Android")
    }
}