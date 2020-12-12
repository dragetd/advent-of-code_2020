package net.speciesm.aoc2020

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day10Test {
    private val cut = Day10
    private val testData1 = """
        16
        10
        15
        5
        1
        11
        7
        19
        6
        12
        4
    """.trimIndent()

    private val testData2 = """
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
        assertThat(cut.solve(testData1.lines())).isEqualTo(5 * 7)
    }

    @Test
    fun solves1_2() {
        assertThat(cut.solve(testData2.lines())).isEqualTo(22 * 10)
    }
}
