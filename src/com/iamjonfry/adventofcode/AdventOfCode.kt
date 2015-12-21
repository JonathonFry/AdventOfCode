package com.iamjonfry.adventofcode

import java.nio.file.Paths
import java.util.*

/**
 * Created by Jonathon Fry on 18/12/2015.
 */
fun main(args: Array<String>) {
    day1()
    day2()
    day3()
    day4()
    day5()
    day6()
}

fun openFile(name: String): Scanner {
    return Scanner(Paths.get("files/" + name))
}
