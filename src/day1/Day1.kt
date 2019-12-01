package day1

import java.io.File

private val input = readFile("input.txt").map { it.toInt() }

fun main(args: Array<String>) {
    println(part1())
    println(part2())
}

/**
 * Returns a new BufferedReader for reading the contents of the file.
 * Once we have a BufferedReader, we can read all the lines in it
 */
fun readFile(fileName: String): List<String> = File("src/day1/$fileName").bufferedReader().readLines()

/**
 * Map list to integers and return their sum
 */
fun part1(): Int = input.sum()

/**
 * Infinitely loops through input.txt list and adds currentFrequency in
 * a set until it finds a frequency that is reached before
 */
fun part2(): Int {
    val frequenciesReachedOnce = mutableSetOf<Int>()
    var currentFrequency = 0

    while (true) {
        for (i in input) {
            if (currentFrequency !in frequenciesReachedOnce) {
                frequenciesReachedOnce.add(currentFrequency)
                currentFrequency += i
            } else {
                return currentFrequency
            }
        }
    }
}
