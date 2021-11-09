/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projettennis;

/**
 *
 * @author axand
 */
public class Set {

    public static Match [] set(Match[] TabMatch, int n, int a, int auto) {
        System.out.println("Debut Set");
        System.out.println("numero 1 " + TabMatch[n - 1].Joueur1.nomNaissance + " = " + TabMatch[n - 1].Joueur1.numero);
        System.out.println("numero 2 =" + TabMatch[n - 1].Joueur2.nomNaissance + " = " + TabMatch[n - 1].Joueur2.numero);
        int jeujoueur1 = 0;
        int jeujoueur2 = 0;
        
        TabMatch[n - 1].Joueur1.WinSet = 0;
        TabMatch[n - 1].Joueur2.WinSet = 0;

        Set.AffichageScoreJeu(TabMatch, n, jeujoueur1, jeujoueur2);

        while (((jeujoueur1 < 6) & (jeujoueur2 < 6)) | ((Math.abs(jeujoueur1 - jeujoueur2)) < 2)) {
           
            TabMatch = Jeu.jeu(TabMatch, n, TabMatch[n-1].DernierService, auto);
            
            if (TabMatch[n-1].DernierService==1){                       
               
                TabMatch[n-1].DernierService=2;
            } else  {
                
                TabMatch[n-1].DernierService=1;
            }
            
            if (a == 1) {
                System.out.println("Le joueur " + TabMatch[n - 1].Joueur1.nomNaissance + " a le service");
            } else {
                System.out.println("Le joueur " + TabMatch[n - 1].Joueur2.nomNaissance + " a le service");
            }

            
            if (TabMatch[n - 1].Joueur1.WinJeu == 1) {
                jeujoueur1++;
                TabMatch[n - 1].Joueur1.JeuJoueur++;

            } else {

                jeujoueur2++;
                TabMatch[n - 1].Joueur2.JeuJoueur++;

            }
            System.out.println("\n");
            Set.AffichageScoreJeu(TabMatch, n, jeujoueur1, jeujoueur2);
        }
        if (jeujoueur1 > jeujoueur2) {
            TabMatch[n - 1].Joueur1.WinSet = 1;
        } else {
            TabMatch[n - 1].Joueur2.WinSet = 1;
        }
        System.out.println("\n");
        System.out.println("Fin du Set");
        System.out.println("\n");
        return TabMatch;
    }

    public static void AffichageScoreJeu(Match[] TabMatch, int n, int jeujoueur1, int jeujoueur2) {

        System.out.println("    Jeu " + TabMatch[n - 1].Joueur1.nomNaissance + " - " + TabMatch[n - 1].Joueur2.nomNaissance + "  :  " + jeujoueur1 + " - " + jeujoueur2);

    }

}
