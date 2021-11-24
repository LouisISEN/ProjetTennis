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

    private int Exit = 0;
    private String NomTournoi;
    private String genre;
    private String lieu;
    private String surface;
    private String tour = "1";
    private int nbTour = 1;
    Joueur Vainqueur = new Joueur();
    private int Resultat = 0;

    public void IncrementeNbTour() {
        nbTour++;
    }

    public int getExit() {
        return this.Exit;
    }

    public void setExit(int Exit) {
        this.Exit = Exit;
    }

    public String getNomTournoi() {
        return this.NomTournoi;
    }

    public void setNomTournoi(String NomTournoi) {
        this.NomTournoi = NomTournoi;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLieu() {
        return this.lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getSurface() {
        return this.surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public String getTour() {
        return this.tour;
    }

    public void setTour(String tour) {
        this.tour = tour;
    }

    public int getNbTour() {
        return this.nbTour;
    }

    public void setNbTour(int nbTour) {
        this.nbTour = nbTour;
    }

    public Joueur getVainqueur() {
        return this.Vainqueur;
    }

    public void setVainqueur(Joueur Vainqueur) {
        this.Vainqueur = Vainqueur;
    }

    public int getResultat() {
        return this.Resultat;
    }

    public void setResultat(int Resultat) {
        this.Resultat = Resultat;
    }

    public static ArrayList<Joueur> ListeQualif(ArrayList<Match> ListMatch, int nbTour) {

        ArrayList<Joueur> ListQualif = new ArrayList();

        for (int k = 0; k < ListMatch.size(); k++) {

            if (ListMatch.get(k).joueur1.getQualification().equals("Demi-finale")) {
                ListQualif.add(ListMatch.get(k).joueur1);
                System.out.println("joueur1 trouve");
            }
            if (ListMatch.get(k).joueur2.getQualification().equals("Demi-finale")) {
                ListQualif.add(ListMatch.get(k).joueur2);
                System.out.println("joueur2 trouve");
            }

        }

        for (int k = 0; k < ListMatch.size(); k++) {
            if (ListMatch.get(k).joueur1.getQualification().equals("qualifie")) {
                ListQualif.add(ListMatch.get(k).joueur1);
            }
            if (ListMatch.get(k).joueur2.getQualification().equals("qualifie")) {
                ListQualif.add(ListMatch.get(k).joueur2);
            }
        }

        return ListQualif;
    }

    public static void AffichageQualif(ArrayList<Joueur> ListQualif) {
        System.out.println("Liste des Joueurs qualifiés : \n");

        for (int i = 0; i < ListQualif.size(); i++) {

            System.out.println("Joueur numero " + (i + 1) + " qualifié = " + ListQualif.get(i).getNomNaissance() + " " + ListQualif.get(i).getQualification());
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

                match.joueur1 = ListQualif.get((int) numbers.get(k));
                match.joueur2 = ListQualif.get((int) numbers.get(k + 1));
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

                match.joueur1 = ListQualif.get(k);
                match.joueur2 = ListQualif.get(k + 1);
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
            System.out.println("\nMatch n*" + (i + 1) + " : " + ListMatch.get(i).joueur1.getNomNaissance() + " " + ListMatch.get(i).joueur1.getPrenom() + " VS " + ListMatch.get(i).joueur2.getNomNaissance() + " " + ListMatch.get(i).joueur2.getPrenom());
            System.out.println("Arbitre : " + ListMatch.get(i).arbitre.getNomNaissance() + " " + ListMatch.get(i).arbitre.getPrenom());
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
        while ((str == 0) || (str > 5)) {
            try {
                str = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("EXCEPTION : Veuillez entrer un chiffre et non un caractère.");
            }
        }
        if (str == 5) {
            System.out.println("Vous avez quitté la création de tournoi");
            ObjTournoi.Exit = 1;
        } else {
            ObjTournoi = Tournoi.Genre(ObjTournoi, str);
        }

        return ObjTournoi;
    }

    public static ArrayList<Joueur> Classement(ArrayList<Joueur> listClassement, Joueur perdant) {
        Joueur BufferJoueur = new Joueur();
        int ajout = 0;

        if (listClassement.isEmpty()) {
            listClassement.add(perdant);

        } else {
            int a = listClassement.size();
            for (int i = 0; i < a; i++) {
                if (listClassement.get(i).getQualification().equals(perdant.getQualification())) {

                    if (listClassement.get(i).getPointJoueur() > perdant.getPointJoueur()) {

                        BufferJoueur = listClassement.get(listClassement.size() - 1);
                        listClassement.add(BufferJoueur);

                        int k = 2;

                        while (listClassement.size() - k != i) {

                            listClassement.set(listClassement.size() - k, listClassement.get(listClassement.size() - k - 1));
                            k++;
                        }
                        listClassement.set(i, perdant);
                        ajout = 1;
                        break;
                    }

                }
            }
            if (ajout != 1) {

                listClassement.add(perdant);
            }
        }

        return listClassement;
    }

    public static void AffichageClassement(ArrayList<Joueur> listClassement) {
        for (int j = listClassement.size() - 1; j > -1; j--) {
            System.out.println(Utilitaire.affichageTxt(String.valueOf(128 - j), 5) + Utilitaire.affichageTxt(listClassement.get(j).getNomNaissance(), 10) + Utilitaire.affichageTxt(listClassement.get(j).getPrenom(), 10) + "     Tour  :" + Utilitaire.affichageTxt(listClassement.get(j).getQualification(), 20) + "   point marque " + Utilitaire.affichageTxt(String.valueOf(listClassement.get(j).getPointJoueur()), 10));
        }

    }

    public static void PresentationPodium(ArrayList<Joueur> listClassement, Tournoi ObjTournoi) {
        System.out.println("\n\n\n\n\n\n");
        System.out.println("                                                    Le grand Vainqueur du Tournoi " + ObjTournoi.NomTournoi + " est :\n");
        Utilitaire.delay(3000);
        System.out.println("                                                                        1. " + ObjTournoi.Vainqueur.getPrenom() + " " + ObjTournoi.Vainqueur.getNomNaissance());
        Utilitaire.delay(3000);
        System.out.println("\n                                                        2. " + listClassement.get(listClassement.size() - 2).getNomNaissance() + " " + listClassement.get(listClassement.size() - 2).getPrenom() + "                   3." + listClassement.get(listClassement.size() - 3).getNomNaissance() + " " + listClassement.get(listClassement.size() - 3).getPrenom() + "\n\n");
        Utilitaire.delay(3000);
        System.out.println("FIN DU TOURNOI");
    }

    public static void MenuFin(ArrayList<Joueur> listClassement, ArrayList<Joueur> ListJoueur, Tournoi ObjTournoi) {
        int a = 0;
        Scanner sc = new Scanner(System.in);
        int str;
        while (a == 0) {
            str = 0;
            System.out.println("\n\n\n");
            System.out.println("                                                            Menu de fin du Tournoi");
            System.out.println("                                                       1 - Afficher la liste des joueurs");
            System.out.println("                                                       2 - Afficher le classement");
            System.out.println("                                                       3 - Afficher le podium");
            System.out.println("                                                       4 - Afficher les statistiques");
            System.out.println("                                                       5 - Exit");
            while ((str == 0) || (str > 8)) {
                try {
                    str = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("EXCEPTION");
                }
            }
            switch (str) {
                case 1:
                    Joueur.AffichageJoueur(ListJoueur);
                    break;
                case 2:
                    Tournoi.AffichageClassement(listClassement);
                    break;
                case 3:
                    Tournoi.PresentationPodium(listClassement, ObjTournoi);
                    break;
                case 4:
                    Statistiques.AffichageStat(ListJoueur);
                    break;
                case 5:
                    a = 1;
                    break;
            }

        }
    }
}
