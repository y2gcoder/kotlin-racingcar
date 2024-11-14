package week1.step3

class Car(var position: Int = DEFAULT_POSITION) {
    fun move(randomNumber: Int) {
        when (randomNumber) {
            in STOPPING_NUMBERS -> return
            in FORWARDING_NUMBERS -> position++
            else -> throw IllegalArgumentException("0-9 사이의 randomNumber 가 아닙니다: randomNumber=$randomNumber")
        }
    }

    companion object {
        const val DEFAULT_POSITION = 0
        private val FORWARDING_NUMBERS = listOf(4, 5, 6, 7, 8, 9)
        private val STOPPING_NUMBERS = listOf(0, 1, 2, 3)
    }
}
