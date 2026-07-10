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

// Run Scope Function: Similar to apply,
// you can use the run scope function to initialize an object,
// but it's better to use run to initialize an object
// at a specific moment in your code and immediately compute a result.

fun runScope() {
    val client: Client = Client("Run").apply {
        token = "Run Token"
    }

    val result: String = client.run {
        connect()
        authenticate()
        getData()
    }
    println(result)
}


// Also Scope Function: Use the also scope function
// to complete an additional action with an object and
// then return the object to continue using it in your code,
// like writing a log.

// Since the also function returns the object,
// it is useful for not only logging but debugging,
// chaining multiple operations, and
// performing other side effect operations
// that don't affect the main flow of your code.

fun alsoScope() {
    val medals: List<String> = listOf("Gold", "Silver", "Bronze")
    val reversedLongUppercaseMedals: List<String> =
        medals.map({ it.uppercase() })
            .filter({ it.length > 4 })
            .reversed()
    println(reversedLongUppercaseMedals)

    val result: List<String> =
        medals.map{ it.uppercase() }
            .also{ println(it) }
            .filter{ it.length > 4 }
            .also{ println(it) }
            .reversed()
    println(result)
}


// With Scope Function: Unlike the other scope functions,
// with is not an extension function, so the syntax is different.
// You pass the receiver object to with as an argument.

// Use the with scope function when you want to
// call multiple functions on an object.

class Canvas {
    fun rect(x: Int, y: Int, w: Int, h: Int): Unit = println("$x, $y, $w, $h")
    fun circ(x: Int, y: Int, rad: Int): Unit = println("$x, $y, $rad")
    fun text(x: Int, y: Int, str: String): Unit = println("$x, $y, $str")
}

fun withScope() {
    val canvas: Canvas = Canvas()
    canvas.text(10, 10, "Hello")
    canvas.rect(20, 30, 100, 50)
    canvas.circ(40, 60, 25)

    canvas.text(15, 45, "World")
    canvas.rect(70, 80, 150, 100)
    canvas.circ(90, 110, 40)

    with(canvas) {
        text(15, 45, "Foo")
        rect(70, 80, 150, 100)
        circ(90, 110, 40)

        text(50, 70, "Kotlin")
        rect(120, 140, 200, 75)
        circ(160, 180, 55)
    }
}

fun main() {
    letScope()

    applyScope()

    runScope()

    alsoScope()

    withScope()
}