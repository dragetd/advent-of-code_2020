package net.speciesm.aoc2020

object Day06 {
    // Whole input with spaces instead of newlines, then separated by empty line
    private fun List<String>.toGroups(): List<String> = this
        .fold("") { line, next -> "$line $next" }
        .split("  ")
        .map { it.trim() }

    fun solve(inputs: List<String>): Int = inputs
        .toGroups()
        .map { it.replace(" ", "").toCharArray().distinct() }
        .sumBy { it.size }

    private fun String.toGroupAnswers(): List<String> = this.split(' ')

    private fun String.countCommonAnswers(): Int = this
        .replace(" ", "")
        .groupBy { it }
        .count { it.value.size == this.split(' ').size }

    fun solve2(inputs: List<String>): Int = inputs
        .toGroups()
        .map { it.countCommonAnswers() }
        .sum()
}
