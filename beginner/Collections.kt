package beginner

// Lists:   Ordered collections of items
// Sets:    Unique unordered collections of items
// Maps:    Sets of key-value pairs where keys are unique and map to only one value

fun lists() {
//    read only list
    val readOnlyShapes = listOf("triangle", "square", "circle")
    println(readOnlyShapes)

//    mutable list with explicit type declaration
    val shapes: MutableList<String> = mutableListOf("hexagon", "pentagon")
    println(shapes)

//    you can create read only list from mutable list
//    this is also called casting
    val shapesLocked: List<String> = shapes
    println(shapesLocked)

    println("The first item in the list is ${readOnlyShapes[0]}")
    println("First item: ${readOnlyShapes.first()} and Last item: ${readOnlyShapes.last()}")
    println("List has ${readOnlyShapes.count()} shapes")
    println("circle" in readOnlyShapes)

    shapes.add("dot")
    println(shapes)

    shapes.remove("hexagon")
    println(shapes)
}

fun sets() {
//    read only set
    val readOnlyFruits = setOf("apple", "orange", "cherry", "apple")
    println(readOnlyFruits)

//    mutable set with explicit type declaration
    val fruits: MutableSet<String> = mutableSetOf("grape", "avocado")
    println(fruits)

//    you can create read only set from mutable set
//    this is also called casting
    val fruitsLocked: Set<String> = fruits
    println(fruitsLocked)

    println("There are ${readOnlyFruits.count()} fruits in the set")
    println("banana" in readOnlyFruits)

    fruits.add("dragonfruit")
    println(fruits)

    fruits.remove("grape")
    println(fruits)
}

fun maps() {
//    read only map
    val readOnlyJuice = mapOf("lemon" to 100, "kiwi" to 190, "mango" to 230)
    println(readOnlyJuice)

//    mutable map with explicit type declaration
    val juiceMenu: MutableMap<String, Int> = mutableMapOf("blueberry" to 330, "redberry" to 300)
    println(juiceMenu)


//    you can create read only map from mutable map
//    this is also called casting
    val juiceMenuLocked: Map<String, Int> = juiceMenu
    println(juiceMenuLocked)

    println("The value of lemon is ${readOnlyJuice["lemon"]}")
    println("The value of pineapple is ${juiceMenu["pineapple"]}")

    juiceMenu["pineapple"] = 150
    println(juiceMenu)

    juiceMenu.remove("blueberry")
    println(juiceMenu)

    println("We have ${juiceMenu.count()} items in our juice menu")
    println("Do we have kiwi in our menu: ${juiceMenu.containsKey("kiwi")}")

    println(juiceMenu.keys)
    println(juiceMenu.values)

    println("orange" in readOnlyJuice)
}

fun main() {
    lists()

    sets()

    maps()
}