fun main() {
    fun part1(input: List<String>): Int =
        input.sumOf { str ->
            val charList = str
                .toList()
            val firstDigit = charList
                .find { it.isDigit() }
            val lastDigit = charList
                .reversed()
                .find { it.isDigit() }
            (firstDigit.toString() + lastDigit.toString()).toInt()
        }

    fun part2(input: List<String>): Int {
        val numbers = listOf(
            "zero",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine"
        )
        val reversedNumbers = numbers.map {
            it.reversed()
        }
        val fixedInputs = input.map { word ->
            val firstPair = word.findAnyOf(numbers)
            val lastPair = word.reversed().findAnyOf(reversedNumbers)

            val fixedWord = word.mapIndexed { index, c ->
                if (firstPair != null && index == firstPair.first) {
                    numbers.indexOf(firstPair.second).toString()
                } else if (lastPair != null && index == word.length - lastPair.first - 1) {
                    reversedNumbers.indexOf(lastPair.second).toString()
                } else {
                    c.toString()
                }
            }.joinToString()
            fixedWord
        }
        return part1(fixedInputs)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day01_1_test")
    println(part1(testInput))
    check(part1(testInput) == 56506)

    println(part2(testInput))
    check(part2(testInput) == 56017)
}
