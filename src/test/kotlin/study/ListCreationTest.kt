package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class ListCreationTest : StringSpec({
    "코틀린은 List의 특수한 생성자를 통해 입력 갯수만큼 리스트의 초깃값을 초기화할 수 있다." {
        val size = 10

        val sut: List<Int> = List(size) { 1 }

        sut.size shouldBe size

        sut.forAll { number ->
            number shouldBe 1
        }
    }
})
