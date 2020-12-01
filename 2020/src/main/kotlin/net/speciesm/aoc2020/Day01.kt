package net.speciesm.aoc2020

fun day01(inputs: List<String>): Int {
    val numericInputs = inputs.map(String::toInt).sorted()

    return numericInputs.takeWhile { x -> x < 2020 }
        .flatMap {
            numericInputs.takeWhile { y -> y < 2020 }
                .filter { y -> it + y == 2020 }
                .map { y -> it * y }
        }.first()
}

fun day01_alternative(inputs: List<String>): Int {
    val numericInputs = inputs.map(String::toInt).sorted()

    for (x in numericInputs.indices) {
        if (numericInputs[x] > 2020) {
            return -1
        }
        for (y in x until numericInputs.size) {
            if (numericInputs[x] + numericInputs[y] > 2020) {
                break
            } else if (numericInputs[x] + numericInputs[y] == 2020) {
                return numericInputs[x] * numericInputs[y]
            }
        }
    }
    return -1
}
