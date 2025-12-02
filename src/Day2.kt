fun main() {
    fun part1(input: List<String>): Long {
        val idRanges = input[0].split(",").map {
            val splits = it.split("-")
            splits[0].toLong()..splits[1].toLong()
        }
        val regex = """(\d+)\1""".toRegex()
        val invalidIds = idRanges.flatMap { range ->
            range.filter { regex.matches("$it") }
        }
        return invalidIds.sum()
    }

    fun part2(input: List<String>): Long {
        val idRanges = input[0].split(",").map {
            val splits = it.split("-")
            splits[0].toLong()..splits[1].toLong()
        }
        val regex = """(\d+)\1+""".toRegex()
        val invalidIds = idRanges.flatMap { range ->
            range.filter { regex.matches("$it") }
        }
        return invalidIds.sum()
    }

    val input = readInput("input2")
    part1(input).println()
    part2(input).println()
}
