package net.speciesm.aoc2020

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day12Test {
    private val cut = Day12
    private val testData = """
        F10
        N3
        F7
        R90
        F11
    """.trimIndent()

    @Test
    fun solves() {
        assertThat(cut.solve(testData.lines())).isEqualTo(25)
    }
}
