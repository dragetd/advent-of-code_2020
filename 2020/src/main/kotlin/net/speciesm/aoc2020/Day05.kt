package net.speciesm.aoc2020

import java.util.*

@Suppress("EXPERIMENTAL_API_USAGE")
object Day05 {
    private const val ROW_BITS = 7
    private const val COLUMN_BITS = 3

    @ExperimentalUnsignedTypes
    private fun seatId(seatCode: String): Int {
        val rowBits = BitSet()
        val columnBits = BitSet()

        for (charPos in 0 until ROW_BITS) {
            if (seatCode[charPos] == 'B') rowBits.set((ROW_BITS - 1) - charPos)
        }
        for (charPos in 0 until COLUMN_BITS) {
            if (seatCode[ROW_BITS + charPos] == 'R') columnBits.set((COLUMN_BITS - 1) - charPos)
        }
        val rowId = try {
            rowBits.toByteArray().first().toUByte().toInt()
        } catch (e: NoSuchElementException) {
            0
        }
        val columnId = try {
            columnBits.toByteArray().first().toUByte().toInt()
        } catch (e: NoSuchElementException) {
            0
        }

        return rowId * 8 + columnId
    }

    fun solve(inputs: List<String>): Int = inputs
        .map { seatId(it) }.maxByOrNull { it } ?: -1

    //-- Second Task
    fun solve2(inputs: List<String>): Int {
        val seatList = inputs.map { seatId(it) }.sorted()
        for ((i, seatId) in seatList.withIndex()) {
            if (i == 0) continue
            if ((seatList[i - 1] == seatList[i] - 2) && i != 0) return seatId - 1
        }
        return -1
    }
}
