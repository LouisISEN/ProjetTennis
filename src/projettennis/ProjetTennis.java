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
        int NbrArbitre = 10;
        int NbrJoueur = 128;
        int menu1 = 0;
        int menu2 = 0;

        String AdrFileA = "info-arbitre.txt";

        Tournoi ObjTournoi = new Tournoi();
        ArrayList<Joueur> ListClassement = new ArrayList();
        ArrayList<Joueur> ListJoueur = new ArrayList();
        ArrayList<Joueur> ListQualif = new ArrayList();
        ArrayList<Match> ListMatch = new ArrayList();
        ArrayList<Arbitre> ListArbitre = new ArrayList();

        System.out.println("                                               Bienvenue dans le menu de création de tournoi :");
        System.out.println("                                                          1- Open d'Australie");
        System.out.println("                                                          2- Wimbledon");
        System.out.println("                                                          3- Roland Garros");
        System.out.println("                                                          4- US Open");
        System.out.println("                                                          5- Exit");
        System.out.println("\n Choisissez le tournoi (en saisissant le chiffre associé) : ");

        ObjTournoi = Tournoi.ChoixTournoi(ObjTournoi);

        if (ObjTournoi.getExit() == 1) {
            return;
        }

        System.out.println("\nVous avez choisi le Tournoi " + ObjTournoi.getGenre() + " " + ObjTournoi.getNomTournoi());

        System.out.println("\n\n                                                  CREATION DU TOURNOI EN COURS... \n");
        Utilitaire.delay(3000);

        System.out.println("Le Tournoi " + ObjTournoi.getNomTournoi() + " se joue à 128 joueurs, voulez vous créer un/plusieurs joueurs manuellement (dans le cas contraire ils seront générés de facon aléatoire)");
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
                                ListJoueur.add(Joueur.NewJoueur(ListJoueur.size()));
                                System.out.println("Creer un autre joueur ?");
                                str="";
                            }

            }
        
       
        if (!ListJoueur.isEmpty()) {
            System.out.println("Vous avez creer " + ListJoueur.size() + " Joueurs, voulez vous voir la liste des joueurs créés ?");
            str = sc.nextLine();
            while (!str.equals("oui") == true && !str.equals("non") == true) {
                str = sc.nextLine();
            }
            if (str.equals("oui")) {
                Joueur.AffichageJoueur(ListJoueur);
            }
            System.out.println("Génération des joueurs " + (NbrJoueur - ListJoueur.size()) + " restants...");

        }

        System.out.println("Génération des joueurs...\n \n");
        Utilitaire.delay(3000);
        System.out.println("Génération des arbitres...");
        Utilitaire.delay(1000);
        ListJoueur = Joueur.GenerateurJoueur(ObjTournoi.getGenre(), ListJoueur);
        ListArbitre = Arbitre.GenerateurArbitre(ObjTournoi.getGenre());

        ListMatch = Tournoi.CompoMatch(ListJoueur, ListArbitre, ObjTournoi.getNbTour());
        ListQualif = Tournoi.ListeQualif(ListMatch, ObjTournoi.getNbTour());

        Scanner sc2 = new Scanner(System.in);
        int str2;

        while (menu1 != 1) {
            switch (ObjTournoi.getNbTour()) {
                case 1:
                    ObjTournoi.setTour("Tour 1");
                    break;
                case 2:
                    ObjTournoi.setTour("Tour 2");
                    break;
                case 3:
                    ObjTournoi.setTour("Tour 3");
                    break;
                case 4:
                    ObjTournoi.setTour("Huitième de finale");
                    break;
                case 5:
                    ObjTournoi.setTour("Quart de finale");
                    break;
                case 6:
                    ObjTournoi.setTour("Demi-finale");
                    break;
                case 7:
                    ObjTournoi.setTour("Petite Finale");
                    break;
                case 8:
                    ObjTournoi.setTour("Finale");
                    break;
            }
            str2 = 0;
            menu2 = 0;
            System.out.println("Début du Tournoi : \n");
            System.out.println("                                                                   MENU TOURNOI :                                         " + ObjTournoi.getNomTournoi() + " " + ObjTournoi.getGenre() + ":  " + ObjTournoi.getTour() + "\n");
            System.out.println("                                                        1 -   Jouer " + ObjTournoi.getTour());
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
                    Tournoi.AffichageCompoMatch(ListMatch, ObjTournoi);
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
                            Scanner NumMatch = new Scanner(System.in);
                            int IntMatch = 0;

                            if (str3.equals("oui") == true) {
                                while ((IntMatch == 0) || (IntMatch > ListMatch.size())) {
                                    System.out.println(" Quel match voulez vous jouer (numero du match) ?");

                                    try {
                                        IntMatch = Integer.parseInt(NumMatch.nextLine());
                                    } catch (NumberFormatException e) {
                                        System.out.println("EXCEPTION");
                                    }
                                    if ((IntMatch == 0) && IntMatch > ListMatch.size()) {
                                        System.out.println("Numero de match invalide");
                                    }
                                }
                               
                                auto = 1;
                                if (ListMatch.get(IntMatch - 1).getResultat() == 1) {
                                    System.out.println("le match n*" + IntMatch + " a deja ete joué.");

                                } else {
                                    Match BufferMatch = new Match();
                                    if (ObjTournoi.getNbTour() == 7) {
                                        System.out.println(ObjTournoi.getNbTour());

                                        BufferMatch = Match.JouerM(ListMatch.get(0), IntMatch, ObjTournoi, auto);
                                        if (BufferMatch.getPerdant() == 1) {
                                            ListClassement.set(ListClassement.size() - 2, BufferMatch.joueur1);
                                            ListClassement.set(ListClassement.size() - 1, BufferMatch.joueur2);

                                        } else {
                                            ListClassement.set(ListClassement.size() - 2, BufferMatch.joueur2);
                                            ListClassement.set(ListClassement.size() - 1, BufferMatch.joueur1);

                                        }
                                    } else {

                                        BufferMatch = Match.JouerM(ListMatch.get(IntMatch - 1), IntMatch, ObjTournoi, auto);
                                        if ((ObjTournoi.getNbTour() != 6) || (ObjTournoi.getNbTour() != 7)) {
                                            if (BufferMatch.getPerdant() == 1) {
                                                ListClassement = Tournoi.Classement(ListClassement, BufferMatch.joueur1);

                                            } else {
                                                ListClassement = Tournoi.Classement(ListClassement, BufferMatch.joueur2);

                                            }
                                        }
                                    }

                                    ListMatch.set(IntMatch - 1, BufferMatch);

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
                        Match BufferMatch = new Match();
                        if ((ObjTournoi.getNbTour() == 7)) {

                            System.out.println(ObjTournoi.getNbTour());

                            System.out.println("\n");
                            BufferMatch = Match.JouerM(ListMatch.get(0), n, ObjTournoi, auto);
                            if (BufferMatch.getPerdant() == 1) {
                                ListClassement.set(ListClassement.size() - 2, BufferMatch.joueur1);
                                ListClassement.set(ListClassement.size() - 1, BufferMatch.joueur2);

                            } else {
                                ListClassement.set(ListClassement.size() - 2, BufferMatch.joueur2);
                                ListClassement.set(ListClassement.size() - 1, BufferMatch.joueur1);

                            }

                            ListMatch.set(0, BufferMatch);
                            ObjTournoi.IncrementeNbTour();
                        } else {
                            while (n <= ListMatch.size()) {
                                if (ListMatch.get(n - 1).getResultat()== 0) {

                                  
                                    BufferMatch = Match.JouerM(ListMatch.get(n - 1), n, ObjTournoi, auto);
                                    if ((ObjTournoi.getNbTour() != 6) || (ObjTournoi.getNbTour() != 7)) {
                                        if (BufferMatch.getPerdant() == 1) {
                                            ListClassement = Tournoi.Classement(ListClassement, BufferMatch.joueur1);

                                        } else {
                                            ListClassement = Tournoi.Classement(ListClassement, BufferMatch.joueur2);

                                        }
                                    }
                                    ListMatch.set(n - 1, BufferMatch);

                                }
                                n++;
                            }
                            ObjTournoi.IncrementeNbTour();

                        }
                        ListQualif = Tournoi.ListeQualif(ListMatch, ObjTournoi.getNbTour());
                        ListMatch = Tournoi.CompoMatch(ListQualif, ListArbitre, ObjTournoi.getNbTour());

                        menu2 = 1;
                        if (ListQualif.size() == 1) {
                            menu1 = 1;
                            ObjTournoi.Vainqueur = ListQualif.get(0);
                            ListClassement.add(ListQualif.get(0));
                            Tournoi.PresentationPodium(ListClassement, ObjTournoi);
                        }

                    }

                    break;
                case 2:
                    Arbitre.AffichageArbitre(ListArbitre);
                    break;
                case 3:
                    Joueur.AffichageJoueur(ListJoueur);
                    break;
                case 4:

                    Tournoi.AffichageQualif(ListQualif);
                    break;
                case 5:
                    Tournoi.AffichageCompoMatch(ListMatch, ObjTournoi);
                    break;
                case 6:
                    System.out.println("Affichage statistiques joueurs");
                    Statistiques.AffichageStat(ListJoueur);
                    break;
                case 7:
                    System.out.println("Classement actuel :");
                    Tournoi.affClassement(ListClassement);
                    break;
                case 8:
                    System.out.println("Vous quittez le Tournoi");
                    return;

            }

        }

    }

}
