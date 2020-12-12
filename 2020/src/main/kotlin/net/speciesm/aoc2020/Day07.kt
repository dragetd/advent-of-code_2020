package net.speciesm.aoc2020

object Day07 {
    private const val MAX_DEPTH = 99
    private const val SHINY_BAG = "shiny gold"

    private const val colors = """\w+ \w+"""
    private const val nobags = "no other bags"
    private val rulePattern = Regex("""^($colors) bags contain (.*).$""")
    private val bagRulesPattern = Regex("""(\d+) ($colors) bags?|$nobags""")

    private fun List<String>.toRules(): Map<String, Map<String, Int>> =
        this.mapNotNull { rulePattern.matchEntire(it)?.destructured }
            .map { (subject, bagRules) -> subject to bagRules.toColors() }
            .toMap()

    private fun String.toColors(): Map<String, Int> =
        if (this == nobags) mapOf() else bagRulesPattern.findAll(this)
            .mapNotNull { it.destructured }
            .map { (count, allowedColor) -> allowedColor to count.toInt() }
            .toMap()

    private fun String.canReachShiny(rules: Map<String, Map<String, Int>>): Boolean =
        this.canReachShinyRecursive(rules, 0)

    private fun String.canReachShinyRecursive(rules: Map<String, Map<String, Int>>, depth: Int): Boolean {
        if (depth > MAX_DEPTH) throw IllegalStateException("Rules to deep! Depth at $depth")
        if (rules[this]?.keys?.contains(SHINY_BAG) == true) return true
        return (rules[this]?.any { it.key.canReachShinyRecursive(rules, depth + 1) } == true)
    }

    fun solve(inputs: List<String>): Int {
        val rules = inputs.toRules()
        return rules.keys.count { it.canReachShiny(rules) }
    }
}
