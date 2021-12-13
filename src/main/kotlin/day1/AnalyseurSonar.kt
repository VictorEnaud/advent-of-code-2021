package day1

class AnalyseurSonar(private val relevésDeProfondeurInput: List<String>) {
    val relevésDeProfondeur = relevésDeProfondeurInput.map { it.toInt() }

    fun compterAugmentationsDeProfondeurFinement(): Int {
        var relevéPrécédent = relevésDeProfondeur.first()
        var nombreDAugmentations = 0
        relevésDeProfondeur.forEach {
            if(it > relevéPrécédent) {
                nombreDAugmentations += 1
            }
            relevéPrécédent = it
        }
        return nombreDAugmentations
    }

    fun compterAugmentationsDeProfondeurLissé(): Int {
        var nombreDAugmentations = 0
        for (i in 3 until relevésDeProfondeur.size) {
            val lissagePrécédent = relevésDeProfondeur.slice(i-3 until i).sum()
            val lissageCourant = relevésDeProfondeur.slice(i-2..i).sum()
            if(lissageCourant > lissagePrécédent)
                nombreDAugmentations+=1
        }
        return nombreDAugmentations
    }
}