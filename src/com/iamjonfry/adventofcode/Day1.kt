package com.iamjonfry.adventofcode

/**
 * Created by Jonathon Fry on 20/12/2015.
 */

fun day1() {
    val input = openFile("day1").next()
    var floor = 0

    for (bracket in input) {
        if (bracket.toString().equals(("(")))
            floor += 1
        else if (bracket.toString().equals(")"))
            floor -= 1
    }

    println(floor)
}