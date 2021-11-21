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

    public static Match set(Match match, int n, int a, int auto, int setjoueur1, int setjoueur2) {
        
        System.out.println("Debut Set");
        
        int jeujoueur1 = 0;
        int jeujoueur2 = 0;
        
        
        match.Joueur1.setWinSet(0);
        match.Joueur2.setWinSet(0);       
        

    //    Set.AffichageScoreJeu(ListMatch, n, jeujoueur1, jeujoueur2);

        while (((jeujoueur1 < 6) & (jeujoueur2 < 6)) | ((Math.abs(jeujoueur1 - jeujoueur2)) < 2)) {
           
            match = Jeu.jeu(match, n, match.DernierService, auto, jeujoueur1, jeujoueur2, setjoueur1, setjoueur2);
            
            if (match.DernierService==1){                       
               
                
                match.DernierService=2;                          
               
            } else  {
                
                
               match.DernierService=1;                          
                
            }
            
            if (a == 1) {
                System.out.println("Le joueur " + match.Joueur1.getNomNaissance() + " a le service");
            } else {
                System.out.println("Le joueur " + match.Joueur2.getNomNaissance() + " a le service");
            }

            
            if (match.Joueur1.getWinJeu() == 1) {
                jeujoueur1++;
                
                match.Joueur1.incrementeJeuJoueur();                          
                
                

            } else {

                jeujoueur2++;
                
                match.Joueur2.incrementeJeuJoueur();                          
             

            }
            
         //   Set.AffichageScoreJeu(ListMatch, n, jeujoueur1, jeujoueur2);
        }
        if (jeujoueur1 > jeujoueur2) {
                
                match.Joueur1.setWinSet(1);                          
                
        } else {
             
                match.Joueur2.setWinSet(1);                          
               
        }
        
        System.out.println("Fin du Set");
        System.out.println("\n");
        return match;
    }

   /* public static void AffichageScoreJeu(ArrayList<Match> ListMatch, int n, int jeujoueur1, int jeujoueur2) {

        System.out.println("Joueur      JEU");
        System.out.println( Tournoi.affichageTxt(ListMatch.get(n-1).Joueur1.nomNaissance) +" | "+ jeujoueur1 );
        System.out.println( Tournoi.affichageTxt(ListMatch.get(n-1).Joueur2.nomNaissance) +" | "+ jeujoueur2);
    }*/

}
