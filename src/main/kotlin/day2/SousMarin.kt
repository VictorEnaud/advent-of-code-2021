package day2

private const val AVANCER = "forward"
private const val PLONGER = "down"
private const val MONTER = "up"

class SousMarin(private val instructionsInput: List<String>) {
    private var coordonnées = Coordonnées(0, 0)

    fun activerAutoPilote() {
        coordonnées = lireInstructions()
            .fold(coordonnées) { mouvement, instruction -> mouvement + instruction.enCoordonnées() }
    }

    private fun lireInstructions(): List<Instruction> {
        return instructionsInput.map { lireInstruction(it) }
    }

    private fun lireInstruction(instructionBrute: String): Instruction {
        return Instruction(instructionBrute)
    }

    fun localisation(): Coordonnées {
        return coordonnées
    }

    class Instruction(instructionBrute: String) {
        private val commande = instructionBrute.split(" ")[0]
        private val distance = instructionBrute.split(" ")[1].toInt()

        fun enCoordonnées(): Coordonnées {
            return when (commande) {
                AVANCER -> Coordonnées(distance, 0)
                PLONGER -> Coordonnées(0, distance)
                MONTER -> Coordonnées(0, -distance)
                else -> Coordonnées(0, 0)
            }
        }
    }
}