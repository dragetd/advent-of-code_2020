package net.speciesm.aoc2020

object Day13 {
    fun solve(inputs: List<String>): Int {
        val earliest = inputs[0].toInt()
        val bus = inputs[1].split(',')
            .filter { it != "x" }
            .map { it.toInt() }
            .map { Pair(it, it - (earliest % it)) }
            .minByOrNull { it.second }
        if (bus != null) return bus.first * bus.second
        throw IllegalStateException("Something went wrong")
    }
}
