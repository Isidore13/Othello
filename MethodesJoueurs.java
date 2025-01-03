import java.util.Scanner;

public class MethodesJoueurs {

    public static void afficherScore(String[] pseudo, int[] score){
        for( int i = 0; i < pseudo.length; i++){
            System.out.println(pseudo[i] + "\t" +  score[i] +  " victoires !! \n ");
        }


    }

    public static void modifierPseudo(String[] pseudo) {
        Scanner scanner = new Scanner(System.in);

        int indicePseudo ;

        do {

            System.out.println("Quel pseudo voulez-vous modifier ? \n 1.Pseudo n°1 \n 2.Pseudo n°2 \n 3.Annuler. ");
            indicePseudo = scanner.nextInt();
            scanner.nextLine();

            switch (indicePseudo) {
                case 1:
                    if (pseudo[0] == null) {
                        System.out.println("Modification impossible aucun pseudo n'a été enregistré pour cet utilisateur.");
                    }
                    else{
                        System.out.println("Par quoi voulez-vous remplacer le pseudo " + pseudo[0] + " ?");
                        pseudo[indicePseudo-1] = scanner.nextLine();
                    }

                    break;

                case 2:
                    if (pseudo[1] == null) {
                        System.out.println("Modification impossible aucun pseudo n'a été enregistré pour cet utilisateur.");
                    }
                    else {
                        System.out.println("Par quoi voulez-vous remplacer le pseudo " + pseudo[1] + " ?");
                        pseudo[indicePseudo-1] = scanner.nextLine();
                    }
                    break;


            }

        }
        while (indicePseudo != 3);
    }
}
