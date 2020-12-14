package net.speciesm.aoc2020

import kotlin.math.pow

object Day14 {
    @ExperimentalUnsignedTypes
    object Memory {
        private val memory: MutableMap<Int, ULong> = mutableMapOf()

        fun set(address: Int, value: ULong) {
            memory[address] = value
        }

        fun sum() = memory.values.sum()
    }

    @ExperimentalUnsignedTypes
    object MaskEvaluator {
        private const val MAXBITS = 36
        private var oneBits: ULong = 0u
        private var zeroBits: ULong = 0u

        fun setMask(mask: String) {
            require(mask.length == MAXBITS)
            oneBits = 0u
            zeroBits = 0u
            for ((i, char) in mask.withIndex()) {
                when (char) {
                    '0' -> zeroBits = zeroBits or (2.toDouble().pow(MAXBITS - 1 - i).toULong())
                    '1' -> oneBits = oneBits or (2.toDouble().pow(MAXBITS - 1 - i).toULong())
                }
            }
        }

        fun mapValue(value: ULong): ULong = (value or oneBits) and zeroBits.inv()
    }

    fun solve(inputs: List<String>): Long {
        val memRegex = Regex("""^mem\[(\d+)] = (\d+)$""")
        for (input in inputs) {
            if (input.startsWith("mask = ")) {
                MaskEvaluator.setMask(input.substring(7))
            } else {
                val result = memRegex.matchEntire(input)
                require(result != null) { "Invalid Input" }
                val (address, value) = result.destructured
                Memory.set(address.toInt(), MaskEvaluator.mapValue(value.toULong()))
            }
        }
        return Memory.sum().toLong()
    }
}
