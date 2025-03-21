package com.darcy.message.composedemo.ui.pages.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.darcy.message.composedemo.exts.logD
import com.darcy.message.composedemo.ui.LogInUiIntent
import com.darcy.message.composedemo.ui.pages.chat.UserBean
import com.darcy.message.composedemo.ui.pages.login.viewmodel.LoginViewModel
import com.darcy.message.composedemo.ui.pages.login.viewmodel.LoginViewModel2
import com.darcy.message.composedemo.ui.pages.ui.theme.ComposeDemoTheme

class LoginActivity : ComponentActivity() {
    private val viewmodel: LoginViewModel by viewModels<LoginViewModel>()
    private val viewmodel2: LoginViewModel2 by viewModels<LoginViewModel2>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeDemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GreetingLogin(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding),
                        viewmodel2
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingLogin(name: String, modifier: Modifier = Modifier, viewmodel: LoginViewModel2? = null) {
    val username: MutableState<String> = remember {
        mutableStateOf("")
    }
    val password: MutableState<String> = remember {
        mutableStateOf("")
    }
//    // 从ViewModel的LiveData获取state
//    val uiStateFromLiveData = viewmodel?.uiStateLiveData?.observeAsState()
    // 从ViewModel的Flow获取state
    val uiStateFromFlow = viewmodel?.uiStateFlow?.collectAsState()
    Column {
//        Text(
//            text = viewmodel?.uiState?.value?.toString() ?: "SignedOut",
//            modifier = modifier
//        )
//        Text(
//            text = uiStateFromLiveData?.value?.toString() ?: "SignedOut",
//            modifier = modifier
//        )
        Text(
            text = uiStateFromFlow?.value?.toString() ?: "DEFAULT",
            modifier = modifier
        )
        TextField(
            value = username.value,
            placeholder = { Text("Please input username") },
            onValueChange = {
                username.value = it
                logD("onValueChange: $it")
            })
        TextField(
            value = password.value,
            placeholder = { Text("Please input password") },
            onValueChange = {
                password.value = it
                logD("onValueChange: $it")
            })
//        Button(onClick = {
//            viewmodel?.handleIntent(LogInUiIntent.LoginIntent(UserBean(-1L, username.value, password.value)))
//        }) {
//            Text(text = "Login")
//        }
//        Button(onClick = {
//            viewmodel?.handleIntent(LogInUiIntent.LogoutIntent(UserBean(-1L, username.value, password.value)))
//        }) {
//            Text(text = "LogOut")
//        }
        Button(onClick = {
            viewmodel?.sendUiIntent(LogInUiIntent.LoginIntent(UserBean(-1L, username.value, password.value)))
        }) {
            Text(text = "Login")
        }
        Button(onClick = {
            viewmodel?.sendUiIntent(LogInUiIntent.LogoutIntent(UserBean(-1L, username.value, password.value)))
        }) {
            Text(text = "Logout")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    ComposeDemoTheme {
        GreetingLogin("Android")
    }
}