open class Person(var name: String, var age: Int) {
    open fun printInfo() {
        println("Name: $name, Age: $age")
    }
}


//主构造参数score加var，直接成为类成员属性，不需要额外在类内声明
class Student(name: String, age: Int, var score: Int) : Person(name, age) {

    // 可选：添加次构造函数，支持只传姓名年龄，默认分数为0
    constructor(name: String, age: Int) : this(name, age, 0)

    override fun printInfo() {
        super.printInfo()//(可选)，调用父类逻辑
        println("Score: $score")
    }
}

// 测试用例
fun main() {
    // 使用主构造函数创建
    val student1 = Student("张三", 18, 95)
    student1.printInfo()
    // 输出：
    // Name: 张三, Age: 18
    // Score: 95

    // 使用次构造函数创建（默认0分）
    val student2 = Student("李四", 17)
    student2.printInfo()
    // 输出：
    // Name: 李四, Age: 17
    // Score: 0
}




