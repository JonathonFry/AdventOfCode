package com.iamjonfry.adventofcode

import java.util.*

/**
 * Created by Jonathon Fry on 20/12/2015.
 */

fun day5Part1() {
    var count = 0

    val scanner = openFile("day5")
    while (scanner.hasNext()) {
        val input = scanner.next()
        if (isNicePart1(input)) count++
    }
    println("Day 5 Part 1 : $count")
}

private fun isNicePart1(string: String): Boolean {
    var vowelCount = 0
    var twiceInARow = false
    var containsNaughty = false

    val vowels = Arrays.asList("a", "e", "i", "o", "u")
    val naughtyStrings = Arrays.asList("ab", "cd", "pq", "xy")

    for ((i, character )in string.withIndex().reversed()) {
        if (vowels.contains(character.toString())) vowelCount++

        var j = i - 1
        if (j == -1)
            break

        val prevCharacter = string[j]
        if (character == prevCharacter) twiceInARow = true


        if (naughtyStrings.contains(prevCharacter.toString() + character.toString())) {
            containsNaughty = true
        }

    }

    return vowelCount >= 3 && twiceInARow && !containsNaughty
}

fun day5Part2() {
    var count = 0

    val scanner = openFile("day5")
    while (scanner.hasNext()) {
        val input = scanner.next()
        if (isNicePart2(input)) count++
    }
    println("Day 5 Part 2 : $count")
}

private fun isNicePart2(string: String): Boolean {
    var repeats = false
    var pairOfLetters = false


    for ((i, character )in string.withIndex().reversed()) {
        var j = i - 2

        if (j == -1)
            break

        val repeatCharacter = string[j]

        if (character == repeatCharacter) {
            repeats = true
            break
        }

    }

    for ((i, character )in string.withIndex()) {
        if (i == string.length - 1)
            break
        var nextCharacter = string[i + 1]

        val testString = character.toString().plus(nextCharacter.toString())

        for ((j, subCharacter )in string.withIndex()) {
            if (j == string.length - 1)
                break
            var nextSubCharacter = string[j + 1]

            val testSubString = subCharacter.toString().plus(nextSubCharacter.toString())

            if (testString.equals(testSubString, true) && i != j && i + 1 != j && i != j + 1) {
                pairOfLetters = true
                break
            }

        }
    }

    return repeats && pairOfLetters
}
