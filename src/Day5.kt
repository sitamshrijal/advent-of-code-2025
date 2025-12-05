fun main() {
    fun part1(input: List<String>): Int {
        val blankLineIndex = input.indexOf("")
        val ranges = input.take(blankLineIndex).map {
            val splits = it.split("-")
            splits[0].toLong()..splits[1].toLong()
        }
        val ids = input.drop(blankLineIndex + 1).map { it.toLong() }
        return ids.count { it.isFresh(ranges) }
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    val input = readInput("input5")
    part1(input).println()
    part2(input).println()
}

fun Long.isFresh(ranges: List<LongRange>): Boolean = ranges.any { range ->
    this in range
}
