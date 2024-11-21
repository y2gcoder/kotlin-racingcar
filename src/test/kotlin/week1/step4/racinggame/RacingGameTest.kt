package week1.step4.racinggame

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldBeIn
import io.kotest.matchers.shouldBe

val alwaysMovingNumberGenerator = RandomNumberGenerator { 4 }

class RacingGameTest : StringSpec({
    "RacingGame의 레이스를 시작하기 위해서는 라운드가 1 이상이어야 한다" {
        val carRoster = CarRoster(listOf("pobi", "crong", "honux"))
        val sut = RacingGame(carRoster, alwaysMovingNumberGenerator)
        shouldThrow<IllegalArgumentException> {
            sut.race(0)
        }
    }

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
                car.getName() shouldBeIn carNames
                roundPosition shouldBe expectedPosition
            }
        }
    }

    "RacingGame 에서 레이스 실행 후 우승자들을 받을 수 있다(3팀 무조건 전진)" {
        val carNames = listOf("pobi", "crong", "honux")
        val carRoster = CarRoster(carNames)

        val sut = RacingGame(carRoster, alwaysMovingNumberGenerator)

        val round = 5
        sut.race(round)

        val results = sut.getWinners()

        results.size shouldBe 3
        results.forEach { car ->
            car.getName() shouldBeIn carNames
            car.position shouldBe round
        }
    }

    "RacingGame 에서 레이스 실행 후 우승자들을 받을 수 있다(1팀 무조건 전진, 2팀 무조건 멈춤)" {
        val carNames = listOf("pobi", "crong", "honux")
        val carRoster = CarRoster(carNames)

        val candidates = listOf(4, 3, 3)
        var index = 0
        val onlyFirstCarAlwaysMoveGenerator =
            RandomNumberGenerator {
                candidates[index++ % candidates.size]
            }

        val sut = RacingGame(carRoster, onlyFirstCarAlwaysMoveGenerator)

        val round = 5
        sut.race(round)

        val results = sut.getWinners()

        results.size shouldBe 1
        results[0].getName() shouldBe "pobi"
        results[0].position shouldBe round
    }
})
