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
 *La class Joueur permet de créer un/des joueurs manuellement, générer des joueurs avec des attributs aléatoires, ainsi que d'afficher la liste de joueur
 * @author axand
 */
public class Joueur extends Personne implements Vetement {


    private String bras;
    private String entraineur;
    private int classement;
    private int numero;
    private int taille;
    private String sponsor;
    private int anneeNaissance;
    private String nationalite;

    private String qualification = "qualifie";  // si le joueur est élimniné, qualification prend le nom du tour ou le joueur fut élimniné

    private int pointJoueur = 0;            //attribut statistique du joueur
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

    public void incrementePointJoueur() {
        pointJoueur++;
    }

    public void incrementeService() {
        service++;
    }

    public void incrementeFaute() {
        faute++;
    }

    public void incrementeSetJoueur() {
        setJoueur++;
    }

    public void incrementeJeuJoueur() {
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
    

    public static ArrayList<Joueur> generateurJoueur(String genre, ArrayList<Joueur> listeJoueur) throws FileNotFoundException, IOException {
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
        ArrayList<String> listNom = new ArrayList<String>();        
        ArrayList<String> listSponsor = new ArrayList<String>();
        ArrayList<String> listNationalite = new ArrayList<String>();
       

        while ((lineNom = brNom.readLine()) != null) {      // while qui ajoute dans la liste les noms du .txt
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


        ArrayList<Integer> random1 = new ArrayList<Integer>();       //on met le plus de listes random possibles afin de rendre le plus aléatoire possible les combinaisons d'attributs
        ArrayList<Integer> random2 = new ArrayList<Integer>();
        ArrayList<Integer> random3 = new ArrayList<Integer>();      //les 3 premières listes Random = pour les noms, prénoms, bras des joueurs
        ArrayList<Integer> random4 = new ArrayList<Integer>();      //pour les tailles
        ArrayList<Integer> random5 = new ArrayList<Integer>();      //pour les années de naissance
        ArrayList<Integer> random6 = new ArrayList<Integer>();      //pour les nationalités
        

        for (int k = 0; k < listNom.size(); k++) {      //ajoute des nombres de la liste =
            random1.add(k);
            random2.add(k);
            random3.add(k);
        }

        for (int j = 160; j<220;j++) {      //tailles des joueurs comprises entre 160 et 220cm
            random4.add(j);
        }
        for (int h = 1976; h<2003;h++) {        //date de naissance comprises entre 1976 et 2003
            random5.add(h);
        }

        for(int u = 0;u<33;u++) {       //pour avoir autant de valeurs dans random6 que dans listNationalite
            random6.add(u);
        }

        Collections.shuffle(random1);       //mélange les chiffres dans les listes random
        Collections.shuffle(random2);
        Collections.shuffle(random3);
        Collections.shuffle(random4);
        Collections.shuffle(random5);
        Collections.shuffle(random6);

        int a = 0;
        int b = 0;
        int c = 0;
        for (int p = listeJoueur.size(); p < listNom.size(); p++) {      
            Joueur joueur = new Joueur();
            joueur.setNomNaissance(listNom.get(random1.get(p)));  
            joueur.setPrenom(listPrenom.get(random2.get(p)));
            if (a==33) {
                a=0;
            }
            if (b==59) {
                b=0;
            }
            //
            if (c==26) {
                c=0;
            }
            joueur.setNationalite(listNationalite.get(random6.get(a)));
            joueur.setSponsor(listSponsor.get(random6.get(a)));
            joueur.setTaille(random4.get(b));
            joueur.setAnneeNaissance(random5.get(c));
            joueur.classement = p + 1;
            joueur.numero = p + 1;
            
            if ((random3.get(p)) % 2 == 0) {
                joueur.bras = "droit";
            } else {
                joueur.bras = "gauche";
            }
            listeJoueur.add(joueur);
            a++;
            b++;
            c++;
        }

        frPrenom.close();
        frNom.close();
        return listeJoueur;
    }

    public static void affichageJoueur(ArrayList<Joueur> listeJoueur) {     //affichage des attributs des joueurs

        System.out.println("Liste des Joueurs : \n");

        for (int i = 0; i < listeJoueur.size(); i++) {
            System.out.println("Joueur n*  " + (i + 1));
            System.out.println("Prise de la raquette : " + listeJoueur.get(i).bras);
            System.out.println("Prenom               : " + listeJoueur.get(i).getPrenom());
            System.out.println("Nom de naissance     : " + listeJoueur.get(i).getNomNaissance());
            System.out.println("Nationalite          : " + listeJoueur.get(i).nationalite);
            System.out.println("Annee de naissance   : " + listeJoueur.get(i).anneeNaissance);
            System.out.println("Taille               : " + listeJoueur.get(i).taille);
            System.out.println("Classement           : " + listeJoueur.get(i).classement);
            System.out.println("Numero Tournoi       : " + listeJoueur.get(i).numero);
            System.out.println("Qualification        : " + listeJoueur.get(i).qualification);
            System.out.println("Sponsor              : " + listeJoueur.get(i).sponsor);

            System.out.println("\n");
        }
    }

    public static Joueur newJoueur(int n) {    //creer un/des nouveau joueur manuellement 
        Joueur joueur = new Joueur();
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Prise de la raquette (droit/gauche) ?");
        String str = sc.nextLine();
        joueur.bras = str;

        System.out.println("Prenom de votre Joueur :");
        str = sc.nextLine();
        joueur.setPrenom(str);

        System.out.println("Nom de naissance de votre Joueur :");
        str = sc.nextLine();
        joueur.setNomNaissance(str);

        System.out.println("Annee de naissance de votre Joueur (entre 1976 et 2003) :");
        int str2=0;
        while ((str2 < 1976) || (str2 > 2003)) {
            try {
                str2 = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("EXCEPTION : Veuillez entrer une année de naissance comprise entre 1976 et 2003.");
            }
        }
        joueur.setAnneeNaissance(str2);

        System.out.println("Nationalite de votre Joueur :");
        str = sc.nextLine();
        joueur.setNationalite(str);

        System.out.println("Taille de votre Joueur en centimetres (entre 160 et 220):");
        while ((str2 < 160) || (str2 > 220 )) {
            try {
                str2 = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("EXCEPTION : Veuillez entrer une taille comprise entre 160 et 220 (en cm).");
            }
        }
        joueur.setTaille(str2);

        System.out.println("Sponsor de votre Joueur :");
        str = sc.nextLine();
        joueur.setSponsor(str);
        

        joueur.classement = n + 1;
        joueur.numero = n+1;
        joueur.qualification = "qualifie";

        return joueur;
    }
    
    @Override
    public void changerVetement() {
        System.out.println("Change de T-shirt");
}

    

}
