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

    public static ArrayList<Match> set(ArrayList<Match> ListMatch, int n, int a, int auto) {
        
        System.out.println("Debut Set");
        System.out.println("numero 1 =" + ListMatch.get(n-1).Joueur1.nomNaissance + " = " + ListMatch.get(n-1).Joueur1.numero);
        System.out.println("numero 2 =" + ListMatch.get(n-1).Joueur2.nomNaissance + " = " + ListMatch.get(n-1).Joueur2.numero);
        int jeujoueur1 = 0;
        int jeujoueur2 = 0;
        
        Match BufferMatch = new Match();
        BufferMatch =ListMatch.get(n-1);
        BufferMatch.Joueur1.WinSet = 0;
        BufferMatch.Joueur2.WinSet = 0;       
        ListMatch.set(n-1, BufferMatch);

        Set.AffichageScoreJeu(ListMatch, n, jeujoueur1, jeujoueur2);

        while (((jeujoueur1 < 6) & (jeujoueur2 < 6)) | ((Math.abs(jeujoueur1 - jeujoueur2)) < 2)) {
           
            ListMatch = Jeu.jeu(ListMatch, n, ListMatch.get(n-1).DernierService, auto);
            
            if (ListMatch.get(n-1).DernierService==1){                       
               
                BufferMatch =ListMatch.get(n-1);
                BufferMatch.DernierService=2;                          
                ListMatch.set(n-1, BufferMatch);
            } else  {
                
                BufferMatch =ListMatch.get(n-1);
                BufferMatch.DernierService=1;                          
                ListMatch.set(n-1, BufferMatch);
            }
            
            if (a == 1) {
                System.out.println("Le joueur " + ListMatch.get(n-1).Joueur1.nomNaissance + " a le service");
            } else {
                System.out.println("Le joueur " + ListMatch.get(n-1).Joueur2.nomNaissance + " a le service");
            }

            
            if (ListMatch.get(n-1).Joueur1.WinJeu == 1) {
                jeujoueur1++;
                BufferMatch =ListMatch.get(n-1);
                BufferMatch.Joueur1.JeuJoueur++;                          
                ListMatch.set(n-1, BufferMatch);
                

            } else {

                jeujoueur2++;
                 BufferMatch =ListMatch.get(n-1);
                BufferMatch.Joueur2.JeuJoueur++;                          
                ListMatch.set(n-1, BufferMatch);

            }
            System.out.println("\n");
            Set.AffichageScoreJeu(ListMatch, n, jeujoueur1, jeujoueur2);
        }
        if (jeujoueur1 > jeujoueur2) {
                BufferMatch =ListMatch.get(n-1);
                BufferMatch.Joueur1.WinSet=1;                          
                ListMatch.set(n-1, BufferMatch);
        } else {
             BufferMatch =ListMatch.get(n-1);
                BufferMatch.Joueur2.WinSet=1;                          
                ListMatch.set(n-1, BufferMatch);
        }
        System.out.println("\n");
        System.out.println("Fin du Set");
        System.out.println("\n");
        return ListMatch;
    }

    public static void AffichageScoreJeu(ArrayList<Match> ListMatch, int n, int jeujoueur1, int jeujoueur2) {

        System.out.println("    Jeu " + ListMatch.get(n-1).Joueur1.nomNaissance + " - " + ListMatch.get(n-1).Joueur2.nomNaissance + "  :  " + jeujoueur1 + " - " + jeujoueur2);

    }

}
