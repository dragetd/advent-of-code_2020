package net.speciesm.aoc2020

object Day02 {
    private val policy = Regex("""^(\d+)-(\d+) (.): (.*)$""")

    private fun isValid(min: Int, max: Int, char: Char, pass: String): Boolean =
        (pass.filter { it == char }.count() in min..max)

    fun solve(inputs: List<String>): Int {
        return inputs
            .mapNotNull { policy.find(it)?.destructured }
            .count { (min, max, char, pass) -> isValid(min.toInt(), max.toInt(), char.first(), pass) }
    }
}

