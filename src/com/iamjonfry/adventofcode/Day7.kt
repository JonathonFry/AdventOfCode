package com.iamjonfry.adventofcode

import java.util.*

/**
 * Created by Jonathon Fry on 20/12/2015.
 */

val AND = " AND "
val OR = " OR "
val NOT = "NOT "
val LSHIFT = " LSHIFT "
val RSHIFT = " RSHIFT "

var expressions = TreeMap<String, String>()
var gates = TreeMap<String, Int>()

fun day7Part1() {

    val scanner = openFile("day7")
    while (scanner.hasNext()) {
        val input = scanner.nextLine()

        var split = input.split(" -> ")
        expressions.put(split[1], split[0])
        gates.put(split[1], -1)
    }
    val output = eval(expressions["a"]!!)

    println("Day 7 Part 1: $output")
}

fun getValue(key: String): Int {
    var value: Int
    try {
        value = Integer.valueOf(key)
    } catch(e: NumberFormatException) {
        value = gates[key]!!
    }

    if (value == -1) {
        value = eval(expressions[key]!!)
        gates.put(key, value)
        return value
    } else {
        return value
    }
}


fun eval(expression: String): Int {

    if (expression.contains(AND)) {
        val expressionSplit = expression.split(AND)
        val leftKey = expressionSplit[0]
        val rightKey = expressionSplit[1]

        var leftValue = getValue(leftKey)
        var rightValue = getValue(rightKey)

        return leftValue.and(rightValue)
    } else if (expression.contains(OR)) {
        val expressionSplit = expression.split(OR)
        val leftKey = expressionSplit[0]
        val rightKey = expressionSplit[1]

        var leftValue = getValue(leftKey)
        var rightValue = getValue(rightKey)

        return leftValue.or(rightValue)

    } else if (expression.contains(NOT)) {
        val key = expression.replace(NOT, "")
        var value = gates[key]

        if (value == -1) {
            value = eval(expressions[key]!!)
            gates.put(key, value)
        }

        return value!!.inv()

    } else if (expression.contains(LSHIFT)) {
        val expressionSplit = expression.split(LSHIFT)
        val leftKey = expressionSplit[0]

        val rightValue = Integer.valueOf(expressionSplit[1])
        val leftValue = getValue(leftKey)


        return leftValue.shl(rightValue!!)
    } else if (expression.contains(RSHIFT)) {
        val expressionSplit = expression.split(RSHIFT)
        val leftKey = expressionSplit[0]

        val rightValue = Integer.valueOf(expressionSplit[1])
        val leftValue = getValue(leftKey)

        return leftValue.shr(rightValue!!)
    } else {
        return getValue(expression)
    }

}


fun day7Part2() {
    val scanner = openFile("day7")
    while (scanner.hasNext()) {
        val input = scanner.nextLine()

        var split = input.split(" -> ")
        expressions.put(split[1], split[0])
        gates.put(split[1], -1)
    }
    val part1Output = eval(expressions["a"]!!)



    gates.forEach { s, i -> gates.put(s, -1) }
    gates.put("b", part1Output)

    val part2Output = eval(expressions["a"]!!)
    println("Day 7 Part 2: $part2Output")
}
