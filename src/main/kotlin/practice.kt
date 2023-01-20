fun main(args: Array<String>) {
    println("숫자야구에 오신것을 환영합니다.")
  //  var result = generateThreeNums().toList()
  //  println("${result}")
    println("숫자 야구 게임에 필요한 숫자 3개를 입력하시면 됩니다.")
    var regame = true
    while(regame) {
        playGame()
        println("게임을 다시 시작하시겠습니까? [Y / N]")
        regame = shouldReplay()
    }
}
fun shouldReplay() :Boolean {
    var inputChar = readLine()
    while (inputChar.isNullOrBlank() || (inputChar != "Y" && inputChar != "N")) {
        println("값을 정확히 입력해주세요")
        inputChar = readLine()
    }
    return inputChar != "N"
}

fun playGame() {

    var result = generateThreeNums().toList()
    println("${result}")
    println("숫자 야구 게임에 필요한 숫자 3개를 입력하시면 됩니다.")
    var isWin = false
    for (i in 1..9) {
        val userInputNum = getNums()
        println("$i 회차 시도 $userInputNum 을 입력하셨습니다")

        val strike = countStrike(result, userInputNum)
        val ball = countBall(result, userInputNum)

        if (strike == 0 && ball == 0) {
            println("아웃입니다")
        } else if (strike == 3) {
            isWin = true
            break
        } else {
            println("$strike 스트라이크 $ball 볼")
        }
    }

    if (isWin) {
        println("승리하셨습니다.")
    } else {
        println("패배하였습니다. 정답은 $result 입니다")
    }
}


fun countStrike(result: List<Int>, userInputNum: List<Int>): Int {
    var strike = 0
    for (i in 0..2) {
        if (result[i] == userInputNum[i]) {
            strike = strike + 1
        }
    }
    return strike
}

fun countBall(result: List<Int>, userInputNum: List<Int>): Int {
    var ball = 0
    for (i in 0..2) {
        if (result.contains(userInputNum[i]) && result[i] !== userInputNum[i]) {
            ball = ball + 1
        }
    }
    return ball
}

fun generateThreeNums(): Set<Int> {
    var answer = mutableSetOf<Int>()
    val numList = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    while (answer.size < 3) {
        answer.add(numList.random())
    }
    return answer
}

fun getNums(): List<Int> {
    val numList = mutableListOf<Int>()
    for (i in 1..3) {
        println("$i 번째 숫자를 입력해주세요")
        var num = inputNumber()
        while (numList.contains(num)) {
            println("중복된 숫자입니다. 다시 입력해주세요")
            num = inputNumber()
        }
        numList.add(num)
    }
    return numList
}

private fun inputNumber(): Int {
    var result = readLine()
    while (result.isNullOrBlank() || !(result[0].isDigit()) || result.length >= 2) {
        println("문자, 빈칸, 중복숫자 금지!(넣으면 병준)")
        result = readLine()
    }
    return result.toInt()
}