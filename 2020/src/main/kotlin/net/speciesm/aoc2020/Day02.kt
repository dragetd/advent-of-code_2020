package net.speciesm.aoc2020

object Day02 {
    private const val EXPECTED_MATCHES = 5
    private val pattern = Regex("""^(\d+)-(\d+) (.): (.*)$""")

    private fun isValid(input: String): Boolean {
        val matches = pattern.find(input)
        if (matches != null && matches.groups.size == EXPECTED_MATCHES) {
            val min = matches.groups[1]!!.value.toInt()
            val max = matches.groups[2]!!.value.toInt()
            val char = matches.groups[3]!!.value.first()
            val pass = matches.groups[4]!!.value
            val count = pass.filter { it == char }.count()
            return (count in min..max)
        }
        return false
    }

    fun solve(inputs: List<String>) = inputs.filter { isValid(it) }.count()
}

