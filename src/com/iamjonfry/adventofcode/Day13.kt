package com.iamjonfry.adventofcode

import java.util.*

/**
 * Created by jonfry on 01/12/2016.
 */

fun day13Part1() {
    var data: HashMap<String, HashMap<String, Int>> = hashMapOf()

    var input = openFile("day13")

    while (input.hasNext()) {
        var line = input.nextLine()
        var split = line.split(" ")

        var name = split[0]
        var value = split[3]
        var nextTo = split[split.size - 1]
        nextTo = nextTo.substring(0, nextTo.length - 1)

        if (data.containsKey(name)) {
            data[name]!!.put(nextTo, Integer.valueOf(value))
        } else {
            var temp = hashMapOf(Pair(nextTo, Integer.valueOf(value)))
            data[name] = temp

        }
    }

    data.keys.forEach(::println)

    /*
    TODO - Calculate all possible options
    Carol David Alice Bob
    Carol David Bob Alice
    Carol Alice David Bob
    Carol Alice Bob David
    Carol Bob David Alice
    Carol Bob Alice David
     */

//    Alice would lose 2 happiness units by sitting next to Bob.

    /*
     +41 +46
+55   David    -2
Carol       Alice
+60    Bob    +54
     -7  +83
     */
}