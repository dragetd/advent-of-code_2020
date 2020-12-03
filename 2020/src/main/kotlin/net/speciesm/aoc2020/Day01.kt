package net.speciesm.aoc2020

object Day01 {

    private fun Pair<Int, Int>.sum() = this.first + this.second
    private fun Pair<Int, Int>.product() = this.first * this.second

    private fun pairSequence(inputs: List<Int>): Sequence<Pair<Int, Int>> {
        return inputs.flatMap { first -> inputs.map { second -> Pair(first, second) } }
            .asSequence()
    }

    fun solve(inputs: List<String>): Int {
        val numericInputs = inputs.map(String::toInt)

        return pairSequence(numericInputs)
            .filter { it.sum() == 2020 }
            .first().product()
    }
}

