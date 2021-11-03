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
public class Jeu {

    int JeuJoueur1;
    int JeuJoueur2;

    //fonction pour gerer les echanges et les scores.
    public static void jeu(Match match, Tournoi[] TabMatch, int n, int a) {
        System.out.println("debut jeu");
        int pointjoueur1 = 0;
        int pointjoueur2 = 0;

        if (Echange.Service(TabMatch, a, (n - 1)) == 1) {

            match.pointJoueur1++;
            pointjoueur1++;
        } else {
            match.pointJoueur2++;
            pointjoueur2++;
        }
        Jeu.AffichageScoreJeu(TabMatch, pointjoueur1, pointjoueur2, n);

        while ((pointjoueur1 != 5) & (pointjoueur2 != 5)) {
            if (Echange.Service(TabMatch, a, (n - 1)) == 1) {
                
                if ((pointjoueur1==3)&&(pointjoueur2==4)){
                    pointjoueur2=3;
                    pointjoueur1=3;
                }
                else if ((pointjoueur1==3)&&(pointjoueur2<3)){
                    pointjoueur1=5;
                }
                else {
                    pointjoueur1++;
                }
                match.pointJoueur1++;
                
                
            } else {
                 if ((pointjoueur2==3)&&(pointjoueur1==4)){
                    pointjoueur1=3;
                    pointjoueur2=3;
                }
                else if ((pointjoueur2==3)&&(pointjoueur1<3)){
                    pointjoueur2=5;
                }
                else {
                    pointjoueur2++;
                }
                
                match.pointJoueur2++;
                
            }

            Jeu.AffichageScoreJeu(TabMatch, pointjoueur1, pointjoueur2, n);
        }
        System.out.println("fin du jeu   " + match.pointJoueur1 + match.pointJoueur2);
    }
    
    

    public static void AffichageScoreJeu(Tournoi[] TabMatch, int pointjoueur1, int pointjoueur2, int n) {
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
                break;

        }
        System.out.println(TabMatch[n - 1].Joueur1 + " - " + TabMatch[n - 1].Joueur2 + "  :  " + score1 + " - " + score2);

    }
}
