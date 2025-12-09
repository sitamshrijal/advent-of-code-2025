fun main() {
    fun part1(input: List<String>): Long {
        val regex = """\s+""".toRegex()
        val operations = input.last().split(regex).map {
            when (it) {
                "+" -> Operation.ADD
                "*" -> Operation.MULTIPLY
                else -> error("Unsupported operation")
            }
        }
        val numbers = buildList {
            input.dropLast(1).forEach { row ->
                val splits = row.split(regex).map { it.toLong() }
                add(splits)
            }
        }

        val problems = mutableListOf<Problem>()

        for (j in numbers[0].indices) {
            val list = mutableListOf<Long>()
            for (i in numbers.indices) {
                list += numbers[i][j]
            }
            problems += Problem(list, operations[j])
        }
        return problems.sumOf { it.answer() }
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    val input = readInput("input6")
    part1(input).println()
    part2(input).println()
}

data class Problem(val numbers: List<Long>, val operation: Operation) {
    fun answer(): Long = when (operation) {
        Operation.ADD -> numbers.sum()
        Operation.MULTIPLY -> numbers.fold(1L) { a, b -> a * b }
    }
}

enum class Operation {
    ADD, MULTIPLY
}
