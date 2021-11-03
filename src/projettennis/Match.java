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

    int NbrSetMax = 3;
    public String Joueur1;
    int pointJoueur1=0;
    int SetJoueur1=0;
    int JeuJoueur1=0;
    
    public String Joueur2;
    int pointJoueur2=0;
    int SetJoueur2=0;
    int JeuJoueur2=0;

    
    
    public static void Jouer(Tournoi TabMatch[], int n) {
        Match match =new Match();
        int a =0;
        a=Match.DeterminationService(TabMatch, n);
        System.out.println("Debut du match " + n + " " + TabMatch[n - 1].Joueur1 + " contre " + TabMatch[n - 1].Joueur2);
        
        Jeu.jeu(match, TabMatch, n, a);
        
       
        
        
        TabMatch[n-1].Resultat=1;
    }
    
    

    public static int DeterminationService(Tournoi TabMatch[], int n) {            //dertmine qui commence avec le service

        Random random = new Random();
        int nb;
        int Borne1 = 2;
        int Borne2 = 0;
        String joueur;
        nb = 1 + random.nextInt(Borne1 - Borne2);
        if (nb==1){
            joueur=TabMatch[n-1].Joueur1;
        }
        else {
            joueur=TabMatch[n-1].Joueur2;
        }
        System.out.println("Le joueur " + joueur + " commence avec le service");
        return nb;
    }

}
