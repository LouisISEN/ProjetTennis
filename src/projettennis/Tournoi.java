/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projettennis;

import java.io.*;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author axand
 */
public class Tournoi {

    int Exit = 0;
    String NomTournoi;
    String genre;
    String lieu;
    String surface;
    String tour = "1";
    int nbTour = 1;
    Joueur Vainqueur = new Joueur();
    int Resultat = 0;

    public static ArrayList<Joueur> ListeQualif(ArrayList<Match> ListMatch, int nbTour) {

        ArrayList<Joueur> ListQualif = new ArrayList();

        for (int k = 0; k < ListMatch.size(); k++) {

            if (ListMatch.get(k).Joueur1.getQualification().equals("Demi-finale")) {
                ListQualif.add(ListMatch.get(k).Joueur1);
                System.out.println("Joueur1 trouve");
            }
            if (ListMatch.get(k).Joueur2.getQualification().equals("Demi-finale")) {
                ListQualif.add(ListMatch.get(k).Joueur2);
                System.out.println("joueur2 trouve");
            }

        }

        for (int k = 0; k < ListMatch.size(); k++) {
            if (ListMatch.get(k).Joueur1.getQualification().equals("qualifie")) {
                ListQualif.add(ListMatch.get(k).Joueur1);
            }
            if (ListMatch.get(k).Joueur2.getQualification().equals("qualifie")) {
                ListQualif.add(ListMatch.get(k).Joueur2);
            }
        }

        return ListQualif;
    }

    public static void AffichageQualif(ArrayList<Joueur> ListQualif) {
        System.out.println("Liste des Joueurs qualifiés : \n");

        for (int i = 0; i < ListQualif.size(); i++) {

            System.out.println("Joueur numero " + (i + 1) + " qualifié = " + ListQualif.get(i).getNomNaissance() + " " + ListQualif.get(i).getQualification()
            );
        }
        System.out.println("\n");
    }

    public static ArrayList<Match> CompoMatch(ArrayList<Joueur> ListQualif, ArrayList<Arbitre> ListArbitre, int tour) {

        int NbrQualif = ListQualif.size();
        ArrayList<Match> ListMatch = new ArrayList();

        if (tour == 1) {

            ArrayList numbers = new ArrayList();
            for (int i = 0; i < NbrQualif; i++) {
                numbers.add(i);

            }

            ArrayList numbers2 = new ArrayList();
            for (int i = 0; i < ListArbitre.size(); i++) {
                numbers2.add(i);

            }
            Collections.shuffle(numbers);
            Collections.shuffle(numbers2);

            int a = 0;
            System.out.println("Composition des Matchs du tour");
            for (int k = 0; k < (NbrQualif - 1); k++) {               //Creation d'un tableau TabMatch, chaque case contient deux adversaires aléatoires
                if (a == 9) {
                    a = 0;
                }
                //  System.out.println(numbers.get(k));
                Match match = new Match();

                match.Joueur1 = ListQualif.get((int) numbers.get(k));
                match.Joueur2 = ListQualif.get((int) numbers.get(k + 1));
                match.arbitre = ListArbitre.get((int) numbers2.get(a));
                ListMatch.add(match);
                k++;
                a++;
            }
        } else {

            int a = 0;
            System.out.println("Composition des Matchs du tour");
            for (int k = 0; k < (NbrQualif - 1); k++) {               //Creation d'un tableau TabMatch, chaque case contient deux adversaires aléatoires
                if (a == 9) {
                    a = 0;
                }
                //  System.out.println(numbers.get(k));
                Match match = new Match();

                match.Joueur1 = ListQualif.get(k);
                match.Joueur2 = ListQualif.get(k + 1);
                match.arbitre = ListArbitre.get(a);
                ListMatch.add(match);
                k++;
                a++;
            }

        }
        System.out.println("\n");
        return ListMatch;
    }

    public static void AffichageCompoMatch(ArrayList<Match> ListMatch) {
        System.out.println("Composition des matchs du Tour :");
        for (int i = 0; i < ListMatch.size(); i++) {
            System.out.println("Match n*" + (i + 1) + " : " + ListMatch.get(i).Joueur1.getNomNaissance() + " VS " + ListMatch.get(i).Joueur2.getNomNaissance());
            System.out.println("Arbitre : " + ListMatch.get(i).arbitre.getNomNaissance());
        }
        System.out.println("\n");
    }

    public static Tournoi Genre(Tournoi ObjTournoi, int str) {
        Scanner sc2 = new Scanner(System.in);
        String str2 = "";

        switch (str) {
            case 1:
                ObjTournoi.NomTournoi = "Open d'Australie";
                break;
            case 2:
                ObjTournoi.NomTournoi = "Wimbleton";
                break;
            case 3:
                ObjTournoi.NomTournoi = "Roland Garros";
                break;
            case 4:
                ObjTournoi.NomTournoi = "US Open";
                break;
            case 5:
                ObjTournoi.Exit = 1;
        }
        if (ObjTournoi.Exit == 1) {
            return ObjTournoi;
        }
        while (((!str2.equals("F")) == true) && ((!str2.equals("f")) == true) && ((!str2.equals("m")) == true) && ((!str2.equals("M")) == true)) {
            str2 = sc2.nextLine();
            if (((!str2.equals("F")) == true) && ((!str2.equals("f")) == true) && ((!str2.equals("m")) == true) && ((!str2.equals("M")) == true)) {
                System.out.println("Mauvaise saisie du genre ");
            }
        }
        if (str2.equals("F") || str2.equals("f")) {
            ObjTournoi.genre = "Féminin";
        } else if (str2.equals("M") || str2.equals("m")) {
            ObjTournoi.genre = "Masculin";

        }
        return ObjTournoi;
    }

