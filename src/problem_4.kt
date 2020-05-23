import java.util.*

/**
 * D. Alice, Bob and Candies
 * Input
 * 7
 * 11
 * 3 1 4 1 5 9 2 6 5 3 5
 * 1
 * 1000
 * 3
 * 1 1 1
 * 13
 * 1 2 3 4 5 6 7 8 9 10 11 12 13
 * 2
 * 2 1
 * 6
 * 1 1 1 1 1 1
 * 7
 * 1 1 1 1 1 1 1
 * Output
 * 6 23 21
 * 1 1000 0
 * 2 1 2
 * 6 45 46
 * 2 2 1
 * 3 4 2
 * 4 4 3
 */
fun main() {

    val inputStringList = arrayListOf<String>()
    val scanner = Scanner(System.`in`)
    val numberOfCases = scanner.nextLine().trim().toInt()

    for (i in 1..numberOfCases * 2) {
        inputStringList.add(scanner.nextLine())
    }

    for (i in 1..inputStringList.size step 2) {
        var currentList = inputStringList[i].split(" ").map { it.toInt() }

        var aCounter = 0
        var bCounter = 0
        var aTurn = true
        var aEaten = 0
        var aEatenTotal = 0
        var bEaten = 0
        var bEatenTotal = 0
        var moveCounter = 0

        while (currentList.isNotEmpty()) {
            if (aTurn) {
                moveCounter += 1
                aTurn = false
                aCounter += 1

                var eatenValue = 0
                var eatenIndex = 0
                for (index in 0 until currentList.size) {
                    if (eatenValue > bEaten) {
                        eatenIndex = index
                        break
                    }
                    eatenValue += currentList[index]

                    if (index == currentList.size - 1) {
                        eatenIndex = currentList.size
                    }
                }

                aEaten = eatenValue
                aEatenTotal += aEaten
                currentList = currentList.subList(eatenIndex, currentList.size)

            } else {
                moveCounter += 1
                aTurn = true
                bCounter += 1

                var eatenValue = 0
                var eatenIndex = 0
                for (index in 0 until currentList.size) {
                    if (eatenValue > aEaten) {
                        eatenIndex = currentList.size - index
                        break
                    }
                    eatenValue += currentList[currentList.size - 1 - index]

                    if (currentList.size - 1 - index == 0) {
                        eatenIndex = 0
                    }
                }

                bEaten = eatenValue
                bEatenTotal += bEaten
                currentList = currentList.subList(0, eatenIndex)
            }
        }

        println("$moveCounter $aEatenTotal $bEatenTotal")

    }
}