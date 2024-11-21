package week1.step4.racinggame

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarRosterTest : StringSpec({
    "CarRoster는 자동차 이름 리스트를 받아 자동차 들을 생성할 수 있다" {
        val carNames = listOf("pobi", "crong", "honux")
        val sut = CarRoster(carNames)

        val result = sut.createCars()

        result.size shouldBe 3
        result.stream().map { it.getName() }.toList() shouldBe carNames
    }

    "자동차 이름 리스트는 하나 이상의 이름을 포함하고 있어야 한다" {
        val emptyCarNames = emptyList<String>()
        shouldThrow<IllegalArgumentException> {
            CarRoster(emptyCarNames)
        }
    }
})