    public static Tournoi ChoixTournoi(Tournoi ObjTournoi) {
        int str = 0;
        Scanner sc = new Scanner(System.in);
        while ((str != 1) && (str != 2) && (str != 3) && (str != 4) && (str != 5)) {
            str = sc.nextInt();
            switch (str) {
                case 1 -> {
                    System.out.println("Choisissez le genre du Tournoi (F pour féminin et H pour Masculin)");
                    ObjTournoi = Tournoi.Genre(ObjTournoi, 1);
                }
                case 2 -> {
                    System.out.println("Choisissez le genre du Tournoi (F pour féminin et H pour Masculin)");
                    ObjTournoi = Tournoi.Genre(ObjTournoi, 2);

                }
                case 3 -> {
                    System.out.println("Choisissez le genre du Tournoi (F pour féminin et H pour Masculin)");
                    ObjTournoi = Tournoi.Genre(ObjTournoi, 3);

                }
                case 4 -> {
                    System.out.println("Choisissez le genre du Tournoi (F pour féminin et H pour Masculin)");
                    ObjTournoi = Tournoi.Genre(ObjTournoi, 4);
                }
                case 5 -> {
                    System.out.println("Vous avez quitté la création de tournoi");
                    ObjTournoi.Exit = 1;
                    return ObjTournoi;
                }

            }
            if ((str != 1) && (str != 2) && (str != 3) && (str != 4) && (str != 5)) {
                System.out.println("Mauvaise saisie du Tournoi");
                System.out.println("\n Choisissez le tournoi (en saisissant le chiffre associé) : ");

            }

        }
        return ObjTournoi;
    }

    public static String affichageTxt(String txt) {
        for (int i = txt.length(); i < 10; i++) {
            txt = txt + " ";
        }
        return txt;
    }

    public static ArrayList<Joueur> Classement(ArrayList<Joueur> ListClassement, Joueur perdant) {
        Joueur BufferJoueur = new Joueur();
        int ajout = 0;
        
       
        if (ListClassement.isEmpty()) {
            ListClassement.add(perdant);

        } else {
            int a = ListClassement.size();
            for (int i = 0; i < a; i++) {
                if (ListClassement.get(i).getQualification().equals(perdant.getQualification())) {
                    
                    
                    if (ListClassement.get(i).getPointJoueur() > perdant.getPointJoueur()) {

                        
                        BufferJoueur = ListClassement.get(ListClassement.size() - 1);
                        ListClassement.add(BufferJoueur);
                        
                        int k = 2;

                        while (ListClassement.size() - k != i) {

                            ListClassement.set(ListClassement.size() - k, ListClassement.get(ListClassement.size() - k - 1));
                            k++;
                        }
                        ListClassement.set(i, perdant);
                        ajout = 1;
                        break;
                    }

                }
            }
            if (ajout != 1) {

                ListClassement.add(perdant);
            }
        }

        return ListClassement;
    }

    public static void affClassement(ArrayList<Joueur> ListClassement) {
        for (int j = ListClassement.size() - 1; j > -1; j--) {
            System.out.println(Tournoi.affichageTxt(String.valueOf(128-j)) + Tournoi.affichageTxt(ListClassement.get(j).getNomNaissance()) + "     Tour  :" + Tournoi.affichageTxt(ListClassement.get(j).getQualification()) + "   point marque " + Tournoi.affichageTxt(String.valueOf(ListClassement.get(j).getPointJoueur())));
        }

    }

    public static void PresentationPodium(ArrayList<Joueur> ListClassement, Tournoi ObjTournoi) {
        System.out.println("\n\n\n\n\n\n");
        System.out.println("                                                    Le grand Vainqueur du Tournoi " + ObjTournoi.NomTournoi + " est :\n");
        System.out.println("                                                                        " + ObjTournoi.Vainqueur.getPrenom() + " " + ObjTournoi.Vainqueur.getNomNaissance());
        System.out.println("\n\n\n\n\n\n");
        System.out.println("\n\n\n\n\n\n");
        System.out.println("                                                                                1. "+ObjTournoi.Vainqueur.getPrenom()+" "+ObjTournoi.Vainqueur.getNomNaissance());
        System.out.println("\n                                                                     2. "+ListClassement.get(ListClassement.size()-2).getNomNaissance()+" "+ListClassement.get(ListClassement.size()-2).getPrenom()+ "      3."+ListClassement.get(ListClassement.size()-3).getNomNaissance()+" "+ListClassement.get(ListClassement.size()-3).getPrenom());
    }

}
