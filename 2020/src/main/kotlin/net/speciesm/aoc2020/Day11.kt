package net.speciesm.aoc2020

object Day11 {
    private fun List<CharArray>.isOccupiedAt(x: Int, y: Int): Boolean {
        if (y !in this.indices) return false
        if (x !in this[y].indices) return false
        return this[y][x] == '#'
    }

    private fun List<CharArray>.countNeighbours(x: Int, y: Int): Int =
        listOf(
            this.isOccupiedAt(x - 1, y - 1), this.isOccupiedAt(x, y - 1),
            this.isOccupiedAt(x + 1, y - 1),
            this.isOccupiedAt(x - 1, y), this.isOccupiedAt(x + 1, y),
            this.isOccupiedAt(x - 1, y + 1), this.isOccupiedAt(x, y + 1),
            this.isOccupiedAt(x + 1, y + 1)
        ).count { it }

    private fun tick(current: List<CharArray>, buffer: List<CharArray>): Boolean {
        var changed = false
        for ((y, line) in current.withIndex()) {
            for (x in line.indices)
                when (current[y][x]) {
                    'L' -> {
                        buffer[y][x] = 'L'
                        if (current.countNeighbours(x, y) == 0) buffer[y][x] = '#'.also { changed = true }
                    }
                    '#' -> {
                        buffer[y][x] = '#'
                        if (current.countNeighbours(x, y) >= 4) buffer[y][x] = 'L'.also { changed = true }
                    }
                    else -> {
                        buffer[y][x] = '.'
                    }
                }
        }
        return changed
    }

    fun solve(inputs: List<String>): Int {
        var currentField = inputs.map { it.toCharArray() }
        var buffer = inputs.map { it.toCharArray() }

        var changed = true
        while (changed) {
            changed = tick(currentField, buffer)
            // swap
            currentField = buffer.also { buffer = currentField }
        }

        return currentField
            .map { it -> it.count { it == '#' } }
            .sumBy { it }
    }
}
