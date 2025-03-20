package com.darcy.message.composedemo.ui.pages.login.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.darcy.message.composedemo.ui.LogInUiIntent
import com.darcy.message.composedemo.ui.LoginUiState
import com.darcy.message.composedemo.ui.pages.chat.UserBean
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel : ViewModel() {
    fun handleIntent(event: LogInUiIntent) {
        when (event) {
            is LogInUiIntent.LoginIntent -> {
                doLogin(event.userBean)
            }

            is LogInUiIntent.LogoutIntent -> {
                doLogout(event.userBean)
            }
        }
    }

    private val _uiState = mutableStateOf<LoginUiState>(LoginUiState.SignedOut)
    val uiState: State<LoginUiState>
        get() = _uiState

    private val _uiStateLiveData = MutableLiveData<LoginUiState>(LoginUiState.SignedOut)
    val uiStateLiveData: LiveData<LoginUiState>
        get() = _uiStateLiveData

    private val _uiStateFlow = MutableStateFlow<LoginUiState>(LoginUiState.SignedOut)
    val uiStateFlow: StateFlow<LoginUiState>
        get() = _uiStateFlow

    private fun doLogin(userBean: UserBean) {
        _uiState.value = LoginUiState.Loading
        _uiStateLiveData.value = LoginUiState.Loading
        _uiStateFlow.update { LoginUiState.Loading }
        viewModelScope.launch(Dispatchers.IO) {
            delay(3_000)
            withContext(Dispatchers.Main) {
                val user = UserBean(101L, "darcy", "123456")
                _uiState.value = LoginUiState.Success(user)
                _uiStateLiveData.value = LoginUiState.Success(user)
                _uiStateFlow.update { LoginUiState.Success(user) }
            }
        }
    }

    private fun doLogout(userBean: UserBean) {
        _uiState.value = LoginUiState.Loading
        _uiStateLiveData.value = LoginUiState.Loading
        _uiStateFlow.update { LoginUiState.Loading }
        viewModelScope.launch(Dispatchers.IO) {
            delay(3_000)
            withContext(Dispatchers.Main) {
                val user = UserBean(101L, "darcy", "123456")
                _uiState.value = LoginUiState.SignedOut
                _uiStateLiveData.value = LoginUiState.SignedOut
                _uiStateFlow.update { LoginUiState.SignedOut }
            }
        }
    }

}