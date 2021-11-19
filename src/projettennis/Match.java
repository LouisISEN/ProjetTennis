/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projettennis;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author axand
 */
public class Match {

    Joueur Joueur1 = new Joueur();
    Joueur Joueur2 = new Joueur();
    Arbitre arbitre = new Arbitre();
    int Resultat = 0;
    int DernierService = 0;

    public static ArrayList<Match> JouerM(ArrayList<Match> ListMatch, int n, Tournoi ObjTournoi, int auto) {

        Match BufferMatch = new Match();
        int NbrSetMax = 0;
        int setjoueur1 = 0;
        int setjoueur2 = 0;

        if (ObjTournoi.genre.equals("Masculin")) {
            NbrSetMax = 3;
        } else {
            NbrSetMax = 2;
        }
        BufferMatch = ListMatch.get(n - 1);
        BufferMatch.DernierService = Match.DeterminationService(ListMatch, n);
        ListMatch.set(n - 1, BufferMatch);

        System.out.println("Debut du match " + n + " " + ListMatch.get(n - 1).Joueur1.nomNaissance + " contre " + ListMatch.get(n - 1).Joueur2.nomNaissance);

        while ((setjoueur1 != NbrSetMax) & (setjoueur2 != NbrSetMax)) {

            ListMatch = Set.set(ListMatch, n, ListMatch.get(n - 1).DernierService, auto, setjoueur1, setjoueur2);

            if (ListMatch.get(n - 1).Joueur1.WinSet == 1) {
                setjoueur1++;
                BufferMatch = ListMatch.get(n - 1);
                BufferMatch.Joueur1.SetJoueur++;
                ListMatch.set(n - 1, BufferMatch);

            } else {
                setjoueur2++;
                BufferMatch = ListMatch.get(n - 1);
                BufferMatch.Joueur2.SetJoueur++;
                ListMatch.set(n - 1, BufferMatch);
            }
            System.out.println("\n");
            //  Match.AffichageScoreSet(ListMatch, n, setjoueur1, setjoueur2);
            System.out.println("\n");

        }
        if (setjoueur1 == NbrSetMax) {
            if (ObjTournoi.nbTour == 6) {
                System.out.println("Fin du Match, Le joueur 1 " + ListMatch.get(n - 1).Joueur1.nomNaissance + " est qualifié pour la finale.");
                System.out.println("Le joueur 2 " + ListMatch.get(n - 1).Joueur2.nomNaissance + " est qualifié par la petite finale.");
                ListMatch.get(n - 1).Joueur2.qualification = "petitefinale";
            } else {
                System.out.println("Fin du Match, Le joueur 1 " + ListMatch.get(n - 1).Joueur1.nomNaissance + " est qualifié pour le tour suivant.");
                System.out.println("Le joueur 2 " + ListMatch.get(n - 1).Joueur2.nomNaissance + " est éliminé.");
                ListMatch.get(n - 1).Joueur2.qualification = "disqualifie";
          }
        } else {
            if (ObjTournoi.nbTour == 6) {

                System.out.println("Fin du Match, Le joueur 2 " + ListMatch.get(n - 1).Joueur2.nomNaissance + " est qualifié pour la finale.");
                System.out.println("Le joueur 1 " + ListMatch.get(n - 1).Joueur1.nomNaissance + " est qualifié pour la petite finale.");
                ListMatch.get(n - 1).Joueur1.qualification = "petitefinale";
            } else {
                System.out.println("Fin du Match, Le joueur 2 " + ListMatch.get(n - 1).Joueur2.nomNaissance + " est qualifié pour le tour suivant.");
                System.out.println("Le joueur 1 " + ListMatch.get(n - 1).Joueur1.nomNaissance + " est éliminé.");
                ListMatch.get(n - 1).Joueur1.qualification = "disqualifie";
            }
        }

    

    BufferMatch  = ListMatch.get(n - 1);
    BufferMatch.Resultat  = 1;
    ListMatch.set(n-1, BufferMatch);

    return ListMatch ;
}

public static int DeterminationService(ArrayList<Match> ListMatch, int n) {            //dertmine qui commence avec le service

        Random random = new Random();
        int nb;
        int Borne1 = 2;
        int Borne2 = 0;
        String joueur;
        nb = 1 + random.nextInt(Borne1 - Borne2);
        if (nb == 1) {
            joueur = ListMatch.get(n-1).Joueur1.nomNaissance;
        } else {
            joueur = ListMatch.get(n-1).Joueur2.nomNaissance;
        }
        System.out.println("Le joueur " + joueur + " commence avec le service");
        return nb;
    }

  /*  public static void AffichageScoreSet(ArrayList<Match> ListMatch, int n, int setjoueur1, int setjoueur2) {

        System.out.println("    SET " + ListMatch.get(n-1).Joueur1.nomNaissance + " - " + ListMatch.get(n-1).Joueur2.nomNaissance + "  :  " + setjoueur1 + " - " + setjoueur2);

    }*/

}
