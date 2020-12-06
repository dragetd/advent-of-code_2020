package net.speciesm.aoc2020

object Day04 {
    private val validationRules = mapOf(
        "byr" to Regex("""^(19[2-9][0-9]|200[0-2])$"""),
        "iyr" to Regex("""^20(1[0-9]|20)$"""),
        "eyr" to Regex("""^20(2[0-9]|30)${'$'}"""),
        "hgt" to Regex("""^((1[5-8][0-9]|19[0-3])cm|(59|6[0-9]|7[0-6])in)$"""),
        "hcl" to Regex("""^#[0-9,a-f]{6}$"""),
        "ecl" to Regex("""^(amb|blu|brn|gry|grn|hzl|oth)$"""),
        "pid" to Regex("""^\d{9}$"""),
    )

    private fun isValid(pass: String): Boolean {
        val fields = pass.trim().split(" ")
            .associate {
                val (key, value) = it.split(":")
                key to value
            }
        // check, ignoring cid
        if (!fields.keys.containsAll(listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"))) return false
        for (rule in validationRules) {
            if (!rule.value.matches(fields[rule.key].toString())) return false
        }

        return true
    }

    fun solve(inputs: List<String>): Int {
        // Whole input with spaces instead of newlines
        val inputString = inputs.fold("") { line, next -> "$line $next" }
        val passes = inputString.split("  ")
        return passes.filter { isValid(it) }.count()
    }

    // solve2 includes solve1
    fun solve2(inputs: List<String>): Int = solve(inputs)
}
