Android Jetpack Compose
## 声明式UI

状态驱动UI界面
UI界面是状态的呈现
声明式UI 本质上是异步的，Compose 通过协程实现异步 

## 函数式编程

强调不可变性
纯函数

## 可组合函数

-  添加@Composable注解，也叫可组合函数
-  只能在其他可组合函数中调用
-  组合：描述页面可组合函数的树形结构
	-  初始组合：第一次组合
	-  重组： 状态改变导致的组合项的更新
	-  组合只能通过【初始组合】生成
	-  组合只能通过【重组】更新
-  生命周期
	-  进入组合
	-  重组 0次或多次
	-  退出组合
-  同一个可组合函数多次调用产生不同实例，生命周期各自独立

## 可组合函数

-  可组合函数的实例与调用位置相关
-  每一次调用都是唯一的
-  本次重组调用的可组合函数与上次重组可能相同，也可能不同
-  Compose决定哪些可组合函数被调用，哪些不调用
	-  if条件不满足的分支里的可组合函数不调用
	-  输入没有变化的可组合函数不调用--跳过
		-  所有输入都是稳定类型
			-  基本数据类型
			-  字符串
			-  函数类型 lambda
			-  MutableState类型 
		-  输入值没有变化（使用equals比较）
	-  关联key的可组合函数 如果key不变则不调用
		-  key在当前作用域唯一
		-  通用 key (bean.id) {}
		-  可组合函数内置 LazyColumn items
## 副作用

-  用于在可组合函数作用域之外执行UI动作（toast snackbar 页面跳转等）
-  可组合函数应该尽可能地不带副作用
-  LaunchedEffect
	-  自动启动协程，可以调用挂起函数
	-  进入组合时触发，只触发一次
	-  key变化时重启，key可以指定为任意值 Unit Int String Class
-  rememberCoroutineScope()  
	-  可组合函数
	-  返回绑定了组合项生命周期的【协程作用域】
-  rememberUpdateState
	-  在可组合函数中保存变量的最新值，可以在LaunchedEffec等副作用中使用
	-  在LuanchedEffect(key) 中使用要求key 不可变：true Unit
-  DisposedEffect
	-  退出组合时触发，只触发一次
	-  key变化时重启，key典型值是lifecycleOwner
	-  必须在末尾调用onDispose {} 
-  SideEffect 
	-  将Compose状态-->转为非Compose状态
	-  每次重组后都执行
-  produceState 
	-  将非Compose状态-->转为Compose状态
	-  自动启动协程，可以调用挂起函数
	-  key变化时重启，key可以是任意类型 Unit Int String Class ViewModel
	-  支持1个key 2个key 3个key key数组，也可以没有key
	-  支持Flow LiveData RxJava的状态
		-  Flow：collectAsStateWithLifecycle、collectAsState
		-  LiveData：observeAsState  
		-  RxJava ：subscribeAsState
	-  典型使用：将业务逻辑转为UI状态（加载图片、获取数据）	
-  derivedStateOf
	-  将一个或多个状态转为另一个新状态
	-  新状态只有在值变化时触发重组，类比Flow distinctUntilChanged()
	-  成本很高，只在变化频率不匹配时使用
	-  典型使用：避免状态变化过快引起的不必要的重组 如LazyColumn滚动位置
-  snapshotFlow
	-  将Compose状态转为Flow
	-  冷流Flow
	-  自带distinctUntilChanged() 当状态值改变时emit
-  如何确定重启的key (LaunchEffect produceState DispoableEffect)
	-  将key 提取为可组合函数的参数
	-  如果不需要重启，将key设置为不可变量 Unit Int String
	-  使用rememberUpdateState()保存后的值，是不可变量， 不要设置为key
