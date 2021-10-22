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

    public static Arbitre[] ListeArbitre(int NbrArbitre, String AdrFile) throws FileNotFoundException, IOException {

        File file = new File(AdrFile);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        StringBuffer sb = new StringBuffer();
        String line;
        int l = 1;
        int j = 1;

        Arbitre[] TabArbitre = new Arbitre[NbrArbitre + 1];     //<-- NOMBRE DE JOUEUR+1
        TabArbitre[j - 1] = new Arbitre();
        while ((line = br.readLine()) != null) {

            if (line.equals(";")) {

                l = 0;
                j = j + 1;
                //  System.out.println("Arbitre "+j+":");
                TabArbitre[j - 1] = new Arbitre();
            }

            switch (l) {

                case 1:
                    TabArbitre[j - 1].prenom = line;
                    break;

                case 2:
                    TabArbitre[j - 1].nomNaissance = line;
                    break;

                case 3:
                    TabArbitre[j - 1].dateNaissance = line;
                    break;

            }

            l = l + 1;

        }
        fr.close();

        return TabArbitre;
    }

    public static void AffichageArbitre(Arbitre TabArbitre[]) {
        System.out.println("Liste des Arbitres : \n");
        for (int i = 0; i < TabArbitre.length - 1; i++) {
            System.out.println("Arbitre " + (i + 1));
            System.out.println("Prenom =" + TabArbitre[i].prenom);
            System.out.println("Nom de naissance =" + TabArbitre[i].nomNaissance);
            System.out.println("Date de naissance =" + TabArbitre[i].dateNaissance);
            System.out.println("\n");
        }
    }

}
