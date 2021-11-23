/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projettennis;

import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author axand
 */
public class Echange {

    public static int Service(Match match, int nbService, int nbMatch) {

        int a = 1;
        int let = 0;
        Scanner sc = new Scanner(System.in);
        int str = 0;
        String joueur;

        if (nbService == 1) {
            joueur = match.Joueur1.getNomNaissance();
        } else {
            joueur = match.Joueur2.getNomNaissance();
        }

        while (a != 0) {
            System.out.println("Le joueur " + joueur + " marque-t-il (1)? fait-il faute (2)? ou let (3) ?Manu");
            str = sc.nextInt();
            if ((str == 1) || (str == 2)) {
                a = 0;
            } else if (str == 3) {
                let++;
            }

            if (let == 2) {
                str = 2;
                a = 0;
            }

            Arbitre.annonce(str, joueur); 

        }
        return str;
    }

    public static int ServiceAuto(Match match, int nbService, int nbMatch) {

        int a = 1;
        int let = 0;
        int nb=0;
        String joueur;

        if (nbService == 1) {
            joueur = match.Joueur1.getNomNaissance();
        } else {
            joueur = match.Joueur2.getNomNaissance();
        }

        System.out.println("Le joueur " + joueur + " sert : ");
        Random random = new Random();
        
        int Borne1 = 100;
        int Borne2 = 0;
        
        while(a!=0){
            
        nb = 1 + random.nextInt(Borne1 - Borne2);
        
        if ((1 <= nb) & (nb < 45)) {
            nb = 1;                         //marque
        }
        if ((45 <= nb) & (nb < 90)) {
            nb = 2;                         //faute
        }
        if ((90 <= nb) & (nb <= 100)) {
            nb = 3;                         //let
        }
        
            if ((nb == 1) || (nb == 2)) {
                a = 0;
            } else if (nb == 3) {
                let++;
            }

            if (let == 2) {
                nb = 2;
                a = 0;
            }
            Arbitre.annonce(nb, joueur);
        }

        return nb;
    }

}
