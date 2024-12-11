public class Methode {

    public static char[][] creationPlateau(char[][] plateau) {
        //plateau[y][x]
        char[][] plateau = {{'\0','A','B','C','D','E','F','G','H'},
                            {'1','*','*','*','*','*','*','*','*'},
                            {'2','*','*','*','*','*','*','*','*'},
                            {'3','*','*','*','*','*','*','*','*'},
                            {'4','*','*','*','B','W','*','*','*'},
                            {'5','*','*','*','W','B','*','*','*'},
                            {'6','*','*','*','*','*','*','*','*'},
                            {'7','*','*','*','*','*','*','*','*'},
                            {'8','*','*','*','*','*','*','*','*'}};

        return plateau;
        

    }
    
    public static int[] saisieutilisateur(char[][] plateau) {
        
        Scanner scanner = new Scanner(System.in);
        
        String positionPion;
        int[] positionFinale=new int[2];
        boolean verification=false;

        do{
            System.out.print("Saisissez l'emplacement où placer le pion : ");
            positionPion = scanner.nextLine();
            
            if(positionPion.length()!=2 || positionPion.charAt(0)<'A' || positionPion.charAt(0)>'H' || PositionPion.charAt(1)<'1' || PositionPion.charAt(1)>'8'){
                System.out.println("Erreur saisisser une valeur entre (A et H) en majuscule et une valeur entre (1 et 8) par exemple E5");
            }
                
            else 
                verification=true;
            
        }
        
        while(verification==false);
        
        positionFinale[0]=((int)positionPion.charAt(0))-64; // 64 car 'A' - 64 egale 1 pour avoir les coordonnee
        positionFinale[1]=((int)positionPion.charAt(1))-48; //48 car '1' egale 49 donc si l'on soustrait 48 '1' egale 1
        
        return positionFinale;
    }

}
