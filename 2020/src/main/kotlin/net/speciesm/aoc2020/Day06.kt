package net.speciesm.aoc2020

object Day06 {
    fun solve(inputs: List<String>): Int {
        // Whole input with spaces instead of newlines, then separated by empty line
        val inputString = inputs.fold("") { line, next -> "$line $next" }
        val groups = inputString.split("  ")
        return groups
            .map { it.replace(" ", "").toCharArray().distinct() }
            .sumBy { it.size }
    }
}
