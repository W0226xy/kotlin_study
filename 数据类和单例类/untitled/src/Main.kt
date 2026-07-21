
// 1. 定义数据类：主构造必须至少有1个参数，且参数必须加val/var声明为属性
data class Student(
    //数据类完全可以像普通类一样定义成员方法、静态方法（伴生对象方法），
    // 也可以实现接口，只是核心定位是封装数据，不建议加太复杂的业务逻辑
    val id: String,      // 学号
    val name: String,    // 姓名
    val age: Int,        // 年龄
    val score: Int       // 分数
)

//fun main() {
//    // ========== 特性1：自动生成toString方法，直接打印属性内容 ==========
//    val student1 = Student("2024001", "张三", 18, 95)
//    println(student1)
//    // 输出：Student(id=2024001, name=张三, age=18, score=95)
//    // 普通类默认打印类名+地址，数据类直接打印所有属性值
//
//    // ========== 特性2：equals/hashCode比较内容而非地址 ==========
//    val student2 = Student("2024001", "张三", 18, 95)
//    println(student1 == student2)
//    // 输出：true（普通类这里会输出false，因为比较的是对象地址）
//
//    // ========== 特性3：copy方法，快速复制对象并修改部分属性 ==========
//    val student3 = student1.copy(score = 100, name = "张三(补考)")
//    println(student3)
//    // 输出：Student(id=2024001, name=张三(补考), age=18, score=100)
//    // 其他属性和原对象一致，只修改指定的属性，非常方便
//
//    // ========== 特性4：支持解构声明 ==========
//    val (id, name, age, score) = student1
//    println("学号：$id，姓名：$name，年龄：$age，分数：$score")
//    // 输出：学号：2024001，姓名：张三，年龄：18，分数：95
//}



//### 数据类核心规则和注意点：
//1. **主构造要求**：主构造函数必须至少有1个参数，且所有参数必须用`val`/`var`声明为类属性
//2. **不能继承/被继承**：数据类默认是final的，不能被其他类继承，也不能继承其他普通类（但可以实现接口）
//3. **自动生成方法优先级**：如果你手动重写了`equals()`、`toString()`等方法，编译器就不会再自动生成对应的方法
//4. **适用场景**：
//- 网络接口返回的JSON实体类
//- 数据库表对应的实体类
//- 页面状态、事件等纯数据封装
//- 代替Java中的POJO类，不用再写一堆get/set、equals、toString模板代码

//单例类
// 直接用object关键字定义，天生就是单例，构造函数默认私有
object AppConfig {
    // 单例属性
    val appVersion = "1.0.0"
    var isDebugMode = true

    // 单例方法
    fun getApiHost(): String {
        return if (isDebugMode) "https://test.api.com" else "https://prod.api.com"
    }
}

// 使用：直接通过类名访问，不需要创建对象
fun main() {
    println(AppConfig.appVersion)    // 输出：1.0.0
    println(AppConfig.getApiHost())  // 输出：https://test.api.com

    // 所有地方拿到的都是同一个实例
    val config1 = AppConfig
    val config2 = AppConfig
    println(config1 == config2)  // 输出：true
    println(config1 === config2) // 输出：true
    //== 是一个相等性比较操作符，用于比较两个变量的值是否相等。
    //=== 是一个恒等性比较操作符，它不仅比较两个对象的值是否相等，还检查它们是否是同一个对象实例
}