package com.darcy.message.composedemo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.darcy.message.composedemo.MainShow
import com.darcy.message.composedemo.exts.showToast
import com.darcy.message.composedemo.ui.pages.chat.ChatDetailShow
import com.darcy.message.composedemo.ui.pages.chat.ChatListShow
import com.darcy.message.composedemo.ui.pages.sample.ConstraintLayoutShow
import com.darcy.message.composedemo.ui.pages.sample.FrameLayoutShow
import com.darcy.message.composedemo.ui.pages.sample.ImageViewShow
import com.darcy.message.composedemo.ui.pages.sample.LinearLayoutShow
import com.darcy.message.composedemo.ui.pages.sample.RecyclerViewShow
import com.darcy.message.composedemo.ui.pages.sample.RelativeLayoutShow
import com.darcy.message.composedemo.ui.pages.sample.SwitchesShow
import com.darcy.message.composedemo.ui.pages.sample.TextViewShow
import com.darcy.message.composedemo.ui.pages.sample.ViewPagerShow

enum class Screen(name: String) {
    Main("Main"),
    ChatList("ChatList"),
    ChatDetail("ChatDetail"),
    ChatSettings("ChatSettings"),
    ConstraintLayout("ConstraintLayout"),
    FrameLayout("FrameLayout"),
    ImageView("ImageView"),
    LinearLayout("LinearLayout"),
    RecyclerView("RecyclerView"),
    RelativeLayout("RelativeLayout"),
    Switch("Switch"),
    TextView("TextView"),
    ViewPager("ViewPager"),
}

@Composable
fun DarcyApp(
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = Screen.Main.name) {
        composable(Screen.Main.name) {
            MainShow(
                name = "",
                onNextButtonClicked = {
                    when (it) {
                        Screen.ChatList.name -> navController.navigate(Screen.ChatList.name)
                        Screen.ChatDetail.name -> navController.navigate(Screen.ChatDetail.name)
                        Screen.ChatSettings.name -> navController.navigate(Screen.ChatSettings.name)
                        Screen.ConstraintLayout.name -> navController.navigate(Screen.ConstraintLayout.name)
                        Screen.FrameLayout.name -> navController.navigate(Screen.FrameLayout.name)
                        Screen.ImageView.name -> navController.navigate(Screen.ImageView.name)
                        Screen.LinearLayout.name -> navController.navigate(Screen.LinearLayout.name)
                        Screen.RecyclerView.name -> navController.navigate(Screen.RecyclerView.name)
                        Screen.RelativeLayout.name -> navController.navigate(Screen.RelativeLayout.name)
                        Screen.Switch.name -> navController.navigate(Screen.Switch.name)
                        Screen.TextView.name -> navController.navigate(Screen.TextView.name)
                        Screen.ViewPager.name -> navController.navigate(Screen.ViewPager.name)
                        else -> {
                            "Navigation Error".showToast()
                        }
                    }
                })
        }
        composable(Screen.ChatList.name) {
            ChatListShow(
                name = "",
                onNextButtonClicked = {
                    navController.navigate(Screen.ChatDetail.name+ "/userId")
                }
            )
        }
        composable(
            // page route
            route = Screen.ChatDetail.name + "/{userId}",
            // darcyRefactor  arguments for page
            arguments = listOf(navArgument("chatId"){
                type = NavType.StringType
                defaultValue = "hello world."
            })) {
            ChatDetailShow(
                name = it.arguments?.getString("chatId") ?: "default value.",
                onCancelButtonClicked = {
                    navController.popBackStack(Screen.Main.name, false)
                }
            )
        }
        composable(Screen.ChatSettings.name){
//            SettingsShow(
//
//            )
        }
        composable(Screen.ConstraintLayout.name) {
            ConstraintLayoutShow(
                name = "",
            )
        }
        composable(Screen.FrameLayout.name){
            FrameLayoutShow(name = "")
        }
        composable(Screen.ImageView.name){
            ImageViewShow(name = "")
        }
        composable(Screen.LinearLayout.name){
            LinearLayoutShow(name = "")
        }
        composable(Screen.RelativeLayout.name){
            RelativeLayoutShow(name = "")
        }
        composable(Screen.RecyclerView.name) {
            RecyclerViewShow(name = "")
        }
        composable(Screen.Switch.name) {
            SwitchesShow(name = "")
        }
        composable(Screen.TextView.name) {
            TextViewShow(name = "")
        }
        composable(Screen.ViewPager.name) {
            ViewPagerShow(name = "")
        }
    }

}