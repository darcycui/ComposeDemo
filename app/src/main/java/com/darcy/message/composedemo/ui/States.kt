package com.darcy.message.composedemo.ui

import com.darcy.message.composedemo.ui.pages.chat.UserBean

interface IUiState {}

data class LoginMainUiState(
    val loginUiState: LoginUiState,
    val bannerUiState: BannerUiState
) : IUiState {

}

sealed class LoginUiState : IUiState {
    data object SignedOut : LoginUiState()
    data object Loading : LoginUiState()
    data class Success(val data: UserBean) : LoginUiState()
    data class Error(val error: Throwable) : LoginUiState()
}

sealed class BannerUiState : IUiState {
    data object Loading : BannerUiState()
    data class Success(val data: List<String>) : BannerUiState()
    data class Error(val error: Throwable) : BannerUiState()
}
