package net.speciesm.aoc2020

import kotlinx.cli.ArgParser
import kotlinx.cli.ArgType
import kotlinx.cli.required
import java.io.File
import java.io.FileNotFoundException
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    val argParser = ArgParser("AoC2020")
    val inputFileName by argParser.option(
        ArgType.String, "input-file",
        "i", "Input file"
    ).required()
    val day by argParser.option(
        ArgType.Int, "day",
        "d", "Number of the challenge/day"
    ).required()
    argParser.parse(args)

    val inputs = try {
        File(inputFileName).readLines()
    } catch (e: FileNotFoundException) {
        panic("Input file not found."); listOf()
    }

    println("Answer(s) for day $day with input $inputFileName:")
    val result: String = when (day) {
        1 -> "${Day01.solve(inputs)}, ${Day01.solve2(inputs)}"
        2 -> "${Day02.solve(inputs)}, ${Day02.solve2(inputs)}"
        3 -> "${Day03.solve(inputs)}, ${Day03.solve2(inputs)}"
        4 -> "${Day04.solve(inputs)}, ${Day04.solve2(inputs)}"
        5 -> "${Day05.solve(inputs)}, ${Day05.solve2(inputs)}"
        6 -> "${Day06.solve(inputs)}, ${Day06.solve2(inputs)}"
        7 -> "${Day07.solve(inputs)}, ${Day07.solve2(inputs)}"
        8 -> "${Day08.solve(inputs)}, ${Day08.solve2(inputs)}"
        9 -> "${Day09.solve(inputs)}" //, ${Day09.solve2(inputs)}"
        10 -> "${Day10.solve(inputs)}" //, ${Day10.solve2(inputs)}"
//        11 -> "${Day11.solve(inputs)}" //, ${Day11.solve2(inputs)}"
        12 -> "${Day12.solve(inputs)}" //, ${Day12.solve2(inputs)}"
        13 -> "${Day13.solve(inputs)}" //, ${Day13.solve2(inputs)}"
        14 -> "${Day14.solve(inputs)}" //, ${Day14.solve2(inputs)}"
//        15 -> "${Day15.solve(inputs)}" //, ${Day15.solve2(inputs)}"
//        16 -> "${Day16.solve(inputs)}" //, ${Day16.solve2(inputs)}"
//        17 -> "${Day17.solve(inputs)}" //, ${Day17.solve2(inputs)}"
//        18 -> "${Day18.solve(inputs)}" //, ${Day18.solve2(inputs)}"
//        19 -> "${Day19.solve(inputs)}" //, ${Day19.solve2(inputs)}"
//        20 -> "${Day20.solve(inputs)}" //, ${Day20.solve2(inputs)}"
//        21 -> "${Day21.solve(inputs)}" //, ${Day21.solve2(inputs)}"
//        22 -> "${Day22.solve(inputs)}" //, ${Day22.solve2(inputs)}"
//        23 -> "${Day23.solve(inputs)}" //, ${Day23.solve2(inputs)}"
//        24 -> "${Day24.solve(inputs)}" //, ${Day24.solve2(inputs)}"
        else -> "".also { panic("Day $day is unknown.") }
    }
    println(result)
}

fun panic(message: String) {
    System.err.println(message)
    exitProcess(1)
}
