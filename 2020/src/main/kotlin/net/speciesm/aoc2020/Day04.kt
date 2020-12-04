package net.speciesm.aoc2020

object Day04 {
    fun solve(inputs: List<String>): Int {
        // Whole input with spaces instead of newlines
        val inputString = inputs.fold("") { line, next -> "$line $next" }
        val passes = inputString.split("  ")
        return passes.filter { isValid(it) }.count()

    }

    private fun isValid(pass: String): Boolean {
        val fields = pass.trim().split(" ")
            .associate {
                val (key, value) = it.split(":")
                key to value
            }
        // check, ignoring cid
        return fields.keys.containsAll(listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"))
    }
}
