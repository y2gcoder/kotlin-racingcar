package week1.step3

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class CarRosterTest : StringSpec({

    "CarRoster를 만들기 위해서는 count가 0보다 커야 한다." {
        val count = 0

        shouldThrow<IllegalArgumentException> {
            CarRoster(count)
        }
    }
})
