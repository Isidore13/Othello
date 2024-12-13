https://code-with-me.global.jetbrains.com/fuugTa6W84DQwkD4avLPnQ#p=IU&fp=A9D8B60CD46713034CC165ECAB8474A432F4C6329F969FE3768E05A6CBD10124&newUi=false

import java.util.Scanner;

public class Methode {
    public static void main(String[] args) {
        jeu();
    }

    public static char[][] creationPlateau() {
        //plateau[y][x]
        char[][] plateau = {{' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',' '},
                {'1', '*', '*', '*', '*', '*', '*', '*', '*','1'},
                {'2', '*', '*', '*', '*', '*', '*', '*', '*','2'},
                {'3', '*', '*', '*', '*', '*', '*', '*', '*','3'},
                {'4', '*', '*', '*', 'N', 'W', '*', '*', '*','4'},
                {'5', '*', '*', '*', 'W', 'N', '*', '*', '*','5'},
                {'6', '*', '*', '*', '*', '*', '*', '*', '*','6'},
                {'7', '*', '*', '*', '*', '*', '*', '*', '*','7'},
                {'8', '*', '*', '*', '*', '*', '*', '*', '*','8'},
                {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',' '}
                };

        return plateau;


    }

    public static int[] saisieutilisateur(char[][] plateau) {
        //positionFinal = [y,x]
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
                positionFinale[1] = ((int) positionPion.charAt(0)) - 64; // 64 car 'A' - 64 egale 1 pour avoir les coordonnee
                positionFinale[0] = ((int) positionPion.charAt(1)) - 48; //48 car '1' egale 49 donc si l'on soustrait 48 '1' egale 1
                //Verifie si un pion existe à l'emplacement choisi
                if (plateau[positionFinale[0]][positionFinale[1]] != '*') {
                    verification = false;
                    System.out.println("Il y à déjà un pion ici.");
                }
                //verifie si il y a un pion a cote
                else if(verificationPlacement(plateau,positionFinale)==false){
                    verification=false;
                    System.out.println("Doit-être placer à côté d'un pion.");
                }

            }

        } while (verification == false);
        return positionFinale;
    }

    public static void placementPion(char[][] plateau, int[] coordonées, int tourjoueur) {
        if (tourjoueur == 1) {
            plateau[coordonées[0]][coordonées[1]] = 'W';
        } else {
            plateau[coordonées[0]][coordonées[1]] = 'N';
        }


    }

    // Cette fonction affiche l'état du plateau
    public static void afficherplateau(char[][] plateau) {
        for (int y = 0; y < plateau.length; y++) {
            for (int x = 0; x < plateau[y].length; x++) {
                System.out.print(plateau[y][x] + "\t");
            }
            System.out.println();
        }
    }

    // Cette fonction vérifie si le plateau est plein, il renvoie true s'il l'est sinon il renvoie false
    public static boolean plateauPlein(char[][] plateau) {
        for (int y = 0; y < plateau.length; y++) {
            for (int x = 0; x < plateau[y].length; x++) {
                if (plateau[y][x] == '*') {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean verificationPlacement(char[][] plateau, int[] coordonées) {
        for (int y = -1; y <= 1; y++) {
            for (int x = -1; x <= 1; x++) {
                if(plateau[coordonées[0]+y][coordonées[1]+x]=='N' || plateau[coordonées[0]+y][coordonées[1]+x]=='W'){
                    return true;
                }
            }

        }
        return false;
    }

    public static void verificationHorizontal(char[][] plateau, int[] coordonnee){

    }


    public static void jeu() {
        int tourJoueur = 1;
        char[][] plateau = creationPlateau();
        while (plateauPlein(plateau) == false) {
            afficherplateau(plateau);
            placementPion(plateau, saisieutilisateur(plateau), tourJoueur);

            if (tourJoueur == 1) {
                tourJoueur++;
            } else {
                tourJoueur--;
            }

        }
        afficherplateau(plateau);
    }


}
