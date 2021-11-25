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
 *La class Tournoi permet de :
 * créer un tournoi (choisir le tournoi ainsi que le genre)
 * la création de la liste des joueurs qualifiés (qui sert a la composition des matchs) et son affichage 
 * la création d'une composition aléatoire des matchs et son affichage
 * le classement et son affichage
 * la présentation du podium
 * le menu de fin de tournoi
 * @author axand
 */
public class Tournoi {

    private int exit = 0;         //pour quitter le tournoi et le programme
    private String nomTournoi;
    private String genre;
    private String tour = "1";    //String qui peut prendre la valeu tour 1, tour 2,tour 3 huitième de finale, quart de finale, demi finale, petite finale, finale
    private int nbTour = 1;       // prend la valeur 1,2,3,4,5,6,7,8 (voir ci dessus a quoi correspond les tours)
    Joueur vainqueur = new Joueur(); 
    private int resultat = 0;           // si le match a deja été joué ou non (0 pour non et 1 pour 1)

    public void incrementeNbTour() {
        nbTour++;
    }

    public int getExit() {
        return this.exit;
    }

    public void setExit(int exit) {
        this.exit = exit;
    }

    public String getNomTournoi() {
        return this.nomTournoi;
    }

    public void setNomTournoi(String nomTournoi) {
        this.nomTournoi = nomTournoi;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
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
        return this.vainqueur;
    }

    public void setVainqueur(Joueur vainqueur) {
        this.vainqueur = vainqueur;
    }

    public int getResultat() {
        return this.resultat;
    }

