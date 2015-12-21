package com.iamjonfry.adventofcode

/**
 * Created by Jonathon Fry on 20/12/2015.
 */

fun day2() {
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
    println(total)
}