package com.darcy.message.composedemo.ui.pages.login.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.darcy.message.composedemo.ui.LoginIntent
import com.darcy.message.composedemo.ui.Loading
import com.darcy.message.composedemo.ui.Success
import com.darcy.message.composedemo.ui.LogoutIntent
import com.darcy.message.composedemo.ui.SignedOut
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
            is LoginIntent -> {
                doLogin(event.userBean)
            }

            is LogoutIntent -> {
                doLogout(event.userBean)
            }
        }
    }

    private val _uiState = mutableStateOf<LoginUiState>(SignedOut)
    val uiState: State<LoginUiState>
        get() = _uiState

    private val _uiStateLiveData = MutableLiveData<LoginUiState>(SignedOut)
    val uiStateLiveData: LiveData<LoginUiState>
        get() = _uiStateLiveData

    private val _uiStateFlow = MutableStateFlow<LoginUiState>(SignedOut)
    val uiStateFlow: StateFlow<LoginUiState>
        get() = _uiStateFlow

    private fun doLogin(userBean: UserBean) {
        _uiState.value = Loading
        _uiStateLiveData.value = Loading
        _uiStateFlow.update { Loading }
        viewModelScope.launch(Dispatchers.IO) {
            delay(3_000)
            withContext(Dispatchers.Main) {
                val user = UserBean(101L, "darcy", "123456")
                _uiState.value = Success(user)
                _uiStateLiveData.value = Success(user)
                _uiStateFlow.update { Success(user) }
            }
        }
    }

    private fun doLogout(userBean: UserBean) {
        _uiState.value = Loading
        _uiStateLiveData.value = Loading
        _uiStateFlow.update { Loading }
        viewModelScope.launch(Dispatchers.IO) {
            delay(3_000)
            withContext(Dispatchers.Main) {
                val user = UserBean(101L, "darcy", "123456")
                _uiState.value = SignedOut
                _uiStateLiveData.value = SignedOut
                _uiStateFlow.update { SignedOut }
            }
        }
    }

}