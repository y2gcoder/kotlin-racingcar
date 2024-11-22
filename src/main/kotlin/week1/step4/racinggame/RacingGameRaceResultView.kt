package week1.step4.racinggame

class RacingGameRaceResultView {
    companion object {
        fun announceRoundResult(cars: List<Car>) {
            cars.forEach {
                print("${it.getName()} : ")
                println("-".repeat(it.position))
            }
            println()
        }

        fun announceRaceWinners(winners: List<Car>) {
            println("${winners.joinToString(", ") { it.getName() }}가 최종 우승했습니다.")
        }
    }
}
