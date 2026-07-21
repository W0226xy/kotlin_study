

// 1. 定义接口：规定所有可打印信息的类，都必须有printInfo方法
interface Printable {
    // 接口里只声明方法，不写具体实现（Kotlin也支持写默认实现，这是进阶用法）
    fun printInfo()
}

// 2. Person类实现Printable接口，相当于"承诺遵守这个规范，必须实现printInfo方法"
// 语法：类名() : 父类, 接口1, 接口2...
open class Person(var name: String, var age: Int) : Printable {
    // 必须重写接口里的printInfo方法
    override fun printInfo() {
        println("员工信息：姓名$name，年龄$age")
    }
}

// 3. 再定义另一个类，也实现Printable接口
class Teacher(name: String, age: Int, var subject: String) : Person(name, age) {
    //父类实现了接口后，所有子类会自动继承这个接口，不需要子类再显式声明实现该接口
    override fun printInfo() {
        println("老师信息：姓名$name，年龄$age，教$subject")
    }
}

class Student(name: String, age: Int, var score: Int) : Person(name, age) {
    override fun printInfo() {
        println("学生信息：姓名$name，年龄$age，分数$score")
    }
}

// 4. 接口的强大之处：可以统一处理所有实现了接口的类
fun printAllInfo(list: List<Printable>) {
    //`List<Printable>`表示这个集合可以接收所有实现了Printable接口的类的对象，
    // 不管是`Person`、`Teacher`、`Student`，哪怕你以后新增`Cleaner`、`SecurityGuard`类，只要它实现了`Printable`接口，都可以放进这个集合里传进来。
    list.forEach { it.printInfo() }
}


fun main() {
    val people = listOf(
        Person("王主任", 40),
        Teacher("李老师", 35, "数学"),
        Student("张三", 17, 92)
    )
    printAllInfo(people)
}
//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
