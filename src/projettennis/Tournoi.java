/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projettennis;

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

            if (ListMatch.get(k).Joueur1.qualification.equals("Demi-finale")) {
                ListQualif.add(ListMatch.get(k).Joueur1);
                System.out.println("Joueur1 trouve");
            }
            if (ListMatch.get(k).Joueur2.qualification.equals("Demi-finale")) {
                ListQualif.add(ListMatch.get(k).Joueur2);
                System.out.println("joueur2 trouve");
            }

        }

        for (int k = 0; k < ListMatch.size(); k++) {
            if (ListMatch.get(k).Joueur1.qualification.equals("qualifie")) {
                ListQualif.add(ListMatch.get(k).Joueur1);
            }
            if (ListMatch.get(k).Joueur2.qualification.equals("qualifie")) {
                ListQualif.add(ListMatch.get(k).Joueur2);
            }
        }

        return ListQualif;
    }

    public static void AffichageQualif(ArrayList<Joueur> ListQualif) {
        System.out.println("Liste des Joueurs qualifiés : \n");

        for (int i = 0; i < ListQualif.size(); i++) {

            System.out.println("Joueur numero " + (i + 1) + " qualifié = " + ListQualif.get(i).nomNaissance + " " + ListQualif.get(i).qualification);
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
            for (int k = 0; k < (NbrQualif - 1); k++) {
                if (a == 9) {
                    a = 0;
                }

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
            for (int k = 0; k < (NbrQualif - 1); k++) {
                if (a == 9) {
                    a = 0;
                }

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

    public static void AffichageCompoMatch(ArrayList<Match> ListMatch, Tournoi ObjTournoi) {

        int n = 1;
        if (ObjTournoi.nbTour != 7) {
            n = ListMatch.size();
        }
        System.out.println("Composition des matchs " + ObjTournoi.tour + " :");
        for (int i = 0; i < n; i++) {
            System.out.println("\nMatch n*" + (i + 1) + " : " + ListMatch.get(i).Joueur1.nomNaissance + " " + ListMatch.get(i).Joueur1.prenom + " VS " + ListMatch.get(i).Joueur2.nomNaissance + " " + ListMatch.get(i).Joueur2.prenom);
            System.out.println("Arbitre : " + ListMatch.get(i).arbitre.nomNaissance + " " + ListMatch.get(i).arbitre.prenom);
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
            System.out.println("Choisissez le genre du Tournoi (F pour féminin et H pour Masculin)");
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
        while ((str==0)||(str>5)) {
            try {
                str = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("EXCEPTION : Veuillez entrer un chiffre et non un caractère.");
            }
        }
            if (str==5){
                System.out.println("Vous avez quitté la création de tournoi");
                    ObjTournoi.Exit = 1;
            }
            else {
                ObjTournoi = Tournoi.Genre(ObjTournoi, str);
            }
   
        return ObjTournoi;
    }

    public static ArrayList<Joueur> Classement(ArrayList<Joueur> ListClassement, Joueur perdant) {
        Joueur BufferJoueur = new Joueur();
        int ajout = 0;

        if (ListClassement.isEmpty()) {
            ListClassement.add(perdant);

        } else {
            int a = ListClassement.size();
            for (int i = 0; i < a; i++) {
                if (ListClassement.get(i).qualification.equals(perdant.qualification)) {

                    if (ListClassement.get(i).pointJoueur > perdant.pointJoueur) {

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
            System.out.println(Utilitaire.affichageTxt(String.valueOf(128 - j), 5) + Utilitaire.affichageTxt(ListClassement.get(j).nomNaissance, 10) + Utilitaire.affichageTxt(ListClassement.get(j).prenom, 10) + "     Tour  :" + Utilitaire.affichageTxt(ListClassement.get(j).qualification, 20) + "   point marque " + Utilitaire.affichageTxt(String.valueOf(ListClassement.get(j).pointJoueur), 10));
        }

    }

    public static void PresentationPodium(ArrayList<Joueur> ListClassement, Tournoi ObjTournoi) {
        System.out.println("\n\n\n\n\n\n");
        System.out.println("                                                    Le grand Vainqueur du Tournoi " + ObjTournoi.NomTournoi + " est :\n");
        Utilitaire.delay(3000);
        System.out.println("                                                                        1. " + ObjTournoi.Vainqueur.prenom + " " + ObjTournoi.Vainqueur.nomNaissance);
        Utilitaire.delay(3000);
        System.out.println("\n                                                        2. " + ListClassement.get(ListClassement.size() - 2).nomNaissance + " " + ListClassement.get(ListClassement.size() - 2).prenom + "                   3." + ListClassement.get(ListClassement.size() - 3).nomNaissance + " " + ListClassement.get(ListClassement.size() - 3).prenom + "\n\n");
        Utilitaire.delay(3000);
        System.out.println("FIN DU TOURNOI");
        Tournoi.affClassement(ListClassement);
    }

}
