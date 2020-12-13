package net.speciesm.aoc2020

object Day10 {
    fun solve(inputs: List<String>): Int {
        val distribution = inputs
            .map { it.toInt() }
            .sorted()
            .windowed(2)
            .groupingBy { it[1] - it[0] }
            .eachCount()
        require(distribution.keys.maxOf { it } <= 3) { "Input chain has gaps larger than three." }
        val oneGaps = distribution[1]?.plus(1) ?: 0
        val threeGaps = distribution[3]?.plus(1) ?: 0
        return oneGaps * threeGaps
    }
}
