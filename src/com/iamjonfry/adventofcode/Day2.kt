package com.iamjonfry.adventofcode

/**
 * Created by Jonathon Fry on 20/12/2015.
 */

fun day2Part1() {
    val scanner = openFile("day2")
    var total = 0

    while (scanner.hasNext()) {
        val input = scanner.next().split("x")
        val l: Int = Integer.valueOf(input[0])
        val w: Int = Integer.valueOf(input[1])
        val h: Int = Integer.valueOf(input[2])

        val a = (2 * (l * w))
        val b = (2 * (w * h))
        val c = (2 * (h * l))

        total += (a + b + c) + (Math.min(Math.min(a, b), c) / 2)
    }
    println("Day 2 Part 1: $total")
}

fun day2Part2() {
    val scanner = openFile("day2")

    var total = 0

    while (scanner.hasNext()) {
        val input = scanner.next().split("x")
        val l: Int = Integer.valueOf(input[0])
        val w: Int = Integer.valueOf(input[1])
        val h: Int = Integer.valueOf(input[2])

        val sortedInput = input.map { Integer.valueOf(it) }
                .sorted()
        total += (sortedInput[0] * 2) + (sortedInput[1] * 2) + (l * w * h)
    }

    println("Day 2 Part 2: $total")

}