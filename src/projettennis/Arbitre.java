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

/**
 *
 * @author axand
 */
public class Arbitre extends Personne {

    public static void score(int score1, int score2) {
        System.out.println("Le score est de" + score1 + "-" + score2);
    }

    public static void faute() {
        System.out.println("dire faute");
    }

    public static ArrayList<Arbitre> ListeArbitre(int NbrArbitre, String AdrFile) throws FileNotFoundException, IOException {

        File file = new File(AdrFile);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        StringBuffer sb = new StringBuffer();
        String line;
        int l = 1;
        int j = 1;

        ArrayList<Arbitre> ListArbitre = new ArrayList();     //<-- NOMBRE DE JOUEUR+1
        Arbitre arbitre = new Arbitre();
        while ((line = br.readLine()) != null) {

            if (line.equals(";")) {
                ListArbitre.add(arbitre);
                l = 0;
             
                //  System.out.println("Arbitre "+j+":");
                
            }

            switch (l) {

                case 1:
                    arbitre.prenom = line;
                    break;

                case 2:
                    arbitre.nomNaissance = line;
                    break;

                case 3:
                    arbitre.dateNaissance = line;
                    break;

            }
            
            l = l + 1;
            
        }
        fr.close();

        return ListArbitre;
    }

    public static void AffichageArbitre(ArrayList<Arbitre> ListArbitre) {
        System.out.println("Liste des Arbitres : \n");
        for (int i = 0; i < ListArbitre.size()-1; i++) {
            System.out.println("Arbitre " + (i + 1));
            System.out.println("Prenom =" + ListArbitre.get(i).prenom);
            System.out.println("Nom de naissance =" + ListArbitre.get(i).nomNaissance);
            System.out.println("Date de naissance =" + ListArbitre.get(i).dateNaissance);
            System.out.println("\n");
        }
    }

}
