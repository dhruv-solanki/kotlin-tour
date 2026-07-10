package intermediate

// Kotlin classes only support single inheritance,
// meaning it is only possible to inherit from one class at a time.
// This class is called the parent.

// By default, classes in Kotlin can't be inherited.
// Kotlin is designed this way to prevent
// unintended inheritance and make your classes easier to maintain.

// The parent of a class inherits from
// another class (the grandparent), forming a hierarchy.
// At the top of Kotlin's class hierarchy is
// the common parent class: Any.
// All classes ultimately inherit from the Any class

// Abstract Classes can be inherited by default.
// The purpose of abstract classes is to
// provide members that other classes inherit or implement.
// As a result, they have a constructor,
// but you can't create instances from them.
// Within the child class, you define the behavior
// of the parent's properties and functions with the override keyword.
// In this way, you can say that the
// child class "overrides" the members of the parent class.

abstract class Product(val name: String, val price: Double) {
    abstract val category: String

    fun productInfo(): String {
        return "Product: $name, Category: $category, Price: $price"
    }
}

class Electronics(name: String, price: Double, val warranty: Int): Product(name, price) {
    override val category = "Electronics"
}

// Interfaces: are similar to classes, but they have some differences

// You can't create an instance of an interface.
// They don't have a constructor or header.

// Their functions and properties are implicitly inheritable by default.
// In Kotlin, we say that they are "open."

// You don't need to mark their functions as abstract
// if you don't give them an implementation.

interface PaymentMethod {
    fun initPayment(amount: Double): String
}

interface PaymentType {
    val paymentType: String
}

class CreditCardPayment(val cardNumber: String, val cardHolderName: String, val expiryDate: String): PaymentMethod, PaymentType {
    override fun initPayment(amount: Double): String {
        return "Payment of $amount initiated using $paymentType number ending in ${cardNumber.takeLast(4)} of $cardHolderName"
    }

    override val paymentType: String = "Credit Card"
}

// Delegation
// Interfaces are useful, but if your interface contains many functions,
// its child classes can end up with a lot of boilerplate code.
// If you only want to override a small part of a class's behavior,
// you need to repeat yourself a lot.

interface DrawingTool {
    val color: String
    fun draw(shape: String)
    fun erase(area: String)
    fun getToolInfo(): String
}

class PenTool: DrawingTool {
    override val color: String = "Black"

    override fun draw(shape: String) {
        println("Drawing $shape using pen in color $color")
    }

    override fun erase(area: String) {
        println("Erasing $area with pen tool")
    }

    override fun getToolInfo(): String {
        return "PenTool(color=$color)"
    }
}

class CanvasSession(val tool: DrawingTool): DrawingTool {
    override val color: String = "Blue"

    override fun draw(shape: String) {
        tool.draw(shape)
    }

    override fun erase(area: String) {
        tool.erase(area)
    }

    override fun getToolInfo(): String {
        return tool.getToolInfo()
    }
}

class CanvasSessionTwo(val tool: DrawingTool): DrawingTool by tool {
    override val color: String = "Green"
}

// Exercise 1:
interface Refundable {
    fun refund(amount: Double)
}

abstract class PaymentMethod2(val name: String) {
    fun authorize(amount: Double) {
        println("Authorizing payment of $amount for $name credit card")
    }

    abstract fun processPayment(amount: Double)
}

class CreditCard(name: String): PaymentMethod2(name), Refundable {
    override fun processPayment(amount: Double) {
        println("Processing $name credit card payment of $amount")
    }

    override fun refund(amount: Double) {
        println("Refunding $amount to the $name credit card")
    }
}

// Exercise 2:
interface Messenger {
    fun sendMessage(message: String)
    fun receiveMessage(): String
}

class BasicMessenger: Messenger {
    override fun sendMessage(message: String) {
        println("Sending message: $message")
    }

    override fun receiveMessage(): String {
        return "You've got a new message"
    }
}

class SmartMessenger(val basicMessenger: BasicMessenger): Messenger by basicMessenger {
    override fun sendMessage(message: String) {
        println("Sending a smart message: $message")
        basicMessenger.sendMessage("[smart] $message")
    }
}

fun main() {
    val laptop = Electronics(name = "Laptop", price = 98000.0, warranty = 2)

    println(laptop.productInfo())

    val paymentMethod = CreditCardPayment("1234 5678 9012 3456", "John Doe", "12/26")
    val result = paymentMethod.initPayment(1000.0)
    println(result)

    val penTool = PenTool()
    val sessionOne = CanvasSession(penTool)
    with(sessionOne) {
        draw("Circle")
        erase("100 x 100")
        println(getToolInfo())
    }

    val sessionTwo = CanvasSession(penTool).apply {
        draw("Rectangle")
        erase("10 x 10")
    }
    println(sessionTwo.getToolInfo())

    val visa = CreditCard("Visa")
    with(visa) {
        authorize(100.0)
        processPayment(100.0)
        refund(50.0)
    }

    val basicMessenger = BasicMessenger()
    val smartMessenger = SmartMessenger(basicMessenger)

    basicMessenger.sendMessage("Hello!")
    println(smartMessenger.receiveMessage())

    smartMessenger.sendMessage("Hello from SmartMessenger!")

}