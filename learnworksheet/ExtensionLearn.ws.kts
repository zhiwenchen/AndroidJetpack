import kotlin.math.pow

fun String.method1(i: Int) {
    println("$this $i")
}
"dfs".method1(2)
2f.pow(10)
(Int::toFloat)(1)

// 扩展属性
val Float.test
    get() = this + 1
val test1 = 200f.test
println("$test1")