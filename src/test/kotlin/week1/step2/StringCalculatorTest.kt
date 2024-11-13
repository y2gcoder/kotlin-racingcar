package week1.step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class StringCalculatorTest {
    private lateinit var sut: StringCalculator

    @BeforeEach
    fun setUp() {
        sut = StringCalculator()
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "1 + 1=2",
            "1 - 2=-1",
            "2 * 2=4",
            "2 / 2=1",
            "1 / 2=0.5",
            "2 + 3 * 4 / 2=10",
            "20 + 30 * 40 / 20=100",
            "10=10",
        ],
        delimiter = '=',
    )
    fun `문자열을 받아 사칙 연산을 수행할 수 있다`(
        input: String,
        expected: Double,
    ) {
        val result = sut.calculate(input)
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `연산식의 앞 뒤 공백이 있어도 연산을 수행할 수 있다`() {
        val input = " 2 + 3 * 4 / 2 "
        val result = sut.calculate(input)
        assertThat(result).isEqualTo(10.0)
    }

    @Test
    fun `입력값이 Blank이면 IllegalArgumentException 예외를 던진다`() {
        assertThatIllegalArgumentException().isThrownBy { sut.calculate(" ") }
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "1 # 2",
            "* 1 - 2",
        ],
    )
    fun `입력한 사칙 연산식이 올바르지 않을 때 IllegalArgumentException 예외를 던진다`(input: String) {
        assertThatIllegalArgumentException().isThrownBy { sut.calculate(input) }
    }
}
