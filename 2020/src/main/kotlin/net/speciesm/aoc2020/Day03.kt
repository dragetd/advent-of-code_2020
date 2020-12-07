package net.speciesm.aoc2020

object Day03 {
    private fun treesOnSlope(inputs: List<String>, rightStep: Int, downStep: Int): Long {
        var acc = 0L
        for (y in inputs.indices step downStep) {
            if (y == 0) continue // ignore first row
            val x = ((y * rightStep) / downStep) % inputs[y].length
            if (inputs[y][x] == '#') acc++
        }
        return acc
    }

    fun solve(inputs: List<String>): Long = treesOnSlope(inputs, 3, 1)

    //--- Second Task
    fun solve2(inputs: List<String>): Long =
        listOf(1 to 1, 3 to 1, 5 to 1, 7 to 1, 1 to 2)
            .map { (rightStep, downStep) -> treesOnSlope(inputs, rightStep, downStep) }
            .reduce { acc, result -> acc * result}
}