    public void setResultat(int resultat) {
        this.resultat = resultat;
    }
    /**
     *créer la liste des joueurs encore qualifiés dans le tournoi
     */
    public static ArrayList<Joueur> creerListeQualif(ArrayList<Match> listMatch, int nbTour) {

        ArrayList<Joueur> listQualif = new ArrayList<Joueur>();

        for (int k = 0; k < listMatch.size(); k++) {

            if (listMatch.get(k).joueur1.getQualification().equals("Demi-finale")) {
                listQualif.add(listMatch.get(k).joueur1);
                System.out.println("joueur1 trouve");
            }
            if (listMatch.get(k).joueur2.getQualification().equals("Demi-finale")) {
                listQualif.add(listMatch.get(k).joueur2);
                System.out.println("joueur2 trouve");
            }

        }

        for (int k = 0; k < listMatch.size(); k++) {
            if (listMatch.get(k).joueur1.getQualification().equals("qualifie")) {
                listQualif.add(listMatch.get(k).joueur1);
            }
            if (listMatch.get(k).joueur2.getQualification().equals("qualifie")) {
                listQualif.add(listMatch.get(k).joueur2);
            }
        }

        return listQualif;
    }
    /**
     * affiche la liste des joueurs qualifiés
     * @param listQualif 
     */
    public static void afficherQualif(ArrayList<Joueur> listQualif) {
        System.out.println("Liste des Joueurs qualifiés : \n");

        for (int i = 0; i < listQualif.size(); i++) {

            System.out.println("Joueur numero " + (i + 1) + " qualifié = " + listQualif.get(i).getNomNaissance() + " " + listQualif.get(i).getQualification());
        }
        System.out.println("\n");
    }
    /**
     * Créer la compostion des matchs pour chaque tour (aleatoire pour le premier tour puis normalement pour les autres tours)
     * @param listQualif
     * @param listArbitre
     * @param tour
     * @return 
     */
    public static ArrayList<Match> creerCompoMatch(ArrayList<Joueur> listQualif, ArrayList<Arbitre> listArbitre, int tour) {

        int nbrQualif = listQualif.size();
        ArrayList<Match> listMatch = new ArrayList<Match>();

        if (tour == 1) {

            ArrayList<Integer> numbers = new ArrayList<Integer>();
            for (int i = 0; i < nbrQualif; i++) {
                numbers.add(i);

            }

            ArrayList<Integer> numbers2 = new ArrayList<Integer>();
            for (int i = 0; i < listArbitre.size(); i++) {
                numbers2.add(i);

            }
            Collections.shuffle(numbers);
            Collections.shuffle(numbers2);

            int a = 0;
            System.out.println("Composition des Matchs du tour");
            for (int k = 0; k < (nbrQualif - 1); k++) {
                if (a == 9) {
                    a = 0;
                }

                Match match = new Match();

                match.joueur1 = listQualif.get((int) numbers.get(k));
                match.joueur2 = listQualif.get((int) numbers.get(k + 1));
                match.arbitre = listArbitre.get((int) numbers2.get(a));
                listMatch.add(match);
                k++;
                a++;
            }
        } else {

            int a = 0;
            System.out.println("Composition des Matchs du tour");
            for (int k = 0; k < (nbrQualif - 1); k++) {
                if (a == 9) {
                    a = 0;
                }

                Match match = new Match();

                match.joueur1 = listQualif.get(k);
                match.joueur2 = listQualif.get(k + 1);
                match.arbitre = listArbitre.get(a);
                listMatch.add(match);
                k++;
                a++;
            }

        }
        System.out.println("\n");
        return listMatch;
    }
    /**
     * affichage de la composition des matchs
     * @param listMatch
     * @param objTournoi 
     */
    public static void afficherCompoMatch(ArrayList<Match> listMatch, Tournoi objTournoi) {

        int n = 1;
        if (objTournoi.nbTour != 7) {
            n = listMatch.size();
        }
        System.out.println("Composition des matchs " + objTournoi.tour + " :");
        for (int i = 0; i < n; i++) {
            System.out.println("\nMatch n*" + (i + 1) + " : " + listMatch.get(i).joueur1.getNomNaissance() + " " + listMatch.get(i).joueur1.getPrenom() + " VS " + listMatch.get(i).joueur2.getNomNaissance() + " " + listMatch.get(i).joueur2.getPrenom());
            System.out.println("Arbitre : " + listMatch.get(i).arbitre.getNomNaissance() + " " + listMatch.get(i).arbitre.getPrenom());
        }
        System.out.println("\n");
    }
    /**
     *  Choix du genre du tournoi
     * @param objTournoi
     * @param str
     * @return 
     */
    public static Tournoi genre(Tournoi objTournoi, int str) {

        Scanner sc2 = new Scanner(System.in);
        String str2 = "";

        switch (str) {
            case 1:
                objTournoi.nomTournoi = "Open d'Australie";
                break;
            case 2:
                objTournoi.nomTournoi = "Wimbleton";
                break;
            case 3:
                objTournoi.nomTournoi = "Roland Garros";
                break;
            case 4:
                objTournoi.nomTournoi = "US Open";
                break;
            case 5:
                objTournoi.exit = 1;
        }
        if (objTournoi.exit == 1) {
            return objTournoi;
        }
        while (((!str2.equals("F")) == true) && ((!str2.equals("f")) == true) && ((!str2.equals("m")) == true) && ((!str2.equals("M")) == true)) {
            System.out.println("Choisissez le genre du Tournoi (F pour féminin et M pour Masculin)");
            str2 = sc2.nextLine();
            if (((!str2.equals("F")) == true) && ((!str2.equals("f")) == true) && ((!str2.equals("m")) == true) && ((!str2.equals("M")) == true)) {
                System.out.println("Mauvaise saisie du genre (F pour féminin et M pour Masculin");
            }
        }
        if (str2.equals("F") || str2.equals("f")) {
            objTournoi.genre = "Féminin";
        } else if (str2.equals("M") || str2.equals("m")) {
            objTournoi.genre = "Masculin";

        }
        return objTournoi;
    }
    /**
     * choix du tournoi, verifie que la saisie est bonne 
     * @param objTournoi
     * @return 
     */
    public static Tournoi choixTournoi(Tournoi objTournoi) {
        int str = 0;
        System.out.println("                                               Bienvenue dans le menu de création de tournoi :");
        System.out.println("                                                          1- Open d'Australie");
        System.out.println("                                                          2- Wimbledon");
        System.out.println("                                                          3- Roland Garros");
        System.out.println("                                                          4- US Open");
        System.out.println("                                                          5- Exit");
        System.out.println("\n Choisissez le tournoi (en saisissant le chiffre associé) : ");
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
            objTournoi.exit = 1;
        } else {
            objTournoi = Tournoi.genre(objTournoi, str);
        }

