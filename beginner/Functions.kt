package beginner

fun sum(x: Int, y: Int): Int {
    return x + y
}

// If your function doesn't return a useful value then its return type is Unit
// You don't have to declare that Unit is returned explicitly in your function body.
fun printMessageWithPrefix(message: String, prefix: String = "Info") {
    println("[$prefix] $message")
}

// single expression function
fun multiply(x: Int, y: Int) = x * y

fun lambdaFunctions() {
//    lambda function
    val uppercaseString: (String) -> String = {text: String -> text.uppercase()}
    println(uppercaseString("hello world"))

    val numbers = listOf(1, -2, 3, -4, 5, -6)
    println(numbers)

    val positives = numbers.filter({x -> x > 0})
    println(positives)

    val isNegative = {x: Int -> x < 0}
    val negatives = numbers.filter(isNegative)
    println(negatives)

    val doubled = numbers.map{x -> x * 2}
    println(doubled)

    val isTripled = {x: Int -> x * 3}
    val tripled = numbers.map(isTripled)
    println(tripled)

//    return lambda function
    fun toSeconds(time: String): (Int) -> Int = when (time) {
        "hour" -> {value -> value * 60 * 60}
        "minute" -> {value -> value * 60}
        else -> {value -> value}
    }

    val timesInMinutes = listOf(2, 10, 15, 1)
    val minToSec = toSeconds("minute")
    val timesInSeconds = timesInMinutes.map(minToSec)
    println(timesInSeconds)

    val totalTimeInSec = timesInMinutes.map(minToSec).sum()
    println(totalTimeInSec)

//    invoke separately
    println({text: String -> text.lowercase()}("WHY LOWERCASE!"))

//    trailing lambda
    val total = listOf(1, 2, 3).fold(0, {x, item -> x + item})
    println(total)
    println(listOf(1, 2, 3).fold(0) {x, item -> x + item})

    repeatN(5) { println("Hello") }
}

// repeat action for n times, where action is lambda
fun repeatN(n: Int, action: () -> Unit) {
    for(i in 1..n) {
        action()
    }
}

fun main() {
    println(sum(12, 76))

    println(multiply(7, 9))

    printMessageWithPrefix(prefix = "Log", message = "Hello World")

    printMessageWithPrefix(message = "This is test")

    lambdaFunctions()
}