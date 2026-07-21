// <T> 是泛型类型参数声明，相当于占位符，使用时才确定具体类型
//class Box<T>(private val content: T) {
//    // 取出内容，返回类型和存储类型一致
//    fun getContent(): T = content
//    //函数返回值类型T
//    //=content是Kotlin提供的简化语法糖,等价于下面写法
//    //fun getContent(): T {
//    //    return content
//    //}
//
//
//    // 对内容做处理的高阶函数，接收符合T类型规则的处理函数
//    fun <R> mapContent(transform: (T) -> R): R {
//        return transform(content)
//    }
//}
//
//fun main() {
//    // 存整数的盒子
//    val intBox = Box(100)
//    println(intBox.getContent()) // 输出 100
//    // 把Int转成String
//
//    //注意`it`只有在Lambda只有1个参数的时候才能用
//    val intToString = intBox.mapContent { "数字是：$it" }//这里it对应的是T，等价于下面的写法
//    val intToString1= intBox.mapContent { value -> "数字是：$value" }
//    //`it`是Kotlin为只有1个参数的Lambda表达式提供的默认隐式参数名，
//    // 属于Kotlin的语法糖，不用你手动声明参数名就可以直接用
//    //参数transform是 「接收1个T类型参数，返回R类型」 的函数
//    println(intToString) // 输出 数字是：100
//    println(intToString1)// 输出 数字是：100
//
//    // 存字符串的盒子
//    val strBox = Box("泛型示例")
//    println(strBox.getContent()) // 输出 泛型示例
//    // 计算字符串长度
//    val strLength = strBox.mapContent { it.length }
//    println(strLength) // 输出 4
//}





//out：协变，只出不进

// 加out修饰：这个只读盒子只能往外拿数据，不能往里放

//interface Box<out T> {
//
//    fun get(): T// ✅ 合法：T作为返回值，生产数据
//    // fun set(value: T)// ❌ 非法：T作为输入参数，消费数据，加了out就不能这么写
//}
//
//fun main()
//{
//    // Int是Number的子类
//    val intBox: Box<Int> = object : Box<Int> {
//        //val intBox: Box<Int>	声明一个不可变变量，变量名是intBox，类型是Box<Int>（存储Int类型的Box接口类型）
//        //object : Box<Int>	核心是Kotlin的对象表达式：<br>创建一个匿名类的实例，这个匿名类实现了Box<Int>接口，不需要你单独写一个class IntBoxImpl : Box<Int>这样的命名子类
//        override fun get() = 100
//    }
//    //等价于下面写法
////    // 1. 先写一个命名的实现类
////    class IntBoxImpl : Box<Int> {
////        override fun get() = 100
////    }
////    // 2. 再创建实例
////    val intBox: Box<Int> = IntBoxImpl()
//
//    //匿名对象语法
//    //object : 父类构造 / 接口1, 接口2... {
//    //类体：可以定义属性、方法、重写父类/接口的成员
//    //}
//
//
//    val numberBox: Box<Number> = intBox// ✅ 合法：因为加了out协变，Box<Int>可以直接赋值给Box<Number>
//    println(numberBox.get()) // 输出 100
//}


//in 逆变 只进不出
// 加in修饰：这个比较器只能接收数据做处理，不能返回T类型数据
//interface Comparator<in T> {
//
//    fun compare(a: T, b: T): Int  // ✅ 合法：T作为输入参数，消费数据
//
//    // fun get(): T // ❌ 非法：T作为返回值，加了in就不能这么写
//}
//
//fun main()
//{
//    val numberComparator :Comparator<Number> = object:Comparator<Number>
//    {
//        override fun compare(a: Number, b: Number): Int = a.toInt()-b.toInt()
//    }
//
//    // ✅ 合法：因为加了in逆变，能处理Number的比较器当然也能处理Int
//    val intComparator: Comparator<Int> = numberComparator
//    println(intComparator.compare(10, 20)) // 输出 -10
//}


//where：泛型多边界约束
//比如你要求泛型T必须同时是某个类的子类，还要实现多个接口，就用`where`。
// 要求泛型T必须同时满足：1.是Number的子类 2.实现Comparable接口
fun <T> sortList(list: List<T>) where T : Number, T : Comparable<T> {
    // 里面既可以调用Number的toInt()等方法，也可以调用Comparable的compareTo()方法
    list.sorted()
}

fun main() {
    // ✅ 合法：Int同时是Number子类，也实现了Comparable
    sortList(listOf(3,1,2))

    // ❌ 非法：String不是Number的子类，不满足约束
    // sortList(listOf("a","b","c"))
}