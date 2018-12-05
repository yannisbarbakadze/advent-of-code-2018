package day2

import java.io.File

private val input = readFile("input.txt")

fun main(args: Array<String>) {
    println(part1())
}

/**
 * Returns a new BufferedReader for reading the contents of the file.
 * Once we have a BufferedReader, we can read all the lines in it
 */
fun readFile(fileName: String): List<String> = File("src/day2/$fileName").bufferedReader().readLines()

/**
 * Loops through input, groups letters and returns the number of key/value pairs in the map
 */
fun part1(): Int {
    var appearedTwice = 0
    var appearedThrice = 0

    for (id in input) {
        val counts = id.groupBy { it }.map { it.value.size }

        if (counts.contains(2)) {
            appearedTwice++
        }

        if (counts.contains(3)) {
            appearedThrice++
        }
    }

    return appearedTwice * appearedThrice
}