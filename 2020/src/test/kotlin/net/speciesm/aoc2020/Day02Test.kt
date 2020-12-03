package net.speciesm.aoc2020

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day02Test {
    private val testData = """
        1-3 a: abcde
        1-3 b: cdefg
        2-9 c: ccccccccc
        """.trimIndent().lines()

    @Test
    fun solves() {
        assertThat(Day02.solve(testData)).isEqualTo(2)
    }

    @Test
    fun solves2() {
        assertThat(Day02.solve2(testData)).isEqualTo(1)
    }
}
