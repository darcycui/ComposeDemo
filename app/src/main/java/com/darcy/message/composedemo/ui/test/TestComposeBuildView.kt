package com.darcy.message.composedemo.ui.test

import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.compose.runtime.AbstractApplier
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeNode
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

/**
 * Use Compose to build View
 * https://juejin.cn/post/7176437908935540797
 */
@Composable
fun ComposeBuildTest(name: String, modifier: Modifier = Modifier) {
    var count = remember { mutableIntStateOf(1) }

    LinearLayout {
        TextView(
            text = "This is the Android TextView!!",
        )
        repeat(count.intValue) {
            TextView(
                text = "Android View!!TextView:$it $count",
                onClick = {
                    count.intValue++
                }
            )
        }
    }
}

class MyViewApplier(val view: FrameLayout) : AbstractApplier<View>(view) {
    override fun onClear() {
        (view as? ViewGroup)?.removeAllViews()
    }

    override fun insertBottomUp(index: Int, instance: View) {
        (current as? ViewGroup)?.addView(instance, index)
    }

    override fun insertTopDown(index: Int, instance: View) {
    }

    override fun move(from: Int, to: Int, count: Int) {
        // NOT Supported
        TODO()
    }

    override fun remove(index: Int, count: Int) {
        (view as? ViewGroup)?.removeViews(index, count)
    }
}

@Composable
fun TextView(
    text: String,
    onClick: () -> Unit = {}
) {
    val context = LocalContext.current
    ComposeNode<TextView, MyViewApplier>(
        factory = {
            TextView(context)
        },
        update = {
            set(text) {
                this.text = text
            }
            set(onClick) {
                setOnClickListener { onClick() }
            }
        },
    )
}

@Composable
fun LinearLayout(children: @Composable () -> Unit) {
    val context = LocalContext.current
    ComposeNode<LinearLayout, MyViewApplier>(
        factory = {
            LinearLayout(context).apply {
                orientation = LinearLayout.VERTICAL
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT,
                )
            }
        },
        update = {},
        content = children,
    )
}


