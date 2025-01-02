import java.util.Scanner;

public class Menu {
    public static void ChoixActions() {
        Scanner scanner = new Scanner(System.in);

        int possibilité;
        String[] pseudo = new String[2];
        int[] score = new int[2];

        for(int i = 0; i < pseudo.length;  i++){
            System.out.println("Sélectionnez le pseudo n° " + (i+1) + " : ");
            pseudo[i] = scanner.nextLine();
        }

        do {

            System.out.println("Quelle action voulez-vous effectuer ?\n 1.Lancer une partie \n 2.Lancer une partie contre l'IA \n 3.Afficher le score \n 4.Modifier un pseudo \n 5.Quitter ");
            possibilité = scanner.nextInt();

            switch (possibilité) {
                case 1:
                    Methode.jeu(pseudo,score);

                    break;

                case 2:
                    Methode.jeuContreIA(pseudo);

                    break;

                case 3:
                    MethodesJoueurs.afficherScore(pseudo,score);

                    break;

                case 4:
                    MethodesJoueurs.modifierPseudo(pseudo);

                    break;


                default:
                    System.out.println("Au revoir");

            }

        }

        while (possibilité != 5) ;

    }
}
