package com.darcy.message.composedemo.learn

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.tooling.preview.Preview
import com.darcy.message.composedemo.exts.logD
import com.darcy.message.composedemo.exts.logE
import com.darcy.message.composedemo.exts.logI
import com.darcy.message.composedemo.learn.widgets.HomeImage

@Composable
fun Conversation(messages: List<Message>) {
    val showHomePage = rememberSaveable {
        mutableStateOf(false)
    }
    if (showHomePage.value) {
        ShowHomeContent()
        return
    }
    val showNextPage = rememberSaveable {
        mutableStateOf(false)
    }
    if (showNextPage.value) {
        HomeImage()
        return
    }

    /**
     * darcyRefactor: 返回键监听
     */
    BackHandler {
        // 改变状态的值,从而触发Compose函数重绘(刷新UI)
        showHomePage.value = !showHomePage.value
    }

    Column {
        Row {
            Button(onClick = {
                // 改变状态的值,从而触发Compose函数重绘(刷新UI)
                showHomePage.value = !showHomePage.value
            }) {
                Text(text = "上一页")
            }
            Button(onClick = { showNextPage.value = !showNextPage.value }) {
                Text(text = "下一页")
            }
            Button(onClick = { /* todo*/ }) {
                Text(text = "重绘")
            }
        }

        // TODO 只首次绘制的时候执行一次
        LaunchedEffect(Unit) {
            logI("LaunchedEffect: INIT items: ${messages.size}")
        }
        // TODO 每次绘制的时候都会执行
        SideEffect {
            logD("SideEffect: UPDATE")
        }
        // TODO 只销毁的时候执行一次
        DisposableEffect(Unit) {
            onDispose {
                logE("DisposableEffect: REMOVE")
            }
        }
        /**
         * 列表控件
         */
        LazyColumn {
            /**
             * 列表item
             */
//            items(messages.size) { index ->
//                logD("items index: $index")
//                MessageCard(message = messages[index])
//            }
            itemsIndexed(messages) { index, item ->
                logD("itemsIndexed index: $index item=$item")
                MessageCard(message = item)
            }
        }
    }
}

private const val author = "Jetpack Compose 博物馆"

@Preview
@Composable
fun ConversationPreview() {
    Conversation(
        messages = listOf(
            Message(author, "我们开始更新啦"),
            Message(
                author,
                "为了给广大的读者一个更好的体验，从今天起，我们公众号决定陆续发一些其他作者的高质量文章"
            ),
            Message(
                author,
                "每逢佳节倍思亲，从今天起，参加我们公众号活动的同学可以获得精美礼品一份！！"
            ),
            Message(author, "荣华梦一场，功名纸半张，是非海波千丈，马蹄踏碎禁街霜，听几度头鸡唱"),
            Message(
                author,
                "唤归来，西湖山上野猿哀。二十年多少风流怪，花落花开。望云霄拜将台，袖星斗安邦策，破烟月迷魂寨。酸斋笑我，我笑酸斋"
            ),
            Message(
                author,
                "伤心尽处露笑颜，醉里孤单写狂欢。两路殊途情何奈，三千弱水忧忘川。花开彼岸朦胧色，月过长空爽朗天。青鸟思飞无侧羽，重山万水亦徒然"
            ),
            Message(
                author,
                "又到绿杨曾折处，不语垂鞭，踏遍清秋路。衰草连天无意绪，雁声远向萧关去。恨天涯行役苦，只恨西风，吹梦成今古。明日客程还几许，沾衣况是新寒雨"
            ),
            Message(
                author,
                "莫笑农家腊酒浑，丰年留客足鸡豚。山重水复疑无路，柳暗花明又一村。箫鼓追随春社近，衣冠简朴古风存。从今若许闲乘月，拄杖无时夜叩门"
            ),
            Message(
                author,
                "把酒问月 青天有月来几时 我今停杯一问之 人攀明月不可得 月行却与人相随 皎如飞临临丹阙 绿烟灭尽清辉发 但见宵从海上来 宁知晓向云间没 白兔捣药秋复春 嫦娥孤栖与谁邻 今人不见古时月 今月曾经照古人 "
            ),
            Message(
                author,
                "春江花月夜 春江潮水连海平 海上明月共潮生 滟滟随波千万里 何处春江无月明 江流宛转绕芳甸 月照花林皆似霰 空里流霜不觉飞 汀上白沙看不见 江天一色无纤尘 皎皎空中孤月轮 江畔何人初见月 江月何年初照人 人生代代无穷已 江月年年望相似 不知江月待何人 但见长江送流水"
            )
        )
    )
}
