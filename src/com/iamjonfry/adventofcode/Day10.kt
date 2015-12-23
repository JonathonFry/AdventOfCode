package com.iamjonfry.adventofcode

/**
 * @author Jonathon.Fry@skyscanner.net on 23/12/2015.
 */

fun day10Part1() {
    var input = openFile("day10").next()

    for (i in 1..40) {
        input = solve(input)
    }
    println("Day 10 Part 1: ${input.length}")
}

fun day10Part2() {
    var input = openFile("day10").next()

    for (i in 1..50) {
        input = solve(input)
    }
    println("Day 10 Part 2: ${input.length}")
}


fun solve(input: String): String {
    var count = 0
    var char = input.substring(0, 1).toCharArray()[0]
    var output = StringBuilder()

    input.forEach {
        if (char == it) {
            count++
        } else {
            output.append(count).append(char)
            char = it
            count = 1
        }
    }
    output.append(count).append(char)

    return output.toString()
}