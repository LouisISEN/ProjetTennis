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
    int Perdant = 0;

    public static Match JouerM(Match match, int n, Tournoi ObjTournoi, int auto) {

        int NbrSetMax = 0;
        int setjoueur1 = 0;
        int setjoueur2 = 0;

        if (ObjTournoi.genre.equals("Masculin")) {
            NbrSetMax = 3;
        } else {
            NbrSetMax = 2;
        }
        System.out.println("Debut du match " + n + " " + match.Joueur1.nomNaissance + " contre " + match.Joueur2.nomNaissance);

        while ((setjoueur1 != NbrSetMax) & (setjoueur2 != NbrSetMax)) {

            match = Set.set(match, n, match.DernierService, auto, setjoueur1, setjoueur2);

            if (match.Joueur1.WinSet == 1) {
                setjoueur1++;
                
                match.Joueur1.SetJoueur++;
             

            } else {
                setjoueur2++;
                
                match.Joueur2.SetJoueur++;
               
            }
            System.out.println("\n");
            //  Match.AffichageScoreSet(ListMatch, n, setjoueur1, setjoueur2);
            System.out.println("\n");

        }
        if (setjoueur1 == NbrSetMax) {
                if (ObjTournoi.nbTour==7){
                    
                    System.out.println("Fin du Match, Le joueur 1 " + match.Joueur1.nomNaissance + " est le gagnant de la petite finale.");
                    System.out.println("Le joueur 2 " + match.Joueur2.nomNaissance + " est éliminé.");
                    
                    
                }
                
                System.out.println("Fin du Match, Le joueur 1 " + match.Joueur1.nomNaissance + " est qualifié pour le tour suivant.");
                System.out.println("Le joueur 2 " + match.Joueur2.nomNaissance + " est éliminé.");
                match.Joueur2.qualification = ObjTournoi.tour;
                match.Perdant=2;
          
        } else {
                if (ObjTournoi.nbTour==7){
                   
                    System.out.println("Fin du Match, Le joueur 2 " + match.Joueur2.nomNaissance + " est le gagnant de la petite finale.");
                    System.out.println("Le joueur 1 " + match.Joueur1.nomNaissance + " est éliminé.");
                    
                }
                
                System.out.println("Fin du Match, Le joueur 2 " + match.Joueur2.nomNaissance + " est qualifié pour le tour suivant.");
                System.out.println("Le joueur 1 " + match.Joueur1.nomNaissance + " est éliminé.");
                match.Joueur1.qualification = ObjTournoi.tour;
                match.Perdant=1;
        }

    match.Resultat  = 1;              
    

    return match ;
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
