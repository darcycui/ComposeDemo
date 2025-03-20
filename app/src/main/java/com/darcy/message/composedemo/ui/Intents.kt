package com.darcy.message.composedemo.ui

import com.darcy.message.composedemo.ui.pages.chat.UserBean

interface IUiIntent {
}


sealed class LogInUiIntent : IUiIntent {}
data class LoginIntent(val userBean: UserBean) : LogInUiIntent()
data class LogoutIntent(val userBean: UserBean) : LogInUiIntent()