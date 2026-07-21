//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
fun main() {
    val name = "Kotlin"
    val int =1
    val long = 123456L
    val double = 12.34
    val float = 12.34F

    //float=13.234F这里会报错,val不可更改，类似final

    println(name)
    println(int)
    println(long)
    println(double)
    println(float)

    var float1=12.34F
    float1=12.34F//可以编译通过，val=var+final


}