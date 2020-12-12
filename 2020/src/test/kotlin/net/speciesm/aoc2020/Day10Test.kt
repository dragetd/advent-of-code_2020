package net.speciesm.aoc2020

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day10Test {
    private val cut = Day10
    private val testData = """
        28
        33
        18
        42
        31
        14
        46
        20
        48
        47
        24
        23
        49
        45
        19
        38
        39
        11
        1
        32
        25
        35
        8
        17
        7
        9
        4
        2
        34
        10
        3
    """.trimIndent()

    @Test
    fun solves() {
        assertThat(cut.solve(testData.lines())).isEqualTo(220)
    }
}
