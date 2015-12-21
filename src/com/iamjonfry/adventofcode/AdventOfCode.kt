package com.iamjonfry.adventofcode

import java.nio.file.Paths
import java.util.*

/**
 * Created by Jonathon Fry on 18/12/2015.
 */
fun main(args: Array<String>) {
    day1Part1()
    day1Part2()
    day2Part1()
    day2Part2()
    day3Part1()
    day3Part2()
    day4Part1()
    day4Part2()
    day5Part1()
    day5Part2()
    day6Part1()
    day6Part2()
}

fun openFile(name: String): Scanner {
    return Scanner(Paths.get("files/" + name))
}
