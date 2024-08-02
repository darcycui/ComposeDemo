package com.darcy.message.composedemo.ui.test.viewapplier

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.darcy.message.composedemo.ui.test.ui.theme.ComposeDemoTheme

class TestComposeBuildActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBuildTest("Android")
//            ComposeDemoTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    ComposeBuildTest("Android")
//                }
//            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    ComposeDemoTheme {
        ComposeBuildTest("Android")
    }
}