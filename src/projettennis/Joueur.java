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
    public int numero;

    public String qualification = "qualifie";

    int pointJoueur = 0;
    int SetJoueur = 0;
    int JeuJoueur = 0;
    int Service=0;
    int Faute=0;

    public int WinSet = 0;
    public int WinJeu = 0;

    public static ArrayList<Joueur> GenerateurJoueur(String genre, ArrayList<Joueur> ListJoueur) throws FileNotFoundException, IOException {
        String nomFile = "nom.txt";
        String prenomFile = "";
        if (genre.equals("Féminin")) {
            prenomFile = "prenomF.txt";
        } else if (genre.equals("Masculin")) {
            prenomFile = "prenomM.txt";
        }

        File fileNom = new File(nomFile);
        FileReader frNom = new FileReader(fileNom);
        BufferedReader brNom = new BufferedReader(frNom);
        String lineNom;

        File filePrenom = new File(prenomFile);
        FileReader frPrenom = new FileReader(filePrenom);
        BufferedReader brPrenom = new BufferedReader(frPrenom);
        String linePrenom;

        ArrayList<String> ListPrenom = new ArrayList();   // ---< voir pq 52 ???
        ArrayList<String> ListNom = new ArrayList();

        while ((lineNom = brNom.readLine()) != null) {
            ListNom.add(lineNom);
        }

        while ((linePrenom = brPrenom.readLine()) != null) {
            ListPrenom.add(linePrenom);

        }

        ArrayList Random1 = new ArrayList();
        ArrayList Random2 = new ArrayList();
        ArrayList Random3 = new ArrayList();

        for (int k = 0; k < ListNom.size(); k++) {
            Random1.add(k);
            Random2.add(k);
            Random3.add(k);
        }
        Collections.shuffle(Random1);
        Collections.shuffle(Random2);
        Collections.shuffle(Random3);

        for (int p = ListJoueur.size(); p < ListNom.size(); p++) {
            Joueur joueur = new Joueur();
            joueur.nomNaissance = ListNom.get((int) Random1.get(p));
            joueur.prenom = ListPrenom.get((int) Random2.get(p));
            joueur.classement = p + 1;
            joueur.numero = p + 1;
            if (((int) Random3.get(p)) % 2 == 0) {
                joueur.bras = "droit";
            } else {
                joueur.bras = "gauche";
            }
            ListJoueur.add(joueur);

        }

        frPrenom.close();
        frNom.close();
        return ListJoueur;
    }

    public static void AffichageJoueur(ArrayList<Joueur> ListJoueur) {

        System.out.println("Liste des Joueurs : \n");
        int j = 0;

        int compteur = 0;

        for (int i = 0; i < ListJoueur.size(); i++) {
            System.out.println("Joueur n*  " + (i + 1));
            System.out.println("Prise de la raquette : " + ListJoueur.get(i).bras);
            System.out.println("Prenom               : " + ListJoueur.get(i).prenom);
            System.out.println("Nom de naissance     : " + ListJoueur.get(i).nomNaissance);
            System.out.println("Classement           : " + ListJoueur.get(i).classement);
            System.out.println("Numero Tournoi       : " + ListJoueur.get(i).numero);
            System.out.println("Qualification        : " + ListJoueur.get(i).qualification);
            System.out.println("\n");
        }
    }

    public static Joueur NewJoueur(int n) {
        Joueur joueur = new Joueur();
        Scanner sc = new Scanner(System.in);
        System.out.println("Prise de la raquette (droit/gauche) ?");
        String str = sc.nextLine();
        joueur.bras = str;
        System.out.println("Prenom de votre Joueur :");
        str = sc.nextLine();
        joueur.prenom = str;
        System.out.println("nomNaissance de votre Joueur :");
        str = sc.nextLine();
        joueur.nomNaissance = str;
        joueur.classement = n + 1;
        joueur.numero = n+1;
        joueur.qualification = "qualifie";

        return joueur;
    }

    

}
