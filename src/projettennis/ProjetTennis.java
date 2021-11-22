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
        int menu2 = 0;
        int menu3 = 0;

        String AdrFileA = "info-arbitre.txt";

        Tournoi ObjTournoi = new Tournoi();
        ArrayList<Joueur> ListClassement = new ArrayList();
        ArrayList<Joueur> ListJoueur = new ArrayList();
        ArrayList<Joueur> ListQualif = new ArrayList();
        ArrayList<Match> ListMatch = new ArrayList();
        ArrayList<Arbitre> ListArbitre = new ArrayList();

        // while (menu1 != 1) {
        System.out.println("                                               Bienvunue dans le menu de création de tournoi :");
        System.out.println("                                                          1- Open d'Australie");
        System.out.println("                                                          2- Wimbledon");
        System.out.println("                                                          3- Roland Garros");
        System.out.println("                                                          4- US Open");
        System.out.println("                                                          5- Exit");
        System.out.println("\n Choisissez le tournoi (en saisissant le chiffre associé) : ");

        ObjTournoi = Tournoi.ChoixTournoi(ObjTournoi);
        System.out.println(ObjTournoi.Exit);
        if (ObjTournoi.Exit == 1) {
            return;
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

        if (!ListJoueur.isEmpty()) {
            System.out.println("Vous avez creer " + ListJoueur.size() + " Joueurs, voulez vous voir la liste des joueurs créés ?");
            str3 = sc3.nextLine();
            while (!str3.equals("oui") == true && !str3.equals("non") == true) {
                str3 = sc3.nextLine();
            }
            if (str3.equals("oui")) {
                Joueur.AffichageJoueur(ListJoueur);
            }
            System.out.println("Génération des joueurs " + (NbrJoueur - ListJoueur.size()) + " restants...");
        }

        System.out.println("Génération des joueurs...\n \n");

        ListJoueur = Joueur.GenerateurJoueur(ObjTournoi.genre, ListJoueur);
        ListArbitre = Arbitre.GenerateurArbitre(ObjTournoi.genre);

        ListMatch = Tournoi.CompoMatch(ListJoueur, ListArbitre, ObjTournoi.nbTour);
        ListQualif = Tournoi.ListeQualif(ListMatch, ObjTournoi.nbTour);

        Scanner sc4 = new Scanner(System.in);
        int str4;

        while (menu2 != 1) {
            switch (ObjTournoi.nbTour) {
                case 1:
                    ObjTournoi.tour = "Tour 1";
                    break;
                case 2:
                    ObjTournoi.tour = "Tour 2";
                    break;
                case 3:
                    ObjTournoi.tour = "Tour 3";
                    break;
                case 4:
                    ObjTournoi.tour = "Huitième de finale";
                    break;
                case 5:
                    ObjTournoi.tour = "Quart de finale";
                    break;
                case 6:
                    ObjTournoi.tour = "Demi-finale";
                    break;
                case 7:
                    ObjTournoi.tour = "Petite Finale";
                    break;
                case 8:
                    ObjTournoi.tour = "Finale";
                    break;
            }
            str4 = 0;
            menu3 = 0;
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
                    Tournoi.AffichageCompoMatch(ListMatch);
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
                            auto = 1;
                            if (ListMatch.get(IntMatch - 1).Resultat == 1) {
                                System.out.println("le match n*" + IntMatch + " a deja ete joué.");

                            } else {
                                Match BufferMatch = new Match();
                                BufferMatch = Match.JouerM(ListMatch.get(IntMatch - 1), IntMatch, ObjTournoi, auto);
                                if (BufferMatch.Perdant == 1) {
                                    ListClassement = Tournoi.Classement(ListClassement, BufferMatch.Joueur1);
                                   
                                } else {
                                    ListClassement = Tournoi.Classement(ListClassement, BufferMatch.Joueur2);
                                    
                                }

                                ListMatch.set(IntMatch - 1, BufferMatch);

                            }
                            System.out.println("Voulez-vous jouer un autre Match ?");
                            str5 = sc5.nextLine();

                        }

                        str5 = "";
                        System.out.println("Les Matchs vont se jouer automatiquement...");
                        auto = 2;
                        int n = 1;
                        Match BufferMatch = new Match();
                        if ((ObjTournoi.nbTour == 7)) {

                            System.out.println(ObjTournoi.nbTour);
                             Tournoi.affClassement(ListClassement);
                            System.out.println("\nDebut de la " + ObjTournoi.tour + "\n");
                            BufferMatch = Match.JouerM(ListMatch.get(0), n, ObjTournoi, auto);
                            if (BufferMatch.Perdant == 1) {
                                ListClassement.set(ListClassement.size()-2,BufferMatch.Joueur1);
                                ListClassement.set(ListClassement.size()-1, BufferMatch.Joueur2);
                               
                            } else {
                                ListClassement.set(ListClassement.size()-1,BufferMatch.Joueur2);
                                ListClassement.set(ListClassement.size()-2,BufferMatch.Joueur1);
                                
                            }
                            
                            ListMatch.set(0, BufferMatch);
                            ObjTournoi.nbTour++;
                        } else {
                            while (n <= ListMatch.size()) {
                                if (ListMatch.get(n - 1).Resultat == 0) {

                                    System.out.println("Debut Match n*" + n);
                                    BufferMatch = Match.JouerM(ListMatch.get(n - 1), n, ObjTournoi, auto);
                                    if ((ObjTournoi.nbTour != 6)||(ObjTournoi.nbTour != 7)) {
                                        if (BufferMatch.Perdant == 1) {
                                            ListClassement = Tournoi.Classement(ListClassement, BufferMatch.Joueur1);
                                          
                                        } else {
                                            ListClassement = Tournoi.Classement(ListClassement, BufferMatch.Joueur2);
                                            
                                        }
                                    }
                                    ListMatch.set(n - 1, BufferMatch);

                                }
                                n++;
                            }
                            ObjTournoi.nbTour++;

                        }
                        ListQualif = Tournoi.ListeQualif(ListMatch, ObjTournoi.nbTour);
                        ListMatch = Tournoi.CompoMatch(ListQualif, ListArbitre, ObjTournoi.nbTour);
                        //ListJoueur au lieu de ListQualif car tous qualifié et modificatioh de ListQualif dans l'ordre Random

                        menu3 = 1;
                        if (ListQualif.size() == 1) {
                            menu2 = 1;
                            ObjTournoi.Vainqueur = ListQualif.get(0);
                            ListClassement.add(ListQualif.get(0));
                            Tournoi.affClassement(ListClassement);
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
                    Tournoi.AffichageCompoMatch(ListMatch);
                    break;
                case 6:
                    System.out.println("Affichage statistiques joueurs");
                    Statistiques.AffichageStat(ListJoueur);
                    break;
                case 7:
                    System.out.println("Vous quittez le Tournoi");
                    return;

            }

        }

    }

}
