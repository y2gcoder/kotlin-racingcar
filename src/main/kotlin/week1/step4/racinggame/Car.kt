package week1.step4.racinggame

class Car(name: String, position: Int = DEFAULT_POSITION) {
    val name = CarName(name)
    var position: Int = position
        private set

    fun move(randomNumber: Int) {
        validateRandomNumber(randomNumber)
        if (canMove(randomNumber)) {
            position++
        }
    }

    fun getName(): String {
        return name.value
    }

    private fun validateRandomNumber(randomNumber: Int) {
        if (randomNumber !in 0..9) {
            throw IllegalArgumentException("0-9 사이의 randomNumber 가 아닙니다: randomNumber=$randomNumber")
        }
    }

    private fun canMove(randomNumber: Int): Boolean {
        return randomNumber in FORWARDING_NUMBERS
    }

    companion object {
        const val DEFAULT_POSITION = 0
        private val FORWARDING_NUMBERS = listOf(4, 5, 6, 7, 8, 9)
    }
}
