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

            val result = dfs(digit, arrayListOf(), originalList)
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

fun dfs(start: Int, path: MutableList<Int>, originalList: MutableList<Int>): List<Int>? {
    var result: List<Int>? = null

    val newPath = path.toMutableList()
    newPath.add(start)

    //println("Current path:" + printPath(path))
    //println("Current dfs path:" + printPath(newPath))

    if (newPath.size == originalList.size) {
        return newPath
    }

    val rangeList = arrayListOf<Int>(start - 4, start - 3, start - 2, start + 2, start + 3, start + 4)
    val candidateList = arrayListOf<Int>()
    for (number in rangeList) {
        if (number in originalList) {
            candidateList.add(number)
        }
    }

    //println("Candidates for $start is: $candidateList")

    for (candidate in candidateList) {
        if (!newPath.contains(candidate)) {
            if (result == null) {
                val resultPath = dfs(candidate, newPath, originalList)
                if (resultPath != null) {
                    result = resultPath
                }
            }
        }
    }

    return result
}

fun printPath(pathes: MutableList<Int>): String {
    var result = ""
    for (path in pathes) {
        result += path.toString()
        if (path != pathes.last()) {
            result = "$result->"
        }
    }
    return result
}