package week1.step3

class InputView {
    companion object {
        fun inputNumber(message: String): Int {
            println(message)
            return readln().toInt()
        }
    }
}
