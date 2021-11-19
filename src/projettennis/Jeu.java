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
public class Jeu {

    int JeuJoueur1;
    int JeuJoueur2;

    //fonction pour gerer les echanges et les scores.
    public static Match jeu(Match match, int n, int a, int auto, int jeujoueur1, int jeujoueur2, int setjoueur1, int setjoueur2) {

        
        match.Joueur1.WinJeu = 0;
        match.Joueur2.WinJeu = 0;
        

        System.out.println("debut jeu");
        System.out.println("\n");
        int pointjoueur1 = 0;
        int pointjoueur2 = 0;
        System.out.println(auto);

 
        Jeu.AffichageScorePoint(match, pointjoueur1, pointjoueur2, n, jeujoueur1, jeujoueur2, setjoueur1, setjoueur2);

        while ((pointjoueur1 != 5) & (pointjoueur2 != 5)) {

            if (auto == 1) {
                
                if (Echange.Service(match, match.DernierService, (n - 1)) == 1) {
                    if (match.DernierService == 1) {
                        
                        if ((pointjoueur1 == 3) && (pointjoueur2 == 4)) {
                            pointjoueur2 = 3;
                            pointjoueur1 = 3;
                        } else if ((pointjoueur1 == 3) && (pointjoueur2 < 3)) {
                            pointjoueur1 = 5;
                        } else {
                            pointjoueur1++;
                        }

                      
                        match.Joueur1.pointJoueur++;
                        match.Joueur1.Service++;
                        
                    } else {
                        if ((pointjoueur2 == 3) && (pointjoueur1 == 4)) {
                            pointjoueur1 = 3;
                            pointjoueur2 = 3;
                        } else if ((pointjoueur2 == 3) && (pointjoueur1 < 3)) {
                            pointjoueur2 = 5;
                        } else {
                            pointjoueur2++;
                        }
                       
                        match.Joueur2.Service++;
                        match.Joueur2.pointJoueur++;
                     
                    }
                } else {
                    if (match.DernierService == 1) {
                        if ((pointjoueur2 == 3) && (pointjoueur1 == 4)) {
                            pointjoueur1 = 3;
                            pointjoueur2 = 3;
                        } else if ((pointjoueur2 == 3) && (pointjoueur1 < 3)) {
                            pointjoueur2 = 5;
                        } else {
                            pointjoueur2++;
                        }
                        
                        match.Joueur1.Faute++;
                        match.Joueur2.pointJoueur++;
                     
                    } else {
                        if ((pointjoueur1 == 3) && (pointjoueur2 == 4)) {
                            pointjoueur2 = 3;
                            pointjoueur1 = 3;
                        } else if ((pointjoueur1 == 3) && (pointjoueur2 < 3)) {
                            pointjoueur1 = 5;
                        } else {
                            pointjoueur1++;
                        }

                    
                        match.Joueur2.Faute++;
                        match.Joueur1.pointJoueur++;
                   
                    }

                }
            } else {
                          if (Echange.ServiceAuto(match, match.DernierService, (n - 1)) == 1) {
                    if (match.DernierService == 1) {
                        if ((pointjoueur1 == 3) && (pointjoueur2 == 4)) {
                            pointjoueur2 = 3;
                            pointjoueur1 = 3;
                        } else if ((pointjoueur1 == 3) && (pointjoueur2 < 3)) {
                            pointjoueur1 = 5;
                        } else {
                            pointjoueur1++;
                        }

                      
                        match.Joueur1.pointJoueur++;
                        match.Joueur1.Service++;
                        
                    } else {
                        if ((pointjoueur2 == 3) && (pointjoueur1 == 4)) {
                            pointjoueur1 = 3;
                            pointjoueur2 = 3;
                        } else if ((pointjoueur2 == 3) && (pointjoueur1 < 3)) {
                            pointjoueur2 = 5;
                        } else {
                            pointjoueur2++;
                        }
                       
                        match.Joueur2.pointJoueur++;
                        match.Joueur2.Service++;
                      
                    }
                } else {
                    if (match.DernierService == 1) {
                        if ((pointjoueur2 == 3) && (pointjoueur1 == 4)) {
                            pointjoueur1 = 3;
                            pointjoueur2 = 3;
                        } else if ((pointjoueur2 == 3) && (pointjoueur1 < 3)) {
                            pointjoueur2 = 5;
                        } else {
                            pointjoueur2++;
                        }
                       
                        match.Joueur2.pointJoueur++;
                        match.Joueur1.Faute++;
                        
                    } else {
                        if ((pointjoueur1 == 3) && (pointjoueur2 == 4)) {
                            pointjoueur2 = 3;
                            pointjoueur1 = 3;
                        } else if ((pointjoueur1 == 3) && (pointjoueur2 < 3)) {
                            pointjoueur1 = 5;
                        } else {
                            pointjoueur1++;
                        }

                       
                        match.Joueur1.pointJoueur++;
                        match.Joueur2.Faute++;
                        
                    }

                }
            }
            System.out.println("\n");
            Jeu.AffichageScorePoint(match, pointjoueur1, pointjoueur2, n, jeujoueur1, jeujoueur2, setjoueur1, setjoueur2);
            System.out.println("\n");
        }
        if (pointjoueur1 == 5) {
            
            match.Joueur1.WinJeu = 1;
           
        } else {
           
            match.Joueur2.WinJeu = 1;
        }

        System.out.println("Fin du jeu");
        return match;
    }

    public static void AffichageScorePoint(Match match, int pointjoueur1, int pointjoueur2, int n, int jeujoueur1, int jeujoueur2, int setjoueur1, int setjoueur2) {
        String score1 = "0";
        String score2 = "0";

        switch (pointjoueur1) {
            case 0:
                score1 = "0";
                break;
            case 1:
                score1 = "15";
                break;
            case 2:
                score1 = "30";
                break;
            case 3:
                score1 = "40";
                break;
            case 4:

                score1 = "A";
                break;

            case 5:
                score1 = "GAGNE";
                System.out.println(" Jeu gagné par : " + match.Joueur1.nomNaissance);
                break;

        }
        switch (pointjoueur2) {
            case 0:
                score2 = "0";
                break;
            case 1:
                score2 = "15";
                break;
            case 2:
                score2 = "30";
                break;
            case 3:
                score2 = "40";
                break;
            case 4:

                score2 = "A";
                break;
            case 5:
                score2 = "GAGNE";
                System.out.println(" Jeu gagné par : " +match.Joueur2.nomNaissance);
                break;

        }
        System.out.println("\n");
        System.out.println("Joueur      SET JEU  POINT");
        System.out.println(Tournoi.affichageTxt(match.Joueur1.nomNaissance) + " | "+ setjoueur1+" | "+ jeujoueur1 +" | " + score1);
        System.out.println(Tournoi.affichageTxt(match.Joueur2.nomNaissance) + " | "+ setjoueur2+" | "+ jeujoueur2 +" | " + score2);
        System.out.println("\n");
    }
    
     
}
