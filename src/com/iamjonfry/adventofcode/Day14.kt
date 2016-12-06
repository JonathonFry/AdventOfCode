package com.iamjonfry.adventofcode

/**
 * Created by jonathonfry on 06/12/2016.
 */
val TIME = 2503


fun day14Part1() {
    val reindeer: MutableList<Reindeer> = mutableListOf()

    val input = openFile("day14")

    while (input.hasNext()) {
        val line = input.nextLine()
        val split = line.split(" ")

        reindeer.add(Reindeer(split[0], Integer.valueOf(split[3]), Integer.valueOf(split[6]), Integer.valueOf(split[13]), 0, 0, 0))
    }

    for (i in 0..TIME - 1) {
        reindeer.forEach {
            updateReindeer(i, it)
        }
    }

    reindeer.forEach {
        println("$it")
    }

}

fun updateReindeer(time: Int, reindeer: Reindeer) {
    if (time == reindeer.startAt) {
        reindeer.blockedAt = time + reindeer.fly
        reindeer.startAt = time + reindeer.fly + reindeer.rest
    }

    if (time < reindeer.blockedAt) {
        reindeer.distance += reindeer.speed
    }
}

data class Reindeer(val name: String, val speed: Int, val fly: Int, val rest: Int, var distance: Int, var blockedAt: Int, var startAt: Int)
