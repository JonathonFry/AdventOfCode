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

        reindeer.add(Reindeer(split[0], Integer.valueOf(split[3]), Integer.valueOf(split[6]), Integer.valueOf(split[13])))
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

fun day14Part2() {
    val reindeer: MutableList<Reindeer> = mutableListOf()

    val input = openFile("day14")

    while (input.hasNext()) {
        val line = input.nextLine()
        val split = line.split(" ")

        reindeer.add(Reindeer(split[0], Integer.valueOf(split[3]), Integer.valueOf(split[6]), Integer.valueOf(split[13])))
    }

    for (i in 0..TIME - 1) {
        reindeer.forEach {
            updateReindeer(i, it)
        }
        reindeer.sortByDescending { it.distance }

        var max = 0
        reindeer.forEach {
            if (max == 0) {
                max = it.distance
            }
            if (it.distance == max) {
                it.points += 1
            }

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

data class Reindeer(val name: String, val speed: Int, val fly: Int, val rest: Int, var distance: Int = 0, var blockedAt: Int = 0, var startAt: Int = 0, var points: Int = 0)
