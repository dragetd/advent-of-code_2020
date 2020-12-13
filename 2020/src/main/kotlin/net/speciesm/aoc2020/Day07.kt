package net.speciesm.aoc2020

object Day07 {
    private const val MAX_DEPTH = 99
    private const val SHINY_BAG = "shiny gold"

    private const val colors = """\w+ \w+"""
    private const val nobags = "no other bags"
    private val rulePattern = Regex("""^($colors) bags contain (.*).$""")
    private val bagRulesPattern = Regex("""(\d+) ($colors) bags?|$nobags""")

    private fun List<String>.toRules(): Map<String, Map<String, Int>> = this
        .mapNotNull { rulePattern.matchEntire(it)?.destructured }
        .map { (subject, bagRules) -> subject to bagRules.toColors() }
        .toMap()

    private fun String.toColors(): Map<String, Int> =
        if (this == nobags) mapOf() else bagRulesPattern
            .findAll(this)
            .mapNotNull { it.destructured }
            .map { (count, allowedColor) -> allowedColor to count.toInt() }
            .toMap()

    private fun String.canReachShiny(rules: Map<String, Map<String, Int>>) = this
        .canReachShinyRecursive(rules, 0)

    private fun String.canReachShinyRecursive(rules: Map<String, Map<String, Int>>, depth: Int): Boolean {
        check(depth < MAX_DEPTH) { "Rules to deep! Depth at $depth" }
        if (rules[this]?.keys?.contains(SHINY_BAG) == true) return true
        return (rules[this]?.any { it.key.canReachShinyRecursive(rules, depth + 1) } == true)
    }

    fun solve(inputs: List<String>): Int {
        val rules = inputs.toRules()
        return rules.keys.count { it.canReachShiny(rules) }
    }

    //--- Second Task
    private fun Map<String, Map<String, Int>>.countBagsFor(color: String): Int {
        // No further rules defined, just the bag
        if (this[color]?.isEmpty() != false) return 1
        // The bag plus its sub-bags
        return 1 + this[color]!!.entries
            .map { (color, count) -> (count * this.countBagsFor(color)) }
            .sum()
    }

    fun solve2(inputs: List<String>): Int {
        val rules = inputs.toRules()
        // Count minus one to exclude the shiny bag itself
        return rules.countBagsFor(SHINY_BAG) - 1
    }
}
