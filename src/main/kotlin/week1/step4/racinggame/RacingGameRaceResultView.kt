package week1.step4.racinggame

class RacingGameRaceResultView {
    companion object {
        fun announceRaceResult(raceResult: List<RoundResult>) {
            println("실행 결과")
            raceResult.forEach { roundResult ->
                printRoundResult(roundResult)
            }
        }

        private fun printRoundResult(roundResult: RoundResult) {
            roundResult.result.forEach { (car, position) ->
                print("${car.name} : ")
                println("-".repeat(position))
            }
            println()
        }

        fun announceRaceWinners(winners: List<Car>) {
            println("${winners.joinToString(", ") { it.name }}가 최종 우승했습니다.")
        }
    }
}
