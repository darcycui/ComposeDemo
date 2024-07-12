package com.darcy.message.composedemo.ui.pages.sample

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.darcy.message.composedemo.exts.showToast
import com.darcy.message.composedemo.ui.theme.ComposeDemoTheme

class RecyclerViewActivity : ComponentActivity() {
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
                    RecyclerViewShow("Android")
                }
            }
        }
    }
}

val itemList = listOf("Android",
    "iOS",
    "Flutter",
    "Kotlin",
    "Java",
    "Swift",
    "React Native",
    "Objective-C",
    "C++",
    "C#",
    "PHP",
    "Python",
    "Ruby",
    "Scala",
    "Go",
    "JavaScript",
    "TypeScript",
    "Lua",
    "Perl",
    "R",
    "Julia",
    "Haskell",
    "Scheme",
    "Lisp",
    "Prolog",
    "Basic",
    "COBOL",
    "Fortran",
    "Pascal",
    "Assembly",
    "Brainf",
    "Clean",
    "Erlang",
    "Factor",
    "Forth",
    "FREEBASIC")

    @Composable
    fun RecyclerViewShow(name: String, modifier: Modifier = Modifier) {
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .background(color = Color.Transparent)
        ) {
            items(itemList.size) {
                Text(
                    text = "Hello ${itemList[it]}",
                    modifier = Modifier
                        .background(color = Color.Gray)
                        .fillMaxWidth()
                        .height(100.dp)
                        .padding(10.dp)
                        .clickable {
                            "点击了文本${itemList[it]}".showToast()
                        }
                )
                // 空白间隔
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun RecyclerViewPreview() {
        ComposeDemoTheme {
            RecyclerViewShow("Android")
        }
    }