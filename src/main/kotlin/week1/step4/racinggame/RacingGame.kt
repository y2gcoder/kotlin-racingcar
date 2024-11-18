package week1.step4.racinggame

import kotlin.random.Random

@JvmInline
value class CarRoster(private val carNames: List<String>) {
    init {
        require(carNames.isNotEmpty()) {
            "레이싱 게임을 하기 위해서는 차가 1대 이상이어야 합니다."
        }
    }

    fun createCars(): List<Car> {
        return carNames.map { Car(it) }
    }
}

fun interface RandomNumberGenerator {
    fun generate(): Int
}

class RacingGame(
    carRoster: CarRoster,
    private val randomNumberGenerator: RandomNumberGenerator = RandomNumberGenerator { Random.nextInt(0, 10) },
) {
    private val cars: List<Car> = carRoster.createCars()

    fun race(round: Int): List<RoundResult> {
        validateRound(round)
        return (0 until round).map {
            moveAllCarPerRound()
            getRoundResult()
        }
    }

    private fun validateRound(round: Int) {
        if (round <= 0) {
            throw IllegalArgumentException("레이스는 1라운드 이상이어야 합니다.")
        }
    }

    private fun moveAllCarPerRound() {
        cars.forEach {
            val randomNumber = randomNumberGenerator.generate()
            it.move(randomNumber)
        }
    }

    private fun getRoundResult() = RoundResult(cars.associateWith { it.position })

    fun getWinners(): List<Car> {
        val winnerPosition = cars.maxOf { it.position }
        return cars.filter { it.position == winnerPosition }
    }
}

data class RoundResult(val result: Map<Car, Int>)
