package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringTest {
    @Test
    fun isBlank() {
        assertThat(" ".isBlank()).isTrue()
        assertThat("\n".isBlank()).isTrue()
        assertThat("\t".isBlank()).isTrue()
        assertThat("""\n""".isBlank()).isFalse()
    }
}
