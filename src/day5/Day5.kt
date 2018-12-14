package day5

import java.io.File

val input = readFile("input.txt")

fun main(args: Array<String>) {
    println(part1())
}

fun part1(): Int {
    return input.react().size
}

/**
 * Extension function using fold which takes an initial empty mutable list of Char.
 * The lambda gets called for each Char in our string. If chars match we remove them
 * from the parsed list, otherwise, add them.
 */
private fun String.react(): MutableList<Char> =
    this.fold(mutableListOf()) { parsed, nextChar ->
        when {
            parsed.firstOrNull().matches(nextChar) -> parsed.removeAt(0)
            else -> parsed.add(0, nextChar)
        }
        parsed
    }

/**
 * Extension function to compare two characters and determine wheter
 */
private fun Char?.matches(other: Char): Boolean =
    when {
        this == null -> false
        this.toUpperCase() != other.toUpperCase() -> false
        else -> this != other
    }

/**
 * Returns a new BufferedReader for reading the contents of the file.
 * Once we have a BufferedReader, we can read all the lines in it
 */
fun readFile(fileName: String): String = File("src/day5/$fileName").bufferedReader().readLines().toString()

