
import java.util.Scanner;

public class Menu {
    public static void ChoixActions() {
        Scanner scanner = new Scanner(System.in);

        int possibilité;
        String[] pseudo = new String[2];
        pseudo[0] = "A";
        int[] score = new int[2];

        do {

            System.out.println("Quelle action voulez-vous effectuer ?\n 1.Lancer une partie \n 2.Lancer une partie contre l'IA \n 3.Afficher le score \n 4.Modifier un pseudo \n 5.Quitter ");
            possibilité = scanner.nextInt();

            switch (possibilité) {
                case 1:
                    if( pseudo[0]== null || pseudo[1] == null) {
                        for(int i = 0; i < pseudo.length;  i++){
                            System.out.println("Sélectionnez le pseudo n° " + (i+1) + " : ");
                            scanner = new Scanner(System.in);
                            pseudo[i] = scanner.nextLine();
                        }
                    }
                    Methode.jeu(pseudo,score);

                    break;

                case 2:
                    if( pseudo[0]== null ) {
                        System.out.println("Sélectionnez votre pseudo : ");
                            scanner = new Scanner(System.in);
                            pseudo[0] = scanner.nextLine();
                        }
                    MenuIA.choixDifficulte(pseudo);

                    break;

                case 3:
                    MethodesJoueurs.afficherScore(pseudo,score);

                    break;

                case 4:
                    if( pseudo[0]== null && pseudo[1] == null ) {
                        System.out.println("Aucun pseudo n'a été enregistré. Modification impossible");
                    }
                    else
                        MethodesJoueurs.modifierPseudo(pseudo);

                    break;


                default:
                    System.out.println("Au revoir");

            }

        }

        while (possibilité != 5) ;

    }
}
