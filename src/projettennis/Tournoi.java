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

/**
 *
 * @author axand
 */
public class Tournoi {

    String NomTournoi;
    String genre;
    String lieu;
    String surface;
    String tour = "1";
    int nb = 1;

    int Resultat = 0;

    public static ArrayList<Joueur> ListeQualif(ArrayList<Joueur> ListJoueur) {
        
        ArrayList<Joueur> ListQualif = new ArrayList();
        for (int k = 0; k < ListJoueur.size(); k++) {

            if (ListJoueur.get(k).qualification.equals("qualifie")) {
                
                ListQualif.add(ListJoueur.get(k));

            }

        }
        return ListQualif;
    }

    public static void AffichageQualif(ArrayList<Joueur> ListQualif) {
        System.out.println("Liste des Joueurs qualifiés : \n");
      
       
        for (int i = 0; i < ListQualif.size();i++) {

            System.out.println("Joueur numero " + (i + 1) + " qualifié = " + ListQualif.get(i).nomNaissance);
        }
        System.out.println("\n");
    }

    public static ArrayList<Match> CompoMatch(ArrayList<Joueur> ListQualif, ArrayList<Arbitre> ListArbitre, int tour) {

        int NbrQualif = ListQualif.size();       
        ArrayList<Match> ListMatch = new ArrayList();
        
        if (tour==1){
            
        ArrayList numbers = new ArrayList();
        for (int i = 0; i < NbrQualif; i++) {
            numbers.add(i);
       
        }
        Collections.shuffle(numbers);
      
        int a = 0;
        System.out.println("Composition des Matchs du tour");
        for (int k = 0; k < (NbrQualif-1); k++) {               //Creation d'un tableau TabMatch, chaque case contient deux adversaires aléatoires
            if (a == 9) {
                a = 0;
            }
            //  System.out.println(numbers.get(k));
            Match match = new Match();
            
            
            match.Joueur1.NumeroMatch=k;
            match.Joueur2.NumeroMatch=k+1;
            match.Joueur1 = ListQualif.get((int) numbers.get(k));
            match.Joueur2 = ListQualif.get((int) numbers.get(k+1));
//          match.arbitre = ListArbitre.get((int) numbers.get(k));
            ListMatch.add(match);
            k++;
            a++;
            }
        }
        else {
            
               int a = 0;
        System.out.println("Composition des Matchs du tour");
        for (int k = 0; k < (NbrQualif-1); k++) {               //Creation d'un tableau TabMatch, chaque case contient deux adversaires aléatoires
            if (a == 9) {
                a = 0;
            }
            //  System.out.println(numbers.get(k));
            Match match = new Match();
            
            

            match.Joueur1 = ListQualif.get(k);
            match.Joueur2 = ListQualif.get(k+1);
//          match.arbitre = ListArbitre.get((int) numbers.get(k));
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
            System.out.println("Match n*" + (i + 1) + " : " + ListMatch.get(i).Joueur1.nomNaissance + " VS " + ListMatch.get(i).Joueur2.nomNaissance);
            System.out.println("Arbitre : " + ListMatch.get(i).arbitre.nomNaissance);
        }
        System.out.println("\n");
    }

}
