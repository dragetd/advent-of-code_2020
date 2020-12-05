package net.speciesm.aoc2020

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day05Test {
    private val cut = Day05
    private val testData = mapOf(
        "BFFFBBFRRR" to 567,
        "FFFBBBFRRR" to 119,
        "BBFFBBFRLL" to 820)

    @Test
    fun solves() {
        assertThat(cut.solve(testData.keys.toList())).isEqualTo(820)
    }

    @Test
    fun single_entries_solve() {
        for (test in testData) {
            assertThat(cut.solve(listOf(test.key))).isEqualTo(test.value)
        }
    }
}
