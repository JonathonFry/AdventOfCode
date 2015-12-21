package com.iamjonfry.adventofcode

import java.security.MessageDigest

/**
 * Created by Jonathon Fry on 20/12/2015.
 */

fun day4Part1() {
    val input = openFile("day4").next()
    val messageDigest = MessageDigest.getInstance("MD5")
    var count = 0


    while (true) {
        val inputBytes = (input + count).toByteArray(Charsets.UTF_8)
        val md5 = messageDigest.digest(inputBytes)
        val output = bytesToHex(md5)
        if (output.startsWith("00000")) {
            break
        }
        count++
    }

    println("Day 4 Part 1: $count")
}

fun day4Part2() {
    val input = openFile("day4").next()
    val messageDigest = MessageDigest.getInstance("MD5")
    var count = 0


    while (true) {
        val inputBytes = (input + count).toByteArray(Charsets.UTF_8)
        val md5 = messageDigest.digest(inputBytes)
        val output = bytesToHex(md5)
        if (output.startsWith("000000")) {
            break
        }
        count++
    }

    println("Day 4 Part 2: $count")
}

//http://stackoverflow.com/a/9855338/1022454
private fun bytesToHex(byteArray: ByteArray): String {
    val hexArray = "0123456789ABCDEF".toCharArray()
    var hexChars = CharArray(byteArray.size * 2)
    for ((j, byte )in byteArray.withIndex()) {
        var v = byte.toInt() and 0xFF
        hexChars[j * 2] = hexArray[v.ushr(4)]
        hexChars[j * 2 + 1] = hexArray[v.and(0x0F)]
    }
    return String(hexChars)
}