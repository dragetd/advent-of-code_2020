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
        6 -> "${Day06.solve(inputs)}" //, ${Day06.solve2(inputs)}"
        7 -> "${Day07.solve(inputs)}"
        else -> "".also { panic("Day $day is unknown.") }
    }
    println(result)
}

fun panic(message: String) {
    System.err.println(message)
    exitProcess(1)
}
