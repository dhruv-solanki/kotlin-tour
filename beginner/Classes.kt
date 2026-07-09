package beginner

import kotlin.random.Random

// You can declare properties without val or var within parentheses but
// these properties are not accessible after an instance has been created.
// The content contained within parentheses () is called the class header.
class Contact(val id: Int, var email: String = "example@gmail.com") {
    val category: String = "work"

    fun printMe() {
        println("$id and $email with $category")
    }
}

// Kotlin has data classes which are particularly useful for storing data.
// Data classes have the same functionality as classes,
// but they come automatically with additional member functions.
// These member functions allow you to
// easily print the instance to readable output,
// compare instances of a class, copy instances, and more.

data class User(val name: String, val id: Int)

// Exercise:
// To test your code, you need a generator that can create random employees.
// Define a RandomEmployeeGenerator class
// with a fixed list of potential names (inside the class body).
// Configure the class with a minimum and maximum salary (inside the class header).
// In the class body, define the generateEmployee() function.
// Once again, the main function demonstrates how you can use this class.

data class Employee(val name: String, var salary: Int)

class RandomEmployeeGenerator(var minSalary: Int, var maxSalary: Int) {
    val names = listOf("Ana", "James", "John", "Veronica", "Roger")

    fun generateEmployee() = Employee(
        names.random(),
        Random.nextInt(from = minSalary, until = maxSalary)
    )
}

fun main() {
    val contact = Contact(1, "dhruv@gmail.com")
    println(contact.email)

    contact.email = "james@gmail.com"
    println(contact.email)

    contact.printMe()

    val user = User("Dhruv", 7)
    println(user)

    val secondUser = user.copy()
    println(secondUser)
    val thirdUser = user.copy(name="Jane")
    println(thirdUser)

    println("user == secondUser: ${user == secondUser}")
    println("user == thirdUser: ${user == thirdUser}")

    val empGen = RandomEmployeeGenerator(10, 30)
    println(empGen.generateEmployee())
    println(empGen.generateEmployee())
    println(empGen.generateEmployee())
}