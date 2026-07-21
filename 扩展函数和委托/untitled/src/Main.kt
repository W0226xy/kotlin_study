//扩展函数语法结构
//fun 接收者类型.函数名(参数列表): 返回值类型 {
//    // 函数体
//    // 内部可以用this访问接收者对象的成员
//}

// 定义扩展函数：给Int类加一个toTimeString()方法
fun Int.toTimeString(): String {
    val totalSeconds = this / 1000 // this代表调用这个方法的Int值（毫秒数）
    val minutes = totalSeconds / 60
    val seconds = totalSeconds % 60
    return "%02d:%02d".format(minutes, seconds)
}

// 给String类扩展一个isNumber属性，判断字符串是不是纯数字
val String.isNumber: Boolean
    get() = this.matches(Regex("\\d+")) // this代表调用该属性的字符串本身
//每次访问`.isNumber`的时候，都会自动执行get()里的逻辑计算结果，不需要加括号，就像访问类本身的成员属性一样。
//get()：这是扩展属性的取值方法，每次你访问这个`isNumber`属性的时候，就会自动执行这个方法，方法的返回值就是属性的结果。



//fun main() {
//    val songDuration = 215000 // 歌曲时长215000毫秒
//    println(songDuration.toTimeString()) // 输出：03:35
//
//    // 还可以直接给字面量用
//    println(184000.toTimeString()) // 输出：03:04
//
//
//    println("123456".isNumber)  // 输出 true
//    println("hello123".isNumber) // 输出 false
//}

//委托
// 1. 定义公共接口Base，约定要实现的能力
interface Base {
    fun print()
}

// 2. Base的默认实现类，print方法会打印构造传入的x值
class BaseImpl(val x: Int) : Base {
    override fun print() { print(x) }
}

// 3. 核心：类委托语法
// Derived类也实现Base接口，但它自己不实现接口方法
// by b表示：把Base接口的所有方法实现，全部委托给传入的b对象去处理
class Derived(b: Base) : Base by b
//等价于下面这段代码
//class Derived(val b: Base) : Base {
//    override fun print() {
//        b.print() 
//    }
//}

fun main() {
    val base = BaseImpl(10)//创建的是BaseImpl实例，然后把这个实例传给了Derived
    // 调用Derived的print()，实际上会自动转发给委托的base对象的print()执行
    Derived(base).print()
}