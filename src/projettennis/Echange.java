/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projettennis;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author axand
 */
public class Echange {

    public static int Service(Tournoi TabMatch[], int nbService, int nbMatch) {
        int a = 1;
        Scanner sc = new Scanner(System.in);
        int str = 0;
        String joueur;

        if (nbService == 1) {
            joueur = TabMatch[nbMatch].Joueur1;
        } else {
            joueur = TabMatch[nbMatch].Joueur2;
        }

        System.out.println("Le joueur " + joueur + " marque-t-il (1)? fait-il faute (2)? ou let (3) ?");
        while (a != 0) {

            str = sc.nextInt();
            switch (str) {
                case 1:
                    System.out.println("Le joueur marque le point");
                    a = 0;
                    if (nbService==1){
                        return 1;
                    }
                    else {
                        return 2;
                    }
                    
                case 2:
                    System.out.println("Le joueur fait faute");
                    a = 0;
                     if (nbService==1){
                        return 2;
                    }
                    else {
                        return 1;
                    }
                    
                case 3:
                    System.out.println("Le joueur fait Let, deuxieme service ");
                    a++;

            }
            if (a == 3) {
                str = 2;
                System.out.println("2 Let, Faute");
                a = 0;
            }

        }

        return str;
    }

}
