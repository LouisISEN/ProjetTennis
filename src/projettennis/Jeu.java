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
    public static Match[] jeu(Match[] TabMatch, int n, int a, int auto) {
        TabMatch[n - 1].Joueur1.WinJeu = 0;
        TabMatch[n - 1].Joueur2.WinJeu = 0;
        System.out.println("debut jeu");
        System.out.println("\n");
        int pointjoueur1 = 0;
        int pointjoueur2 = 0;
        System.out.println(auto);
        if (auto == 1) {

            if (Echange.Service(TabMatch, TabMatch[n - 1].DernierService, (n - 1)) == 1) {

                //  TabMatch[n - 1].Joueur1.pointJoueur++;
                TabMatch[n - 1].Joueur1.pointJoueur++;
                pointjoueur1++;
            } else {
                //  TabMatch[n - 1].Joueur2.pointJoueur++;
                TabMatch[n - 1].Joueur2.pointJoueur++;
                pointjoueur2++;
            }
        } else {
            if (Echange.ServiceAuto(TabMatch, TabMatch[n - 1].DernierService, (n - 1)) == 1) {

                //  TabMatch[n - 1].Joueur1.pointJoueur++;
                TabMatch[n - 1].Joueur1.pointJoueur++;
                pointjoueur1++;
            } else {
                //  TabMatch[n - 1].Joueur2.pointJoueur++;
                TabMatch[n - 1].Joueur2.pointJoueur++;
                pointjoueur2++;
            }
        }

        Jeu.AffichageScorePoint(TabMatch, pointjoueur1, pointjoueur2, n);

        while ((pointjoueur1 != 5) & (pointjoueur2 != 5)) {

            if (auto == 1) {
                if (Echange.Service(TabMatch, TabMatch[n - 1].DernierService, (n - 1)) == 1) {

                    if ((pointjoueur1 == 3) && (pointjoueur2 == 4)) {
                        pointjoueur2 = 3;
                        pointjoueur1 = 3;
                    } else if ((pointjoueur1 == 3) && (pointjoueur2 < 3)) {
                        pointjoueur1 = 5;
                    } else {
                        pointjoueur1++;
                    }
                    TabMatch[n - 1].Joueur1.pointJoueur++;

                } else {
                    if ((pointjoueur2 == 3) && (pointjoueur1 == 4)) {
                        pointjoueur1 = 3;
                        pointjoueur2 = 3;
                    } else if ((pointjoueur2 == 3) && (pointjoueur1 < 3)) {
                        pointjoueur2 = 5;
                    } else {
                        pointjoueur2++;
                    }

                    TabMatch[n - 1].Joueur2.pointJoueur++;

                }
            } else {
                if (Echange.ServiceAuto(TabMatch, TabMatch[n - 1].DernierService, (n - 1)) == 1) {

                    if ((pointjoueur1 == 3) && (pointjoueur2 == 4)) {
                        pointjoueur2 = 3;
                        pointjoueur1 = 3;
                    } else if ((pointjoueur1 == 3) && (pointjoueur2 < 3)) {
                        pointjoueur1 = 5;
                    } else {
                        pointjoueur1++;
                    }
                    TabMatch[n - 1].Joueur1.pointJoueur++;

                } else {
                    if ((pointjoueur2 == 3) && (pointjoueur1 == 4)) {
                        pointjoueur1 = 3;
                        pointjoueur2 = 3;
                    } else if ((pointjoueur2 == 3) && (pointjoueur1 < 3)) {
                        pointjoueur2 = 5;
                    } else {
                        pointjoueur2++;
                    }

                    TabMatch[n - 1].Joueur2.pointJoueur++;

                }
            }
            System.out.println("\n");
            Jeu.AffichageScorePoint(TabMatch, pointjoueur1, pointjoueur2, n);
            System.out.println("\n");
        }
        if (pointjoueur1 == 5) {
            TabMatch[n - 1].Joueur1.WinJeu = 1;
        } else {
            TabMatch[n - 1].Joueur2.WinJeu = 1;
        }

        System.out.println("Fin du jeu");
        return TabMatch;
    }

    public static void AffichageScorePoint(Match[] TabMatch, int pointjoueur1, int pointjoueur2, int n) {
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
                System.out.println(" Victoire du joueur 1 : " + TabMatch[n - 1].Joueur1.nomNaissance);
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
                System.out.println(" Victoire du joueur 2 : " + TabMatch[n - 1].Joueur2.nomNaissance);
                break;

        }
        System.out.println("\n");
        System.out.println("    Point " + TabMatch[n - 1].Joueur1.nomNaissance + " - " + TabMatch[n - 1].Joueur2.nomNaissance + "  :  " + score1 + " - " + score2);
        System.out.println("\n");
    }
}
