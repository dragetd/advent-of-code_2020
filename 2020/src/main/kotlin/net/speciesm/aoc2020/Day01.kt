package net.speciesm.aoc2020

object Day01 {

    private fun Pair<Int, Int>.sum() = this.first + this.second
    private fun Pair<Int, Int>.product() = this.first * this.second

    private fun pairSequence(inputs: List<Int>): Sequence<Pair<Int, Int>> {
        return inputs.asSequence().flatMap { first ->
            inputs.map { second ->
                Pair(first, second)
            }
        }.asSequence()
    }

    fun solve(inputs: List<String>): Int {
        val numericInputs = inputs.map(String::toInt)

        return pairSequence(numericInputs)
            .filter { it.sum() == 2020 }
            .first().product()
    }

    // --- Second Task
    private fun Triple<Int, Int, Int>.sum() = this.first + this.second + this.third
    private fun Triple<Int, Int, Int>.product() = this.first * this.second * this.third

    private fun tripleSequence(inputs: List<Int>): Sequence<Triple<Int, Int, Int>> {
        return inputs.asSequence().flatMap { first ->
            inputs.flatMap { second ->
                inputs.map { third ->
                    Triple(first, second, third)
                }
            }.asSequence()
        }
    }

    fun solve2(inputs: List<String>): Int {
        val numericInputs = inputs.map(String::toInt)

        return tripleSequence(numericInputs)
            .filter { it.sum() == 2020 }
            .first().product()
    }
}

