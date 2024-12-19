public class MethodesContreIA {


    public static void jeuContreIA(String[] pseudo) {
        char tourJoueur = 'r';
        char[][] plateau = Methode.creationPlateau();
        boolean impossibleDeJouer = false;
        while (!Methode.plateauPlein(plateau) && !impossibleDeJouer) {
            Methode.afficherplateau(plateau);
            Methode.placementPion(plateau, saisieUtilisateur(plateau, tourJoueur, pseudo), tourJoueur);
            //verifie si le joueur peut jouer sinon passe son tour
            if (tourJoueur == 'r' && Methode.verifSiPeutJouer(plateau, 'b')) {
                tourJoueur = 'b';
            } else {
                //verifie si l'IA peut jouer si elle ne peux pas jouer elle passe son tour
                if (Methode.verifSiPeutJouer(plateau, 'r')) {
                    tourJoueur = 'r';
                }
                tourJoueur = 'r';
            }
            if (!Methode.verifSiPeutJouer(plateau, 'r') && !Methode.verifSiPeutJouer(plateau, 'b')) {
                impossibleDeJouer = true;
            }

        }

        Methode.calculVictoire(plateau);

    }
}
