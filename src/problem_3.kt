import java.util.*


/**
 * C. Sum of Round Numbers
 * Input
 * 5
 * 5009
 * 7
 * 9876
 * 10000
 * 10
 * Output
 * 2
 * 5000 9
 * 1
 * 7
 * 4
 * 800 70 6 9000
 * 1
 * 10000
 * 1
 * 10
 */
fun main() {
    val inputList = arrayListOf<Int>()
    val scanner = Scanner(System.`in`)
    val numberOfCases = scanner.nextLine().trim().toInt()
    val resultList = arrayListOf<String>()

    for (i in 1..numberOfCases) {
        val a = scanner.nextLine().toInt()
        inputList.add(a)
    }

    for (result in inputList) {
        var cou = 0
        val resultStringList = result.toString()
        val reversedString = resultStringList.reversed()

        var currentString = ""
        for (index in 0 until reversedString.length) {

            var char = reversedString[index].toString()

            if (!char.equals("0")) {
                cou += 1
                for (counter in 0 until index) {
                    char += "0"

                }
                currentString += "$char "
            }
        }
        resultList.add(cou.toString())
        resultList.add(currentString)
    }

    for (re in resultList) {
        println(re)
    }
}