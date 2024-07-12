package com.darcy.message.composedemo.ui.pages.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.MutableLiveData
import com.darcy.message.composedemo.databinding.DarcyActivityViewBinding
import com.darcy.message.composedemo.exts.showToast

class ViewActivity : AppCompatActivity() {
    private val binding: DarcyActivityViewBinding by lazy {
        DarcyActivityViewBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.darcy_activity_view)
        setContentView(binding.root)
        initView()
    }

    private val tittleLiveData = MutableLiveData("Android")
    /**
     * 在 View 中嵌入 Compose
     */
    private fun initView() {
        // 初始化Compose
        binding.composeView.setContent {
            // LiveData转换为State
            val titleState by tittleLiveData.observeAsState()
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Max)
                    .background(color = Color.Green)
            ) {
                Text(text = titleState.orEmpty(),
                    modifier = Modifier.clickable {
                        tittleLiveData.value = "测试LiveData转换State"
                    })
                Button(onClick = { "Compose Click".showToast() }) {
                    Text(text = "嵌入ComposeUI")
                }
            }
        }
        binding.tvTop.setOnClickListener {
        }
    }
}