package com.darcy.message.composedemo.ui.pages.login.viewmodel

import androidx.lifecycle.viewModelScope
import com.darcy.message.composedemo.ui.BannerUiState
import com.darcy.message.composedemo.ui.BaseViewModel
import com.darcy.message.composedemo.ui.LogInUiIntent
import com.darcy.message.composedemo.ui.LoginMainUiState
import com.darcy.message.composedemo.ui.LoginUiState
import com.darcy.message.composedemo.ui.pages.chat.UserBean
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel2 : BaseViewModel<LoginMainUiState, LogInUiIntent>() {
    override fun initUiState(): LoginMainUiState {
        return LoginMainUiState(LoginUiState.SignedOut, BannerUiState.Loading)
    }

    override fun handleUiIntent(intent: LogInUiIntent) {
        when (intent) {
            is LogInUiIntent.LoginIntent -> {
                doLogin(intent.userBean)
            }

            is LogInUiIntent.LogoutIntent -> {
                doLogout(intent.userBean)
            }
        }
    }

    private fun doLogin(userBean: UserBean) {
        sendUiState { copy(loginUiState = LoginUiState.Loading) }
        viewModelScope.launch(Dispatchers.IO) {
            delay(3_000)
            withContext(Dispatchers.Main) {
                val user = UserBean(102L, "darcy2", "123456")
                sendUiState { copy(loginUiState = LoginUiState.Success(user)) }
            }
        }
    }

    private fun doLogout(userBean: UserBean) {
        sendUiState { copy(loginUiState = LoginUiState.Loading) }
        viewModelScope.launch(Dispatchers.IO) {
            delay(3_000)
            withContext(Dispatchers.Main) {
                val user = UserBean(102L, "darcy2", "123456")
                sendUiState { copy(loginUiState = LoginUiState.SignedOut) }
            }
        }
    }

}