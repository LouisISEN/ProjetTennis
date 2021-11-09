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

    public static Joueur[] ListeQualif(Joueur TabJoueur[], Joueur TabQualif[]) {
        Joueur Joueur0 =new Joueur();
        for (int i=0; i<TabQualif.length; i++){
            TabQualif[i]=Joueur0;
        }
        
   
        int i = 0;
        for (int k = 0; k < TabJoueur.length; k++) {

            if (TabJoueur[k].qualification.equals("qualifie")) {
                
                TabQualif[i] = TabJoueur[k];
                i++;

            }

        }
        return TabQualif;
    }

    public static void AffichageQualif(Joueur TabQualif[]) {
        System.out.println("Liste des Joueurs qualifiés : \n");
       int NbrQualif = Tournoi.SizeJoueur(TabQualif);

        for (int i = 0; i < NbrQualif; i++) {

            System.out.println("Joueur numero " + (i + 1) + " qualifié = " + TabQualif[i].nomNaissance);
        }
        System.out.println("\n");
    }

    public static Match[] CompoMatch(Joueur TabQualif[], Arbitre TabArbitre[]) {

        ArrayList numbers = new ArrayList();
        int NbrQualif = Tournoi.SizeJoueur(TabQualif);
        
        Match TabMatch[] = new Match[(NbrQualif / 2)];     //NbrQualif/2=Nbr de match

        for (int i = 0; i <= NbrQualif - 1; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        int n = 1;
        int a = 0;
        System.out.println("Composition des Matchs du tour");
        for (int k = 0; k < (NbrQualif - 1); k++) {               //Creation d'un tableau TabMatch, chaque case contient deux adversaires aléatoires
            if (a == 9) {
                a = 0;
            }
            //  System.out.println(numbers.get(k));
            TabMatch[n - 1] = new Match();

            TabMatch[n - 1].Joueur1 = TabQualif[(int) numbers.get(k)];
            TabMatch[n - 1].Joueur2 = TabQualif[(int) numbers.get(k + 1)];
            TabMatch[n - 1].arbitre = TabArbitre[a].nomNaissance + " " + TabArbitre[a].prenom;
            n++;
            k++;
            a++;
        }

        System.out.println("\n");
        return TabMatch;
    }

    public static void AffichageCompoMatch(Match TabMatch[], String tour) {
        System.out.println("Composition des matchs du Tour " + tour);
        for (int i = 0; i < TabMatch.length; i++) {
            System.out.println("Match n*" + (i + 1) + " : " + TabMatch[i].Joueur1.nomNaissance + " VS " + TabMatch[i].Joueur2.nomNaissance);
            System.out.println("Arbitre : " + TabMatch[i].arbitre);
        }
        System.out.println("\n");
    }

    public static Joueur[] Statistique(Match TabMatch[], Joueur TabJoueur[]) {

        for (int i = 0; i < TabMatch.length; i++) {
            for (int k = 0; k < TabJoueur.length; k++) {
                if (TabMatch[i].Joueur1.numero==TabJoueur[k].numero){
                    TabJoueur[k]=TabMatch[i].Joueur1;
                }     
            }
            
            for (int k = 0; k < TabJoueur.length; k++) {
                if (TabMatch[i].Joueur2.numero==TabJoueur[k].numero){
                    TabJoueur[k]=TabMatch[i].Joueur2;
                }     
            }
        }

        return TabJoueur;
    }
    
    public static int SizeMatch(Match [] TabMatch){
        int j = 0;
        
        int compteur = 0;
        
        while ((j != TabMatch.length) && (TabMatch[j].Joueur1 != null)) {
           
            j++;
            compteur++;

        }
        return compteur;
    }
    
    public static int SizeJoueur(Joueur [] TabJoueur){
        int j = 0;
        
        int compteur = 0;
        
        while ((j != TabJoueur.length) && (TabJoueur[j].nomNaissance != null)) {
           
            j++;
            compteur++;

        }
        return compteur;
    }
}
