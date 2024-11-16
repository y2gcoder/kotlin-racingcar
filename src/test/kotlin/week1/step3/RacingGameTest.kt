package week1.step3

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class RacingGameTest : StringSpec({

    "자동차 대수를 0 이하로 RacingGame을 생성할 수 없다" {
        val carCount = 0

        shouldThrow<IllegalArgumentException> {
            RacingGame(carCount)
        }
    }

    "RacingGame의 레이스를 실행하면 각 라운드마다 Car들의 위치를 표시해놓은 결과를 받을 수 있다" {
        val carCount = 3
        val sut = RacingGame(carCount) { 4 } // 무조건 전진
        val round = 5

        val roundResults = sut.race(round)

        roundResults.size shouldBe round
        roundResults.forEachIndexed { index, roundResult ->
            val expectedPosition = index + 1
            roundResult.result.values.forEach { carPosition ->
                carPosition shouldBe expectedPosition
            }
        }
    }

    "RacingGame의 레이스를 시작하기 위해서는 라운드가 1 이상이어야 한다" {
        val carCount = 0
        shouldThrow<IllegalArgumentException> {
            RacingGame(carCount)
        }
    }
})
