package com.iamjonfry.adventofcode

/**
 * @author Jonathon.Fry@skyscanner.net on 23/12/2015.
 */

fun day10() {
    var input = openFile("day10").next()


    for (i in 1..40) {
        input = solve(input)
    }
    print("Day 10 Part 1: ${input.length}")
}


fun solve(input: String): String {
    var count = 0
    var char = input.substring(0, 1)
    var output = ""

    input.forEach {
        if (char == it.toString()) {
            count++
        } else {
            output = output.concat("$count$char")
            char = it.toString()
            count = 1
        }
    }
    output = output.concat("$count$char")

    return output
}