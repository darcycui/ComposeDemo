package com.darcy.message.composedemo.learn.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.darcy.message.composedemo.R
import com.darcy.message.composedemo.exts.showToast
import com.darcy.message.composedemo.learn.ShowHomeContent

@Composable
fun HomeDialog() {
    val showHomePage = remember {
        mutableStateOf(false)
    }
    if (showHomePage.value) {
        ShowHomeContent()
        return
    }
    AlertDialog(
        onDismissRequest = {
            showHomePage.value = showHomePage.value.not()
        },
        title = {
            Text(
                text = "提示",
                fontWeight = FontWeight.Bold
            )
        },
        text = {
            Text(
                text = "是否要返回首页"
            )
        },
        confirmButton = {
            TextButton(onClick = {
                showHomePage.value = showHomePage.value.not()
                "点击确定按钮".showToast()
            }) {
                Text(
                    text = "确定"
                )
            }
        },
        dismissButton = {
            TextButton(onClick = {
                showHomePage.value = showHomePage.value.not()
                "点击取消按钮".showToast()
            }) {
                Text(
                    text = "取消"
                )
            }
        },
        icon = {
//            Image(ImageVector.vectorResource(id = R.drawable.darcy_dog), contentDescription = "弹窗图片说明")
            Image(ImageBitmap.imageResource(id = R.drawable.icon), contentDescription = "弹窗图片说明")
//            Image(painterResource(id = R.drawable.icon), contentDescription = "弹窗图片说明")
        },
//        containerColor = Color.Gray,
        iconContentColor = Color.Green,
        textContentColor = Color.Blue,
        titleContentColor = Color.Red,
        modifier = Modifier.clip(RoundedCornerShape(10))
    )
}

@Preview(showBackground = true)
@Composable
fun HomeDialogPreview() {
    HomeDialog()
}