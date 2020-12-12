package net.speciesm.aoc2020

object Day09 {

    private fun Pair<Long, Long>.sum() = first + second
    private fun List<Long>.toPairs(): Sequence<Pair<Long, Long>> =
        this.asSequence()
            .flatMapIndexed { i, first ->
                this.mapIndexedNotNull() { h, second -> if (i == h) null else Pair(first, second) }
            }

    private fun correctSum(window: List<Long>): Boolean {
        return window.subList(0, window.size - 1)
            .toPairs()
            .any { it.sum() == window.last() }
    }

    fun solve(inputs: List<String>, window: Int = 25): Int =
        inputs
            .map { it.toLong() }
            .windowed(window + 1)
            .first { !correctSum(it) }
            .last()
            .toInt()
}
