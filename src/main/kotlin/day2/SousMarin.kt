package day2

private const val AVANCER = "forward"
private const val PLONGER = "down"
private const val MONTER = "up"

class SousMarin(private val instructionsInput: List<String>) {
    private var coordonnées = Coordonnées(0, 0)
    private var visée = 0

    fun activerAutoPilote() {
        coordonnées = lireInstructions()
            .fold(coordonnées) { mouvement, instruction -> mouvement + instruction.enCoordonnées() }
    }

    fun activerAutoPiloteAvecCorrection() {
        lireInstructionsCorrigées().forEach(::suivreInstructions)
    }

    fun localisation(): Coordonnées {
        return coordonnées
    }

    private fun lireInstructions(): List<Instruction> {
        return instructionsInput.map { lireInstruction(it) }
    }

    private fun lireInstruction(instructionBrute: String): Instruction {
        return Instruction(instructionBrute)
    }

    private fun lireInstructionsCorrigées(): List<InstructionCorrigée> {
        return instructionsInput.map { lireInstructionCorrigée(it) }
    }

    private fun suivreInstructions(instruction: InstructionCorrigée) {
        when (instruction.commande) {
            AVANCER -> coordonnées += Coordonnées(instruction.valeur, instruction.valeur * visée)
            PLONGER -> visée += instruction.valeur
            MONTER -> visée -= instruction.valeur
        }
    }

    private fun lireInstructionCorrigée(instructionBrute: String): InstructionCorrigée {
        return InstructionCorrigée(instructionBrute)
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

    class InstructionCorrigée(instructionBrute: String) {
        val commande = instructionBrute.split(" ")[0]
        val valeur = instructionBrute.split(" ")[1].toInt()
    }
}