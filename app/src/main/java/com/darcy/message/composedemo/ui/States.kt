package com.darcy.message.composedemo.ui.pages.chat

sealed class UiState
data object SignedOut : UiState()
data object LoginLoading : UiState()
data class LoginSuccess(val data: List<UserBean>) : UiState()
data class LoginError(val error: Throwable) : UiState()
