package day3

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class BinaireTest {
    @ParameterizedTest(name = "le binaire \"{0}\" est égal à {1} en décimal")
    @MethodSource("testValues")
    fun test(binaireString: String, décimal:Int) {
        // When
        val binaire = Binaire(binaireString)

        // Then
        assertThat(binaire.versDécimal()).isEqualTo(décimal)
    }

    private companion object {
        @JvmStatic
        fun testValues(): Stream<Arguments> = Stream.of(
            arguments("", 0),
            arguments("0", 0),
            arguments("1", 1),
            arguments("10", 2),
            arguments("11", 3),
            arguments("100", 4),
            arguments("101", 5),
            arguments("110", 6),
            arguments("111", 7),
        )
    }
}