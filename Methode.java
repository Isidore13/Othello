import java.util.ArrayList;
import java.util.Scanner;

public class Methode {

    public static char[][] creationPlateau() {
        //plateau[y][x]
        char[][] plateau = {
                {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', ' '},
                {'1', '*', '*', '*', '*', '*', '*', '*', '*', '1'},
                {'2', '*', '*', '*', '*', '*', '*', '*', '*', '2'},
                {'3', '*', '*', '*', '*', '*', '*', '*', '*', '3'},
                {'4', '*', '*', '*', 'b', 'r', '*', '*', '*', '4'},
                {'5', '*', '*', '*', 'r', 'b', '*', '*', '*', '5'},
                {'6', '*', '*', '*', '*', '*', '*', '*', '*', '6'},
                {'7', '*', '*', '*', '*', '*', '*', '*', '*', '7'},
                {'8', '*', '*', '*', '*', '*', '*', '*', '*', '8'},
                {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', ' '}
        };
        return plateau;
    }

    public static int[] saisieUtilisateur(char[][] plateau, char tourjoueur, String[] pseudo) {
        //positionFinal = [y,x]
        Scanner scanner = new Scanner(System.in);

        String positionPion;
        int[] positionFinale = new int[2];
        boolean verification = false;

        do {
            if (tourjoueur == 'r') {
                System.out.print("C'est au tour de " + pseudo[0] + " de saisir l'emplacement où placer le pion (pion rouge): ");
            } else {
                System.out.print("C'est au tour de " + pseudo[1] + " de saisir l'emplacement où placer le pion (pion bleu): ");
            }

            positionPion = scanner.nextLine();
            positionPion = positionPion.toUpperCase();

            if (positionPion.length() != 2 || positionPion.charAt(0) < 'A' || positionPion.charAt(0) > 'H' || positionPion.charAt(1) < '1' || positionPion.charAt(1) > '8') {
                System.out.println("Erreur saisisser une valeur entre (A et H) et une valeur entre (1 et 8) par exemple E5");
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
                else if (!pionEncadrerEtPeutManger(plateau, positionFinale, tourjoueur, true)) {
                    verification = false;
                    System.out.println("Doit manger au moins un pion.");
                }

            }

        } while (!verification);
        return positionFinale;
    }

    public static void placementPion(char[][] plateau, int[] coordonées, char tourjoueur) {
        if (tourjoueur == 'r') {
            plateau[coordonées[0]][coordonées[1]] = 'r';
        } else {
            plateau[coordonées[0]][coordonées[1]] = 'b';
        }

    }

    // Cette fonction affiche l'état du plateau
    public static void afficherplateau(char[][] plateau) {
        for (int y = 0; y < plateau.length; y++) {
            for (int x = 0; x < plateau[y].length; x++) {
                if (plateau[y][x] == 'b') {
                    //bleu
                    System.out.print("\u001B[34m0\u001B[0m" + " ");
                } else if (plateau[y][x] == 'r') {
                    //rouge
                    System.out.print("\u001B[31m0\u001B[0m" + " ");
                } else if (plateau[y][x] == '*') {
                    System.out.print("\u001B[32m□\u001B[0m" + " ");
                } else {
                    System.out.print(plateau[y][x] + " ");
                }
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

    //Cette fonction vérifie si un pion ennemi est bien encadrer si c'est le cas renvoie true et si mange est à true remplace le pion ennemi en pion allié sinon renvoie false
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
                    // verifie si bien pion allié
                    if (plateau[pionVerifier[0] + y][pionVerifier[1] + x] == tourjoueur) {
                        encadrement = true;
                    }
                    pionVerifier[0] = coordonnee[0];
                    pionVerifier[1] = coordonnee[1];
                    if (encadrement) {
                        while (plateau[pionVerifier[0] + y][pionVerifier[1] + x] != tourjoueur) {
                            pionVerifier[0] += y;
                            pionVerifier[1] += x;
                            if (mange) {
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
        boolean peutJouer = false;
        for (int y = 1; y < 9; y++) {
            for (int x = 1; x < 9; x++) {
                coordonnee[0] = y;
                coordonnee[1] = x;
                if (plateau[y][x] == '*' && pionEncadrerEtPeutManger(plateau, coordonnee, tourjoueur, false)) {
                    peutJouer = true;
                }
            }
        }
        return peutJouer;

    }

    public static ArrayList<int[]> listePositionPossibleDeJouer(char[][] plateau, char tourjoueur){
        ArrayList<int[]> positionPossibleDeJouer = new ArrayList<int[]>();
        for (int y = 1; y < 9; y++) {
            for (int x = 1; x < 9; x++) {
                int[] coordonnee = new int[2];
                coordonnee[0] = y;
                coordonnee[1] = x;
                if (plateau[y][x] == '*' && pionEncadrerEtPeutManger(plateau, coordonnee, tourjoueur, false)) {
                    positionPossibleDeJouer.addLast(coordonnee);
                }
            }
        }
        return positionPossibleDeJouer;
    }

    public static void afficheOuPeuxJouer(char[][] plateau, char tourjoueur) {
        int[] coordonnee = new int[2];
        System.out.print("Vous pouvez jouer en :");
        for (int y = 1; y < 9; y++) {
            for (int x = 1; x < 9; x++) {
                coordonnee[0] = y;
                coordonnee[1] = x;
                if (plateau[y][x] == '*' && pionEncadrerEtPeutManger(plateau, coordonnee, tourjoueur, false)) {
                    System.out.print(" " + ((char) (x + 64)) + y);
                }
            }
        }
        System.out.println();
    }

    public static void jeu(String[] pseudo, int[] score) {
        char tourJoueur = 'r';
        char[][] plateau = creationPlateau();
        boolean impossibleDeJouer = false;
        while (!plateauPlein(plateau) && !impossibleDeJouer) {
            afficherplateau(plateau);
            afficheOuPeuxJouer(plateau, tourJoueur);
            placementPion(plateau, saisieUtilisateur(plateau, tourJoueur, pseudo), tourJoueur);
            //verifie si le joueur rouge peut jouer sinon passe sont tour
            if (tourJoueur == 'r' && verifSiPeutJouer(plateau, 'b')) {
                tourJoueur = 'b';
            }
            //verifie si le joueur bleu peut jouer s'il ne peux pas jouer il passe son tour
            else if (verifSiPeutJouer(plateau, 'r')) {
                tourJoueur = 'r';
            } else if (!verifSiPeutJouer(plateau, 'r') && !verifSiPeutJouer(plateau, 'b')) {
                impossibleDeJouer = true;
            }

        }
        afficherplateau(plateau);
        afficheGagnant(plateau);

        if (calculVictoire(plateau) != 2) {
            score[calculVictoire(plateau)] += 1;
        }
    }

    public static void jeuContreIA(String[] pseudo) {
        char tourJoueur = 'r';
        int[] positionIA = new int[2];
        char[][] plateau = creationPlateau();
        boolean impossibleDeJouer = false;
        while (!plateauPlein(plateau) && !impossibleDeJouer) {
            if (tourJoueur == 'r') {
                afficherplateau(plateau);
                afficheOuPeuxJouer(plateau, tourJoueur);
                //affiche seulement si le bot à déjà jouer
                if(positionIA[0]!=0) {
                    System.out.println("Le bot à jouer en " + (char) (positionIA[1] + 64) + positionIA[0]);
                }
                placementPion(plateau, saisieUtilisateur(plateau, tourJoueur, pseudo), tourJoueur);

            } else {
                positionIA = positionJouerParIA(plateau,listePositionPossibleDeJouer(plateau, tourJoueur));
            }

            //verifie si le joueur rouge peut jouer sinon passe sont tour
            if (tourJoueur == 'r' && verifSiPeutJouer(plateau, 'b')) {
                tourJoueur = 'b';
            }
            //verifies si le joueur bleu peut jouer s'il ne peux pas jouer il passe son tour
            else if (verifSiPeutJouer(plateau, 'r')) {
                tourJoueur = 'r';
            } else if (!verifSiPeutJouer(plateau, 'r') && !verifSiPeutJouer(plateau, 'b')) {
                impossibleDeJouer = true;
            }

        }
        afficherplateau(plateau);
        afficheGagnant(plateau);
    }

    public static int[] positionJouerParIA(char[][] plateau, ArrayList<int[]> position) {
        int choixPosition = (int)Math.random() * position.size();
        plateau[position.get(choixPosition)[0]][position.get(choixPosition)[1]] = 'b';
        pionEncadrerEtPeutManger(plateau, position.get(choixPosition),'b',true);
        return position.get(choixPosition);
    }

    public static int[] positionJouerParIADur(char[][] plateau, ArrayList<int[]> position){
        //coordonnee ou il y a le plus de pion manger
        int[] coordonnee = new int[2];
        int nbPionManger = 0;
        int pionManger;
        for (int i = 0; i < position.size(); i++) {
            pionManger = compterNbPionManger(plateau,position.get(i),'b' );
            if(pionManger>nbPionManger){
                nbPionManger=pionManger;
                coordonnee[0] = position.get(i)[0];
                coordonnee[1] = position.get(i)[1];
            }
        }
        pionEncadrerEtPeutManger(plateau,coordonnee,'b',true);
        plateau[coordonnee[0]][coordonnee[1]] = 'b';
        return coordonnee;
    }

    public static int compterNbPionManger(char[][] plateau, int[] coordonnee, char tourjoueur) {
        int nbPionManger = 0;
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
                    // verifie si bien pion allié
                    if (plateau[pionVerifier[0] + y][pionVerifier[1] + x] == tourjoueur) {
                        encadrement = true;
                    }
                    pionVerifier[0] = coordonnee[0];
                    pionVerifier[1] = coordonnee[1];
                    if (encadrement) {
                        while (plateau[pionVerifier[0] + y][pionVerifier[1] + x] != tourjoueur) {
                            pionVerifier[0] += y;
                            pionVerifier[1] += x;
                            nbPionManger++;
                        }
                        encadrement = false;
                    }
                }
            }
        }
        return nbPionManger;
    }

    public static int calculVictoire(char[][] plateau) {
        int pionRouge = 0;
        int pionBleu = 0;
        int indiceScoreGagnant;

        for (int y = 1; y < 9; y++) {
            for (int x = 1; x < 9; x++) {
                if (plateau[y][x] == 'r') {
                    pionRouge++;
                } else if (plateau[y][x] == 'b') {
                    pionBleu++;
                }
            }
        }

        if (pionRouge > pionBleu) {
            indiceScoreGagnant = 0;
        } else if (pionBleu > pionRouge) {
            indiceScoreGagnant = 1;
        } else {
            indiceScoreGagnant = 2;
        }
        return indiceScoreGagnant;
    }

    public static void afficheGagnant(char[][] plateau) {
        int pionRouge = 0;
        int pionBleu = 0;
        for (int y = 1; y < 9; y++) {
            for (int x = 1; x < 9; x++) {
                if (plateau[y][x] == 'r') {
                    pionRouge++;
                } else if (plateau[y][x] == 'b') {
                    pionBleu++;
                }
            }
        }

        if (pionRouge > pionBleu) {
            System.out.println("Victoire des rouge avec " + pionRouge + " points contre " + pionBleu + " points pour les bleu");
        } else if (pionBleu > pionRouge) {
            System.out.println("Victoire des bleu avec " + pionBleu + " points contre " + pionRouge + " points pour les rouge");
        } else {
            System.out.println("Il y a égalité");
        }
    }

}
