package week1.step4.racinggame

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarTest : StringSpec({
    "Car 는 Empty 문자열을 이름으로 할 수 없다" {
        val name = ""
        shouldThrow<IllegalArgumentException> {
            Car(name)
        }
    }

    "Car 는 Blank 문자열을 이름으로 할 수 없다" {
        val name = " "
        shouldThrow<IllegalArgumentException> {
            Car(name)
        }
    }

    "Car는 5글자를 초과하는 이름을 가질 수 없다" {
        val name = "sixman"
        shouldThrow<IllegalArgumentException> {
            Car(name)
        }
    }

    "Car는 4~9의 무작위 값을 받으면 한 칸 전진한다" {
        listOf(4, 5, 6, 7, 8, 9).forEach { randomNumber ->
            val sut = Car("pobi")
            val initialPosition = sut.position

            sut.move(RandomNumber(randomNumber))

            val currentPosition = sut.position
            currentPosition shouldBe initialPosition + 1
        }
    }

    "Car는 0~3의 무작위 값을 받으면 그대로 멈춘다" {
        listOf(0, 1, 2, 3).forEach { randomNumber ->
            val sut = Car("pobi")
            val initialPosition = sut.position

            sut.move(RandomNumber(randomNumber))

            val currentPosition = sut.position
            currentPosition shouldBe initialPosition
        }
    }
})
