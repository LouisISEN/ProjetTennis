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

    public String getBras() {
        return bras;
    }

    public void setBras(String bras) {
        this.bras = bras;
    }

    public String getEntraineur() {
        return entraineur;
    }

    public void setEntraineur(String entraineur) {
        this.entraineur = entraineur;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public int getClassement() {
        return classement;
    }

    public void setClassement(int classement) {
        this.classement = classement;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public int getPointJoueur() {
        return pointJoueur;
    }

    public void setPointJoueur(int pointJoueur) {
        this.pointJoueur = pointJoueur;
    }

    public int getSetJoueur() {
        return SetJoueur;
    }

    public void setSetJoueur(int SetJoueur) {
        this.SetJoueur = SetJoueur;
    }

    public int getJeuJoueur() {
        return JeuJoueur;
    }

    public void setJeuJoueur(int JeuJoueur) {
        this.JeuJoueur = JeuJoueur;
    }

    public int getService() {
        return Service;
    }

    public void setService(int Service) {
        this.Service = Service;
    }

    public int getFaute() {
        return Faute;
    }

    public void setFaute(int Faute) {
        this.Faute = Faute;
    }

    public int getWinSet() {
        return WinSet;
    }

    public void setWinSet(int WinSet) {
        this.WinSet = WinSet;
    }

    public int getWinJeu() {
        return WinJeu;
    }

    public void setWinJeu(int WinJeu) {
        this.WinJeu = WinJeu;
    }

    
    private String bras;
    private String entraineur;
    private String sponsor;
    private int classement;

    private String qualification = "qualifie";

    private int pointJoueur = 0;
    private int SetJoueur = 0;
    private int JeuJoueur = 0;
    private int Service=0;
    private int Faute=0;

    private int WinSet = 0;
    private int WinJeu = 0;
    
    public void incrementeSetJoueur(){
        SetJoueur++;
    }
    
    public void incrementeJeuJoueur(){
        JeuJoueur++;
    }
    
    public void incrementePointJoueur(){
        pointJoueur++;
    }
    
    public void incrementeServiceJoueur(){
        Service++;
    }
    
    public void incrementeFauteJoueur(){
        Faute++;
    }
    
    public static ArrayList<Joueur> GenerateurJoueur(String genre, ArrayList<Joueur> ListJoueur) throws FileNotFoundException, IOException {
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
            joueur.setNomNaissance(ListNom.get((int) Random1.get(p)));
            joueur.setPrenom(ListPrenom.get((int) Random2.get(p)));
            joueur.classement = p + 1;
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
            System.out.println("Joueur " + (i + 1));
            System.out.println("Bras =" + ListJoueur.get(i).bras);
            System.out.println("Prenom =" + ListJoueur.get(i).getPrenom());
            System.out.println("nomNaissance =" + ListJoueur.get(i).getNomNaissance());
            System.out.println("Classement =" + ListJoueur.get(i).classement);
            //System.out.println("Numero =" + ListJoueur.get(i).NumeroMatch);
            System.out.println("Qualification =" + ListJoueur.get(i).qualification);
            System.out.println("\n");
        }
    }

    public static Joueur NewJoueur(int n) {
        Joueur joueur = new Joueur();
        Scanner sc = new Scanner(System.in);
        System.out.println("Bras de votre Joueur (droitier/gaucher):");
        String str = sc.nextLine();
        joueur.bras = str;
        System.out.println("Prenom de votre Joueur :");
        str = sc.nextLine();
        joueur.setPrenom(str); 
        System.out.println("nomNaissance de votre Joueur :");
        str = sc.nextLine();
        joueur.setNomNaissance(str);
        joueur.classement = n + 1;
        joueur.qualification = "qualifie";

        return joueur;
    }

    public static void AffichageStat(ArrayList<Joueur> ListJoueur) {
        System.out.println("Statistiques joueurs :\n");
        System.out.println("Numéro    Nom       Prénom       Point     Jeu       Set      Service    Faute");
        System.out.println("                                                               Réussi");
        for (int i = 0; i < ListJoueur.size(); i++) {

            System.out.println(Tournoi.affichageTxt(String.valueOf(i + 1)) + Tournoi.affichageTxt(ListJoueur.get(i).getNomNaissance()) + Tournoi.affichageTxt(ListJoueur.get(i).getPrenom()) + ":    " + Tournoi.affichageTxt(String.valueOf(ListJoueur.get(i).pointJoueur)) + Tournoi.affichageTxt(String.valueOf(ListJoueur.get(i).JeuJoueur)) + Tournoi.affichageTxt(String.valueOf(ListJoueur.get(i).SetJoueur)) + Tournoi.affichageTxt(String.valueOf(ListJoueur.get(i).Service))+ Tournoi.affichageTxt(String.valueOf(ListJoueur.get(i).Faute)));

            System.out.println("\n");

        }
    }

}
