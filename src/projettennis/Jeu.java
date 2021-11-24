/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projettennis;

import java.util.ArrayList;

/**
 *La class Jeu permet de gérer l'affiche du score, les echanges dans un jeu, et les statistiques joueurs (nombre de point)
 * @author axand
 */
public class Jeu {

    private int jeuJoueur1=0;               // attributs faisant avancer le match 
    private int jeuJoueur2=0;   


    public int getJeuJoueur1() {
        return this.jeuJoueur1;
    }

    public void setJeuJoueur1(int jeuJoueur1) {
        this.jeuJoueur1 = jeuJoueur1;
    }

    public int getJeuJoueur2() {
        return this.jeuJoueur2;
    }

    public void setJeuJoueur2(int jeuJoueur2) {
        this.jeuJoueur2 = jeuJoueur2;
    }

    public void IncrementeJeuJoueur1() {
        jeuJoueur1++;
    }

    public void IncrementeJeuJoueur2() {
        jeuJoueur2++;
    }


    public static Match jeu(Match match, Tournoi ObjTournoi, int n, int a, int auto, int jeuJoueur1, int jeuJoueur2, int setJoueur1, int setJoueur2) {

        Echange point = new Echange();
        
        match.joueur1.setWinJeu(0);
        match.joueur2.setWinJeu(0);

        System.out.println("Debut jeu");
        System.out.println("\n");

 
        Jeu.AffichageScorePoint(match, ObjTournoi,point.getPointJoueur1(), point.getPointJoueur2(), n, jeuJoueur1, jeuJoueur2, setJoueur1, setJoueur2);
        //affiche les scores, point jeu et set
        while ((point.getPointJoueur1() != 5) && (point.getPointJoueur2() != 5)) {
            // tant que l'un des deux joueurs n'a pas 5 point (40pts + marque) on continue de jouer le jeu
            if (auto == 1) {        //auto determine si on joue le match manuellement ou autommatiquement (1 manuellement et 2 automatiquement)
                
                if (Echange.Service(match, match.getDernierService(), (n - 1)) == 1) {      // Si le joueur marque
                    if (match.getDernierService() == 1) {                                   // si c'est le joueur 1 qui a servi
                        
                        if ((point.getPointJoueur1() == 3) && (point.getPointJoueur2() == 4)) {     //condition pour l'avantages (score 40-40) ou non
                            point.setPointJoueur2(3);                                               
                            point.setPointJoueur1(3);
                        } else if ((point.getPointJoueur1() == 3) && (point.getPointJoueur2() < 3)) {
                            point.setPointJoueur1(5);
                        } else {
                            point.IncrementePointJoueur1();;                                        //incremente les variables qui font avancer le match
                        }

                      
                        match.joueur1.IncrementePointJoueur();          //statistiques joueurs
                        match.joueur1.IncrementeService();;
                        
                    } else {                                // si c'est le joueur 2 qui a servi
                        if ((point.getPointJoueur2() == 3) && (point.getPointJoueur1() == 4)) {
                            point.setPointJoueur1(3);
                            point.setPointJoueur2(3);
                        } else if ((point.getPointJoueur2() == 3) && (point.getPointJoueur1() < 3)) {
                            point.setPointJoueur2(5);
                        } else {
                            point.IncrementePointJoueur2();;
                        }
                       
                        match.joueur2.IncrementeService();;
                        match.joueur2.IncrementePointJoueur();;
                     
                    }
                } else {                                            // si le joueur loupe son service
                    if (match.getDernierService() == 1) {               // si c'est le joueur 1 qui a servi
                        if ((point.getPointJoueur2() == 3) && (point.getPointJoueur1() == 4)) {
                            point.setPointJoueur1(3);
                            point.setPointJoueur2(3);
                        } else if ((point.getPointJoueur2() == 3) && (point.getPointJoueur1() < 3)) {
                            point.setPointJoueur2(5);
                        } else {
                            point.IncrementePointJoueur2();;
                        }
                        
                        match.joueur1.IncrementeFaute();;
                        match.joueur2.IncrementePointJoueur();;
                     
                    } else {                                        // si c'est le joueur 2 qui a servi
                        if ((point.getPointJoueur1() == 3) && (point.getPointJoueur2()== 4)) {
                            point.setPointJoueur2(3);
                            point.setPointJoueur1(3);
                        } else if ((point.getPointJoueur1() == 3) && (point.getPointJoueur2() < 3)) {
                            point.setPointJoueur1(5);
                        } else {                                                                                                //Pareil qu'au dessus 
                            point.IncrementePointJoueur1();
                        }

                    
                        match.joueur2.IncrementeFaute();;
                        match.joueur1.IncrementePointJoueur();
                   
                    }

                }
            } else {                        // Meme Chose qu'au dessus mais pour la version en automatique 
                          if (Echange.ServiceAuto(match, match.getDernierService(), (n - 1)) == 1) {
                    if (match.getDernierService() == 1) {
                        if ((point.getPointJoueur1() == 3) && (point.getPointJoueur2() == 4)) {
                            point.setPointJoueur2(3);
                            point.setPointJoueur1(3);
                        } else if ((point.getPointJoueur1() == 3) && (point.getPointJoueur2() < 3)) {
                            point.setPointJoueur1(5);
                        } else {
                            point.IncrementePointJoueur1();;
                        }

                      
                        match.joueur1.IncrementePointJoueur();;
                        match.joueur1.IncrementeService();;
                        
                    } else {
                        if ((point.getPointJoueur2() == 3) && (point.getPointJoueur1() == 4)) {
                            point.setPointJoueur1(3);
                            point.setPointJoueur2(3);
                        } else if ((point.getPointJoueur2() == 3) && (point.getPointJoueur1() < 3)) {
                            point.setPointJoueur2(5);
                        } else {
                            point.IncrementePointJoueur2();;
                        }
                       
                        match.joueur2.IncrementePointJoueur();;
                        match.joueur2.IncrementeService();;
                      
                    }
                } else {
                    if (match.getDernierService() == 1) {
                        if ((point.getPointJoueur2() == 3) && (point.getPointJoueur1() == 4)) {
                            point.setPointJoueur1(3);
                            point.setPointJoueur2(3);
                        } else if ((point.getPointJoueur2() == 3) && (point.getPointJoueur1() < 3)) {
                            point.setPointJoueur2(5);
                        } else {
                            point.IncrementePointJoueur2();;
                        }
                       
                        match.joueur2.IncrementePointJoueur();;
                        match.joueur1.IncrementeFaute();;
                        
                    } else {
                        if ((point.getPointJoueur1() == 3) && (point.getPointJoueur2() == 4)) {
                            point.setPointJoueur2(3);
                            point.setPointJoueur1(3);
                        } else if ((point.getPointJoueur1() == 3) && (point.getPointJoueur2() < 3)) {
                            point.setPointJoueur1(5);
                        } else {
                            point.IncrementePointJoueur1();
                        }

                       
                        match.joueur1.IncrementePointJoueur();;
                        match.joueur2.IncrementeFaute();;
                        
                    }

                }
            }
            //affichage du score a la fin de chaque echange
            System.out.println("\n");
            Jeu.AffichageScorePoint(match, ObjTournoi, point.getPointJoueur1(), point.getPointJoueur2(), n, jeuJoueur1, jeuJoueur2, setJoueur1, setJoueur2);
            System.out.println("\n");
        }
        if (point.getPointJoueur1() == 5) {   // si on sort de la boucle cela veut dire qu'un joueur a gagné le jeu, on determine qui a gagné
            
            match.joueur1.setWinJeu(1);;
           
        } else {
           
            match.joueur2.setWinJeu(1);
        }

        System.out.println("Fin du jeu");
        return match;
    }

