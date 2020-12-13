package net.speciesm.aoc2020

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day05Test {
    private val cut = Day05
    private val testData = mapOf(
        "BFFFBBFRRR" to 567,
        "FFFBBBFRRR" to 119,
        "BBFFBBFRLL" to 820
    )

    @Test
    fun solves() {
        assertThat(cut.solve(testData.keys.toList())).isEqualTo(820)
    }

    @Test
    fun single_entries_solve() {
        for (test in testData) assertThat(cut.solve(listOf(test.key))).isEqualTo(test.value)
    }

    //--- Second Task
    private val seatsWithGap = mapOf(
        "FFFFBBFRLR" to 53,
        "FFFFBBFRRR" to 55
    )
    private val seatsWithoutGap = mapOf(
        "FFFFBBFRLL" to 52,
        "FFFFBBFRLR" to 53
    )

    @Test
    fun seat_list_is_valid() {
        for (test in seatsWithGap) assertThat(cut.solve(listOf(test.key))).isEqualTo(test.value)
        for (test in seatsWithoutGap) assertThat(cut.solve(listOf(test.key))).isEqualTo(test.value)
    }

    @Test
    fun finds_gap() {
        assertThat(cut.solve2(seatsWithGap.keys.toList())).isEqualTo(54)
    }

    @Test
    fun returns_negativeone_without_gap() {
        assertThat(cut.solve2(seatsWithoutGap.keys.toList())).isEqualTo(-1)
    }
}
