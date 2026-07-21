
fun maxNub(a: Int, b: Int): Int {
//    if(a>b) return a
//    else return b
     return if (a > b) {//和上面两行代码效果一样
        a
    } else {
        b
    }
}

fun schedule(day:String): String=when(day)//传参String类的day，返回一个String类型
{
    //when 语句类似于 java 中的 switch 语句，每个分支通过->连接，不再需要break，由上到下匹配，
    //如果没有匹配到则执行else分支的逻辑（类似于switch语句中的default）。它同样可以作为表达式给变量赋值或者作为函数返回值

    "SAT"->"basketball"//
    "SUN"->"football"
    "FRI"->"running"
    else->"study"
}

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
fun main() {
    val x=1
    val y=2
    val max =if(x>y) x else y
    println(max)//2

    val z=maxNub(x,y)
    println(z)//2

    val s=schedule("Fri")
    println(s)//study

    for (i in 1..10) {//x..y [x,y]
        print("$i ")//打印1,2...10
    }

    println()

    for(i in 1 until 10)//x until y [x,y)
    {
        print("$i ")//打印1,2...9
    }

    println()
    for (i in 1..10 step 2) {//步长2
        print("$i ")//打印1,3,5,7,9
    }

    println()

    for(i in 1 until 10 step 2)//x until y [x,y)
    {
        print("$i ")//打印1,3,5,7,9
    }
}