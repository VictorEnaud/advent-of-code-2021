package day3

class Diagnostique(donnéesDeDiagnostique: List<String>) {
    private val tauxGamma: String
    private val tauxEpsilon: String

    init {
        val nombreDeMesures = donnéesDeDiagnostique.size
        val colonnesDeBits = obtenirColonnesDeBits(donnéesDeDiagnostique)
        tauxGamma = colonnesDeBits.map { calculerBitGamma(it, nombreDeMesures) }.joinToString("")
        tauxEpsilon = tauxGamma.map { if (it == '0') '1' else '0' }.joinToString("")
    }

    private fun obtenirColonnesDeBits(donnéesDeDiagnostique: List<String>): List<String> {
        val nombreDeBits = donnéesDeDiagnostique[0].length
        val colonnesDeBits = List(nombreDeBits) { _ -> "" }.toMutableList()
        donnéesDeDiagnostique.forEach { line ->
            line.forEachIndexed { index, bit -> colonnesDeBits[index] = colonnesDeBits[index] + bit }
        }
        return colonnesDeBits
    }

    private fun calculerBitGamma(
        nBitsDesDonnéesDeDiagnostique: String,
        nombreDeMesures: Int
    ): Char {
        val nombreDe1 = nBitsDesDonnéesDeDiagnostique.count { it == '1' }
        val nombreDe0 = nombreDeMesures - nombreDe1
        if (nombreDe1 > nombreDe0) {
            return '1'
        } else {
            return '0'
        }
    }

    fun obtenirTauxGamma(): Binaire {
        return Binaire(tauxGamma)
    }

    fun obtenirTauxEpsilon(): Binaire {
        return Binaire(tauxEpsilon)
    }
}