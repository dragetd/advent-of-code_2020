package net.speciesm.aoc2020

object Day15 {

    fun List<Int>.toVanEckSequence(): Sequence<Int> {
        val cache = this.subList(0, this.size - 1).mapIndexed { index, value -> value to index }.toMap().toMutableMap()
        var index = this.size - 1
        return generateSequence(this.last()) {
            if (cache[it] != null) {
                val lastPos = cache[it] ?: 0
                cache[it] = index
                index++
                index - 1 - lastPos
            } else {
                cache[it] = index
                index++
                0
            }
        }
    }

    fun solve(inputs: List<String>): Int {
        val input = inputs.first().split(',')
        val toTake = 2020 - input.size + 1
        return input
            .map { it.toInt() }
            .toVanEckSequence()
            .take(toTake)
            .last()
    }
}
