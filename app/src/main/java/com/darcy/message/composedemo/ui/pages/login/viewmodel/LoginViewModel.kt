package com.darcy.message.composedemo.ui.pages.chat.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.darcy.message.composedemo.ui.pages.chat.SignedOut
import com.darcy.message.composedemo.ui.pages.chat.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LoginViewModel : ViewModel() {
    private val _uiState = mutableStateOf<UiState>(SignedOut)
    private val uiState: State<UiState>
        get() = _uiState

    private val _uiStateLiveData = MutableLiveData<UiState>(SignedOut)
    private val uiStateLiveData: LiveData<UiState>
        get() = _uiStateLiveData

    private val _uiStateFlow = MutableStateFlow<UiState>(SignedOut)
    private val uiStateFlow: StateFlow<UiState>
        get() = _uiStateFlow
}