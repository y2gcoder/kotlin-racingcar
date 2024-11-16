package week1.step3

import kotlin.random.Random

class RacingGame(
    carCount: Int,
    private val randomNumber: () -> Int = { Random.nextInt(0, 10) },
) {
    private val cars: List<Car>

    init {
        validateCarCount(carCount)
        cars = List(carCount) { Car() }
    }

    private fun validateCarCount(carCount: Int) {
        if (carCount <= 0) {
            throw IllegalArgumentException("레이싱 게임을 하기 위해서는 차가 1대 이상이어야 합니다.")
        }
    }

    fun race(round: Int): List<RoundResult> {
        validateRound(round)
        return (0 until round).map {
            moveAllCarPerRound()
            getRoundResult()
        }
    }

    private fun moveAllCarPerRound() {
        cars.forEach { it.move(randomNumber()) }
    }

    private fun getRoundResult() = RoundResult(cars.associateWith { it.position })
}

private fun validateRound(round: Int) {
    if (round <= 0) {
        throw IllegalArgumentException("레이스는 1라운드 이상이어야 합니다.")
    }
}

data class RoundResult(val result: Map<Car, Int>)
