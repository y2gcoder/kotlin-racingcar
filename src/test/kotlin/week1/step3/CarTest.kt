package week1.step3

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarTest : StringSpec({
    "Car는 4~9의 무작위 값을 받으면 한 칸 전진한다" {
        listOf(4, 5, 6, 7, 8, 9).forEach { randomNumber ->
            val sut = Car()
            val initialPosition = sut.position

            sut.move(randomNumber)

            val currentPosition = sut.position
            currentPosition shouldBe initialPosition + 1
        }
    }

    "Car는 0~3의 무작위 값을 받으면 그대로 멈춘다" {
        listOf(0, 1, 2, 3).forEach { randomNumber ->
            val sut = Car()
            val initialPosition = sut.position

            sut.move(randomNumber)

            val currentPosition = sut.position
            currentPosition shouldBe initialPosition
        }
    }

    "Car는 0~9 이외의 값을 받으면 InvalidArgumentException 예외를 던진다" {
        listOf(-1, 10).forEach { randomNumber ->
            val sut = Car()

            shouldThrow<IllegalArgumentException> {
                sut.move(randomNumber)
            }
        }
    }
})
