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
    day7Part1()
    day7Part2()
    day8Part1()
    day8Part2()
    day9()
    day10Part1()
    day10Part2()
    day11Part1()
    day11Part2()
    day12Part1()
    day12Part2()
}

fun openFile(name: String): Scanner {
    return Scanner(Paths.get("files/" + name))
}
