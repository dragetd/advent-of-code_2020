package net.speciesm.aoc2020

import net.speciesm.aoc2020.Day08.Opcode.ACC
import net.speciesm.aoc2020.Day08.Opcode.JMP
import net.speciesm.aoc2020.Day08.Opcode.NOP

object Day08 {
    // Known opcodes
    enum class Opcode {
        NOP,
        ACC,
        JMP;

        companion object {
            fun byName(name: String): Opcode = when (name.toLowerCase()) {
                "nop" -> NOP
                "acc" -> ACC
                "jmp" -> JMP
                else -> throw IllegalArgumentException("Unknown opcode '$name'")
            }
        }
    }

    // ROM with instruction counter
    class ROM(input: List<String>) {
        private val code = input
            .map { Pair(it.opCode(), it.param()) }
            .toList()
        private val executions = IntArray(code.size)

        fun String.opCode() = Opcode.byName(this.split(' ')[0])

        fun String.param() = this.split(' ')[1].toInt()

        operator fun get(index: Int) = code[index].first

        fun parameter(index: Int) = code[index].second

        fun executions(index: Int) = executions[index]

        fun executed(index: Int) = executions[index]++
    }

    // Emulated CPU
    class CPU(val rom: ROM, var accumulator: Int = 0, var instructionPointer: Int = 0) {
        fun run() {
            while (rom.executions(instructionPointer) < 1) {
                execute(rom[instructionPointer], rom.parameter(instructionPointer))
            }
        }

        private fun execute(instruction: Opcode, parameter: Int) {
            rom.executed(instructionPointer)
            when (instruction) {
                ACC -> accumulator += parameter
                JMP -> instructionPointer += parameter - 1
                NOP -> {
                }
            }
            instructionPointer++
        }
    }

    fun solve(inputs: List<String>): Int {
        val rom = ROM(inputs)
        val cpu = CPU(rom)
        cpu.run()
        return cpu.accumulator
    }
}
