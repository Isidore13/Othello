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

            System.out.println("Quelle action voulez-vous effectuer ?\n 1.Lancer une partie \n 2.Afficher le score \n 3.Modifier un pseudo ");
            possibilité = scanner.nextInt();

            switch (possibilité) {
                case 1:
                    Methode.jeu();

                    break;

                case 2:
                    MethodesJoueurs.afficherScore(pseudo,score);

                    break;

                case 3:
                    MethodesJoueurs.modifierPseudo();

                    break;


                default:
                    System.out.println("Au revoir");

            }

        }

        while (possibilité != 5) ;

    }
}
