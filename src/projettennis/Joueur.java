/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projettennis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author axand
 */
public class Joueur extends Personne {

    public String bras;
    public String entraineur;
    public String sponsor;
    public int classement;
    public String qualification = "qualifie";
    int pointJoueur=0;
    int SetJoueur=0;
    int JeuJoueur=0;
    
   
   public static Joueur[] GenerateurJoueur(String genre, Joueur TabJoueur[], int NewJ) throws FileNotFoundException, IOException {
        String NomFile = "nom.txt";
        String PrenomFile = "";
        if (genre.equals("Féminin")) {
            PrenomFile = "prenomF.txt";
        } else if (genre.equals("Masculin")) {
            PrenomFile = "prenomM.txt";
        }

        File fileNom = new File(NomFile);
        FileReader frNom = new FileReader(fileNom);
        BufferedReader brNom = new BufferedReader(frNom);
        String lineNom;

        File filePrenom = new File(PrenomFile);
        FileReader frPrenom = new FileReader(filePrenom);
        BufferedReader brPrenom = new BufferedReader(frPrenom);
        String linePrenom;

        String Prenom[] = new String[100];    // ---< voir pq 52 ???
        String Nom[] = new String[100];

        int iNom = 0;
        int iPrenom = 0;

        TabJoueur[NewJ] = new Joueur();

        while ((lineNom = brNom.readLine()) != null) {
            Nom[iNom] = lineNom;
            iNom++;
        }

        while ((linePrenom = brPrenom.readLine()) != null) {
            Prenom[iPrenom] = linePrenom;
            iPrenom++;

        }

        ArrayList ListNom = new ArrayList();
        ArrayList ListPrenom = new ArrayList();
        ArrayList ListBras = new ArrayList();

        for (int k = 0; k < Nom.length; k++) {
            ListNom.add(k);
            ListPrenom.add(k);
            ListBras.add(k);
        }
        Collections.shuffle(ListNom);
        Collections.shuffle(ListPrenom);
        Collections.shuffle(ListBras);
        for (int p = NewJ; p < Nom.length; p++) {
            TabJoueur[p] = new Joueur();
            TabJoueur[p].nomNaissance = Nom[(int) ListNom.get(p)];
            TabJoueur[p].prenom = Prenom[(int) ListPrenom.get(p)];
            TabJoueur[p].classement = p + 1;
            if (((int) ListBras.get(p)) % 2 == 0) {
                TabJoueur[p].bras = "droit";
            } else {
                TabJoueur[p].bras = "gauche";
            }

        }

        frPrenom.close();
        frNom.close();
        return TabJoueur;
    } 

    public static void AffichageJoueur(Joueur TabJoueur[]) {

        System.out.println("Liste des Joueurs : \n");
        int j = 0;
        int compteur = 0;
        while (TabJoueur[j] != null & j != TabJoueur.length - 1) {

            j++;
            compteur++;

        }

        for (int i = 0; i < compteur; i++) {
            System.out.println("Joueur " + (i + 1));
            System.out.println("Bras =" + TabJoueur[i].bras);
            System.out.println("Prenom =" + TabJoueur[i].prenom);
            System.out.println("nomNaissance =" + TabJoueur[i].nomNaissance);
            System.out.println("Classement =" + TabJoueur[i].classement);
            System.out.println("Qualification =" + TabJoueur[i].qualification);
            System.out.println("\n");
        }
    }

     public static Joueur[] NewJoueur(int n, Joueur[] TabJoueur) {
        TabJoueur[n] = new Joueur();
        Scanner sc = new Scanner(System.in);
        System.out.println("Bras de votre Joueur (droitier/gaucher):");
        String str = sc.nextLine();
        TabJoueur[n].bras = str;
        System.out.println("Prenom de votre Joueur :");
        str = sc.nextLine();
        TabJoueur[n].prenom = str;
        System.out.println("nomNaissance de votre Joueur :");
        str = sc.nextLine();
        TabJoueur[n].nomNaissance = str;
        TabJoueur[n].classement = n + 1;
        TabJoueur[n].qualification = "qualifie";

        return TabJoueur;
    }

    public static void AffichageStat(Joueur TabJoueur[]){
   for (int i=0; i<TabJoueur.length-1; i++){
     System.out.println("Statistiques du Joueur n*"+(i+1)+" :"+TabJoueur[i].nomNaissance+" "+TabJoueur[i].prenom);
        
        System.out.println("Point Marqué : "+TabJoueur[i].pointJoueur);
        System.out.println("Set gagné : "+TabJoueur[i].SetJoueur);
        System.out.println("Jeu gagné : "+TabJoueur[i].JeuJoueur);
        System.out.println("\n");
        
        
   }
}
}
