fun main() {
    fun part1(input: List<String>): Int {
        var current = 50

        return input.count { rotation ->
            val direction = rotation[0]
            val distance = rotation.drop(1).toInt()
            val delta = when (direction) {
                'L' -> -1
                'R' -> 1
                else -> error("Unsupported direction")
            }
            current = (current + delta * distance) % 100
            current == 0
        }
    }

    fun part2(input: List<String>): Int {
        var current = 50
        var count = 0

        input.forEach { rotation ->
            val direction = rotation[0]
            val distance = rotation.drop(1).toInt()

            val delta = when (direction) {
                'L' -> -1
                'R' -> 1
                else -> error("Unsupported direction")
            }
            repeat(distance) {
                current = (current + delta) % 100
                if (current == 0) count++
            }

        }
        return count
    }

    val input = readInput("input1")
    part1(input).println()
    part2(input).println()
}
