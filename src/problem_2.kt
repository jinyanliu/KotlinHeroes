import java.util.*

/**
 * B. Square?
 * Input
 * 3
 * 2 3
 * 3 1
 * 3 2
 * 1 3
 * 3 3
 * 1 3
 * Output
 * Yes
 * Yes
 * No
 */
fun main() {
    val inputList = arrayListOf<Int>()
    val scanner = Scanner(System.`in`)
    val numberOfCases = scanner.nextLine().trim().toInt()

    val resultList = arrayListOf<Boolean>()

    for (i in 1..numberOfCases * 2) {
        val (a, b) = scanner.nextLine().split(' ').map { it.toInt() }
        inputList.add(a)
        inputList.add(b)
    }

    for (x in 0 until inputList.size step 4) {

        val (a, b, c, d) = listOf(inputList[x], inputList[x + 1], inputList[x + 2], inputList[x + 3])

        if (a == 0 || b == 0 || c == 0 || d == 0) {
            resultList.add(false)
            continue
        }

        var rec1LongSide = 0
        var rec1ShortSide = 0
        var rec2LongSide = 0
        var rec2ShortSide = 0

        if (a > b) {
            rec1LongSide = a
            rec1ShortSide = b
        } else {
            rec1LongSide = b
            rec1ShortSide = a
        }

        if (c > d) {
            rec2LongSide = c
            rec2ShortSide = d
        } else {
            rec2LongSide = d
            rec2ShortSide = c
        }

        if (rec1LongSide == rec2LongSide && (rec1ShortSide + rec2ShortSide == rec1LongSide)) {
            resultList.add(true)
        } else {
            resultList.add(false)
        }
    }

    for (result in resultList) {
        if (result) println("Yes") else println("No")
    }
}