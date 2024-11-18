package week1.step4.racinggame

class Car(val name: String, position: Int = DEFAULT_POSITION) {
    init {
        require(name.isNotBlank()) {
            "자동차의 이름은 빈 문자열일 수 없습니다"
        }

        require(name.length <= 5) {
            "자동차의 이름은 5글자까지 허용합니다"
        }
    }

    var position: Int = position
        private set

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
