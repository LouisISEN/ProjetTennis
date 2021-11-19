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
    public static ArrayList<Match> jeu(ArrayList<Match> ListMatch, int n, int a, int auto, int jeujoueur1, int jeujoueur2, int setjoueur1, int setjoueur2) {

        Match BufferMatch = new Match();
        BufferMatch = ListMatch.get(n - 1);
        BufferMatch.Joueur1.WinJeu = 0;
        BufferMatch.Joueur2.WinJeu = 0;
        ListMatch.set(n - 1, BufferMatch);

        System.out.println("debut jeu");
        System.out.println("\n");
        int pointjoueur1 = 0;
        int pointjoueur2 = 0;
        System.out.println(auto);

 
        Jeu.AffichageScorePoint(ListMatch, pointjoueur1, pointjoueur2, n, jeujoueur1, jeujoueur2, setjoueur1, setjoueur2);

        while ((pointjoueur1 != 5) & (pointjoueur2 != 5)) {

            if (auto == 1) {
                
                if (Echange.Service(ListMatch, ListMatch.get(n - 1).DernierService, (n - 1)) == 1) {
                    if (ListMatch.get(n - 1).DernierService == 1) {
                        
                        if ((pointjoueur1 == 3) && (pointjoueur2 == 4)) {
                            pointjoueur2 = 3;
                            pointjoueur1 = 3;
                        } else if ((pointjoueur1 == 3) && (pointjoueur2 < 3)) {
                            pointjoueur1 = 5;
                        } else {
                            pointjoueur1++;
                        }

                        BufferMatch = ListMatch.get(n - 1);
                        BufferMatch.Joueur1.pointJoueur++;
                        BufferMatch.Joueur1.Service++;
                        ListMatch.set(n - 1, BufferMatch);
                    } else {
                        if ((pointjoueur2 == 3) && (pointjoueur1 == 4)) {
                            pointjoueur1 = 3;
                            pointjoueur2 = 3;
                        } else if ((pointjoueur2 == 3) && (pointjoueur1 < 3)) {
                            pointjoueur2 = 5;
                        } else {
                            pointjoueur2++;
                        }
                        BufferMatch = ListMatch.get(n - 1);
                        BufferMatch.Joueur2.Service++;
                        BufferMatch.Joueur2.pointJoueur++;
                        ListMatch.set(n - 1, BufferMatch);
                    }
                } else {
                    if (ListMatch.get(n - 1).DernierService == 1) {
                        if ((pointjoueur2 == 3) && (pointjoueur1 == 4)) {
                            pointjoueur1 = 3;
                            pointjoueur2 = 3;
                        } else if ((pointjoueur2 == 3) && (pointjoueur1 < 3)) {
                            pointjoueur2 = 5;
                        } else {
                            pointjoueur2++;
                        }
                        BufferMatch = ListMatch.get(n - 1);
                        BufferMatch.Joueur1.Faute++;
                        BufferMatch.Joueur2.pointJoueur++;
                        ListMatch.set(n - 1, BufferMatch);
                    } else {
                        if ((pointjoueur1 == 3) && (pointjoueur2 == 4)) {
                            pointjoueur2 = 3;
                            pointjoueur1 = 3;
                        } else if ((pointjoueur1 == 3) && (pointjoueur2 < 3)) {
                            pointjoueur1 = 5;
                        } else {
                            pointjoueur1++;
                        }

                        BufferMatch = ListMatch.get(n - 1);
                        BufferMatch.Joueur2.Faute++;
                        BufferMatch.Joueur1.pointJoueur++;
                        ListMatch.set(n - 1, BufferMatch);
                    }

                }
            } else {
                          if (Echange.ServiceAuto(ListMatch, ListMatch.get(n - 1).DernierService, (n - 1)) == 1) {
                    if (ListMatch.get(n - 1).DernierService == 1) {
                        if ((pointjoueur1 == 3) && (pointjoueur2 == 4)) {
                            pointjoueur2 = 3;
                            pointjoueur1 = 3;
                        } else if ((pointjoueur1 == 3) && (pointjoueur2 < 3)) {
                            pointjoueur1 = 5;
                        } else {
                            pointjoueur1++;
                        }

                        BufferMatch = ListMatch.get(n - 1);
                        BufferMatch.Joueur1.pointJoueur++;
                        BufferMatch.Joueur1.Service++;
                        ListMatch.set(n - 1, BufferMatch);
                    } else {
                        if ((pointjoueur2 == 3) && (pointjoueur1 == 4)) {
                            pointjoueur1 = 3;
                            pointjoueur2 = 3;
                        } else if ((pointjoueur2 == 3) && (pointjoueur1 < 3)) {
                            pointjoueur2 = 5;
                        } else {
                            pointjoueur2++;
                        }
                        BufferMatch = ListMatch.get(n - 1);
                        BufferMatch.Joueur2.pointJoueur++;
                        BufferMatch.Joueur2.Service++;
                        ListMatch.set(n - 1, BufferMatch);
                    }
                } else {
                    if (ListMatch.get(n - 1).DernierService == 1) {
                        if ((pointjoueur2 == 3) && (pointjoueur1 == 4)) {
                            pointjoueur1 = 3;
                            pointjoueur2 = 3;
                        } else if ((pointjoueur2 == 3) && (pointjoueur1 < 3)) {
                            pointjoueur2 = 5;
                        } else {
                            pointjoueur2++;
                        }
                        BufferMatch = ListMatch.get(n - 1);
                        BufferMatch.Joueur2.pointJoueur++;
                        BufferMatch.Joueur1.Faute++;
                        ListMatch.set(n - 1, BufferMatch);
                    } else {
                        if ((pointjoueur1 == 3) && (pointjoueur2 == 4)) {
                            pointjoueur2 = 3;
                            pointjoueur1 = 3;
                        } else if ((pointjoueur1 == 3) && (pointjoueur2 < 3)) {
                            pointjoueur1 = 5;
                        } else {
                            pointjoueur1++;
                        }

                        BufferMatch = ListMatch.get(n - 1);
                        BufferMatch.Joueur1.pointJoueur++;
                        BufferMatch.Joueur2.Faute++;
                        ListMatch.set(n - 1, BufferMatch);
                    }

                }
            }
            System.out.println("\n");
            Jeu.AffichageScorePoint(ListMatch, pointjoueur1, pointjoueur2, n, jeujoueur1, jeujoueur2, setjoueur1, setjoueur2);
            System.out.println("\n");
        }
        if (pointjoueur1 == 5) {
            BufferMatch = ListMatch.get(n - 1);
            BufferMatch.Joueur1.WinJeu = 1;
            ListMatch.set(n - 1, BufferMatch);
        } else {
            BufferMatch = ListMatch.get(n - 1);
            BufferMatch.Joueur2.WinJeu = 1;
            ListMatch.set(n - 1, BufferMatch);
        }

        System.out.println("Fin du jeu");
        return ListMatch;
    }

    public static void AffichageScorePoint(ArrayList<Match> ListMatch, int pointjoueur1, int pointjoueur2, int n, int jeujoueur1, int jeujoueur2, int setjoueur1, int setjoueur2) {
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
                System.out.println(" Jeu gagné par : " + ListMatch.get(n - 1).Joueur1.nomNaissance);
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
                System.out.println(" Jeu gagné par : " + ListMatch.get(n - 1).Joueur2.nomNaissance);
                break;

        }
        System.out.println("\n");
        System.out.println("Joueur      SET JEU  POINT");
        System.out.println(Tournoi.affichageTxt(ListMatch.get(n - 1).Joueur1.nomNaissance) + " | "+ setjoueur1+" | "+ jeujoueur1 +" | " + score1);
        System.out.println(Tournoi.affichageTxt(ListMatch.get(n - 1).Joueur2.nomNaissance) + " | "+ setjoueur2+" | "+ jeujoueur2 +" | " + score2);
        System.out.println("\n");
    }
    
     
}
