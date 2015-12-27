package com.iamjonfry.adventofcode

import org.json.JSONArray
import org.json.JSONObject

/**
 * @author Jonathon.Fry@skyscanner.net on 27/12/2015.
 */
private var count = 0

fun day12Part1() {
    var input = openFile("day12").next()
    var json = JSONObject(input)

    json.keys().forEach {
        increment(json.get(it))
    }

    println(count)
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