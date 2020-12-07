package net.speciesm.aoc2020

object Day06 {
    // Whole input with spaces instead of newlines, then separated by empty line
    private fun asGroupStrings(inputs: List<String>): List<String> =
        inputs.fold("") { line, next -> "$line $next" }
            .split("  ")

    fun solve(inputs: List<String>): Int =
        asGroupStrings(inputs)
            .map { it.replace(" ", "").toCharArray().distinct() }
            .sumBy { it.size }
    }
}
