package net.speciesm.aoc2020

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day08Test {
    private val cut = Day08
    private val testData = """
        nop +0
        acc +1
        jmp +4
        acc +3
        jmp -3
        acc -99
        acc +1
        jmp -4
        acc +6
    """.trimIndent()

    @Test
    fun solves() {
        assertThat(cut.solve(testData.lines())).isEqualTo(5)
    }
}
