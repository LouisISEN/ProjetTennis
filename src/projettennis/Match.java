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
    String arbitre;
    int Resultat=0;
    int DernierService = 0;
    
    
    public static Match[] JouerM(Match TabMatch[], int n, String genre, int auto) {
        Match match = new Match();

        int NbrSetMax = 0;
        

        int setjoueur1 = 0;
        int setjoueur2 = 0;
        if (genre.equals("Masculin")) {
            NbrSetMax = 3;
        } else {
            NbrSetMax = 2;
        }

        TabMatch[n - 1].DernierService = Match.DeterminationService(TabMatch, n);

        System.out.println("Debut du match " + n + " " + TabMatch[n - 1].Joueur1.nomNaissance + " contre " + TabMatch[n - 1].Joueur2.nomNaissance);

        while ((setjoueur1 != NbrSetMax) & (setjoueur2 != NbrSetMax)) {

            TabMatch = Set.set(TabMatch, n, TabMatch[n - 1].DernierService, auto);

            if (TabMatch[n - 1].Joueur1.WinSet == 1) {
                setjoueur1++;
                TabMatch[n - 1].Joueur1.SetJoueur++;
            } else {
                setjoueur2++;
                TabMatch[n - 1].Joueur2.SetJoueur++;
            }
            System.out.println("\n");
            Match.AffichageScoreSet(TabMatch, n, setjoueur1, setjoueur2);
            System.out.println("\n");

        }
        if (setjoueur1 == NbrSetMax) {
            System.out.println("Fin du Match, Le joueur 1 " + TabMatch[n - 1].Joueur1.nomNaissance + " est qualifié pour le tour suivant.");
            System.out.println("Le joueur 2 " + TabMatch[n - 1].Joueur2.nomNaissance + " est disqualifié.");
            TabMatch[n - 1].Joueur2.qualification = "disqualifie";
        } else {

            System.out.println("Fin du Match, Le joueur 2 " + TabMatch[n - 1].Joueur2.nomNaissance + " est qualifié pour le tour suivant.");
            System.out.println("Le joueur 1 " + TabMatch[n - 1].Joueur1.nomNaissance + " est disqualifié.");
            TabMatch[n - 1].Joueur1.qualification = "disqualifie";

        }

        TabMatch[n - 1].Resultat = 1;
        return TabMatch;
    }

    public static int DeterminationService(Match TabMatch[], int n) {            //dertmine qui commence avec le service

        Random random = new Random();
        int nb;
        int Borne1 = 2;
        int Borne2 = 0;
        String joueur;
        nb = 1 + random.nextInt(Borne1 - Borne2);
        if (nb == 1) {
            joueur = TabMatch[n - 1].Joueur1.nomNaissance;
        } else {
            joueur = TabMatch[n - 1].Joueur2.nomNaissance;
        }
        System.out.println("Le joueur " + joueur + " commence avec le service");
        return nb;
    }

    public static void AffichageScoreSet(Match[] TabMatch, int n, int setjoueur1, int setjoueur2) {

        System.out.println("    SET " + TabMatch[n - 1].Joueur1.nomNaissance + " - " + TabMatch[n - 1].Joueur2.nomNaissance + "  :  " + setjoueur1 + " - " + setjoueur2);

    }


}
