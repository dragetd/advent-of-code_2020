package net.speciesm.aoc2020

import java.io.File

fun main(args: Array<String>) {
    val inputs = File(args[0]).readLines()

    print(day01(inputs))
}
