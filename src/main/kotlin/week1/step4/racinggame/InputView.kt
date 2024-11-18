package week1.step4.racinggame

class InputView {
    companion object {
        fun inputNumber(message: String): Int {
            println(message)
            return readln().toInt()
        }
    }
}
