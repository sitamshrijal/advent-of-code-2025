fun main() {
    fun part1(input: List<String>): Int {
        val banks = input.map { row ->
            row.map { it.digitToInt() }
        }
        return banks.sumOf { bank ->
            var max = 0
            for (i in bank.indices) {
                for (j in i + 1..bank.lastIndex) {
                    val first = bank[i]
                    val second = bank[j]
                    val joltage = "$first$second".toInt()
                    if (joltage > max) {
                        max = joltage
                    }
                }
            }
            max
        }
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    val input = readInput("input3")
    part1(input).println()
    part2(input).println()
}
