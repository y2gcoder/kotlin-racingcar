package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val actual = Person(name = "홍길동", 20, nickname = "홍")
        assertThat(actual.name).isEqualTo("홍길동")
        assertThat(actual.age).isEqualTo(20)
        assertThat(actual.nickname).isEqualTo("홍")
    }

    @Test
    fun `널 타입`() {
        val actual = Person("홍길동", 20, null)
        assertThat(actual.name).isEqualTo("홍길동")
        assertThat(actual.age).isEqualTo(20)
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val actual = Person("홍길동", 20)
        assertThat(actual.name).isEqualTo("홍길동")
        assertThat(actual.age).isEqualTo(20)
        assertThat(actual.nickname).isEqualTo("홍길동")
    }

    @Test
    fun `데이터 클래스`() {
        val person = Person("홍길동", 20)
        val newPerson = Person("홍길동", 20)
        assertThat(person).isEqualTo(newPerson)
    }

    @Test
    fun `copy`() {
        val person = Person("홍길동", 20)
        assertThat(person.nickname).isEqualTo("홍길동")
        person.copy(nickname = "홍")
        assertThat(person.name).isEqualTo("홍길동")
        assertThat(person.age).isEqualTo(20)
        assertThat(person.nickname).isEqualTo("홍길동")
    }
}
