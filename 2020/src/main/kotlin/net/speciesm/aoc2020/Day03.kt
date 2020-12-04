package net.speciesm.aoc2020

object Day03 {
    fun solve(inputs: List<String>): Long = treesOnSlope(inputs, 3, 1)

    private fun treesOnSlope(inputs: List<String>, rightStep: Int, downStep: Int): Long {
        var acc = 0L
        for (y in inputs.indices step downStep) {
            if (y == 0) continue // ignore first row
            val x = ((y * rightStep) / downStep) % inputs[y].length
            if (inputs[y][x] == '#') acc++
        }
        return acc
    }

    //--- Second Task
    fun solve2(inputs: List<String>): Long =
        treesOnSlope(inputs, 1, 1) *
                treesOnSlope(inputs, 3, 1) *
                treesOnSlope(inputs, 5, 1) *
                treesOnSlope(inputs, 7, 1) *
                treesOnSlope(inputs, 1, 2)
}
