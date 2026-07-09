package beginner

fun flow() {
    val a = 1
    val b = 2
    println(if (a > b) a else b)

//    when can be used as either statement or as an expression
//    statement doesn't return anything it just prints value
    val obj = "hello"
    when(obj) {
        "1" -> println("One")
        "hello" -> println("Greetings")
        else -> println("Unknown")
    }

    val trafficLight = "Red"
    val trafficAction = when(trafficLight) {
        "Green" -> "Go"
        "Yellow" -> "Slow Down"
        "Red" -> "Stop"
        else -> "Malfunction"
    }
    println(trafficAction)
}

fun ranges() {
//    1..4 is 1, 2, 3, 4
//    1..<4 is 1, 2, 3
//    4 downTo 1 is 4, 3, 2, 1
//    1..5 step 2 is 1, 3, 5
//    Char ranges:
//    'a'..'d' is 'a', 'b', 'c', 'd'
//    'z' downTo 's' step 2 is 'z', 'x', 'v', 't'

    for(number in 1..5) {
        print(number)
    }
    println()

    val cakes = listOf("carrot", "cheese", "chocolate")
    for(cake in cakes) {
        println("Yummy, it's a $cake cake!")
    }

    var cakesEaten = 0
    while (cakesEaten < 3) {
        println("Eat a cake")
        cakesEaten++
    }
}

fun main() {
    flow()

    ranges()
}
