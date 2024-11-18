package week1.step4.racinggame

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldBeIn
import io.kotest.matchers.shouldBe

val alwaysMovingNumberGenerator = RandomNumberGenerator { 4 }

class RacingGameTest : StringSpec({
    "RacingGame의 레이스를 실행하면 각 라운드마다 Car들의 위치를 표시해놓은 결과를 받을 수 있다" {
        val carNames = listOf("pobi", "crong", "honux")
        val carRoster = CarRoster(carNames)

        val sut = RacingGame(carRoster, alwaysMovingNumberGenerator)
        val round = 5

        val roundResults = sut.race(round)

        roundResults.size shouldBe round
        roundResults.forEachIndexed { index, roundResult ->
            val expectedPosition = index + 1
            roundResult.result.forEach { (car, roundPosition) ->
                car.name shouldBeIn carNames
                roundPosition shouldBe expectedPosition
            }
        }
    }

    "RacingGame의 레이스를 시작하기 위해서는 라운드가 1 이상이어야 한다" {
        val carRoster = CarRoster(listOf("pobi", "crong", "honux"))
        val sut = RacingGame(carRoster, alwaysMovingNumberGenerator)
        shouldThrow<IllegalArgumentException> {
            sut.race(0)
        }
    }
})
