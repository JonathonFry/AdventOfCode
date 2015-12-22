package com.iamjonfry.adventofcode

import java.util.*

/**
 * @author Jonathon.Fry@skyscanner.net on 22/12/2015.
 */
val map = HashMap<String, ArrayList<Pair<String, Int>>>()
val solutions = arrayListOf<Pair<String, Int>>()

fun day9() {
    val scanner = openFile("day9")
    while (scanner.hasNext()) {
        val input = scanner.nextLine()

        val citySplit = input.split(" to ")
        val valueSplit = citySplit[1].split(" = ")
        val start = citySplit[0]
        val end = valueSplit[0]
        val value = Integer.valueOf(valueSplit[1])

        val destsStart = map.getOrDefault(start, ArrayList<Pair<String, Int>>())
        destsStart.add(Pair(end, value))
        map.put(start, destsStart)

        val destsEnd = map.getOrDefault(end, ArrayList<Pair<String, Int>>())
        destsEnd.add(Pair(start, value))
        map.put(end, destsEnd)
    }

    map.forEach { s, arrayList ->
        var history = arrayListOf<String>()
        var historyTotal = 0
        solve(history, historyTotal, s, arrayList)
    }

    println("Day 9 Part 1: ${solutions.minBy { it.second }!!.second}")
    println("Day 9 Part 2: ${solutions.maxBy { it.second }!!.second}")
}


fun solve(visited: ArrayList<String>, total: Int, key: String, locations: ArrayList<Pair<String, Int>>) {
    locations.forEachIndexed { i, it ->
        if (!visited.containsRaw(it.first)) {
            var temp = ArrayList<String>(visited)
            temp.add(key)
            solve(temp, total + it.second, it.first, map[it.first]!!)
        } else if (i == locations.size - 1) {
            visited.add(key)
            if (visited.size == map.size) {
                solutions.add(Pair(visited.toString(), total))
            }
        }
    }
}


