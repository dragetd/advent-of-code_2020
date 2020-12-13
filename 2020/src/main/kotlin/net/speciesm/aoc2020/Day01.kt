package net.speciesm.aoc2020

object Day01 {

    private fun Pair<Int, Int>.sum() = first + second
    private fun Pair<Int, Int>.product() = first * second
    private fun List<Int>.toPairs(): Sequence<Pair<Int, Int>> = this
        .asSequence()
        .flatMapIndexed { i, first ->
            this.drop(i).map { second -> Pair(first, second) }
        }

    fun solve(inputs: List<String>): Int {
        val numericInputs = inputs.map(String::toInt)

        return numericInputs.toPairs()
            .filter { it.sum() == 2020 }
            .first().product()
    }

    // --- Second Task
    private fun Triple<Int, Int, Int>.sum() = first + second + third
    private fun Triple<Int, Int, Int>.product() = first * second * third
    private fun List<Int>.toTriples(): Sequence<Triple<Int, Int, Int>> = this
        .asSequence().flatMapIndexed() { i, first ->
            this.drop(i).flatMapIndexed { j, second ->
                this.drop(j).map { third -> Triple(first, second, third) }
            }
        }

    fun solve2(inputs: List<String>): Int {
        val numericInputs = inputs.map(String::toInt)

        return numericInputs.toTriples()
            .filter { it.sum() == 2020 }
            .first().product()
    }
}

