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

    public static int Service(Match TabMatch[], int nbService, int nbMatch) {
        int a = 1;
        Scanner sc = new Scanner(System.in);
        int str = 0;
        String joueur;

        if (nbService == 1) {
            joueur = TabMatch[nbMatch].Joueur1.nomNaissance;
        } else {
            joueur = TabMatch[nbMatch].Joueur2.nomNaissance;
        }

        System.out.println("Le joueur " + joueur + " marque-t-il (1)? fait-il faute (2)? ou let (3) ?Manu");
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
    
    public static int ServiceAuto(Match TabMatch[], int nbService, int nbMatch) {
       
        
        int a=1;
        String joueur;

        if (nbService == 1) {
            joueur = TabMatch[nbMatch].Joueur1.nomNaissance;
        } else {
            joueur = TabMatch[nbMatch].Joueur2.nomNaissance;
        }
        
        System.out.println("Le joueur " + joueur + " marque-t-il (1)? fait-il faute (2)? ou let (3) ? Auto");
        Random random = new Random();
        int nb;
        int Borne1 = 100;
        int Borne2 = 0;
        nb = 1 + random.nextInt(Borne1 - Borne2);
        if ((1<=nb)&(nb<45)){
            nb=1;
        }
        if ((45<=nb)&(nb<90)){
            nb=2;
        }
        if ((90<=nb)&(nb<=100)){
            nb=3;
        }
        while (a != 0) {

            
            switch (nb) {
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
                    System.out.println("Le joueur fait Let");
                    a++;

            }
            if (a == 3) {
                nb = 2;
                System.out.println("2 Let, Faute");
                a = 0;
            }

        }

        return nb;
    }

}
