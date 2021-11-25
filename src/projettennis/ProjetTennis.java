/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projettennis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author axand
 */
public class ProjetTennis {

    public static void main(String[] args) throws IOException {
        int auto = 0;                           //var qui determine si on veut jouer un match en manuel ou en automatique
        int NBRARBITRE = 10;
        int NBRJOUEUR = 128;
        int menu1 = 0;
        int menu2 = 0;

       

        Tournoi objTournoi = new Tournoi();
        ArrayList<Joueur> listClassement = new ArrayList();
        ArrayList<Joueur> listJoueur = new ArrayList();
        ArrayList<Joueur> listQualif = new ArrayList();
        ArrayList<Match> listMatch = new ArrayList();
        ArrayList<Arbitre> listArbitre = new ArrayList();
        
        // Menu ou on choisit le tournoi ainsi que le genre de la compétition

        objTournoi = Tournoi.choixTournoi(objTournoi);          //renvoi le nom du tournoi, le genre (nombre de set max homme/femme) etc

        if (objTournoi.getExit() == 1) {    //sortie du programme
            return;
        }

        System.out.println("\nVous avez choisi le Tournoi " + objTournoi.getGenre() + " " + objTournoi.getNomTournoi()); //affichage de la selection precedente

        System.out.println("\n\n                                                  CREATION DU TOURNOI EN COURS... \n");
        Utilitaire.delay(3000);     //delai de 3s pour la presentation

        System.out.println("Le Tournoi " + objTournoi.getNomTournoi() + " se joue à 128 joueurs, voulez vous créer un/plusieurs joueurs manuellement (dans le cas contraire ils seront générés de facon aléatoire) oui/ non");
        Scanner sc = new Scanner(System.in);
        String str ="";

//boucle de creation de joueur, elle verifie qu'on entre bien oui/non, sinon il faut recommencer la saisie      
         while (str.equals("non") == false) {
                            while ((!str.equals("oui") == true) && (!str.equals("non") == true)) {
                                str= sc.nextLine();
                                if ((!str.equals("oui") == true) && (!str.equals("non") == true)) {
                                    System.out.println("Mauvaise saisie, Veuillez Saisir oui/non");
                                }
                            }
                            if (str.equals("oui") == true){
                                listJoueur.add(Joueur.creerJoueur(listJoueur.size()));
                                System.out.println("Creer un autre joueur ?");
                                str="";
                            }

            }
        
       // si la liste n'est pas vide on demande pour afficher les joueurs créés
        if (!listJoueur.isEmpty()) {
            System.out.println("Vous avez créé " + listJoueur.size() + " Joueurs, voulez vous voir la liste des joueurs créés ?");
            str = sc.nextLine();
            //boucle qui vérifie que la saisie est bien oui/non
            while (!str.equals("oui") == true && !str.equals("non") == true) {
                str = sc.nextLine();
            }
            if (str.equals("oui")) {
                Joueur.afficherJoueur(listJoueur);
            }
            System.out.println("Génération des joueurs " + (NBRJOUEUR - listJoueur.size()) + " restants...");

        }

        System.out.println("Génération des joueurs...\n \n");
        Utilitaire.delay(3000);
        System.out.println("Génération des arbitres...");
        Utilitaire.delay(2000);
        listJoueur = Joueur.genererJoueur(objTournoi.getGenre(), listJoueur);        //creer les joueurs aléatoirement de la compétition
        listArbitre = Arbitre.genererArbitre(objTournoi.getGenre());                 // de meme pour les arbitres

        listMatch = Tournoi.creerCompoMatch(listJoueur, listArbitre, objTournoi.getNbTour());    //création est composition des matchs aléatoirement
        listQualif = Tournoi.creerListeQualif(listMatch, objTournoi.getNbTour());                //creation de la liste des joueurs qualifiés pour avancer dans les tours

        Scanner sc2 = new Scanner(System.in);
        int str2;

        while (menu1 != 1) {                                    // NbTour est le nombre de tour en integer, Tour est la variable String destiné à l'affichage
            switch (objTournoi.getNbTour()) {
                case 1:
                    objTournoi.setTour("Tour 1");
                    break;
                case 2:
                    objTournoi.setTour("Tour 2");
                    break;
                case 3:
                    objTournoi.setTour("Tour 3");
                    break;
                case 4:
                    objTournoi.setTour("Huitième de finale");
                    break;
                case 5:
                    objTournoi.setTour("Quart de finale");
                    break;
                case 6:
                    objTournoi.setTour("Demi-finale");
                    break;
                case 7:
                    objTournoi.setTour("Petite Finale");
                    break;
                case 8:
                    objTournoi.setTour("Finale");
                    break;
            }
            str2 = 0;               //Menu du tournoi, on revient a ce menu apres chaque execution de tour ou de fonction ci dessous
            menu2 = 0;
            System.out.println("Début du Tournoi : \n");
            System.out.println("                                                                   MENU TOURNOI :                                         " + objTournoi.getNomTournoi() + " " + objTournoi.getGenre() + ":  " + objTournoi.getTour() + "\n");
            System.out.println("                                                        1 -   Jouer " + objTournoi.getTour());
            System.out.println("                                                        2 -   Voir la liste des Arbitres");
            System.out.println("                                                        3 -   Voir la liste des Joueurs");
            System.out.println("                                                        4 -   Voir la liste des Joueurs qualifiés");
            System.out.println("                                                        5 -   Voir La composition des Matchs");
            System.out.println("                                                        6 -   Voir les Statistiques Joueurs");
            System.out.println("                                                        7 -   Voir le classement actuel");
            System.out.println("                                                        8 -   Exit");
            System.out.println(" choisir :");
            str2 = 0;
            // boucle de vérification de la saisie, et le catch gere l'exception si la saisie est n'est pas un integer
            while ((str2 == 0) || (str2 > 8)) {
                try {
                    str2 = Integer.parseInt(sc2.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("EXCEPTION");
                }
            }
            //execution du choix du menu, 
            switch (str2) {
                case 1:         //on joue le tour 
                    Tournoi.afficherCompoMatch(listMatch, objTournoi);                 //on affiche la compo de matchs avant de les jouer
                    System.out.println("\n");
                    System.out.println("\n");
                    System.out.println("\n");

                    while (menu2 == 0) {
                        System.out.println("Voulez-vous jouer 1 match ou jouer en automatique ? (Liste des matchs ci-dessus)");  //proposition de jouer un match manuellement
                        Scanner sc3 = new Scanner(System.in);
                        String str3 = "";
                        //boucle de verification de saisie oui/non
                        while (str3.equals("non") == false) {
                            while ((!str3.equals("oui") == true) && (!str3.equals("non") == true)) {
                                str3 = sc3.nextLine();
                                if ((!str3.equals("oui") == true) && (!str3.equals("non") == true)) {
                                    System.out.println("Mauvaise saisie, Veuillez Saisir oui/non");
                                }
                            }
                            if (str3.equals("oui") == true){
                            Scanner numMatch = new Scanner(System.in);
                            int intMatch = 0;

                            if (str3.equals("oui") == true) {
                                while ((intMatch == 0) || (intMatch > listMatch.size())) {                  
                                    System.out.println(" Quel match voulez vous jouer (numero du match) ?");
                                    //boucle de verification de saisie integer
                                    try {
                                        intMatch = Integer.parseInt(numMatch.nextLine());       //IntMatch correspond au numero de match que l'on veut jouer Manuellement
                                    } catch (NumberFormatException e) {
                                        System.out.println("EXCEPTION");
                                    }
                                    if ((intMatch == 0) && intMatch > listMatch.size()) {
                                        System.out.println("Numero de match invalide");
                                    }
                                }
                               
                                auto = 1;
                                if (listMatch.get(intMatch - 1).getResultat() == 1) {
                                    System.out.println("le match n*" + intMatch + " a deja ete joué.");         //resultat correspond a si le match a deja été joué ou non

                                } else {
                                    Match bufferMatch = new Match();                    //BufferMatch est tampon pour pouvoir sortir le match puis le remettre dans la liste
                                    if (objTournoi.getNbTour() == 7) {                                              //NbTour=7 correpspond a la petite finale
                                        System.out.println(objTournoi.getNbTour());

                                        bufferMatch = Match.jouerM(listMatch.get(0), intMatch, objTournoi, auto);
                                        if (bufferMatch.getPerdant() == 1) {
                                            listClassement.set(listClassement.size() - 2, bufferMatch.joueur1);         //traitement de la petite finale different que pour les autres 
                                            listClassement.set(listClassement.size() - 1, bufferMatch.joueur2);         //Place le perdant en premier dans la liste puis le gagant de la petite finale

                                        } else {
                                            listClassement.set(listClassement.size() - 2, bufferMatch.joueur2);         //idem avec ici joueur2 perdant
                                            listClassement.set(listClassement.size() - 1, bufferMatch.joueur1);

                                        }
                                    } else {

                                        bufferMatch = Match.jouerM(listMatch.get(intMatch - 1), intMatch, objTournoi, auto);
                                        if ((objTournoi.getNbTour() != 6) || (objTournoi.getNbTour() != 7)) {                   // NbTour =6 correpond a la demi finale, or pour la demi finale on ne met met les joueurs dans le classmenet vu qu'lls vont jouer la petite finale
                                            if (bufferMatch.getPerdant() == 1) {
                                                listClassement = Tournoi.ajouterClassement(listClassement, bufferMatch.joueur1);

                                            } else {
                                                listClassement = Tournoi.ajouterClassement(listClassement, bufferMatch.joueur2);

                                            }
                                        }
                                    }

                                    listMatch.set(intMatch - 1, bufferMatch);               // on replace le tampon Match dans la liste des matchs

                                }
                                System.out.println("Voulez-vous jouer un autre Match ?");
                                str3 = "";
                       
                            }
                            }
                        }

                        System.out.println("Les Matchs vont se jouer automatiquement...");
                        Utilitaire.delay(2000);
                        auto = 2;
                        int n = 1;
                        Match bufferMatch = new Match();
                        if ((objTournoi.getNbTour() == 7)) {        //De meme, traitement different pour la petite finale vu qu'on ne place pour les joueurs de la demi finale dans le classement

                            System.out.println(objTournoi.getNbTour());

                            System.out.println("\n");
                            bufferMatch = Match.jouerM(listMatch.get(0), n, objTournoi, auto);          // la compo match est compose de la petite finale en premier et de la finale
                            if (bufferMatch.getPerdant() == 1) {                                        //etant au tour de la petite finale on ne joue que le premier match de la liste match
                                listClassement.set(listClassement.size() - 2, bufferMatch.joueur1);
                                listClassement.set(listClassement.size() - 1, bufferMatch.joueur2);

                            } else {
                                listClassement.set(listClassement.size() - 2, bufferMatch.joueur2);
                                listClassement.set(listClassement.size() - 1, bufferMatch.joueur1);

                            }

                            listMatch.set(0, bufferMatch);
                            objTournoi.incrementeNbTour();
                        } else {
                            while (n <= listMatch.size()) {
                                if (listMatch.get(n - 1).getResultat()== 0) {

                                  
                                    bufferMatch = Match.jouerM(listMatch.get(n - 1), n, objTournoi, auto);
                                    if ((objTournoi.getNbTour() != 6) || (objTournoi.getNbTour() != 7)) {           //de meme que plus haut, on ne place pas les joueurs de la demi-finale de le classement vu qu'il joue la petite finale
                                        if (bufferMatch.getPerdant() == 1) {
                                            listClassement = Tournoi.ajouterClassement(listClassement, bufferMatch.joueur1);    //on place le joueur perdant dans le classement

                                        } else {
                                            listClassement = Tournoi.ajouterClassement(listClassement, bufferMatch.joueur2);

                                        }
                                    }
                                    listMatch.set(n - 1, bufferMatch);

                                }
                                n++;
                            }
                            objTournoi.incrementeNbTour();

                        }
                        listQualif = Tournoi.creerListeQualif(listMatch, objTournoi.getNbTour());
                        listMatch = Tournoi.creerCompoMatch(listQualif, listArbitre, objTournoi.getNbTour());

                        menu2 = 1;
                        if (listQualif.size() == 1) {
                            menu1 = 1;
                            objTournoi.vainqueur = listQualif.get(0);
                            listClassement.add(listQualif.get(0));
                            Tournoi.presenterPodium(listClassement, objTournoi);

                        }

                    }

                    break;
                case 2:
                    Arbitre.afficherArbitre(listArbitre);
                    break;
                case 3:
                    Joueur.afficherJoueur(listJoueur);
                    break;
                case 4:

                    Tournoi.afficherQualif(listQualif);
                    break;
                case 5:
                    Tournoi.afficherCompoMatch(listMatch, objTournoi);
                    break;
                case 6:
                    System.out.println("Affichage statistiques joueurs");
                    Statistiques.afficherStat(listJoueur);
                    break;
                case 7:
                    System.out.println("Classement actuel :");
                    Tournoi.afficherClassement(listClassement);
                    break;
                case 8:
                    System.out.println("Vous quittez le Tournoi");
                    return;

            }

        }
        Tournoi.afficherMenuFin(listClassement, listJoueur, objTournoi);
          
    }

}
