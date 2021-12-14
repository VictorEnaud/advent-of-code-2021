package day2

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.io.File

val INPUT_DATA = File("src/test/resources/DAY_2_DATA.txt").readLines()

class SousMarinTest {
    @Test
    fun `le sous-marin commence à 0-0`() {
        // Given
        val data = emptyList<String>()
        val sousMarin = SousMarin(data)

        // When
        sousMarin.activerAutoPilote()

        // Then
        val coordonnéesAtteintes = sousMarin.localisation()
        val coordonnéesAttendues = Coordonnées(0, 0)
        assertThat(coordonnéesAtteintes).isEqualTo(coordonnéesAttendues)
    }

    @Test
    fun `le sous-marin est capable d'avancer`() {
        // Given
        val data = listOf("forward 5", "forward 4")
        val sousMarin = SousMarin(data)

        // When
        sousMarin.activerAutoPilote()

        // Then
        val coordonnéesAtteintes = sousMarin.localisation()
        val coordonnéesAttendues = Coordonnées(9, 0)
        assertThat(coordonnéesAtteintes).isEqualTo(coordonnéesAttendues)
    }

    @Test
    fun `le sous-marin est capable de plonger`() {
        // Given
        val data = listOf("down 5", "down 3")
        val sousMarin = SousMarin(data)

        // When
        sousMarin.activerAutoPilote()

        // Then
        val coordonnéesAtteintes = sousMarin.localisation()
        val coordonnéesAttendues = Coordonnées(0, 8)
        assertThat(coordonnéesAtteintes).isEqualTo(coordonnéesAttendues)
    }

    @Test
    fun `le sous-marin est capable de remonter`() {
        // Given
        val data = listOf("down 8", "up 5")
        val sousMarin = SousMarin(data)

        // When
        sousMarin.activerAutoPilote()

        // Then
        val coordonnéesAtteintes = sousMarin.localisation()
        val coordonnéesAttendues = Coordonnées(0, 3)
        assertThat(coordonnéesAtteintes).isEqualTo(coordonnéesAttendues)
    }

    @Test
    fun `partie 1`() {
        // Given
        val sousMarin = SousMarin(INPUT_DATA)

        // When
        sousMarin.activerAutoPilote()

        // Then
        val coordonnéesAtteintes = sousMarin.localisation()
        val coordonnéesAttendues = Coordonnées(1957, 955)
        assertThat(coordonnéesAtteintes).isEqualTo(coordonnéesAttendues)
    }

    @Test
    fun `le sous-marin avance sans plonger ou descendre à l'origine`() {
        // Given
        val data = listOf("forward 5", "forward 4")
        val sousMarin = SousMarin(data)

        // When
        sousMarin.activerAutoPiloteAvecCorrection()

        // Then
        val coordonnéesAtteintes = sousMarin.localisation()
        val coordonnéesAttendues = Coordonnées(9, 0)
        assertThat(coordonnéesAtteintes).isEqualTo(coordonnéesAttendues)
    }

    @Test
    fun `le sous-marin plonge lorsque qu'il vise vers le bas`() {
        // Given
        val data = listOf("down 5", "forward 5")
        val sousMarin = SousMarin(data)

        // When
        sousMarin.activerAutoPiloteAvecCorrection()

        // Then
        val coordonnéesAtteintes = sousMarin.localisation()
        val coordonnéesAttendues = Coordonnées(5, 25)
        assertThat(coordonnéesAtteintes).isEqualTo(coordonnéesAttendues)
    }

    @Test
    fun `le sous-marin remonte lorsqu'il vise vers le haut`() {
        // Given
        val data = listOf("down 5", "forward 5", "up 6", "forward 2")
        val sousMarin = SousMarin(data)

        // When
        sousMarin.activerAutoPiloteAvecCorrection()

        // Then
        val coordonnéesAtteintes = sousMarin.localisation()
        val coordonnéesAttendues = Coordonnées(7, 23)
        assertThat(coordonnéesAtteintes).isEqualTo(coordonnéesAttendues)
    }

    @Test
    fun `le sous-marin reste à la même profondeur lorsqu'il vise à 0`() {
        // Given
        val data = listOf("down 5", "forward 5", "up 5", "forward 2")
        val sousMarin = SousMarin(data)

        // When
        sousMarin.activerAutoPiloteAvecCorrection()

        // Then
        val coordonnéesAtteintes = sousMarin.localisation()
        val coordonnéesAttendues = Coordonnées(7, 25)
        assertThat(coordonnéesAtteintes).isEqualTo(coordonnéesAttendues)
    }

    @Test
    fun `partie 2`() {
        // Given
        val sousMarin = SousMarin(INPUT_DATA)

        // When
        sousMarin.activerAutoPiloteAvecCorrection()

        // Then
        val coordonnéesAtteintes = sousMarin.localisation()
        val coordonnéesAttendues = Coordonnées(1957, 1004584)
        assertThat(coordonnéesAtteintes).isEqualTo(coordonnéesAttendues)
    }
}