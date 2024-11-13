package week1.step2

class StringCalculator {
    fun calculate(input: String): Double {
        val parts = parseInput(input)
        val operations = createOperations(parts)
        return operations.executeAll()
    }

    private fun parseInput(input: String): List<String> {
        if (input.isBlank()) {
            throw IllegalArgumentException("입력값은 빈 문자열일 수 없습니다")
        }

        val parts = input.trim().split(" ")
        if (parts.size % 2 == 0) {
            throw IllegalArgumentException("올바르지 않은 형식의 계산식입니다: $input")
        }

        return listOf("+") + parts
    }

    private fun createOperations(parts: List<String>): Operations {
        return Operations(
            parts.chunked(2)
                .map { chunk ->
                    val operator = Operator.fromSymbol(chunk[0])
                    val operand =
                        chunk[1]
                            .toDoubleOrNull()
                            ?: throw IllegalArgumentException("피연산자는 숫자가 아닙니다: ${chunk[1]}")

                    Operation(operator, operand)
                },
        )
    }
}

class Operations(private val operations: List<Operation>) {
    fun executeAll(): Double {
        return operations.fold(0.0) { result, operation -> operation.operate(result) }
    }
}

class Operation(private val operator: Operator, private val operand: Double) {
    fun operate(initialValue: Double): Double {
        return operator.apply(initialValue, operand)
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
