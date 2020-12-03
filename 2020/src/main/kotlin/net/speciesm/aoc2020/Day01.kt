package net.speciesm.aoc2020

object Day01 {
    fun solve(inputs: List<String>): Int {
        val numericInputs = inputs.map(String::toInt).sorted()

        return numericInputs.takeWhile { x -> x < 2020 }
            .flatMap {
                numericInputs.takeWhile { y -> y < 2020 }
                    .filter { y -> it + y == 2020 }
                    .map { y -> it * y }
            }.first()
    }
}

