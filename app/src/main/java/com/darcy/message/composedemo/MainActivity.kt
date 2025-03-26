package com.darcy.message.composedemo

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.darcy.message.composedemo.exts.startPage
import com.darcy.message.composedemo.learn.LearnActivity
import com.darcy.message.composedemo.navigation.DarcyApp
import com.darcy.message.composedemo.navigation.Screen
import com.darcy.message.composedemo.ui.pages.health.ui.HealthActivity
import com.darcy.message.composedemo.ui.pages.login.LoginActivity
import com.darcy.message.composedemo.ui.pages.view.ComposeActivity
import com.darcy.message.composedemo.ui.pages.view.ViewActivity
import com.darcy.message.composedemo.ui.theme.ComposeDemoTheme

class MainActivity : ComponentActivity() {
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
//                    MainShow("Android")
                    // 使用导航
                    DarcyApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MainShow(
    name: String,
    onNextButtonClicked: (String) -> Unit = {},
    modifier: Modifier = Modifier
) {
    // 获取context上下文
    val context = LocalContext.current

    FlowRow(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.LightGray),
        verticalArrangement = Arrangement.Top,
        horizontalArrangement = Arrangement.Start
    ) {
        Button(onClick = { onNextButtonClicked(Screen.ImageView.name) }) {
            Text(
                text = "ImageView",
            )
        }
        Button(onClick = { onNextButtonClicked(Screen.LinearLayout.name) }) {
            Text(
                text = "LinearLayout",
            )
        }
        Button(onClick = { onNextButtonClicked(Screen.FrameLayout.name) }) {
            Text(
                text = "FrameLayout",
            )
        }
        Button(onClick = { onNextButtonClicked(Screen.RelativeLayout.name) }) {
            Text(
                text = "RelativeLayout",
            )
        }
        Button(onClick = { onNextButtonClicked(Screen.ConstraintLayout.name) }) {
            Text(
                text = "ConstraintLayout",
            )
        }
        Button(onClick = { onNextButtonClicked(Screen.RecyclerView.name) }) {
            Text(
                text = "RecyclerView",
            )
        }
        Button(onClick = { onNextButtonClicked(Screen.ViewPager.name) }) {
            Text(
                text = "ViewPager",
            )
        }
        Button(onClick = { onNextButtonClicked(Screen.Switch.name) }) {
            Text(
                text = "Switch",
            )
        }
        Button(onClick = { onNextButtonClicked(Screen.ChatList.name) }) {
            Text(
                text = "MultiComposeFunction",
            )
        }
        Button(onClick = { context.startPage(ViewActivity::class.java) }) {
            Text(
                text = "ViewWithCompose",
            )
        }
        Button(onClick = { context.startPage(ComposeActivity::class.java) }) {
            Text(
                text = "ComposeWithView",
            )
        }
//        Button(onClick = { context.startPage(TestComposeBuildActivity::class.java) }) {
//            Text(
//                text = "Test Compose Build View",
//            )
//        }
        Button(onClick = { context.startPage(LearnActivity::class.java) }) {
            Text(text = "LearnViewModel")
        }
        Button(onClick = { context.startPage(LoginActivity::class.java) }) {
            Text(text = "LoginViewModel")
        }
        Button(onClick = { context.startPage(HealthActivity::class.java) }) {
            Text(text = "HealthActivity")
        }
        Button(onClick = { context.startPage(ToDoListActivity::class.java) }) {
            Text(text = "HealthActivity")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    ComposeDemoTheme {
        MainShow("Android")
    }
}