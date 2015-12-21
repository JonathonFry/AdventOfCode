package com.iamjonfry.adventofcode

import java.util.*

/**
 * Created by Jonathon Fry on 20/12/2015.
 */

fun day5() {
    var count = 0

    val scanner = openFile("day5")
    while (scanner.hasNext()) {
        val input = scanner.next()
        if (isNice(input)) count++
    }
    println(count)
}

private fun isNice(string: String): Boolean {
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