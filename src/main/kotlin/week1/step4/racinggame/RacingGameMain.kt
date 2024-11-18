package week1.step4.racinggame

fun main() {
    val carNames = InputView.inputCarNames()
    val racingGame = RacingGame(carRoster = CarRoster(carNames))

    val round = InputView.inputRound()
    val raceResult = racingGame.race(round)
    RacingGameRaceResultView.announceRaceResult(raceResult)

    val winners = racingGame.getWinners()
    RacingGameRaceResultView.announceRaceWinners(winners)
}
