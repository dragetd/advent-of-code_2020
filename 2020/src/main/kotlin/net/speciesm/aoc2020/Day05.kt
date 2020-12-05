package net.speciesm.aoc2020

import java.util.*

object Day05 {
    private const val ROW_BITS = 7
    private const val COLUMN_BITS = 3

    fun solve(inputs: List<String>): Int =
        inputs.map { seatId(it) }.maxByOrNull { it } ?: -1

    @ExperimentalUnsignedTypes
    private fun seatId(seatCode: String): Int {
        val row = BitSet()
        val column = BitSet()

        for(charPos in 0 until ROW_BITS) {
            if (seatCode[charPos] == 'B') row.set((ROW_BITS - 1) - charPos)
        }
        for(charPos in 0 until COLUMN_BITS) {
            if (seatCode[ROW_BITS + charPos] == 'R') column.set((COLUMN_BITS - 1) - charPos)
        }

        var rowId = 0
        var columnId = 0
        if (row.toByteArray().isNotEmpty()) {
            rowId = row.toByteArray().first().toUByte().toInt()
        }
        if (column.toByteArray().isNotEmpty()) {
            columnId = column.toByteArray().first().toUByte().toInt()
        }

        return rowId * 8 + columnId
    }
}
