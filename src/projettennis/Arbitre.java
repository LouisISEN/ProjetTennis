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

    public static void annonce(int n, String joueur) {
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

    

    public static void affichageArbitre(ArrayList<Arbitre> listArbitre) {
        System.out.println("Liste des Arbitres : \n");
        for (int i = 0; i < listArbitre.size(); i++) {
            System.out.println("Arbitre " + (i + 1));
            System.out.println("Prenom =" + listArbitre.get(i).getPrenom());
            System.out.println("Nom de naissance =" + listArbitre.get(i).getNomNaissance());
            System.out.println("Date de naissance =" + listArbitre.get(i).getDateNaissance());
            System.out.println("\n");
        }
    }
    
     public static ArrayList<Arbitre> generateurArbitre(String genre) throws FileNotFoundException, IOException {
        String nomFile = "nom.txt";
        String prenomFile ="";
        ArrayList<Arbitre> listArbitre = new ArrayList<Arbitre>();
          if (genre.equals("Féminin")) {
            prenomFile = "info-arbitreF.txt";;
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

        while ((lineNom = brNom.readLine()) != null) {
            listNom.add(lineNom);
        }

        while ((linePrenom = brPrenom.readLine()) != null) {
            listPrenom.add(linePrenom);

        }

        ArrayList random1 = new ArrayList();
        ArrayList random2 = new ArrayList();
       

        for (int k = 0; k < listPrenom.size(); k++) {
            random1.add(k);
            random2.add(k);
       
        }
        Collections.shuffle(random1);
        Collections.shuffle(random2);
  

        for (int p = listArbitre.size(); p < listPrenom.size(); p++) {
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
