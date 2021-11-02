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
    String tour="1";
    String Joueur1 = "";
    public String Joueur2 = "";

    public static String[] ListeQualif(Joueur TabJoueur[], String TabQualif[]) {
        
        int i = 0;
        for (int k = 0; k < TabQualif.length-1; k++) {
            System.out.println(k);
            
            if (TabJoueur[k].qualification.equals("qualifie")) {
                TabQualif[i] = TabJoueur[k].prenom;
                i++;

            }

        }
        return TabQualif;
    }

    public static void AffichageQualif(String TabQualif[]) {
        System.out.println("Liste des Joueurs qualifiés : \n");
        for (int i = 0; i < TabQualif.length-1; i++) {

            System.out.println("Joueur numero " + (i + 1) + " qualifié = " + TabQualif[i]);
        }
        System.out.println("\n");
    }

    public static Tournoi[] CompoMatch(String TabQualif[]) {

        ArrayList numbers = new ArrayList();
        int NbrQualif = TabQualif.length;
        Tournoi TabMatch[] = new Tournoi[NbrQualif / 2];     //NbrQualif/2=Nbr de match

        for (int i = 0; i <= NbrQualif - 1; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        int n = 1;
        System.out.println("Composition des Matchs du tour");
        for (int k = 0; k < (NbrQualif - 1); k++) {               //Creation d'un tableau TabMatch, chaque case contient deux adversaires aléatoires

            //  System.out.println(numbers.get(k));
            TabMatch[n - 1] = new Tournoi();

            TabMatch[n - 1].Joueur1 = TabQualif[(int) numbers.get(k)];
            TabMatch[n - 1].Joueur2 = TabQualif[(int) numbers.get(k + 1)];

            n++;
            k++;
        }
       
        System.out.println("\n");
        return TabMatch;
    }
    
    public static void AffichageCompoMatch(Tournoi TabMatch[], String tour){
        System.out.println("Composition des matchs du Tour "+tour);
        for (int i=0; i<TabMatch.length;i++){
            System.out.println(" Match n*"+(i+1)+" : "+TabMatch[i].Joueur1+" VS " + TabMatch[i].Joueur2);
        }
    }
    

}

