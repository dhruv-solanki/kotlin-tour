package intermediate

// Lambda expressions can also have a receiver.
// In this case, lambda expressions can access
// any member functions or properties of the receiver
// without having to explicitly specify the receiver each time.
// Without these additional references,
// your code is easier to read and maintain.

class DrawCanvas {
    fun drawCircle() = println("Drawing circle")
    fun drawSquare() = println("Drawing square")
}

fun render(block: DrawCanvas.() -> Unit): DrawCanvas {
    val canvas = DrawCanvas()
    canvas.block()
    return canvas
}

// Lambda expressions with receiver are helpful
// when you want to create a domain-specific language (DSL).
// Since you have access to the receiver's
// member functions and properties without
// explicitly referencing the receiver,
// your code becomes leaner.

class MenuItem(val name: String)

class Menu(val name: String) {
    val items = mutableListOf<MenuItem>()

    fun item(name: String) {
        items.add(MenuItem(name))
    }
}

fun menu(name: String, init: Menu.() -> Unit): Menu {
    val menu = Menu(name)

//    calls lambda expression with receiver init() on the menu instance
    menu.init()

    return menu
}

fun printMenu(menu: Menu) {
    println("Menu: ${menu.name}")
    menu.items.forEach { println("Item: ${it.name}") }
}

// Exercise 1:
fun fetchData(callback: StringBuilder.() -> Unit) {
    val builder = StringBuilder("Data received")
    builder.callback()
}

// Exercise 2:
fun List<Int>.incremented(): List<Int> {
    val originalList = this

//    buildList returns read only List by performing mutable actions on temp list
    return buildList {
        for(num in originalList) {
            add(num + 1)
        }
    }
}

fun main() {
    render {
        drawCircle()
        drawSquare()
    }

    val mainMenu = menu("Main Menu") {
        item("Home")
        item("Settings")
        item("Exit")
    }

    printMenu(mainMenu)

    fetchData {
        append(" - Processed")
        println(this.toString())
    }

    val originalList = listOf(1, 2, 3)
    val newList = originalList.incremented()
    println(newList)
}