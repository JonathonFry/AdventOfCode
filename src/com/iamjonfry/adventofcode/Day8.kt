package com.iamjonfry.adventofcode

import org.apache.commons.lang3.StringEscapeUtils
import java.util.regex.Pattern

/**
 * @author Jonathon.Fry@skyscanner.net on 22/12/2015.
 */
val BACKSLASH = "\\\\"
val DOUBLE_QUOTE = "\\\""
val HEX = Pattern.compile("\\\\x..")

fun day8Part1() {
    var totalCount = 0
    var escapedCount = 0

    val scanner = openFile("day8")
    while (scanner.hasNext()) {
        val input = scanner.nextLine()
        input.forEach { totalCount++ }

        var tempString = input.toString().substring(1, input.length - 1)

        tempString = tempString.replace(BACKSLASH, "1")
        tempString = tempString.replace(DOUBLE_QUOTE, "1")
        tempString = HEX.matcher(tempString).replaceAll("1")
        escapedCount += tempString.length
    }

    println("Day 8 Part 1: ${totalCount - escapedCount}")
}


fun day8Part2() {
    var totalCount = 0
    var escapedCount = 0

    val scanner = openFile("day8")
    while (scanner.hasNext()) {
        val input = scanner.nextLine()
        totalCount += input.length

        var escaped = StringEscapeUtils.escapeJava(input)
        escaped = "\"$escaped\""
        escapedCount += escaped.length
    }
    println("Day 8 Part 2: ${escapedCount - totalCount}")
}