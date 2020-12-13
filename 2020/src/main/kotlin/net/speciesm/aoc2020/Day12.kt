package net.speciesm.aoc2020

import kotlin.math.absoluteValue

object Day12 {
    object Ship {
        var posNS = 0 // north-south position
        var posEW = 0 // east-west position
        var facing = 0 // 0 -> east, 90 -> north, 180 -> west, 270 -> south
            set(value) {
                require(value % 90 != 0) { "'facing' may only be set in increments of 90." }
                field = value % 360
                if (field < 0) field += 360
            }

        fun move(command: Char, value2: Int) {
            when (command) {
                'N' -> posNS += value2
                'S' -> posNS -= value2
                'E' -> posEW += value2
                'W' -> posEW -= value2
                'F' -> forward(value2)
                'L' -> facing += value2
                'R' -> facing -= value2
                else -> throw IllegalArgumentException("Unknown command.")
            }
        }

        private fun forward(value: Int) {
            when (facing) {
                0 -> posEW += value
                90 -> posNS += value
                180 -> posEW -= value
                270 -> posNS -= value
                else -> throw IllegalStateException("Illegal facing: $facing")
            }
        }

        fun distanceFromZeroManhatten(): Int = posNS.absoluteValue + posEW.absoluteValue
    }

    fun solve(inputs: List<String>): Int {
        for (command in inputs) {
            Ship.move(command.first(), command.substring(1).toInt())
        }
        return Ship.distanceFromZeroManhatten()
    }
}
