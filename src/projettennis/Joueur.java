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


    private String bras;
    private String entraineur;
    private int classement;
    private int numero;
    private int taille;
    private String sponsor;
    private int anneeNaissance;
    private String nationalite;

    private String qualification = "qualifie";

    private int pointJoueur = 0;
    private int setJoueur = 0;
    private int jeuJoueur = 0;
    private int service=0;
    private int faute=0;

    private int winSet = 0;
    private int winJeu = 0;


    public int getTaille() {
        return this.taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public int getAnneeNaissance() {
        return this.anneeNaissance;
    }

    public void setAnneeNaissance(int anneeNaissance) {
        this.anneeNaissance = anneeNaissance;
    }

    public String getNationalite() {
        return this.nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public void IncrementePointJoueur() {
        pointJoueur++;
    }

    public void IncrementeService() {
        service++;
    }

    public void IncrementeFaute() {
        faute++;
    }

    public void IncrementeSetJoueur() {
        setJoueur++;
    }

    public void IncrementeJeuJoueur() {
        jeuJoueur++;
    }


    public String getBras() {
        return this.bras;
    }

    public void setBras(String bras) {
        this.bras = bras;
    }

    public String getEntraineur() {
        return this.entraineur;
    }

    public void setEntraineur(String entraineur) {
        this.entraineur = entraineur;
    }

    public String getSponsor() {
        return this.sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public int getClassement() {
        return this.classement;
    }

    public void setClassement(int classement) {
        this.classement = classement;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getQualification() {
        return this.qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public int getPointJoueur() {
        return this.pointJoueur;
    }

    public void setPointJoueur(int pointJoueur) {
        this.pointJoueur = pointJoueur;
    }

    public int getSetJoueur() {
        return this.setJoueur;
    }

    public void setSetJoueur(int setJoueur) {
        this.setJoueur = setJoueur;
    }

    public int getJeuJoueur() {
        return this.jeuJoueur;
    }

    public void setJeuJoueur(int jeuJoueur) {
        this.jeuJoueur = jeuJoueur;
    }

    public int getService() {
        return this.service;
    }

    public void setService(int service) {
        this.service = service;
    }

    public int getFaute() {
        return this.faute;
    }

    public void setFaute(int faute) {
        this.faute = faute;
    }

    public int getWinSet() {
        return this.winSet;
    }

    public void setWinSet(int winSet) {
        this.winSet = winSet;
    }

    public int getWinJeu() {
        return this.winJeu;
    }

    public void setWinJeu(int winJeu) {
        this.winJeu = winJeu;
    }
    

    public static ArrayList<Joueur> GenerateurJoueur(String genre, ArrayList<Joueur> listeJoueur) throws FileNotFoundException, IOException {
        String nomFile = "nom.txt";         //ligne la = taille, sponsor, année de naissance (et en déduire l'âge), nationalité
        String prenomFile = "";
        String sponsorFile="sponsor.txt";
        String nationaliteFile="nationalite.txt";
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

        File fileSponsor = new File(sponsorFile);
        FileReader frSponsor = new FileReader(fileSponsor);
        BufferedReader brSponsor = new BufferedReader(frSponsor);
        String lineSponsor;

        File fileNationalite = new File(nationaliteFile);
        FileReader frNationalite = new FileReader(fileNationalite);
        BufferedReader brNationalite = new BufferedReader(frNationalite);
        String lineNationalite;

        ArrayList<String> listPrenom = new ArrayList<String>();  
        ArrayList<String> listNom = new ArrayList<String>();        //ligne la
        ArrayList<String> listSponsor = new ArrayList<String>();
        ArrayList<String> listNationalite = new ArrayList<String>();

        while ((lineNom = brNom.readLine()) != null) {      //ligne la, while qui ajoute dans la liste les noms du .txt
            listNom.add(lineNom);
        }

        while ((linePrenom = brPrenom.readLine()) != null) {
            listPrenom.add(linePrenom);

        }
    

        while ((lineNationalite = brNationalite.readLine()) != null) {
            listNationalite.add(lineNationalite);
        }

        while ((lineSponsor = brSponsor.readLine()) != null) {
            listSponsor.add(lineSponsor);
        }

        ArrayList random1 = new ArrayList();        //ligne la
        ArrayList random2 = new ArrayList();
        ArrayList random3 = new ArrayList();

        for (int k = 0; k < listNom.size(); k++) {      //ligne la, remplace la liste random de chiffres
            random1.add(k);
            random2.add(k);
            random3.add(k);
        }
        Collections.shuffle(random1);       //ligne la, mélange les chiffres 
        Collections.shuffle(random2);
        Collections.shuffle(random3);

        for (int p = listeJoueur.size(); p < listNom.size(); p++) {     //ligne la
            Joueur joueur = new Joueur();   //ligne la
            joueur.setNomNaissance(listNom.get((int) random1.get(p)));  //ligne la
            joueur.setPrenom(listPrenom.get((int) random2.get(p)));
            joueur.classement = p + 1;
            joueur.numero = p + 1;
            if (((int) random3.get(p)) % 2 == 0) {
                joueur.bras = "droit";
            } else {
                joueur.bras = "gauche";
            }
            listeJoueur.add(joueur);

        }

        frPrenom.close();
        frNom.close();
        return listeJoueur;
    }

    public static void AffichageJoueur(ArrayList<Joueur> listeJoueur) {

        System.out.println("Liste des Joueurs : \n");

        for (int i = 0; i < listeJoueur.size(); i++) {
            System.out.println("Joueur n*  " + (i + 1));
            System.out.println("Prise de la raquette : " + listeJoueur.get(i).bras);
            System.out.println("Prenom               : " + listeJoueur.get(i).getPrenom());
            System.out.println("Nom de naissance     : " + listeJoueur.get(i).getNomNaissance());
            System.out.println("Classement           : " + listeJoueur.get(i).classement);
            System.out.println("Numero Tournoi       : " + listeJoueur.get(i).numero);
            System.out.println("Qualification        : " + listeJoueur.get(i).qualification);
            //ligne la à rajouter ici pour les attributs
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
        joueur.setPrenom(str);
        System.out.println("nomNaissance de votre Joueur :");
        str = sc.nextLine();
        joueur.setNomNaissance(str);
        joueur.classement = n + 1;
        joueur.numero = n+1;
        joueur.qualification = "qualifie";

        return joueur;
    }

    

}
