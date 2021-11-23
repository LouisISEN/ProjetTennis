/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projettennis;

import java.util.ArrayList;

/**
 *
 * @author axand
 */
public class Set {
    
    int setJoueur1;
    int setJoueur2;
    
    public static Match set(Match match, Tournoi ObjTournoi, int n, int a, int auto, int setjoueur1, int setjoueur2) {

        System.out.println("Debut Set");
        
  
        Jeu jeu = new Jeu();
        match.Joueur1.WinSet = 0;
        match.Joueur2.WinSet = 0;

        while (((jeu.jeuJoueur1 < 6) & (jeu.jeuJoueur2 < 6)) | ((Math.abs(jeu.jeuJoueur1 - jeu.jeuJoueur2)) < 2)) {

            match = Jeu.jeu(match, ObjTournoi, n, match.DernierService, auto, jeu.jeuJoueur1, jeu.jeuJoueur2, setjoueur1, setjoueur2);
            if (match.DernierService == 1) {
                match.DernierService = 2;
            } else {
                match.DernierService = 1;
            }
            if (a == 1) {
                System.out.println("Le joueur " + match.Joueur1.nomNaissance + " a le service");
            } else {
                System.out.println("Le joueur " + match.Joueur2.nomNaissance + " a le service");
            }
            if (match.Joueur1.WinJeu == 1) {
                jeu.jeuJoueur1++;
                match.Joueur1.JeuJoueur++;
            } else {
                jeu.jeuJoueur2++;

                match.Joueur2.JeuJoueur++;
            }
        }
        if (jeu.jeuJoueur1 > jeu.jeuJoueur2) {

            match.Joueur1.WinSet = 1;

        } else {

            match.Joueur2.WinSet = 1;

        }

        System.out.println("Fin du Set");
        return match;
    }
}
