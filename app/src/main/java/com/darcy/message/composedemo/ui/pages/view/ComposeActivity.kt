package com.darcy.message.composedemo.ui.pages.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.darcy.message.composedemo.R
import com.darcy.message.composedemo.exts.showToast
import com.darcy.message.composedemo.ui.pages.view.ui.theme.ComposeDemoTheme

class ComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeWithView("Android")
                }
            }
        }
    }
}

@Composable
fun ComposeWithView(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        loadView()
    }
}

/**
 * 在 Compose UI 中嵌入 View
 */
@Composable
private fun loadView() {
    var recyclerView: RecyclerView
    val adapter: ItemAdapter = ItemAdapter()
    adapter.setData(listOf("Java", "C++", "Go", "Python", "Haskell", "C#", "Php", "JavaScript"))
    AndroidView(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max),
        factory = { context: Context ->
            LayoutInflater.from(context).inflate(R.layout.darcy_view, null).apply {
                recyclerView = findViewById(R.id.rvRecyclerView)
                recyclerView.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                recyclerView.adapter = adapter
            }
        }) {
        // 更新UI
        adapter.setOnClickListener { str, position ->
            "$str $position".showToast()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeDemoTheme {
        ComposeWithView("Android")
    }
}

class ItemViewHolder(view: View, private val clickListener: (String, Int) -> Unit) :
    RecyclerView.ViewHolder(view) {
    private val tvTitle: TextView by lazy {
        itemView.findViewById(R.id.item_title)
    }

    fun initItem(str: String, position: Int) {
        tvTitle.text = str
        tvTitle.setOnClickListener {
            clickListener.invoke(str, position)
        }
    }

}

class ItemAdapter : RecyclerView.Adapter<ItemViewHolder>() {
    private lateinit var clickListener: (String, Int) -> Unit
    private val data: MutableList<String> = mutableListOf()

    fun setData(data: List<String>) {
        this.data.clear()
        this.data.addAll(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.darcy_item_view, parent, false),
            clickListener
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.initItem(data[position], position)
    }

    fun setOnClickListener(function: (String, Int) -> Unit) {
        this.clickListener = function
    }

}