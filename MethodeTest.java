import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MethodeTest {

    @org.junit.jupiter.api.Test
    void calculVictoire() {

        char[][] plateau = {
                {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', ' '},
                {'1', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', '1'},
                {'2', 'r', 'r', 'r', 'r', 'r', 'b', 'b', 'b', '2'},
                {'3', 'b', 'r', 'r', 'r', 'r', 'b', 'r', 'b', '3'},
                {'4', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', '4'},
                {'5', 'r', 'b', 'r', 'r', 'b', 'r', 'r', 'b', '5'},
                {'6', 'r', 'r', 'b', 'r', 'r', 'r', 'r', 'r', '6'},
                {'7', 'b', 'r', 'r', 'b', 'r', 'r', 'b', 'r', '7'},
                {'8', 'b', 'b', 'r', 'r', 'r', 'r', 'b', 'b', '8'},
                {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', ' '}
        };
        assertEquals(0,Methode.calculVictoire(plateau), "Cas Victoire des rouges");

        char[][] plateau2 = {
                {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', ' '},
                {'1', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', '1'},
                {'2', 'b', 'b', 'b', 'b', 'b', 'r', 'r', 'r', '2'},
                {'3', 'r', 'b', 'b', 'b', 'b', 'r', 'b', 'r', '3'},
                {'4', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', '4'},
                {'5', 'b', 'r', 'b', 'b', 'r', 'b', 'b', 'r', '5'},
                {'6', 'b', 'b', 'r', 'b', 'b', 'b', 'b', 'b', '6'},
                {'7', 'r', 'b', 'b', 'r', 'b', 'b', 'r', 'b', '7'},
                {'8', 'r', 'r', 'b', 'b', 'b', 'b', 'r', 'r', '8'},
                {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', ' '}
        };
        assertEquals(1,Methode.calculVictoire(plateau2), "Cas Victoire des bleu");


        char[][] plateau3 = {
                {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', ' '},
                {'1', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', '1'},
                {'2', 'b', 'b', 'b', 'b', 'b', 'r', 'r', 'r', '2'},
                {'3', 'r', 'b', 'b', 'b', 'r', 'r', 'b', 'r', '3'},
                {'4', 'b', 'b', 'b', 'b', 'b', 'b', 'r', 'b', '4'},
                {'5', 'b', 'r', 'b', 'b', 'r', 'b', 'r', 'r', '5'},
                {'6', 'b', 'r', 'r', 'r', 'b', 'r', 'b', 'b', '6'},
                {'7', 'r', 'b', 'b', 'r', 'b', 'r', 'r', 'b', '7'},
                {'8', 'r', 'r', 'b', 'b', 'b', 'b', 'r', 'r', '8'},
                {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', ' '}
        };
        assertEquals(2,Methode.calculVictoire(plateau3), "Cas Egalité");


    }

    @Test
    void plateauPlein() {

        char[][] plateauPlein = {
                {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', ' '},
                {'1', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'r', '1'},
                {'2', 'r', 'r', 'r', 'r', 'b', 'b', 'r', 'b', '2'},
                {'3', 'b', 'r', 'r', 'r', 'r', 'b', 'r', 'r', '3'},
                {'4', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', '4'},
                {'5', 'r', 'b', 'r', 'r', 'b', 'r', 'r', 'b', '5'},
                {'6', 'r', 'r', 'b', 'r', 'r', 'r', 'r', 'r', '6'},
                {'7', 'b', 'r', 'r', 'b', 'r', 'r', 'b', 'r', '7'},
                {'8', 'b', 'b', 'r', 'r', 'r', 'r', 'b', 'b', '8'},
                {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', ' '}
        };
        assertTrue (Methode.plateauPlein(plateauPlein), "Cas Plateau plein");



        char[][] plateauNonPlein = {
                {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', ' '},
                {'1', '*', 'b', 'b', 'b', 'b', 'b', 'b', 'b', '1'},
                {'2', 'r', 'r', 'r', 'r', '*', 'b', 'b', 'b', '2'},
                {'3', 'b', 'r', 'r', 'r', 'r', 'b', '*', 'b', '3'},
                {'4', 'r', 'r', '*', 'r', 'r', 'r', 'r', 'r', '4'},
                {'5', 'r', 'b', 'r', 'r', 'b', 'r', 'r', 'b', '5'},
                {'6', 'r', '*', 'b', '*', 'r', 'r', 'r', 'r', '6'},
                {'7', 'b', 'r', 'r', 'b', 'r', '*', 'b', 'r', '7'},
                {'8', 'b', 'b', '*', 'r', 'r', 'r', 'b', 'b', '8'},
                {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', ' '}
        };
        assertFalse (Methode.plateauPlein(plateauNonPlein), "Cas Plateau non plein");

    }

    @Test
    void verifSiPeutJouer() {
        char[][] coupImpossiblePourBleu = {
                {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', ' '},
                {'1', 'r', '*', 'b', 'b', 'b', 'b', 'b', 'b', '1'},
                {'2', 'r', 'r', '*', 'b', 'b', 'b', 'b', 'b', '2'},
                {'3', 'r', 'r', 'r', 'b', 'b', 'b', 'b', 'b', '3'},
                {'4', 'r', 'r', 'r', 'r', 'b', 'b', 'b', 'b', '4'},
                {'5', 'r', 'r', 'r', 'b', 'r', 'b', 'b', 'b', '5'},
                {'6', 'r', 'r', 'b', 'r', 'b', 'r', 'b', 'b', '6'},
                {'7', 'r', 'r', 'b', 'b', 'r', 'b', 'r', 'b', '7'},
                {'8', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', '8'},
                {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', ' '}
        };
        assertFalse (Methode.verifSiPeutJouer(coupImpossiblePourBleu,'b'), "Cas Coup impossible pour les bleu");

    }
}
