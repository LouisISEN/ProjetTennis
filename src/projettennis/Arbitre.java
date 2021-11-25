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

/**
 *La class Arbitre qui permet de générer les arbitres ainsi que d'afficher la liste générée.
 *L'arbitre peut faire des Annonces concernant les echanges : point, faute ou let.
 * @author axand
 */
public class Arbitre extends Personne {
    /**
     * L'arbitre annonce le résultat du service qui vient de se jouer (point, faute, let)
     * @param n
     * @param joueur 
     */
    public static void annonce(int n, String joueur) {      //annonce de l'arbitre sur le résultat de l'echange
        switch (n) {
            case 1:
                System.out.println(" Arbitre : ' " + joueur + " marque le point' ");
                break;
            case 2:
                System.out.println(" Arbitre : ' " + joueur + " fait faute' ");
                break;
            case 3:
                System.out.println(" Arbitre : ' " + joueur + " fait LET' ");
                break;

        }
    }

    
    /**
     * Affiche la liste des arbitres
     * @param listArbitre 
     */
    public static void afficherArbitre(ArrayList<Arbitre> listArbitre) {               //affichage nom et prenom de la liste des arbitres
        System.out.println("Liste des Arbitres : \n");
        for (int i = 0; i < listArbitre.size(); i++) {
            System.out.println("Arbitre " + (i + 1));
            System.out.println("Prenom =" + listArbitre.get(i).getPrenom());
            System.out.println("Nom de naissance =" + listArbitre.get(i).getNomNaissance());
            System.out.println("Date de naissance =" + listArbitre.get(i).getDateNaissance());
            System.out.println("\n");
        }
    }
    /**
     * Génére les arbitres un à un, et les ajoute a la liste des arbitres du tournoi
     * @param genre
     * @return
     * @throws FileNotFoundException
     * @throws IOException 
     */
     public static ArrayList<Arbitre> genererArbitre(String genre) throws FileNotFoundException, IOException {
        String nomFile = "nom.txt";             //adresse fichier txt
        String prenomFile ="";      
        ArrayList<Arbitre> listArbitre = new ArrayList<Arbitre>();
          if (genre.equals("Féminin")) {
            prenomFile = "info-arbitreF.txt";;                  //choix du fichier de prenom Masculin ou feminin
        } else if (genre.equals("Masculin")) {
            prenomFile = "info-arbitreH.txt";
        }
        
       

        File fileNom = new File(nomFile);
        FileReader frNom = new FileReader(fileNom);
        BufferedReader brNom = new BufferedReader(frNom);
        String lineNom;

        File filePrenom = new File(prenomFile);
        FileReader frPrenom = new FileReader(filePrenom);
        BufferedReader brPrenom = new BufferedReader(frPrenom);
        String linePrenom;

        ArrayList<String> listPrenom = new ArrayList(); 
        ArrayList<String> listNom = new ArrayList();

        while ((lineNom = brNom.readLine()) != null) {     //ajout des noms a la liste de nom
            listNom.add(lineNom);
        }

        while ((linePrenom = brPrenom.readLine()) != null) {    //ajout des prenoms a la liste de prenom
            listPrenom.add(linePrenom);

        }

        ArrayList random1 = new ArrayList();                    
        ArrayList random2 = new ArrayList();
       

        for (int k = 0; k < listPrenom.size(); k++) {   //liste de nombre
            random1.add(k);
            random2.add(k);
       
        }
        Collections.shuffle(random1);               //liste de nombre dans un ordre aléatoire
        Collections.shuffle(random2);
  

        for (int p = listArbitre.size(); p < listPrenom.size(); p++) {          //Creation des arbitres un à un avec prenom et nom aléatoire et sont ajoutés a la liste des arbitres
            Arbitre arbitre = new Arbitre();
            arbitre.setNomNaissance(listNom.get((int) random1.get(p)));
            arbitre.setPrenom(listPrenom.get((int) random2.get(p)));
            
           
            listArbitre.add(arbitre);

        }

        frPrenom.close();
        frNom.close();
        return listArbitre;
    }


}
