/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projettennis;

import java.io.IOException;
//import java.util.Random;
import java.util.Scanner;
//import projettennis.Joueur;
//import projettennis.Set;

/**
 *
 * @author axand
 */
public class ProjetTennis {

    public static void main(String[] args) throws IOException {

        int NbrArbitre = 10;
        int NbrJoueur = 100;
        int NewJ = 0;
        int menu1 = 0;
        int menu2 = 0;
        int menu3 = 0;

        String AdrFileA = "info-arbitre.txt";

        Joueur[] TabJoueur = new Joueur[NbrJoueur];     //<-- NOMBRE DE JOUEUR+1
        String[] TabQualif = new String[NbrJoueur];
        Tournoi[] TabMatch = new Tournoi[(NbrJoueur / 2)];
        Arbitre[] TabArbitre = new Arbitre[NbrArbitre];
        Tournoi ObjTournoi = new Tournoi();

        while (menu1 != 1) {

            System.out.println("                                               Bienvunue dans le menu de création de tournoi :");
            System.out.println("                                                          1- Open d'Australie");
            System.out.println("                                                          2- Wimbledon");
            System.out.println("                                                          3- Roland Garros");
            System.out.println("                                                          4- US Open");
            System.out.println("                                                          5- Exit");
            System.out.println("\n Choisissez le tournoi (en saisissant le chiffre associé) : ");

            Scanner sc = new Scanner(System.in);
            int str = sc.nextInt();
            Scanner sc2 = new Scanner(System.in);

            switch (str) {
                case 1 -> {
                    System.out.println("Choisissez le genre du Tournoi (F pour féminin et H pour Masculin)");

                    String str2 = sc2.nextLine();
                    if (str2.equals("F") || str2.equals("f")) {
                        ObjTournoi.genre = "Féminin";
                    } else if (str2.equals("M") || str2.equals("m")) {
                        ObjTournoi.genre = "Masculin";
                    } else {
                        System.out.println("Mauvais choix du genre, Veuillez indiquer F pour féminin ou M pour Masculin");
                        break;
                    }

                    ObjTournoi.NomTournoi = "Open d'Australie";

                    menu1 = 1;
                }
                case 2 -> {
                    System.out.println("Choisissez le genre du Tournoi (F pour féminin et H pour Masculin)");

                    String str2 = sc2.nextLine();
                    if (str2.equals("F") || str2.equals("f")) {
                        ObjTournoi.genre = "Féminin";
                    } else if (str2.equals("M") || str2.equals("m")) {
                        ObjTournoi.genre = "Masculin";
                    } else {
                        System.out.println("Mauvais choix du genre, Veuillez indiquer F pour féminin ou M pour masculin");
                        break;
                    }

                    ObjTournoi.NomTournoi = "Wimbleton";
                    menu1 = 1;
                }
                case 3 -> {
                    System.out.println("Choisissez le genre du Tournoi (F pour féminin et H pour Masculin)");

                    String str2 = sc2.nextLine();
                    if (str2.equals("F") || str2.equals("f")) {
                        ObjTournoi.genre = "Féminin";
                    } else if (str2.equals("M") || str2.equals("m")) {
                        ObjTournoi.genre = "Masculin";
                    } else {
                        System.out.println("Mauvais choix du genre, Veuillez indiquer F pour féminin ou M pour Masculin");
                        break;
                    }

                    ObjTournoi.NomTournoi = "Roland Garros";
                    menu1 = 1;
                }
                case 4 -> {
                    System.out.println("Choisissez le genre du Tournoi (F pour féminin et H pour Masculin)");

                    String str2 = sc2.nextLine();
                    if (str2.equals("F") || str2.equals("f")) {
                        ObjTournoi.genre = "Féminin";
                    } else if (str2.equals("M") || str2.equals("m")) {
                        ObjTournoi.genre = "Masculin";
                    } else {
                        System.out.println("Mauvais choix du genre, Veuillez indiquer F pour féminin ou M pour masculin");
                        break;
                    }

                    ObjTournoi.NomTournoi = "US Open";
                    menu1 = 1;
                }
                case 5 -> {
                    System.out.println("Vous avez quitté la création de tournoi");

                    return;
                }

            }
            if (menu1 == 0) {
                System.out.println("mauvaise saisie");
            }
        }
        System.out.println("\nVous avez choisi le Tournoi " + ObjTournoi.genre + " " + ObjTournoi.NomTournoi);

        System.out.println("CREATION DU TOURNOI EN COURS... \n");

        //System.out.println("MENU Tournoi " + ObjTournoi.NomTournoi +" "+ ObjTournoi.genre+":");
        System.out.println("Le Tournoi " + ObjTournoi.NomTournoi + " se joue à 128 joueurs, voulez vous créer un/plusieurs joueurs manuellement (dans le cas contraire ils seront générés de facon aléatoire)");
        Scanner sc3 = new Scanner(System.in);
        String str3 = sc3.nextLine();

        while (str3.equals("oui")) {
            TabJoueur = Joueur.NewJoueur(NewJ, TabJoueur);
            NewJ++;                                               //Nombre de nouveau joueur
            System.out.println("Creer un autre joueur ?");
            str3 = sc3.nextLine();
        }
        str3 = "";

        if (NewJ != 0) {
            System.out.println("Vous avez creer " + NewJ + " Joueurs, voulez vous voir la liste des joueurs créés ?");
            str3 = sc3.nextLine();
            while (str3.equals("oui") & str3.equals("non")) {
                str3 = sc3.nextLine();
            }
            if (str3.equals("oui")) {
                Joueur.AffichageJoueur(TabJoueur);
            }
            System.out.println("Génération des joueurs " + (NbrJoueur - NewJ) + " restants...");
        }

        System.out.println("Génération des joueurs...\n \n");

        TabJoueur = Joueur.GenerateurJoueur(ObjTournoi.genre, TabJoueur, NewJ);
        TabArbitre = Arbitre.ListeArbitre(NbrArbitre, AdrFileA);
        TabQualif = Tournoi.ListeQualif(TabJoueur, TabQualif);
        TabMatch = Tournoi.CompoMatch(TabQualif, TabArbitre);

        Scanner sc4 = new Scanner(System.in);
        int str4;

        while (menu2 != 1) {

            System.out.println("Début du Tournoi : \n");
            System.out.println("                                                                   MENU TOURNOI :                                         " + ObjTournoi.NomTournoi + " " + ObjTournoi.genre + ": Tour " + ObjTournoi.tour + "\n");
            System.out.println("                                                        1 -   Jouer le Tour " + ObjTournoi.tour);
            System.out.println("                                                        2 -   Voir la liste des Arbitres");
            System.out.println("                                                        3 -   Voir la liste des Joueurs");
            System.out.println("                                                        4 -   Voir la liste des Joueurs qualifiés");
            System.out.println("                                                        5 -   Voir La composition des Matchs");
            System.out.println("                                                        6 -   Voir les Statistiques Joueurs");
            System.out.println("                                                        7 -   Exit");
            System.out.println(" choisir :");
            str4 = sc4.nextInt();

            switch (str4) {
                case 1:
                    Tournoi.AffichageCompoMatch(TabMatch, ObjTournoi.tour);
                    System.out.println("\n");
                    System.out.println("\n");
                    System.out.println("\n");
                    
                    

                    while (menu3 == 0) {
                        System.out.println("Voulez-vous jouer 1 match ou jouer en automatique ? (Liste des matchs ci-dessus)");
                        Scanner sc5 = new Scanner(System.in);
                        String str5 = sc5.nextLine();
                        
                              
                        while (str5.equals("oui")) {
                            System.out.println(" Quel match voulez vous jouer (numero du match) ?");
                            Scanner NumMatch = new Scanner(System.in);
                            int IntMatch = NumMatch.nextInt();
                            
                            if (TabMatch[IntMatch-1].Resultat==1){
                                System.out.println("le match n*"+IntMatch+" a deja ete joué.");
                            
                            }
                            else {
                                Match.Jouer(TabMatch, IntMatch);
                            }
                            System.out.println("Voulez-vous jouer un autre Match ?");
                            str5 = sc5.nextLine();
                            
                        }
                    str5="";
                        System.out.println("Les Matchs vont se jouer automatiquement...");
                        
                    menu3 = 1;
                    }
                    // System.out.println(Echange.Service(5)); */
                    break;
                case 2:
                    Arbitre.AffichageArbitre(TabArbitre);
                    break;
                case 3:
                    Joueur.AffichageJoueur(TabJoueur);
                    break;
                case 4:
                    Tournoi.AffichageQualif(TabQualif);
                    break;
                case 5:
                    Tournoi.AffichageCompoMatch(TabMatch, ObjTournoi.tour);
                    break;
                case 6:
                    System.out.println("Affichage statistiques joueurs");
                    Joueur.AffichageStat(TabJoueur);
                    break;
                case 7:
                    System.out.println("Vous quittez le Tournoi");
                    return;

            }

        }

    }

}
