package week1.step4.racinggame

fun main() {
    val carCount = InputView.inputNumber("자동차 대수는 몇 대인가요?")
    val round = InputView.inputNumber("시도할 횟수는 몇 회인가요?")

    val racingGame = RacingGame(carRoster = CarRoster(carCount))
    val raceResult = racingGame.race(round)

    RacingGameRaceResultView.announceRaceResult(raceResult)
}
