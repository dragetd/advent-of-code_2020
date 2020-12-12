package net.speciesm.aoc2020

object Day07 {
    private const val MAX_DEPTH = 99
    private const val SHINY_BAG = "shiny gold"

    private const val colors = """\w+ \w+"""
    private const val nobags = "no other bags"
    private val rulePattern = Regex("""^($colors) bags contain (.*).$""")
    private val bagRulesPattern = Regex("""(\d+) ($colors) bags?|$nobags""")

    private fun bagRulesToColors(bagRules: String): Map<String, Int> =
        if (bagRules == nobags) mapOf() else bagRulesPattern.findAll(bagRules)
            .mapNotNull { it.destructured }
            .map { (count, allowedColor) -> allowedColor to count.toInt() }
            .toMap()

    private fun canReachShiny(rules: Map<String, Map<String, Int>>, query: String): Boolean =
        canReachShinyRecursive(rules, query, 0)

    private fun canReachShinyRecursive(rules: Map<String, Map<String, Int>>, query: String, depth: Int): Boolean {
        if (depth > MAX_DEPTH) throw IllegalStateException("Rules to deep! Depth at $depth")
        if (rules[query]?.keys?.contains(SHINY_BAG) == true) return true
        return (rules[query]?.any { canReachShinyRecursive(rules, it.key, depth + 1) } == true)
    }

    fun solve(inputs: List<String>): Int {
        val ruleMap = inputs.mapNotNull { rulePattern.matchEntire(it)?.destructured }
            .map { (subject, ruleParts) -> subject to bagRulesToColors(ruleParts) }
            .toMap()
        return ruleMap.keys.count { canReachShiny(ruleMap, it) }
    }
}
