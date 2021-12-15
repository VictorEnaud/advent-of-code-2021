package day3

import kotlin.math.pow
import kotlin.math.roundToInt

@JvmInline
value class Binaire(val valeur: String) {
    fun versDécimal(): Int = valeur.reversed()
        .mapIndexed { index, binaryNumber -> binaryNumber.digitToInt() * 2.0.pow(index) }
        .sum()
        .roundToInt()
}
