package net.speciesm.aoc2020

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day09Test {
    private val cut = Day09
    private val testData = """
        35
        20
        15
        25
        47
        40
        62
        55
        65
        95
        102
        117
        150
        182
        127
        219
        299
        277
        309
        576
    """.trimIndent()

    @Test
    fun solves() {
        assertThat(cut.solve(testData.lines(), 5)).isEqualTo(127)
    }
}
