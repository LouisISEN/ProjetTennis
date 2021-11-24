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
 *L'arbitre peut faire des annonces concernant les echanges : point, faute ou let.
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

    

    public static void AffichageArbitre(ArrayList<Arbitre> ListArbitre) {
        System.out.println("Liste des Arbitres : \n");
        for (int i = 0; i < ListArbitre.size(); i++) {
            System.out.println("Arbitre " + (i + 1));
            System.out.println("Prenom =" + ListArbitre.get(i).getPrenom());
            System.out.println("Nom de naissance =" + ListArbitre.get(i).getNomNaissance());
            System.out.println("Date de naissance =" + ListArbitre.get(i).getDateNaissance());
            System.out.println("\n");
        }
    }
    
     public static ArrayList<Arbitre> GenerateurArbitre(String genre) throws FileNotFoundException, IOException {
        String NomFile = "nom.txt";
        String PrenomFile ="";
        ArrayList<Arbitre> ListArbitre = new ArrayList<Arbitre>();
          if (genre.equals("Féminin")) {
            PrenomFile = "info-arbitreF.txt";;
        } else if (genre.equals("Masculin")) {
            PrenomFile = "info-arbitreH.txt";
        }
        
       

        File fileNom = new File(NomFile);
        FileReader frNom = new FileReader(fileNom);
        BufferedReader brNom = new BufferedReader(frNom);
        String lineNom;

        File filePrenom = new File(PrenomFile);
        FileReader frPrenom = new FileReader(filePrenom);
        BufferedReader brPrenom = new BufferedReader(frPrenom);
        String linePrenom;

        ArrayList<String> ListPrenom = new ArrayList(); 
        ArrayList<String> ListNom = new ArrayList();

        while ((lineNom = brNom.readLine()) != null) {
            ListNom.add(lineNom);
        }

        while ((linePrenom = brPrenom.readLine()) != null) {
            ListPrenom.add(linePrenom);

        }

        ArrayList Random1 = new ArrayList();
        ArrayList Random2 = new ArrayList();
       

        for (int k = 0; k < ListPrenom.size(); k++) {
            Random1.add(k);
            Random2.add(k);
       
        }
        Collections.shuffle(Random1);
        Collections.shuffle(Random2);
  

        for (int p = ListArbitre.size(); p < ListPrenom.size(); p++) {
            Arbitre arbitre = new Arbitre();
            arbitre.setNomNaissance(ListNom.get((int) Random1.get(p)));
            arbitre.setPrenom(ListPrenom.get((int) Random2.get(p)));
            
           
            ListArbitre.add(arbitre);

        }

        frPrenom.close();
        frNom.close();
        return ListArbitre;
    }


}
