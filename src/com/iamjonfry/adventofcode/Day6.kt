package com.iamjonfry.adventofcode

import java.util.*

/**
 * Created by Jonathon Fry on 20/12/2015.
 */

fun day6Part1() {
    var xy = HashMap<Pair<Int, Int>, Boolean>()

    for (x in 0..999) {
        for (y in 0..999) {
            xy.put(Pair(x, y), false)
        }
    }

    val scanner = openFile("day6")

    while (scanner.hasNext()) {
        val input = scanner.nextLine()

        if (input.startsWith("turn on")) {
            var temp = input.replace("turn on ", "")
            var startEnd = temp.split(" through ")
            val startXy = startEnd[0].split(",").map { Integer.valueOf(it) }
            val endXy = startEnd[1].split(",").map { Integer.valueOf(it) }

            for (x in startXy[0]..endXy[0]) {
                for (y in startXy[1]..endXy[1]) {
                    xy.put(Pair(x, y), true)
                }
            }

        } else if (input.startsWith("turn off")) {
            var temp = input.replace("turn off ", "")
            var startEnd = temp.split(" through ")
            val startXy = startEnd[0].split(",").map { Integer.valueOf(it) }
            val endXy = startEnd[1].split(",").map { Integer.valueOf(it) }

            for (x in startXy[0]..endXy[0]) {
                for (y in startXy[1]..endXy[1]) {
                    xy.put(Pair(x, y), false)
                }
            }

        } else if (input.startsWith("toggle")) {
            var temp = input.replace("toggle ", "")
            var startEnd = temp.split(" through ")
            val startXy = startEnd[0].split(",").map { Integer.valueOf(it) }
            val endXy = startEnd[1].split(",").map { Integer.valueOf(it) }

            for (x in startXy[0]..endXy[0]) {
                for (y in startXy[1]..endXy[1]) {
                    xy.put(Pair(x, y), xy[Pair(x, y)]?.not()!!)
                }
            }

        }

    }
    var count = 0
    xy.entries.forEach {
        count += if (it.value) 1 else 0
    }

    println("Day 6 Part 1: $count")
}

fun day6Part2() {
    var xy = HashMap<Pair<Int, Int>, Int>()

    for (x in 0..999) {
        for (y in 0..999) {
            xy.put(Pair(x, y), 0)
        }
    }

    val scanner = openFile("day6")

    while (scanner.hasNext()) {
        val input = scanner.nextLine()

        if (input.startsWith("turn on")) {
            var temp = input.replace("turn on ", "")
            var startEnd = temp.split(" through ")
            val startXy = startEnd[0].split(",").map { Integer.valueOf(it) }
            val endXy = startEnd[1].split(",").map { Integer.valueOf(it) }

            for (x in startXy[0]..endXy[0]) {
                for (y in startXy[1]..endXy[1]) {
                    xy.put(Pair(x, y), xy.getOrDefault(Pair(x, y), 0) + 1)
                }
            }

        } else if (input.startsWith("turn off")) {
            var temp = input.replace("turn off ", "")
            var startEnd = temp.split(" through ")
            val startXy = startEnd[0].split(",").map { Integer.valueOf(it) }
            val endXy = startEnd[1].split(",").map { Integer.valueOf(it) }

            for (x in startXy[0]..endXy[0]) {
                for (y in startXy[1]..endXy[1]) {
                    var int = xy.getOrDefault(Pair(x, y), 0)
                    if (int > 0) int -= 1
                    xy.put(Pair(x, y), int)
                }
            }

        } else if (input.startsWith("toggle")) {
            var temp = input.replace("toggle ", "")
            var startEnd = temp.split(" through ")
            val startXy = startEnd[0].split(",").map { Integer.valueOf(it) }
            val endXy = startEnd[1].split(",").map { Integer.valueOf(it) }

            for (x in startXy[0]..endXy[0]) {
                for (y in startXy[1]..endXy[1]) {
                    xy.put(Pair(x, y), xy.getOrDefault(Pair(x, y), 0) + 2)
                }
            }

        }

    }
    var count = 0
    xy.entries.forEach {
        count += it.value
    }

    println("Day 6 Part 2: $count")
}