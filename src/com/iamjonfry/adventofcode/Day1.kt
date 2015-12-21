package com.iamjonfry.adventofcode

/**
 * Created by Jonathon Fry on 20/12/2015.
 */

fun day1Part1() {
    val input = openFile("day1").next()
    var floor = 0

    for (bracket in input) {
        if (bracket.toString().equals(("(")))
            floor += 1
        else if (bracket.toString().equals(")"))
            floor -= 1
    }

    println("Day 1 Part 1: $floor")
}

fun day1Part2() {
    val input = openFile("day1").next()
    var floor = 0

    for ((i, bracket) in input.withIndex()) {
        if (bracket.toString().equals(("(")))
            floor += 1
        else if (bracket.toString().equals(")"))
            floor -= 1

        if (floor == -1) {
            println("Day 1 Part 2: ${i + 1}")
            break
        }
    }

}