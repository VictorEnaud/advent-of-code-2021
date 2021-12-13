package day1

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.io.File

val INPUT_DATA = File("src/test/resources/DAY_1_DATA.txt").readLines()

internal class AnalyseurSonarTest {
    @Test
    internal fun `l'analyseur n'a pas d'augmentation de la profondeur quand pas assez de données`() {
        // Given
        val data = listOf("200")
        val analyseurSonar = AnalyseurSonar(data)

        // When
        val augmentationDeProfondeurs = analyseurSonar.compterAugmentationsDeProfondeurFinement()

        // Then
        assertThat(augmentationDeProfondeurs).isEqualTo(0)
    }

    @Test
    internal fun `l'analyseur a une seule augmentation de la profondeur`() {
        // Given
        val data = listOf("200", "208")
        val analyseurSonar = AnalyseurSonar(data)

        // When
        val augmentationDeProfondeurs = analyseurSonar.compterAugmentationsDeProfondeurFinement()

        // Then
        assertThat(augmentationDeProfondeurs).isEqualTo(1)
    }

    @Test
    internal fun `l'analyseur a deux augmentations de profondeur sans compter les diminutions`() {
        // Given
        val data = listOf("200", "208", "198", "199")
        val analyseurSonar = AnalyseurSonar(data)

        // When
        val augmentationDeProfondeurs = analyseurSonar.compterAugmentationsDeProfondeurFinement()

        // Then
        assertThat(augmentationDeProfondeurs).isEqualTo(2)
    }

    @Test
    internal fun `partie 1`() {
        // Given
        val analyseurSonar = AnalyseurSonar(INPUT_DATA)

        // When
        val augmentationDeProfondeurs = analyseurSonar.compterAugmentationsDeProfondeurFinement()

        // Then
        assertThat(augmentationDeProfondeurs).isEqualTo(1448)
    }

    @Test
    internal fun `l'analyseur groupé n'a pas d'augmentation de la profondeur quand pas assez de données`() {
        // Given
        val data = listOf("199", "200", "208")
        val analyseurSonar = AnalyseurSonar(data)

        // When
        val augmentationDeProfondeurs = analyseurSonar.compterAugmentationsDeProfondeurLissé()

        // Then
        assertThat(augmentationDeProfondeurs).isEqualTo(0)
    }

    @Test
    internal fun `l'analyseur groupé a une seule augmentation de la profondeur`() {
        // Given
        val data = listOf("199", "200", "208", "210")
        val analyseurSonar = AnalyseurSonar(data)

        // When
        val augmentationDeProfondeurs = analyseurSonar.compterAugmentationsDeProfondeurLissé()

        // Then
        assertThat(augmentationDeProfondeurs).isEqualTo(1)
    }

    @Test
    internal fun `l'analyseur groupé a deux augmentations de profondeur sans compter les diminutions`() {
        // Given
        val data = listOf("199", "200", "208", "210", "200", "207", "240")
        val analyseurSonar = AnalyseurSonar(data)

        // When
        val augmentationDeProfondeurs = analyseurSonar.compterAugmentationsDeProfondeurLissé()

        // Then
        assertThat(augmentationDeProfondeurs).isEqualTo(2)
    }

    @Test
    internal fun `partie 2`() {
        // Given
        val analyseurSonar = AnalyseurSonar(INPUT_DATA)

        // When
        val augmentationDeProfondeurs = analyseurSonar.compterAugmentationsDeProfondeurLissé()

        // Then
        assertThat(augmentationDeProfondeurs).isEqualTo(1471)
    }
}