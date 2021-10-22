/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projettennis;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import projettennis.Joueur;
import projettennis.Set;

/**
 *
 * @author axand
 */
public class ProjetTennis {

    public static void main(String[] args) throws IOException {

        int Sortie = 0;
        int NbrArbitre = 2;
        int NbrJoueur = 12;
        int NewJ = 0;
        int menu1 = 0;
        int menu2 = 0;

        String AdrFileJ = "info-joueur.txt";
        String AdrFileA = "info-arbitre.txt";

        Joueur[] TabJoueur = new Joueur[NbrJoueur + 1];     //<-- NOMBRE DE JOUEUR+1
        String[] TabQualif = new String[NbrJoueur];
        Tournoi[] TabMatch = new Tournoi[NbrJoueur / 2];
        Arbitre[] TabArbitre = new Arbitre[NbrArbitre];

      //  TabJoueur = Joueur.GenerateurJoueur(AdrFileJ, TabJoueur, NewJ);
        TabArbitre = Arbitre.ListeArbitre(NbrArbitre, AdrFileA);
     //   TabQualif = Tournoi.ListeQualif(TabJoueur, TabQualif);                                        //Création Tableau des joueurs qualifiés à partir du tableau des joueurs + du parametre qualification
      //  TabMatch = Tournoi.CompoMatch(TabQualif);                                                                // creation tableau pour nom des qualifiés

        Arbitre.AffichageArbitre(TabArbitre);
        Joueur.AffichageJoueur(TabJoueur);
        //Tournoi.AffichageQualif(TabQualif);                                                                        // Player = Joueur.ListeJoueur(AdrFileJ, Player);  //Récupération info Joueur + creation tableau Joueur (=Player[])

        Tournoi ObjTournoi = new Tournoi();

        while (menu1 != 1) {
            System.out.println("Bienvunue dans le menu de création de tournoi :");
            System.out.println("1- Open d'Australie");
            System.out.println("2- Wimbledon");
            System.out.println("3- Roland Garros");
            System.out.println("4- US Open");
            System.out.println("5- Exit");
            System.out.println("Choisissez le tournoi (en saisissant le chiffre associé) : ");

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
            System.out.println("\n)Vous avez choisi le Tournoi " + ObjTournoi.genre + " " + ObjTournoi.NomTournoi);

            System.out.println("CREATION DU TOURNOI EN COURS... \n");

        }

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
        str3="";
        
        if (NewJ!=0){
            System.out.println("Vous avez creer "+NewJ+ " Joueurs, voulez vous voir la liste des joueurs créés ?");
            str3 = sc3.nextLine();
        while (str3.equals("oui")&str3.equals("non")){
             str3 = sc3.nextLine();
        }
        if (str3.equals("oui")){
            Joueur.AffichageJoueur(TabJoueur);
        }System.out.println("Génération des joueurs "+(NbrJoueur-NewJ)+" restants...");
        }
        
        System.out.println("Génération des joueurs...");
       TabJoueur = Joueur.GenerateurJoueur(AdrFileJ, TabJoueur, NewJ);
       Joueur.AffichageJoueur(TabJoueur);
        
        

        /*            
        for (int k = 0; k < (TabQualif.length) / 2; k++) {
            nb = Match.Match(TabMatch[k].Joueur1, TabMatch[k].Joueur2, k + 1);        //determine qui commence avec le service

            Echange.Service(nb, TabMatch[k].Joueur1, TabMatch[k].Joueur2);
            System.out.println("\n");
        }

        Echange.echange();
         */
    }
}
