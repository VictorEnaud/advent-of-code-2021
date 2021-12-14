package day2


data class Coordonnées(var horizontal: Int, var depth: Int) {
    operator fun plus(coordonnées: Coordonnées): Coordonnées {
        return Coordonnées(horizontal+coordonnées.horizontal, depth+coordonnées.depth)
    }
}
