package net.speciesm.aoc2020

object Day03 {
    fun solve(inputs: List<String>): Int {
        return treesOnSlope(inputs, 3, 1)
    }

    private fun treesOnSlope(inputs: List<String>, rightStep: Int, downStep: Int): Int {
        var acc = 0
        for (i in 1 until inputs.size step downStep) {
            if (inputs[i][i * rightStep % inputs[i].length] == '#') acc++
        }
        return acc
    }
}
