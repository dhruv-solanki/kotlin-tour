package intermediate

// In programming, a scope is the area in which your variable or object is recognized.
// The most commonly referred to scopes are the global scope and the local scope:

// Global scope – a variable or object that is accessible
// from anywhere in the program.

// Local scope – a variable or object that is only accessible
// within the block or function where it is defined.

// In Kotlin, there are also scope functions that
// allow you to create a temporary scope around an object and execute some code.

// Kotlin has five scope functions in total: let, apply, run, also, and with
// Each scope function takes a lambda expression and
// returns either the object or the result of the lambda expression

// Let Scope Function: Use the let scope function
// when you want to perform null checks in your code and
// later perform further actions with the returned object.

fun sendNotifications(recipientAddress: String): String {
    println("Yo $recipientAddress")
    return "OK"
}

fun getNextAddress(): String {
    return "dhruv@gmail.com"
}

fun letScope() {
    val address: String? = getNextAddress()
//    val confirm = if(address != null) {
//        sendNotifications(address)
//    } else {
//        null
//    }
    val confirm = address?.let{
        sendNotifications(it)
    }
    println(confirm)
}

// Apply Scope Function: Use the apply scope function to initialize objects,
// like a class instance, at the time of creation rather than later on in your code.

class Client(val name: String) {
    var token: String? = null
    fun connect() = println("$name Connected!")
    fun authenticate() = println("$name Authenticated!")
    fun getData(): String {
        println("Getting data for $name!")
        return "Mock Data: $name"
    }
}

fun applyScope() {
    val client1 = Client("Normal")
    client1.token = "Mock Token"
    client1.connect()
    client1.authenticate()
    val data = client1.getData()
    println(data)

    val client = Client("Apply").apply {
        token = "Apply Token"
        connect()
        authenticate()
    }
    println(client.getData())
}

fun main() {
    letScope()

    applyScope()
}