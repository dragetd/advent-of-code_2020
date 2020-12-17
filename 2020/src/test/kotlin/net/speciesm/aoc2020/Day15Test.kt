package net.speciesm.aoc2020

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day15Test {
    private val cut = Day15
    private val testData = mapOf(
        "0,3,6" to 436,
        "1,3,2" to 1,
        "2,1,3" to 10,
        "1,2,3" to 27,
        "2,3,1" to 78,
        "3,2,1" to 438,
        "3,1,2" to 1836
    )

    @Test
    fun solves() {
        for ((test, result) in testData) {
            assertThat(cut.solve(test.lines())).isEqualTo(result)
        }
    }
}
