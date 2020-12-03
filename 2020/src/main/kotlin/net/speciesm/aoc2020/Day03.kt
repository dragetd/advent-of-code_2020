package net.speciesm.aoc2020

object Day03 {
    fun solve(inputs: List<String>): Int {
        val xStep = 3
        var acc = 0

        for ((i, line) in inputs.withIndex()) {
            if (i > 0) {
                if (line[i * xStep % line.length] == '#') acc++
            }
        }

        return acc
    }
}
