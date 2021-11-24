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
        int auto = 0;
        int nbrArbitre = 10;
        int nbrJoueur = 128;
        int menu1 = 0;
        int menu2 = 0;

        String adrFileA = "info-arbitre.txt";

        Tournoi objTournoi = new Tournoi();
        ArrayList<Joueur> listClassement = new ArrayList();
        ArrayList<Joueur> listJoueur = new ArrayList();
        ArrayList<Joueur> listQualif = new ArrayList();
        ArrayList<Match> listMatch = new ArrayList();
        ArrayList<Arbitre> listArbitre = new ArrayList();

        System.out.println("                                               Bienvenue dans le menu de création de tournoi :");
        System.out.println("                                                          1- Open d'Australie");
        System.out.println("                                                          2- Wimbledon");
        System.out.println("                                                          3- Roland Garros");
        System.out.println("                                                          4- US Open");
        System.out.println("                                                          5- Exit");
        System.out.println("\n Choisissez le tournoi (en saisissant le chiffre associé) : ");

        objTournoi = Tournoi.ChoixTournoi(objTournoi);

        if (objTournoi.getExit() == 1) {
            return;
        }

        System.out.println("\nVous avez choisi le Tournoi " + objTournoi.getGenre() + " " + objTournoi.getNomTournoi());

        System.out.println("\n\n                                                  CREATION DU TOURNOI EN COURS... \n");
        Utilitaire.delay(3000);

        System.out.println("Le Tournoi " + objTournoi.getNomTournoi() + " se joue à 128 joueurs, voulez vous créer un/plusieurs joueurs manuellement (dans le cas contraire ils seront générés de facon aléatoire)");
        Scanner sc = new Scanner(System.in);
        String str ="";

      
         while (str.equals("non") == false) {
                            while ((!str.equals("oui") == true) && (!str.equals("non") == true)) {
                                str= sc.nextLine();
                                if ((!str.equals("oui") == true) && (!str.equals("non") == true)) {
                                    System.out.println("Mauvaise saisie, Veuillez Saisir oui/non");
                                }
                            }
                            if (str.equals("oui") == true){
                                listJoueur.add(Joueur.NewJoueur(listJoueur.size()));
                                System.out.println("Creer un autre joueur ?");
                                str="";
                            }

            }
        
       
        if (!listJoueur.isEmpty()) {
            System.out.println("Vous avez creer " + listJoueur.size() + " Joueurs, voulez vous voir la liste des joueurs créés ?");
            str = sc.nextLine();
            while (!str.equals("oui") == true && !str.equals("non") == true) {
                str = sc.nextLine();
            }
            if (str.equals("oui")) {
                Joueur.AffichageJoueur(listJoueur);
            }
            System.out.println("Génération des joueurs " + (nbrJoueur - listJoueur.size()) + " restants...");

        }

        System.out.println("Génération des joueurs...\n \n");
        Utilitaire.delay(3000);
        System.out.println("Génération des arbitres...");
        Utilitaire.delay(1000);
        listJoueur = Joueur.GenerateurJoueur(objTournoi.getGenre(), listJoueur);
        listArbitre = Arbitre.GenerateurArbitre(objTournoi.getGenre());

        listMatch = Tournoi.CompoMatch(listJoueur, listArbitre, objTournoi.getNbTour());
        listQualif = Tournoi.ListeQualif(listMatch, objTournoi.getNbTour());

        Scanner sc2 = new Scanner(System.in);
        int str2;

        while (menu1 != 1) {
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
            str2 = 0;
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

            while ((str2 == 0) || (str2 > 8)) {
                try {
                    str2 = Integer.parseInt(sc2.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("EXCEPTION");
                }
            }

            switch (str2) {
                case 1:
                    Tournoi.AffichageCompoMatch(listMatch, objTournoi);
                    System.out.println("\n");
                    System.out.println("\n");
                    System.out.println("\n");

                    while (menu2 == 0) {
                        System.out.println("Voulez-vous jouer 1 match ou jouer en automatique ? (Liste des matchs ci-dessus)");
                        Scanner sc3 = new Scanner(System.in);
                        String str3 = "";
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

                                    try {
                                        intMatch = Integer.parseInt(numMatch.nextLine());
                                    } catch (NumberFormatException e) {
                                        System.out.println("EXCEPTION");
                                    }
                                    if ((intMatch == 0) && intMatch > listMatch.size()) {
                                        System.out.println("Numero de match invalide");
                                    }
                                }
                               
                                auto = 1;
                                if (listMatch.get(intMatch - 1).getResultat() == 1) {
                                    System.out.println("le match n*" + intMatch + " a deja ete joué.");

                                } else {
                                    Match bufferMatch = new Match();
                                    if (objTournoi.getNbTour() == 7) {
                                        System.out.println(objTournoi.getNbTour());

                                        bufferMatch = Match.JouerM(listMatch.get(0), intMatch, objTournoi, auto);
                                        if (bufferMatch.getPerdant() == 1) {
                                            listClassement.set(listClassement.size() - 2, bufferMatch.joueur1);
                                            listClassement.set(listClassement.size() - 1, bufferMatch.joueur2);

                                        } else {
                                            listClassement.set(listClassement.size() - 2, bufferMatch.joueur2);
                                            listClassement.set(listClassement.size() - 1, bufferMatch.joueur1);

                                        }
                                    } else {

                                        bufferMatch = Match.JouerM(listMatch.get(intMatch - 1), intMatch, objTournoi, auto);
                                        if ((objTournoi.getNbTour() != 6) || (objTournoi.getNbTour() != 7)) {
                                            if (bufferMatch.getPerdant() == 1) {
                                                listClassement = Tournoi.Classement(listClassement, bufferMatch.joueur1);

                                            } else {
                                                listClassement = Tournoi.Classement(listClassement, bufferMatch.joueur2);

                                            }
                                        }
                                    }

                                    listMatch.set(intMatch - 1, bufferMatch);

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
                        if ((objTournoi.getNbTour() == 7)) {

                            System.out.println(objTournoi.getNbTour());

                            System.out.println("\n");
                            bufferMatch = Match.JouerM(listMatch.get(0), n, objTournoi, auto);
                            if (bufferMatch.getPerdant() == 1) {
                                listClassement.set(listClassement.size() - 2, bufferMatch.joueur1);
                                listClassement.set(listClassement.size() - 1, bufferMatch.joueur2);

                            } else {
                                listClassement.set(listClassement.size() - 2, bufferMatch.joueur2);
                                listClassement.set(listClassement.size() - 1, bufferMatch.joueur1);

                            }

                            listMatch.set(0, bufferMatch);
                            objTournoi.IncrementeNbTour();
                        } else {
                            while (n <= listMatch.size()) {
                                if (listMatch.get(n - 1).getResultat()== 0) {

                                  
                                    bufferMatch = Match.JouerM(listMatch.get(n - 1), n, objTournoi, auto);
                                    if ((objTournoi.getNbTour() != 6) || (objTournoi.getNbTour() != 7)) {
                                        if (bufferMatch.getPerdant() == 1) {
                                            listClassement = Tournoi.Classement(listClassement, bufferMatch.joueur1);

                                        } else {
                                            listClassement = Tournoi.Classement(listClassement, bufferMatch.joueur2);

                                        }
                                    }
                                    listMatch.set(n - 1, bufferMatch);

                                }
                                n++;
                            }
                            objTournoi.IncrementeNbTour();

                        }
                        listQualif = Tournoi.ListeQualif(listMatch, objTournoi.getNbTour());
                        listMatch = Tournoi.CompoMatch(listQualif, listArbitre, objTournoi.getNbTour());

                        menu2 = 1;
                        if (listQualif.size() == 1) {
                            menu1 = 1;
                            objTournoi.Vainqueur = listQualif.get(0);
                            listClassement.add(listQualif.get(0));
                            Tournoi.PresentationPodium(listClassement, objTournoi);

                        }

                    }

                    break;
                case 2:
                    Arbitre.AffichageArbitre(listArbitre);
                    break;
                case 3:
                    Joueur.AffichageJoueur(listJoueur);
                    break;
                case 4:

                    Tournoi.AffichageQualif(listQualif);
                    break;
                case 5:
                    Tournoi.AffichageCompoMatch(listMatch, objTournoi);
                    break;
                case 6:
                    System.out.println("Affichage statistiques joueurs");
                    Statistiques.AffichageStat(listJoueur);
                    break;
                case 7:
                    System.out.println("Classement actuel :");
                    Tournoi.AffichageClassement(listClassement);
                    break;
                case 8:
                    System.out.println("Vous quittez le Tournoi");
                    return;

            }

        }
        Tournoi.MenuFin(listClassement, listJoueur, objTournoi);
          
    }

}
