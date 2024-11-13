package week1.step2

class StringCalculator {
    fun calculate(input: String): Double {
        val trimmedInput = input.trim()
        if (trimmedInput.isEmpty()) {
            throw IllegalArgumentException("입력값은 빈 문자열일 수 없습니다")
        }

        // 첫번째 숫자 앞에 + 문자열 추가
        val targetInput = "+ $trimmedInput"

        // 문자열 파싱
        val parts = targetInput.split(" ")

        var result = 0.0

        // 2개씩 (operator , number)
        for (i in parts.indices.filter { i -> i % 2 == 0 }) {
            val numberString = parts[i + 1]
            val number = numberString.toDouble()
            val operatorSymbol = parts[i]

            result = Operator.fromSymbol(operatorSymbol).apply(result, number)
        }

        return result
    }
}

enum class Operator(val symbol: String, val apply: (Double, Double) -> Double) {
    ADD("+", { operand1, operand2 -> operand1 + operand2 }),
    SUBTRACT("-", { operand1, operand2 -> operand1 - operand2 }),
    MULTIPLY("*", { operand1, operand2 -> operand1 * operand2 }),
    DIVIDE("/", { operand1, operand2 -> operand1 / operand2 }),
    ;

    companion object {
        fun fromSymbol(symbol: String): Operator {
            return entries.firstOrNull { operator -> operator.symbol == symbol }
                ?: throw IllegalArgumentException("올바른 사칙 연산 기호가 아닙니다: symbol=$symbol")
        }
    }
}
