package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val actual = Person(name = "양영근", nickname = "영근", age = 20)
        assertThat(actual.name).isEqualTo("양영근")
        assertThat(actual.age).isEqualTo(20)
        assertThat(actual.nickname).isEqualTo("영근")
    }

    @Test
    fun `널 타입`() {
        val actual = Person(name = "양영근", age = 20, nickname = null)
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val actual = Person(name = "양영근", age = 20)
        assertThat(actual.nickname).isEqualTo("양영근")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(name = "양영근", age = 20)
        val person2 = Person(name = "양영근", age = 20)
        assertThat(person1).isEqualTo(person2)
    }
}
