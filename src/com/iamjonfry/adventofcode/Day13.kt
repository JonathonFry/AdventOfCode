package com.iamjonfry.adventofcode

import java.util.*

/**
 * Created by jonfry on 01/12/2016.
 */
var data: HashMap<String, HashMap<String, Int>> = hashMapOf()
var results: MutableList<Int> = mutableListOf()

fun day13Part1() {
    data = hashMapOf()
    results = mutableListOf()

    var input = openFile("day13")

    while (input.hasNext()) {
        var line = input.nextLine()
        var split = line.split(" ")

        var name = split[0]
        var type = split[2]
        var value = Integer.valueOf(split[3])
        if (type == "lose") {
            value = 0 - value
        }
        var nextTo = split[split.size - 1]
        nextTo = nextTo.substring(0, nextTo.length - 1)

        if (data.containsKey(name)) {
            data[name]!!.put(nextTo, value)
        } else {
            var temp = hashMapOf(Pair(nextTo, value))
            data[name] = temp

        }
    }

    permute(data.keys.toMutableList())

    println("Day 1 Part 1: $results.max()")
}

fun day13Part2() {
    data = hashMapOf()
    results = mutableListOf()

    var input = openFile("day13part2")

    while (input.hasNext()) {
        var line = input.nextLine()
        var split = line.split(" ")

        var name = split[0]
        var type = split[2]
        var value = Integer.valueOf(split[3])
        if (type == "lose") {
            value = 0 - value
        }
        var nextTo = split[split.size - 1]
        nextTo = nextTo.substring(0, nextTo.length - 1)

        if (data.containsKey(name)) {
            data[name]!!.put(nextTo, value)
        } else {
            var temp = hashMapOf(Pair(nextTo, value))
            data[name] = temp

        }
    }

    permute(data.keys.toMutableList())

    println("Day 1 Part 2: $results.max()")
}

fun permute(arr: MutableList<String>) {
    permuteHelper(arr, 0)
}

private fun permuteHelper(arr: MutableList<String>, index: Int) {
    if (index >= arr.size - 1) { //If we are at the last element - nothing left to permute
        results.add(calcValue(data, arr))
        return
    }


    for (i in index..arr.size - 1) { //For each index in the sub array arr[index...end]

        //Swap the elements at indices index and i
        var t = arr[index]
        arr[index] = arr[i]
        arr[i] = t

        //Recurse on the sub array arr[index+1...end]
        permuteHelper(arr, index + 1)

        //Swap the elements back
        t = arr[index]
        arr[index] = arr[i]
        arr[i] = t
    }
}

fun calcValue(data: HashMap<String, HashMap<String, Int>>, arrangement: List<String>): Int {
    var totalValue = 0

    for (i in 0..arrangement.size - 1) {
        if (i == arrangement.size - 1) {
            totalValue += calcValue(data, arrangement[i], arrangement[0])
        } else {
            totalValue += calcValue(data, arrangement[i], arrangement[i + 1])
        }
    }


    return totalValue
}

fun calcValue(data: HashMap<String, HashMap<String, Int>>, person1: String, person2: String): Int {
    var value = 0
    value += data[person1]!![person2]!!
    value += data[person2]!![person1]!!
    return value
}

