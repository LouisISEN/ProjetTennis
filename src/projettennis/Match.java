/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projettennis;


import java.util.Random;

/**
 *
 * @author axand
 */
public class Match {

    Joueur Joueur1 = new Joueur();
    Joueur Joueur2 = new Joueur();

    Arbitre arbitre = new Arbitre();
    int Resultat = 0;                               //savoir si le match a deja été joué ou non, 1 oui 2 non
    int DernierService = 0;
    int Perdant = 0;

    public static Match JouerM(Match match, int n, Tournoi ObjTournoi, int auto) {
        Set set = new Set();
        int NbrSetMax = 0;

        if (ObjTournoi.genre.equals("Masculin")) {
            NbrSetMax = 3;
        } else {
            NbrSetMax = 2;
        }
        System.out.println("Debut du match n*" + n + " : " + match.Joueur1.nomNaissance + " " + match.Joueur1.prenom + " contre " + match.Joueur2.nomNaissance + " " + match.Joueur1.prenom);

        while ((set.setJoueur1 != NbrSetMax) & (set.setJoueur2 != NbrSetMax)) {
            match.DernierService=Match.DeterminationService(match, n);
            match = Set.set(match, ObjTournoi, n, match.DernierService, auto, set.setJoueur1, set.setJoueur2);

            if (match.Joueur1.WinSet == 1) {
                set.setJoueur1++;
                match.Joueur1.SetJoueur++;
            } else {
                set.setJoueur2++;
                match.Joueur2.SetJoueur++;
            }
        }
        if (set.setJoueur1 == NbrSetMax) {
            if (ObjTournoi.nbTour == 7) {

                System.out.println("Fin du Match, Le joueur 1 " + match.Joueur1.nomNaissance + " est le gagnant de la petite finale.");
                System.out.println("Le joueur 2 " + match.Joueur2.nomNaissance + " est éliminé.");
                match.Joueur1.qualification = "Gagnant PF";

            } else {

                System.out.println("Fin du Match, Le joueur 1 " + match.Joueur1.nomNaissance + " est qualifié pour le tour suivant.");
                System.out.println("Le joueur 2 " + match.Joueur2.nomNaissance + " est éliminé.");
            }
            match.Joueur2.qualification = ObjTournoi.tour;
            match.Perdant = 2;

        } else {
            if (ObjTournoi.nbTour == 7) {

                System.out.println("Fin du Match, Le joueur 2 " + match.Joueur2.nomNaissance + " est le gagnant de la petite finale.");
                System.out.println("Le joueur 1 " + match.Joueur1.nomNaissance + " est éliminé.");
                match.Joueur2.qualification = "Gagnant PF";

            } else {

                System.out.println("Fin du Match, Le joueur 2 " + match.Joueur2.nomNaissance + " est qualifié pour le tour suivant.");
                System.out.println("Le joueur 1 " + match.Joueur1.nomNaissance + " est éliminé.");
            }

            match.Joueur1.qualification = ObjTournoi.tour;
            match.Perdant = 1;
        }
        System.out.println("\n\n");
        match.Resultat = 1;

        return match;
    }

    public static int DeterminationService(Match match, int n) {            //dertmine qui commence avec le service

        Random random = new Random();
        int nb;
        int Borne1 = 2;
        int Borne2 = 0;
        String joueur;
        nb = 1 + random.nextInt(Borne1 - Borne2);
        if (nb == 1) {
            joueur = match.Joueur1.nomNaissance;
        } else {
            joueur = match.Joueur2.nomNaissance;
        }
        System.out.println("Le joueur " + joueur + " commence avec le service");
        return nb;
    }

}
