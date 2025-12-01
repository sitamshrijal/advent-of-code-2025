fun main() {
    fun part1(input: List<String>): Int {
        var current = 50

        return input.sumOf { rotation ->
            val direction = rotation[0]
            val distance = rotation.drop(1).toInt()
            if (direction == 'L') {
                current = (current - distance).mod(100)
            }
            if (direction == 'R') {
                current = (current + distance).mod(100)
            }
            if (current == 0) {
                1
            } else {
                0
            }
        }
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    val input = readInput("input1")
    part1(input).println()
    part2(input).println()
}
