import java.util.*

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
        var hasResult = false

        val inputDigitList = (1..input).toList()

        val originalList = inputDigitList.toMutableList()

        for (digit in originalList) {

            val result = bfs(digit, originalList)
            var resultString = ""
            if (result != null) {
                for (item in result) {
                    resultString += "$item "
                }
                hasResult = true
                println(resultString)
                break
            }

        }

        if (!hasResult) {
            println(-1)
        }
    }
}

fun bfs(start: Int, originalList: MutableList<Int>): List<Int>? {
    val initPath = mutableListOf<Int>(start)
    val pathQueue = mutableListOf<MutableList<Int>>(initPath)

    while (pathQueue.size != 0) {
        val temPath = pathQueue.removeAt(0)
        //println("Current bfs path:" + printPath(temPath))
        if (temPath.size == originalList.size) {
            return temPath
        }

        val lastNode = temPath.last()

        val rangeList =
            arrayListOf<Int>(lastNode - 4, lastNode - 3, lastNode - 2, lastNode + 2, lastNode + 3, lastNode + 4)
        val candidateList = arrayListOf<Int>()
        for (number in rangeList) {
            if (number in originalList) {
                candidateList.add(number)
            }
        }

        for (candidate in candidateList) {
            if (!temPath.contains(candidate)) {
                val newPath = temPath.toMutableList()
                newPath.add(candidate)
                pathQueue.add(newPath)
            }
        }
    }
    return null
}