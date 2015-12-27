package com.iamjonfry.adventofcode

/**
 * Created by Jonathon Fry on 26/12/2015.
 */

val chars = arrayOf("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z")
val invalidChars = arrayOf("i", "o", "l")

fun day11() {
    var password = openFile("day11").next()

    while (true) {
        password = iteratePassword(password)
        if (isValidPassword(password)) {
            break
        }
    }

    print(password)
}

fun iteratePassword(password: String): String {
    for (c in password.reversed()) {

    }
    return ""
}


fun isValidPassword(password: String): Boolean {

    var containsThreeStraight = false
    var containsTwoPairs = false
    return false
}