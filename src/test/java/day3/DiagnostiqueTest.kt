package day3

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.io.File

val INPUT_DATA = File("src/test/resources/DAY_3_DATA.txt").readLines()

class DiagnostiqueTest {
    @Test
    fun `le taux gamma est égal à la concaténation des bits les plus communs à chaque position lorsqu'il y a un seul bit`() {
        // Given
        val data = listOf("0", "1", "1", "0", "0")
        val diagnostique = Diagnostique(data)

        // When
        val tauxGammaObtenu = diagnostique.obtenirTauxGamma()

        // Then
        val tauxGammaAttendu = Binaire("0")
        assertThat(tauxGammaObtenu).isEqualTo(tauxGammaAttendu)
    }

    @Test
    fun `le taux epsilon est égal à la concaténation des bits les moins communs à chaque position lorsqu'il y a plusieurs bits`() {
        // Given
        val data = listOf("0", "1", "1", "0", "0")
        val diagnostique = Diagnostique(data)

        // When
        val tauxEpsilonObtenu = diagnostique.obtenirTauxEpsilon()

        // Then
        val tauxEpsilonAttendu = Binaire("1")
        assertThat(tauxEpsilonObtenu).isEqualTo(tauxEpsilonAttendu)
    }

    @Test
    fun `le taux gamma est égal à la concaténation des bits les plus communs à chaque position lorsqu'il y a plusieurs bit`() {
        // Given
        val data = listOf("100", "001", "110", "010", "101")
        val diagnostique = Diagnostique(data)

        // When
        val tauxGammaObtenu = diagnostique.obtenirTauxGamma()

        // Then
        val tauxGammaAttendu = Binaire("100")
        assertThat(tauxGammaObtenu).isEqualTo(tauxGammaAttendu)
    }

    @Test
    fun `le taux epsilon est égal à la concaténation des bits les moins communs à chaque position lorsqu'il y a un seul bit`() {
        // Given
        val data = listOf("100", "001", "110", "010", "101")
        val diagnostique = Diagnostique(data)

        // When
        val tauxEpsilonObtenu = diagnostique.obtenirTauxEpsilon()

        // Then
        val tauxEpsilonAttendu = Binaire("011")
        assertThat(tauxEpsilonObtenu).isEqualTo(tauxEpsilonAttendu)
    }

    @Test
    fun `partie 1`() {
        // Given
        val diagnostique = Diagnostique(INPUT_DATA)

        // When
        val tauxGammaObtenu = diagnostique.obtenirTauxGamma()
        val tauxEpsilonObtenu = diagnostique.obtenirTauxEpsilon()

        // Then
        val tauxGammaAttendu = Binaire("011100101100")
        assertThat(tauxGammaObtenu).isEqualTo(tauxGammaAttendu)
        val tauxEpsilonAttendu = Binaire("100011010011")
        assertThat(tauxEpsilonObtenu).isEqualTo(tauxEpsilonAttendu)
        assertThat(tauxGammaObtenu.versDécimal()*tauxEpsilonObtenu.versDécimal()).isEqualTo(4147524)
    }
}