package week1.step4.racinggame

class Car(name: String, position: Int = DEFAULT_POSITION) {
    val name = CarName(name)
    var position: Int = position
        private set

    fun move(randomNumber: RandomNumber) {
        if (canMove(randomNumber.value)) {
            position++
        }
    }

    fun getName(): String {
        return name.value
    }

    fun isWin(other: Car): Boolean {
        return position > other.position
    }

    fun isDraw(other: Car): Boolean {
        return position == other.position
    }

    private fun canMove(randomNumber: Int): Boolean {
        return randomNumber in FORWARDING_NUMBERS
    }

    companion object {
        const val DEFAULT_POSITION = 0
        private val FORWARDING_NUMBERS = listOf(4, 5, 6, 7, 8, 9)
    }
}
