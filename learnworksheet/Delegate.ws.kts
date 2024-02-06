import kotlin.reflect.KProperty

class Delegate {
    operator fun getValue(thisRef: Any?, property:KProperty<*>): String {
        return "$thisRef delegating ${property.name}"
    }

    operator fun setValue(thisRef: Any?, property:KProperty<*>, value: String) {
        println("$thisRef delegating ${property.name}")
    }
}

class Example {
    var str: String by Delegate()
}

val p = Example()
p.str = "Hello"
println(p.str)