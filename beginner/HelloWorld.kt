package beginner

fun types() {
//    Integers:                 Byte, Short, Int, Long
//    Unassigned integers:      UByte, UShort, UInt, ULong
//    Floating-point Numbers:   Float, Double
//    Booleans:                 Boolean
//    Characters:               Char
//    Strings:                  String

//    variable declared without initialization
    val d: Int
//    variable initialized
    d = 3
    println("Int: $d")

//    variable explicitly typed and initialized
    var e: String = "Hello"
    println(e)
}

fun variables() {
//    read only variables with val
//    You can't change a read-only variable once you have given it a value.
    val popcorn = 5
    val hotdogs = 7
    println("$popcorn popcorns and $hotdogs hotdogs")

//    mutable variables with var
    var customers = 10
    println(customers)

    customers = 8
    println("There are $customers customers")
}

fun main() {
    println("Hello World!")

    variables()

    types()
}