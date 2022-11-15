package calculator

import calculator.Operator.*
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class OperatorTest {

    @ParameterizedTest
    @MethodSource("successRecognitionOperatorTest")
    fun `input값이 사칙연산 기호라서 연산자 인식 성공`(input: String, result: Operator) {
        val actual = Operator.of(input)

        val expected = result
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource("failureRecognitionOperatorTest")
    fun `input값이 사칙연산 기호가 아닌 다른 문자라서 연산자 인식 실패`(input: String) {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy {
                Operator.of(input)
            }
    }

    companion object {

        @JvmStatic
        fun successRecognitionOperatorTest() = Stream.of(
            Arguments.of("+", PLUS),
            Arguments.of("-", MINUS),
            Arguments.of("*", MULTIPLE),
            Arguments.of("/", DIVIDE),
        )

        @JvmStatic
        fun failureRecognitionOperatorTest() = Stream.of(
            Arguments.of("1"),
            Arguments.of("ㅂ"),
            Arguments.of("q"),
            Arguments.of("!"),
        )
    }

}