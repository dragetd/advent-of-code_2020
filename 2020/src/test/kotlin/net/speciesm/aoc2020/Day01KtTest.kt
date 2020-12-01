package net.speciesm.aoc2020

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day01KtTest {
    val testData = """
        1721
        979
        366
        299
        675
        1456
        """.trimIndent().lines()

    @Test
    fun `day01 works`() {
        assertThat(day01(testData)).isEqualTo(514579)
    }

    @Test
    fun `day01_alternative works`() {
        assertThat(day01_alternative(testData)).isEqualTo(514579)
    }
}
