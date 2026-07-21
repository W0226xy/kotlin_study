package src



//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
//fun main() {
//    val list = ArrayList<Int>()//常规创建，可以插入数据
//    list.add(1)
//    list.add(2)
//    list.add(3)
//    println(list)//[1,2,3]
//
//    val list1 = listOf<Int>(1, 2, 3)
//    //list1.add(4)//会报错
//    println(list1)//[1,2,3]
//    //listof不可变，只可查
//
//    val list2 = mutableListOf<Int>(1, 2, 3)//mutableListOf：可变
//    list2.add(4)
//    println(list2)//[1, 2, 3, 4]
//
//    //（2） Set集合与List类似, 只是使用的是setOf()和mutableSetOf()
//    val set = setOf<Pair<Int, String>>(1 to "1", 2 to "2")//setOf只能接受一个参数
//    //想存这些键值对到Set集合中 将泛型声明为 `Pair<Int, String>` 即可
//
//    println(set)//[(1, 1), (2, 2)]
//
//    //（3） Map
//    val map1 = HashMap<Int, String>()
//    map1.put(1, "111")
//    map1.put(2, "2")
//    // 赋值
//    map1[2] = "222"
//    // 访问可以用map[key]获取到value
//    println(map1[1])///111
//    println(map1[2])//222
//    println(map1.get(2))//222等价于上一行代码
//
//    // 不可变
//    val map2 = mapOf<Int, String>(1 to "1", 2 to "2")
//    // map2[2] = "222" //报错
//
//    // 可变
//    val map3 = mutableMapOf<Int, String>(1 to "1", 2 to "2")
//    map3[2] = "222"
//
//    println("=============================")
//
//    //Lambda格式： { 参数名1： 参数类型， 参数名2：参数类型 -> 函数体 }

//    val list3 = listOf<String>("abc", "def", "dadf", "dafcwqe")
//    //返回当前list中最多的元素
//    var lambda = { str: String -> str.length }
//    var maxString = list3.maxByOrNull(lambda)
//    //maxByOrNull可以用lambda表达式作为参数
//    //`maxByOrNull` 本身就是高阶函数，它的参数类型就是函数类型 `(T) -> Comparable<*>` 「接收1个参数、返回一个可比较类型值」
//    //`Comparable`是Kotlin的基础接口，所有可以比较大小的类型（比如Int、Long、Float、String、Date等等）都默认实现了这个接口
//    //`<*>`是Kotlin的「星投影」语法，意思是不限制Comparable的具体泛型类型
//
//    println(maxString)//dafcwqe
//
//    // 直接当成参数传递
//    var maxString1 = list3.maxByOrNull({ str: String -> str.length })
//    // 如果lambda是方法的最后一个参数，参数可以提出来
//    var maxString2 = list3.maxByOrNull() { str: String -> str.length }
//    // 如果只有一个参数，且是lambda参数，可以去掉方法的()
//    var maxString3 = list3.maxByOrNull { str: String -> str.length }
//    // 有类型推导机制，也可以去掉参数类型
//    var maxStrinf4 = list3.maxByOrNull { str -> str.length }
//    // 如果lambda只有一个参数，可以用it代替
//    var maxString5 = list3.maxByOrNull { it.length }
//
//    // map映射（将集合中的每个元素都映射成一个另外的值）
//    // 转大写
//    var newList1 = list3.map { it.uppercase() }
//    // 转小写的写法（如果需要）
//    var newList2 = list3.map { it.lowercase() }
//    // filter过滤
//    var newList3 = list3.filter { it.length > 5 }
//    // any 判断是否存在满足条件的元素
//    var isAny = list3.any { it.length > 5 }
//    // all 判断是否全部满足条件
//    var isAll = list3.all { it.length > 0 }
//
//
//}

//高阶函数:Kotlin中函数是「一等公民」，可以作为变量传递、作为参数传入其他函数，也可以作为函数的返回值。
//接收函数作为参数 或 返回值是函数的函数，就叫高阶函数。
// 高阶函数：接收两个Int参数，还有一个运算函数参数(接收两个Int返回Int)
fun calculate(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    //operation	参数名，和普通函数的a: Int里的a是一样的，就是给这个参数起的名字
    //冒号:	和普通参数一样，后面接参数的类型
    //(Int, Int) -> Int	这个参数的类型是「函数类型」，说明这个参数本身是一个函数，这里不是lambda表达式，后面a, b -> a * b才是lambda表达式
    return operation(a, b)
}

fun main() {
    // 用法1：传入匿名函数作为参数
    val sum = calculate(10, 5, fun(a: Int, b: Int): Int {
        return a + b
    })
    println("求和结果：$sum") // 输出 15

    // 用法2：匿名函数也可以简写（当最后一个参数是函数时，可以写在括号外面）
    val multiply = calculate(10, 5) { a, b ->
        a * b
    }
    println("乘积结果：$multiply") // 输出 50

    // 用法3：也可以传入已经定义好的命名函数
    fun minus(a: Int, b: Int) = a - b
    val difference = calculate(10, 5, ::minus)
    println("差值结果：$difference") // 输出 5
}

