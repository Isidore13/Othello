https://code-with-me.global.jetbrains.com/fuugTa6W84DQwkD4avLPnQ#p=IU&fp=A9D8B60CD46713034CC165ECAB8474A432F4C6329F969FE3768E05A6CBD10124&newUi=false

import java.util.Scanner;

public class Methode {
    public static void main(String[] args) {
        char[][] plateau = creationPlateau();
        placementPion(plateau,saisieutilisateur(plateau));
    }


    public static char[][] creationPlateau() {
        //plateau[y][x]
        char[][] plateau = {{'\0', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'},
                {'1', '*', '*', '*', '*', '*', '*', '*', '*'},
                {'2', '*', '*', '*', '*', '*', '*', '*', '*'},
                {'3', '*', '*', '*', '*', '*', '*', '*', '*'},
                {'4', '*', '*', '*', 'B', 'W', '*', '*', '*'},
                {'5', '*', '*', '*', 'W', 'B', '*', '*', '*'},
                {'6', '*', '*', '*', '*', '*', '*', '*', '*'},
                {'7', '*', '*', '*', '*', '*', '*', '*', '*'},
                {'8', '*', '*', '*', '*', '*', '*', '*', '*'}};

        return plateau;


    }

    public static int[] saisieutilisateur(char[][] plateau) {

        Scanner scanner = new Scanner(System.in);

        String positionPion;
        int[] positionFinale = new int[2];
        boolean verification = false;

        do {
            System.out.print("Saisissez l'emplacement où placer le pion : ");
            positionPion = scanner.nextLine();

            if (positionPion.length() != 2 || positionPion.charAt(0) < 'A' || positionPion.charAt(0) > 'H' || positionPion.charAt(1) < '1' || positionPion.charAt(1) > '8') {
                System.out.println("Erreur saisisser une valeur entre (A et H) en majuscule et une valeur entre (1 et 8) par exemple E5");
            } else {
                verification = true;
                positionFinale[0] = ((int) positionPion.charAt(0)) - 64; // 64 car 'A' - 64 egale 1 pour avoir les coordonnee
                positionFinale[1] = ((int) positionPion.charAt(1)) - 48; //48 car '1' egale 49 donc si l'on soustrait 48 '1' egale 1
                //Verifie si un pion existe à l'emplacement choisi
                if (plateau[positionFinale[0]][positionFinale[1]] != '*') {
                    verification = false;
                    System.out.println("Il y à déjà un pion ici.");
                }

            }

        } while (verification == false);
        return positionFinale;
    }

    public static char[][] placementPion(char[][] plateau, int [] coordonées) {
        plateau[coordonées[0]][coordonées[1]] = 'W';

        return plateau;
    }
}
