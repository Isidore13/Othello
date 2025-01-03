import java.util.Scanner;

public class MenuIA {
    public static void choixDifficulte(String[] pseudo){
        Scanner sc = new Scanner(System.in);
        int choixDifficulte;
        do {
            System.out.print("Saisissez 1 pour une difficulté facile ou saisissez 2 pour une difficulté plus dur : ");
            choixDifficulte = sc.nextInt();
            switch (choixDifficulte){
                //difficulté 1 facile difficulté 2 plus dure.
                case 1:
                    Methode.jeuContreIA(pseudo,1);
                    break;
                case 2:
                    Methode.jeuContreIA(pseudo,2);
                    break;
                default:
                    System.out.println("Saisir seulement 1 ou 2");
                    break;
            }
        }while (choixDifficulte<1 || choixDifficulte>2);

    }
}
