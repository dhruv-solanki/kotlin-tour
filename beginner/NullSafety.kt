package beginner

// To help prevent issues with null values in your programs,
// Kotlin has null safety in place.
// Null safety detects potential problems with null values at compile time,
// rather than at run time.

// Null safety is a combination of features that allow you to:

// Explicitly declare when null values are allowed in your program.
// Check for null values.
// Use safe calls to properties or functions that may contain null values.
// Declare actions to take if null values are detected.

fun describeString(maybeString: String?): String {
    if(maybeString != null && maybeString.length > 0) {
        return "String of length ${maybeString.length}"
    } else {
        return "Empty or null string"
    }
}

// safe call operator, use when value can be null
// it will return null if object or any property is null without throwing error
fun lengthString(maybeString: String?): Int? = maybeString?.length

fun main () {
//    by default all variables are non-null
    val neverNull: String = "This can't be null"
//    throws compile error
//    neverNull = null

    var nullable: String? = "You can be null"
    nullable = null

    println(describeString(neverNull))
    println(describeString(nullable))

    println(lengthString(neverNull))
    println(lengthString(nullable))

//    elvis operator, use to return default value if obj is null
    println(nullable?.length ?: 0)
}