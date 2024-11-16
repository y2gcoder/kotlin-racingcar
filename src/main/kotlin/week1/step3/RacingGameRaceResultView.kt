package week1.step3

class RacingGameRaceResultView {
    companion object {
        fun announceRaceResult(raceResult: List<RoundResult>) {
            println("실행 결과")
            raceResult.forEach { roundResult ->
                printRoundResult(roundResult)
            }
        }

        private fun printRoundResult(roundResult: RoundResult) {
            roundResult.result.forEach { (_, position) ->
                printCarPosition(position)
            }
            println()
        }

        private fun printCarPosition(position: Int) {
            println("-".repeat(position))
        }
    }
}