    public static void AffichageScorePoint(Match match, Tournoi ObjTournoi, int pointJoueur1, int pointJoueur2, int n, int jeuJoueur1, int jeuJoueur2, int setJoueur1, int setJoueur2) {
        String score1 = "0";
        String score2 = "0";
        // on compte les scores de 1,2,3,4,5 mais pour l'affichages on affiche 0, 15, 30, 40, Av, et gagné
        switch (pointJoueur1) {
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
                //affichage du gagnant du jeu
                System.out.println(" Jeu gagné par : " + match.joueur1.getNomNaissance());
                Spectateur.applaudir();
                break;

        }
        switch (pointJoueur2) {
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
                System.out.println(" Jeu gagné par : " +match.joueur2.getNomNaissance());
                break;

        }
        System.out.println("\n"); //affichage du score
        System.out.println("Joueur                SET JEU  POINT                                                                   "+Utilitaire.affichageTxt(ObjTournoi.getTour(), 15)+"Match n*"+n);
        System.out.println(Utilitaire.affichageTxt(match.joueur1.getNomNaissance(),10)+ Utilitaire.affichageTxt(match.joueur1.getPrenom(),10) + " | "+ setJoueur1+" | "+ jeuJoueur1 +" | " + score1);
        System.out.println(Utilitaire.affichageTxt(match.joueur2.getNomNaissance(),10)+ Utilitaire.affichageTxt(match.joueur2.getPrenom(),10) + " | "+ setJoueur2+" | "+ jeuJoueur2 +" | " + score2);
        System.out.println("\n");
    }
    
     
}
