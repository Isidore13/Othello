import java.util.Scanner;

public class MethodesJoueurs {

    public static void afficherScore(String[] pseudo, int[] score){
        for( int i = 0; i < pseudo.length; i++){
            System.out.println(pseudo[i] + "\t" +  score[i] +  " victoires !! \n ");
        }


    }

    public static void modifierPseudo(String[] pseudo) {
        Scanner scanner = new Scanner(System.in);

        int indicePseudo = -1;

        do {

            System.out.println("Quel pseudo voulez-vous modifier ? \n 1.Pseudo n°1 \n 2.Pseudo n°2 \n 3.Annuler. ");
            indicePseudo += scanner.nextInt();

            switch (indicePseudo) {
                case 1:
                    System.out.println("Par quoi voulez-vous remplacer le pseudo " + pseudo[0] + " ?");
                    pseudo[indicePseudo] = scanner.nextLine();

                    break;

                case 2:
                    System.out.println("Par quoi voulez-vous remplacer le pseudo " + pseudo[1] + " ?");
                    pseudo[indicePseudo] = scanner.nextLine();

                    break;


            }

        }
        while (indicePseudo != 3);
    }
}
