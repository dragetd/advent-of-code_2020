package net.speciesm.aoc2020

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day01Test {
    private val testData = """
        1721
        979
        366
        299
        675
        1456
        """.trimIndent().lines()

    @Test
    fun `day01 solves`() {
        assertThat(Day01.solve(testData)).isEqualTo(514579)
    }
}
