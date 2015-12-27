package com.iamjonfry.adventofcode

/**
 * Created by Jonathon Fry on 26/12/2015.
 */

val chars = arrayOf("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z")
val invalidChars = arrayOf("i", "o", "l")

fun day11() {
    var password = openFile("day11").next()

    while (true) {
        if (isValidPassword(password)) {
            break
        }
        password = iteratePassword(password)
    }

    print(password)
}

fun iteratePassword(password: String): String {
    var newPassword = password
    for ((i, c) in password.reversed().withIndex()) {
        var alphabetIndex = chars.indexOf(c.toString())
        alphabetIndex += 1
        var index = password.length - 1 - i

        if (alphabetIndex == chars.size) {
            newPassword = newPassword.replaceRange(index, index + 1, chars[0])
        } else {
            newPassword = newPassword.replaceRange(index, index + 1, chars[alphabetIndex])
            break
        }

    }
    return newPassword
}


fun isValidPassword(password: String): Boolean {

    var containsThreeStraight = false
    var containsInvalidChars = false
    var pairCount = 0

    for ((i, c) in password.withIndex()) {
        if (i + 2 == password.length - 1) break

        val c1 = password[i + 1]
        val c2 = password[i + 2]

        val indexC2 = chars.indexOf(c2.toString())
        val indexC1 = chars.indexOf(c1.toString())
        val indexC = chars.indexOf(c.toString())

        if (indexC2 - indexC1 == 1 && indexC1 - indexC == 1) {
            containsThreeStraight = true
        }

        if (invalidChars.contains(c.toString())) {
            containsInvalidChars = true
        }
    }
    val foundIndexes = arrayListOf<Pair<String, Int>>()
    for ((i, c) in password.withIndex()) {
        if (i + 1 == password.length ) break

        val c1 = password[i + 1]

        if (c == c1 && !foundIndexes.contains(Pair(c.toString(), i)) && !foundIndexes.contains(Pair(c.toString(), i + 1))) {
            pairCount++
            foundIndexes.add(Pair(c.toString(), i))
            foundIndexes.add(Pair(c.toString(), i + 1))
        }
    }

    return containsThreeStraight && pairCount > 1 && !containsInvalidChars
}