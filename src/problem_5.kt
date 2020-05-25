import java.util.*
import kotlin.math.abs

/**
 * E. Special Permutation
 * Input
 * 6
 * 10
 * 2
 * 4
 * 6
 * 7
 * 13
 * Output
 * 9 6 10 8 4 7 3 1 5 2
 * -1
 * 3 1 4 2
 * 5 3 6 2 4 1
 * 5 1 3 6 2 4 7
 * 13 9 7 11 8 4 1 3 5 2 6 10 12
 */
fun main() {
    val inputList = arrayListOf<Int>()
    val scanner = Scanner(System.`in`)
    val numberOfCases = scanner.nextLine().trim().toInt()

    for (i in 1..numberOfCases) {
        val a = scanner.nextLine().toInt()
        inputList.add(a)
    }

    for (input in inputList) {
        if (input in 1..3) {
            println("-1")
            continue
        }

        if (input == 4) {
            println("3 1 4 2")
            continue
        }

        val inputDigitList = (1..input).toList()

        val originalList = inputDigitList.toMutableList()
        val resultList = arrayListOf<Int>()

        for (digit in inputDigitList) {
            if (digit % 2 != 0) {
                resultList.add(originalList.removeAt(originalList.indexOf(digit)))
            }
        }

        while (originalList.size > 0) {
            val reversedLeftOverList = originalList.reversed()
            for (item in reversedLeftOverList) {
                if (abs(resultList.last() - item) in 2..4) {
                    resultList.add(originalList.removeAt(originalList.indexOf(item)))
                    break
                }
            }
        }

        var resultString = ""
        for (result in resultList) {
            resultString += "$result "
        }

        println(resultString)

    }
}