        return objTournoi;
    }
    /**
     * gere le classement a la fin de chaque match en ajoutant les perdants des matchs (sauf celui de la demi-finale vu qu'il y la petite finale)
     * @param listClassement
     * @param perdant
     * @return 
     */
    public static ArrayList<Joueur> ajouterClassement(ArrayList<Joueur> listClassement, Joueur perdant) {
        Joueur bufferJoueur = new Joueur();
        int ajout = 0;

        if (listClassement.isEmpty()) {
            listClassement.add(perdant);

        } else {
            int a = listClassement.size();
            for (int i = 0; i < a; i++) {
                if (listClassement.get(i).getQualification().equals(perdant.getQualification())) {

                    if (listClassement.get(i).getPointJoueur() > perdant.getPointJoueur()) {

                        bufferJoueur = listClassement.get(listClassement.size() - 1);
                        listClassement.add(bufferJoueur);

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
    /**
     * Affiche le classement
     * @param listClassement 
     */
    public static void afficherClassement(ArrayList<Joueur> listClassement) {
        for (int j = listClassement.size() - 1; j > -1; j--) {
            System.out.println(Utilitaire.affichageTxt(String.valueOf(128 - j), 5) + Utilitaire.affichageTxt(listClassement.get(j).getNomNaissance(), 10) + Utilitaire.affichageTxt(listClassement.get(j).getPrenom(), 10) + "     Tour  :" + Utilitaire.affichageTxt(listClassement.get(j).getQualification(), 20) + "   point marque " + Utilitaire.affichageTxt(String.valueOf(listClassement.get(j).getPointJoueur()), 10));
        }

    }
    /**
     * Presente le podium gagnant de la fin du tournoi
     * @param listClassement
     * @param objTournoi 
     */
    public static void presenterPodium(ArrayList<Joueur> listClassement, Tournoi objTournoi) {
        System.out.println("\n\n\n\n\n\n");
        System.out.println("                                                    Le grand vainqueur du Tournoi " + objTournoi.nomTournoi + " est :\n");
        Utilitaire.delay(3000);
        System.out.println("                                                                        1. " + objTournoi.vainqueur.getPrenom() + " " + objTournoi.vainqueur.getNomNaissance());
        Utilitaire.delay(3000);
        System.out.println("\n                                                        2. " + listClassement.get(listClassement.size() - 2).getNomNaissance() + " " + listClassement.get(listClassement.size() - 2).getPrenom() + "                   3." + listClassement.get(listClassement.size() - 3).getNomNaissance() + " " + listClassement.get(listClassement.size() - 3).getPrenom() + "\n\n");
        Utilitaire.delay(3000);
        System.out.println("FIN DU TOURNOI");
    }

    public static void afficherMenuFin(ArrayList<Joueur> listClassement, ArrayList<Joueur> listJoueur, Tournoi objTournoi) {
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
            System.out.println("                                                       5 - exit");
            while ((str == 0) || (str > 8)) {
                try {
                    str = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("EXCEPTION");
                }
            }
            switch (str) {
                case 1:
                    Joueur.afficherJoueur(listJoueur);
                    break;
                case 2:
                    Tournoi.afficherClassement(listClassement);
                    break;
                case 3:
                    Tournoi.presenterPodium(listClassement, objTournoi);
                    break;
                case 4:
                    Statistiques.afficherStat(listJoueur);
                    break;
                case 5:
                    a = 1;
                    break;
            }

        }
    }
}
