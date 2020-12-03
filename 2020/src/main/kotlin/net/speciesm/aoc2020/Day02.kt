package net.speciesm.aoc2020

object Day02 {
    private val policy = Regex("""^(\d+)-(\d+) (.): (.*)$""")

    private fun isValid(min: Int, max: Int, char: Char, pass: String): Boolean =
        pass.filter { it == char }.count() in min..max

    fun solve(inputs: List<String>): Int = inputs
        .mapNotNull { policy.find(it)?.destructured }
        .count { (min, max, char, pass) -> isValid(min.toInt(), max.toInt(), char.first(), pass) }

    // --- Second Task
    private fun isValid2(first: Int, second: Int, char: Char, pass: String): Boolean =
        "${pass[first - 1]}${pass[second - 1]}".filter { it == char }.count() == 1

    fun solve2(inputs: List<String>): Int = inputs
        .mapNotNull { policy.find(it)?.destructured }
        .count { (first, second, char, pass) -> isValid2(first.toInt(), second.toInt(), char.first(), pass) }
}

