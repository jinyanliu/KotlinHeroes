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
        val (a, b, c, d) = listOf(inputList[x], inputList[x + 1], inputList[x + 2], inputList[x + 3]).sorted()
        val arrayList = arrayListOf(a, b, c, d)
        var hasEqual = false
        for (i in 0 until 3) {
            if (arrayList[i] == arrayList[i + 1]) {
                hasEqual = true
                val expectedValue = arrayList[i]
                if (expectedValue == 0) {
                    resultList.add(false)
                    break
                }

                var actualValue = 0

                arrayList.removeAt(i)
                arrayList.removeAt(i)
                for (side in arrayList) {
                    actualValue += side
                }

                resultList.add(expectedValue == actualValue)
                break
            }
        }
        if (!hasEqual) {
            resultList.add(false)
        }
    }

    for (result in resultList) {
        if (result) println("YES") else println("NO")
    }
}