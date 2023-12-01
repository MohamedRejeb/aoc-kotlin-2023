fun main() {
    val day = "Day01"

    fun part1(input: List<String>): Int {
        return input.sumOf { line ->
            val firstDigit = line.first { it.isDigit() }.digitToInt()
            val lastDigit = line.last { it.isDigit() }.digitToInt()
            "$firstDigit$lastDigit".toInt()
        }
    }

    fun part2(input: List<String>): Int {
        return input.sumOf { line ->
            val firstDigit = line.firstDigit()
            val lastDigit = line.lastDigit()
            "$firstDigit$lastDigit".toInt()
        }
    }

    // test if implementation meets criteria from the description, like:
    val part1TestInput = readInput("${day}_part01_test")
    check(part1(part1TestInput) == 142)
    val part2TestInput = readInput("${day}_part02_test")
    check(part2(part2TestInput) == 281)

    val part1Input = readInput("${day}_part01")
    val part2Input = readInput("${day}_part02")
    part1(part1Input).println()
    part2(part2Input).println()
}

private val letterDigits = mapOf(
    1 to "one",
    2 to "two",
    3 to "three",
    4 to "four",
    5 to "five",
    6 to "six",
    7 to "seven",
    8 to "eight",
    9 to "nine",
)

private fun String.firstDigit(): Int {
    val (digit, _) = letterDigits.minBy { (key, value) ->
        val keyIndex = indexOf(key.toString()).let {
            if (it == -1) length else it
        }
        val valueIndex = indexOf(value).let {
            if (it == -1) length else it
        }
        kotlin.math.min(keyIndex, valueIndex)
    }

    return digit
}

private fun String.lastDigit(): Int {
    val (digit, _) = letterDigits.maxBy { (key, value) ->
        val keyIndex = lastIndexOf(key.toString())
        val valueIndex = lastIndexOf(value)
        kotlin.math.max(keyIndex, valueIndex)
    }

    return digit
}