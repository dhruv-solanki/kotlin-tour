package intermediate

// In software development, you often need to modify a program's behavior
// without changing the original source code.
// For example, you might want to add extra functionality
// to a class from a third-party library

// You can do this by adding extension functions to extend a class.
// You call extension functions the same way
// you call member functions of a class, using a period '.'

// The receiver is what the function is called on.
// In other words, the receiver is where or with whom the information is shared

// here String class is receiver
fun String.bold(): String = "<b>$this</b>"

fun Int.isPositive(): Boolean = this > 0

data class HttpResponse(val response: String)

class HttpClient {
    fun request(method: String, url: String, headers: Map<String, String>) : HttpResponse {
        println("Requesting $method to $url with headers $headers")
        return HttpResponse("Response from $url")
    }
}

fun HttpClient.get(url: String): HttpResponse = request("GET", url, emptyMap())

fun main () {
    println("hello".bold())

    println((-1).isPositive())

    val client = HttpClient()

    val getResponseWithMember = client.request("GET", "http://www.example.com", emptyMap())
    println(getResponseWithMember)

    val getResponseWithExtention = client.get("http://www.extention.com")
    println(getResponseWithExtention)
}