package net.speciesm.aoc2020

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day03Test {
    private val cut = Day03
    private val testData = """
        ..##.......
        #...#...#..
        .#....#..#.
        ..#.#...#.#
        .#...##..#.
        ..#.##.....
        .#.#.#....#
        .#........#
        #.##...#...
        #...##....#
        .#..#...#.#
        """.trimIndent().lines()

    @Test
    fun solves() {
        assertThat(cut.solve(testData)).isEqualTo(7)
    }

    @Test
    fun solves2() {
        assertThat(cut.solve2(testData)).isEqualTo(336)
    }
}
