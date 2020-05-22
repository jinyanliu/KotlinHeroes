import java.util.*

/**
 * A. A+B (Trial Problem)
 * Input
 * 4
 * 1 5
 * 314 15
 * -99 99
 * 123 987
 * Output
 * 6
 * 329
 * 0
 * 1110
 */
fun main() {
    val resultList = arrayListOf<Int>()
    val scanner = Scanner(System.`in`)
    val numberOfCases = scanner.nextLine().trim().toInt()

    for (i in 1..numberOfCases) {
        val (a, b) = scanner.nextLine().split(' ').map { it.toInt() }
        resultList.add(a + b)
    }

    for (result in resultList) {
        println(result)
    }
}