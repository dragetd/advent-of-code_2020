package net.speciesm.aoc2020

object Day07 {
    private const val MAX_DEPTH = 99
    private const val SHINY_BAG = "shiny gold"

    private const val colors = """\w+ \w+"""
    private const val noBags = "no other bags"
    private val rule = Regex("""^($colors) bags contain (.*).$""")
    private val rulePart = Regex("""(\d+) ($colors) bags?|$noBags""")

    private fun rulePartsToColors(ruleParts: String): List<String> =
        if (ruleParts.equals(noBags)) listOf() else rulePart.findAll(ruleParts)
            .mapNotNull { it.destructured }
            .map { (_, allowedColor) -> allowedColor }
            .toList()

    private fun canReachShiny(ruleMap: Map<String, List<String>>, query: String): Boolean =
        canReachShinyRecursive(ruleMap, query, 0)

    private fun canReachShinyRecursive(ruleMap: Map<String, List<String>>, query: String, depth: Int): Boolean {
        if (depth > MAX_DEPTH) throw IllegalStateException("Rules to deep! Depth at $depth")
        if (ruleMap[query]?.contains(SHINY_BAG) == true) return true
        return (ruleMap[query]?.any { canReachShinyRecursive(ruleMap, it, depth + 1) } == true)
    }

    fun solve(inputs: List<String>): Int {
        val ruleMap = inputs.mapNotNull { rule.matchEntire(it)?.destructured }
            .map { (subject, ruleParts) -> subject to rulePartsToColors(ruleParts) }
            .toMap()
        return ruleMap.keys.count { canReachShiny(ruleMap, it) }
    }
}
