fun main() {
    fun part1(input: List<String>): Int {
        val grid = mutableListOf<Position>()
        input.mapIndexed { i, row ->
            row.mapIndexed { j, char ->
                grid += Position(i, j, char)
            }
        }
        val paperRollPositions = grid.filter { it.char == '@' }
        return paperRollPositions.count { (x, y, _) ->
            var count = 0
            for (direction in Direction.entries) {
                val (dx, dy) = direction.dx to direction.dy
                val hasAdjacent = grid.any { it.x == x + dx && it.y == y + dy && it.char == '@' }
                if (hasAdjacent) {
                    count++
                }
            }
            count < 4
        }
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    val input = readInput("input4")
    part1(input).println()
    part2(input).println()
}

data class Position(val x: Int, val y: Int, val char: Char)

enum class Direction(val dx: Int, val dy: Int) {
    UP(0, -1),
    DOWN(0, 1),
    LEFT(-1, 0),
    RIGHT(1, 0),
    DIAGONAL_1(-1, -1),
    DIAGONAL_2(1, -1),
    DIAGONAL_3(-1, 1),
    DIAGONAL_4(1, 1)
}
