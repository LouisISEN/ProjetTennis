/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projettennis;

import java.io.IOException;
import java.util.ArrayList;
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
        int auto=0;
        int NbrArbitre = 10;
        int NbrJoueur = 128;
        int NewJ = 0;
        int menu1 = 0;
        int menu2 = 0;
        int menu3 = 0;

        String AdrFileA = "info-arbitre.txt";

    /*    Joueur[] TabJoueur = new Joueur[NbrJoueur];     //<-- NOMBRE DE JOUEUR+1
        Joueur[] TabQualif = new Joueur[NbrJoueur];
        Match [] TabMatch = new Match[(NbrJoueur / 2)];
        Arbitre[] TabArbitre = new Arbitre[NbrArbitre];    */
        Tournoi ObjTournoi = new Tournoi();      
        
        ArrayList<Joueur> ListJoueur = new ArrayList();
        ArrayList<Joueur> ListQualif = new ArrayList();
        ArrayList<Match> ListMatch = new ArrayList();
        ArrayList<Arbitre> ListArbitre = new ArrayList();
        
        while (menu1 != 1) {

            System.out.println("                                               Bienvunue dans le menu de création de tournoi :");
            System.out.println("                                                          1- Open d'Australie");
            System.out.println("                                                          2- Wimbledon");
            System.out.println("                                                          3- Roland Garros");
            System.out.println("                                                          4- US Open");
            System.out.println("                                                          5- Exit");
            System.out.println("\n Choisissez le tournoi (en saisissant le chiffre associé) : ");

            Scanner sc = new Scanner(System.in);
            Scanner sc2 = new Scanner(System.in);
            int str = sc.nextInt();
            
            

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
           // TabJoueur = Joueur.NewJoueur(NewJ, TabJoueur);
           ListJoueur.add(Joueur.NewJoueur(ListJoueur.size()));
                                                    //Nombre de nouveau joueur
            System.out.println("Creer un autre joueur ?");
            str3 = sc3.nextLine();
        }
        str3 = "";

        if (ListJoueur.size() != 0) {
            System.out.println("Vous avez creer " + ListJoueur.size() + " Joueurs, voulez vous voir la liste des joueurs créés ?");
            str3 = sc3.nextLine();
            while (str3.equals("oui") & str3.equals("non")) {
                str3 = sc3.nextLine();
            }
            if (str3.equals("oui")) {
                Joueur.AffichageJoueur(ListJoueur);
            }
            System.out.println("Génération des joueurs " + (NbrJoueur - ListJoueur.size()) + " restants...");
        }

        System.out.println("Génération des joueurs...\n \n");

        ListJoueur = Joueur.GenerateurJoueur(ObjTournoi.genre, ListJoueur);
        ListArbitre = Arbitre.ListeArbitre(NbrArbitre, AdrFileA);
        ListQualif = Tournoi.ListeQualif(ListJoueur);
        ListMatch = Tournoi.CompoMatch(ListQualif, ListArbitre);

        Scanner sc4 = new Scanner(System.in);
        int str4;

        while (menu2 != 1) {
            switch (ObjTournoi.nb){
                case 1: ObjTournoi.tour="Tour 1"; break;
                case 2: ObjTournoi.tour="Tour 2"; break;
                case 3: ObjTournoi.tour="Tour 3"; break;
                case 4: ObjTournoi.tour="Huitième de finale"; break;
                case 5: ObjTournoi.tour="Quart de finale"; break;
                case 6: ObjTournoi.tour="Demi-finale"; break;
                case 7: ObjTournoi.tour="Final"; break;
            }
            str4=0;
            menu3=0;
            System.out.println("Début du Tournoi : \n");
            System.out.println("                                                                   MENU TOURNOI :                                         " + ObjTournoi.NomTournoi + " " + ObjTournoi.genre + ":  " + ObjTournoi.tour + "\n");
            System.out.println("                                                        1 -   Jouer " + ObjTournoi.tour);
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
                    Tournoi.AffichageCompoMatch(ListMatch, ObjTournoi.tour);
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
                            auto=1;
                            if (ListMatch.get(IntMatch-1).Resultat==1){
                                System.out.println("le match n*"+IntMatch+" a deja ete joué.");
                            
                            }
                            else {
                                ListMatch=Match.JouerM(ListMatch, IntMatch, ObjTournoi.genre, auto);
                                
                            }
                            System.out.println("Voulez-vous jouer un autre Match ?");
                            str5 = sc5.nextLine();
                            
                        }
                        
                    str5="";
                        System.out.println("Les Matchs vont se jouer automatiquement...");
                        auto=2;
                        int n=1;
                        while (n<=ListMatch.size()){
                            if (ListMatch.get(n-1).Resultat==0){
                                System.out.println("Debut Match n*"+n);
                        ListMatch=Match.JouerM(ListMatch, n, ObjTournoi.genre, auto);
                            }
                            System.out.println(n);
                            n++;
                        }
                        ObjTournoi.nb++;
                        ListQualif=Tournoi.ListeQualif(ListJoueur);
                        ListMatch=Tournoi.CompoMatch(ListQualif, ListArbitre);
                    menu3 = 1;
                    }
                    
                  
            
                    break;
                case 2:
                    Arbitre.AffichageArbitre(ListArbitre);
                    break;
                case 3:
                    Joueur.AffichageJoueur(ListJoueur);
                    break;
                case 4:
                    Tournoi.ListeQualif(ListJoueur);
                    Tournoi.AffichageQualif(ListQualif);
                    break;
                case 5:
                    Tournoi.AffichageCompoMatch(ListMatch, ObjTournoi.tour);
                    break;
                case 6:
                    System.out.println("Affichage statistiques joueurs");
                    Joueur.AffichageStat(ListJoueur);
                    break;
                case 7:
                    System.out.println("Vous quittez le Tournoi");
                    return;

            }

        }

    }

}
