package com.iamjonfry.adventofcode

import org.json.JSONArray
import org.json.JSONObject

/**
 * @author Jonathon.Fry@skyscanner.net on 27/12/2015.
 */
private var count = 0
private val RED = "red"

fun day12Part1() {
    var input = openFile("day12").next()
    var json = JSONObject(input)

    json.keys().forEach {
        increment(json.get(it))
    }

    println("Day 12 Part 1: $count")
}

fun day12Part2() {
    var input = openFile("day12").next()
    var json = JSONObject(input)

    json.keys().forEach {
        incrementWithFilter(json.get(it))
    }

    println("Day 12 Part 2: $count")
}


private fun containsRed(json: JSONObject): Boolean {
    json.keys().forEach {
        if (json.get(it) == RED) {
            return true
        }
    }
    return false
}

private fun incrementWithFilter(json: Any) {
    if (json is Int) {
        count += json
    }
    if (json is JSONObject && !containsRed(json)) {
        json.keys().forEach { incrementWithFilter(json.get(it)) }
    } else if (json is JSONArray) {
        json.forEach { incrementWithFilter(it) }
    }
}

private fun increment(json: Any) {
    if (json is Int) {
        count += json
    }
    if (json is JSONObject) {
        json.keys().forEach { increment(json.get(it)) }
    } else if (json is JSONArray) {
        json.forEach { increment(it) }
    }
}