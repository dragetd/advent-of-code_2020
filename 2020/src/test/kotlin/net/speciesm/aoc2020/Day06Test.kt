package net.speciesm.aoc2020

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day06Test {
    private val cut = Day06
    private val testData = """
        abc

        a
        b
        c

        ab
        ac

        a
        a
        a
        a

        b
    """.trimIndent()

    @Test
    fun solves() {
        assertThat(cut.solve(testData.lines())).isEqualTo(11)
    }

    @Test
    fun solves2() {
        assertThat(cut.solve2(testData.lines())).isEqualTo(6)
    }
}
