
fun a(s:String, block: () -> String) {
    println("$s, ${block()}")
}

fun b() {
    a("hello") {
        "world"
    }
}

b()