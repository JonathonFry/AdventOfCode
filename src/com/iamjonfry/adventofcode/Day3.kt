package com.iamjonfry.adventofcode

import java.util.*

/**
 * Created by Jonathon Fry on 20/12/2015.
 */

fun day3() {
    val input = openFile("day3").next()

    val position = IntArray(2)
    val visited = ArrayList<Pair<Int, Int>>()
    visited.add(Pair(position[0], position[1]))
    for (move in input) {
        val value = move.toString()
        when (value) {
            "^" -> {
                position[1]++
            }
            ">" -> {
                position[0]++
            }
            "v" -> {
                position[1]--
            }
            "<" -> {
                position[0]--
            }
        }
        visited.add(Pair(position[0], position[1]))
    }

    val count = HashSet<Pair<Int, Int>>(visited)
    println(count.size)
}