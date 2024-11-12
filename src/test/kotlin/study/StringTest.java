package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    void isBlank() {
        assertThat(" ".isBlank()).isTrue();
        assertThat("\n".isBlank()).isTrue();
        assertThat("\t".isBlank()).isTrue();
        assertThat("""\n""".isBlank())
    }

}
