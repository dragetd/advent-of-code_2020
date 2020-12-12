package net.speciesm.aoc2020

import net.speciesm.aoc2020.Day08.Opcode.ACC
import net.speciesm.aoc2020.Day08.Opcode.JMP
import net.speciesm.aoc2020.Day08.Opcode.NOP
import java.util.*

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

    // RAM with instruction counter
    class RAM(input: List<String>) {
        private val code = input
            .map { Pair(it.opCode(), it.param()) }
            .toMutableList()
        private val executions = IntArray(code.size)

        private fun String.opCode() = Opcode.byName(this.split(' ')[0])

        private fun String.param() = this.split(' ')[1].toInt()

        val size: Int
            get() = code.size

        operator fun get(index: Int) = code[index].first

        fun parameter(index: Int) = code[index].second

        fun executions(index: Int) = executions[index]

        fun executed(index: Int) = executions[index]++

        fun flipOp(index: Int) {
            code[index] = (if (code[index].first == NOP) JMP else NOP) to code[index].second
        }

        fun resetExecuted() {
            executions.fill(0)
        }
    }

    // Emulated CPU
    class CPU(private val ram: RAM) {
        private data class RegisterState(var acc: Int = 0, var ip: Int = 0) {
            fun reset(newSate: RegisterState = RegisterState()) {
                acc = newSate.acc
                ip = newSate.ip
            }
        }

        private val traceStack = Stack<RegisterState>()
        private val reg: RegisterState = RegisterState()

        var infiniteLoop = false
        var successfulBoot = false

        val acc: Int
            get() = reg.acc

        fun run(trace: Boolean = false) {
            infiniteLoop = false
            successfulBoot = false
            ram.resetExecuted()
            while (!infiniteLoop && !successfulBoot) {
                execute(ram[reg.ip], ram.parameter(reg.ip), trace)
                if (reg.ip >= ram.size) successfulBoot = true
                if (!successfulBoot && ram.executions(reg.ip) != 0) infiniteLoop = true
            }
        }

        private fun execute(instruction: Opcode, parameter: Int, trace: Boolean) {
            ram.executed(reg.ip)
            when (instruction) {
                ACC -> reg.acc += parameter
                JMP -> {
                    if (trace) traceStack.push(reg.copy())
                    reg.ip += parameter - 1
                }
                NOP -> {
                    if (trace) traceStack.push(reg.copy())
                }
            }
            reg.ip++
        }

        fun fixCode() {
            run(trace = true)
            while (traceStack.isNotEmpty()) {
                if (successfulBoot) return
                val lastRegState = traceStack.pop()
                // try to 'fix'
                ram.flipOp(lastRegState.ip)
                reg.reset(lastRegState)
                run()
                if (successfulBoot) {
                    reg.reset()
                    return
                }
                // reset wrong 'fix'
                ram.flipOp(lastRegState.ip)
            }
            throw IllegalArgumentException("Fixing the code failed.")
        }
    }

    fun solve(inputs: List<String>): Int {
        val ram = RAM(inputs)
        val cpu = CPU(ram)
        cpu.run()
        if (!cpu.infiniteLoop) throw IllegalArgumentException("Input does not loop.")
        return cpu.acc
    }

    fun solve2(inputs: List<String>): Int {
        val ram = RAM(inputs)
        val cpu = CPU(ram)
        cpu.fixCode()
        cpu.run()
        if (!cpu.successfulBoot) throw java.lang.IllegalArgumentException("Code could not be fixed.")
        return cpu.acc
    }
}
