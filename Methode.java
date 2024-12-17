import java.util.Scanner;

public class Methode {


    public static char[][] creationPlateau() {
        //plateau[y][x]
        char[][] plateau = {{' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', ' '},
                {'1', '*', '*', '*', '*', '*', '*', '*', '*', '1'},
                {'2', '*', '*', '*', '*', '*', '*', '*', '*', '2'},
                {'3', '*', '*', '*', '*', '*', '*', '*', '*', '3'},
                {'4', '*', '*', '*', 'N', 'W', '*', '*', '*', '4'},
                {'5', '*', '*', '*', 'W', 'N', '*', '*', '*', '5'},
                {'6', '*', '*', '*', '*', '*', '*', '*', '*', '6'},
                {'7', '*', '*', '*', '*', '*', '*', '*', '*', '7'},
                {'8', '*', '*', '*', '*', '*', '*', '*', '*', '8'},
                {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', ' '}
        };

        return plateau;


    }

    public static int[] saisieUtilisateur(char[][] plateau, char tourjoueur) {
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
                else if (pionEncadrerEtPeutManger(plateau, positionFinale, tourjoueur, true) == false) {
                    verification = false;
                    System.out.println("Doit manger au moins un pion.");
                }

            }

        } while (verification == false);
        return positionFinale;
    }

    public static void placementPion(char[][] plateau, int[] coordonées, char tourjoueur) {
        if (tourjoueur == 'W') {
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


    public static boolean pionEncadrerEtPeutManger(char[][] plateau, int[] coordonnee, char tourjoueur, boolean mange) {
        boolean verifmanger = false;
        boolean encadrement = false;
        int[] pionVerifier = new int[2];
        //verifie toute les direction
        for (int y = -1; y <= 1; y++) {
            for (int x = -1; x <= 1; x++) {
                pionVerifier[0] = coordonnee[0];
                pionVerifier[1] = coordonnee[1];
                if (x != 0 || y != 0) {
                    while (plateau[pionVerifier[0] + y][pionVerifier[1] + x] != tourjoueur && plateau[pionVerifier[0] + y][pionVerifier[1] + x] != '*' && (pionVerifier[0] + y > 0 && pionVerifier[0] + y < 9) && (pionVerifier[1] + x > 0 && pionVerifier[1] + x < 9)) {
                        pionVerifier[0] += y;
                        pionVerifier[1] += x;
                    }
                    // verifie si bien pion alié
                    if (plateau[pionVerifier[0] + y][pionVerifier[1] + x] == tourjoueur) {
                        encadrement = true;
                    }
                    pionVerifier[0] = coordonnee[0];
                    pionVerifier[1] = coordonnee[1];
                    if (encadrement == true) {
                        while (plateau[pionVerifier[0] + y][pionVerifier[1] + x] != tourjoueur) {
                            pionVerifier[0] += y;
                            pionVerifier[1] += x;
                            if(mange){
                                plateau[pionVerifier[0]][pionVerifier[1]] = tourjoueur;
                            }
                            verifmanger = true;
                        }
                        encadrement = false;
                    }
                }
            }
        }
        return verifmanger;
    }

    public static boolean verifSiPeutJouer(char[][] plateau, char tourjoueur) {
        int[] coordonnee = new int[2];
        boolean peutJouer=false;
        for (int y = 1; y < 10; y++) {
            for (int x = 1; x < 10; x++) {
                coordonnee[0]=y;
                coordonnee[1]=x;
                if (pionEncadrerEtPeutManger(plateau, coordonnee,tourjoueur,false)){
                    peutJouer=true;
                }
            }
        }
        return peutJouer;

    }


    public static void jeu() {
        char tourJoueur = 'W';
        char[][] plateau = creationPlateau();
        while (plateauPlein(plateau) == false) {
            afficherplateau(plateau);
            placementPion(plateau, saisieUtilisateur(plateau, tourJoueur), tourJoueur);

            if (tourJoueur == 'W') {
                tourJoueur = 'N';
            } else {
                tourJoueur = 'W';
            }

        }
        afficherplateau(plateau);
        calculVictoire(plateau);
    }


    public static void calculVictoire(char[][] plateau) {
        int pionBlanc = 0;
        int pionNoir = 0;

        for (int y = -1; y <= 1; y++) {
            for (int x = -1; x <= 1; x++) {
                if (plateau[y][x] == 'W') {
                    pionBlanc++;
                } else
                    pionNoir++;
            }
        }

        if (pionBlanc > pionNoir) {
            System.out.println("Victoire des blancs");
        } else
            System.out.println("Victoire des noirs");
    }
}
