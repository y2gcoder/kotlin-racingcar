package week1.step4.racinggame

fun main() {
    val carNames = InputView.inputCarNames()
    val racingGame = RacingGame(carRoster = CarRoster(carNames))

    val round = InputView.inputRound()
    println("실행 결과")
    (1..round).forEach {
        println("round: $it")
        racingGame.round()
        RacingGameRaceResultView.announceRoundResult(racingGame.cars)
    }

    val winners = racingGame.getWinners()
    RacingGameRaceResultView.announceRaceWinners(winners)
}
