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

    val result: String = when (day) {
        1 -> "${Day01.solve(inputs)}, ${Day01.solve2(inputs)}"
        2 -> "${Day02.solve(inputs)}"
        3 -> "${Day03.solve(inputs)}"
        else -> "".also { panic("Day $day is unknown.") }
    }
    println(result)
}

fun panic(message: String) {
    System.err.println(message)
    exitProcess(1)
}
