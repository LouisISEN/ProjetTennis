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
 * La class échange permet de jouer les services de facon automatique ou de
 * facon manuelle.
 *
 * @author axand
 */
public class Echange {

    private int pointJoueur1 = 0;               // attributs faisant avancer le match 
    private int pointJoueur2 = 0;

    public int getPointJoueur1() {
        return this.pointJoueur1;
    }

    public void setPointJoueur1(int pointJoueur1) {
        this.pointJoueur1 = pointJoueur1;
    }

    public int getPointJoueur2() {
        return this.pointJoueur2;
    }

    public void setPointJoueur2(int pointJoueur2) {
        this.pointJoueur2 = pointJoueur2;
    }

    public void incrementePointJoueur1() {
        pointJoueur1++;
    }

    public void incrementePointJoueur2() {
        pointJoueur2++;
    }

    /**
     * La méthode simule le service et demande le résultat à l'utilisateur
     *
     * @param match
     * @param nbService
     * @param nbMatch
     * @return
     */
    public static int service(Match match, int nbService, int nbMatch) {   // Joue les services manuellement

        int a = 1;
        int let = 0;
        Scanner sc = new Scanner(System.in);
        int str = 0;
        String joueur;

        if (nbService == 1) {
            joueur = match.joueur1.getNomNaissance();
        } else {
            joueur = match.joueur2.getNomNaissance();
        }

        while (a != 0) {
            System.out.println("Le joueur " + joueur + " marque-t-il (1)? fait-il faute (2)? ou let (3) ?");
            str = sc.nextInt();                     // Porpose 3 choix, le joueur marque, fait faute, ou fait let (donc 2e service)
            if ((str == 1) || (str == 2)) {
                a = 0;
            } else if (str == 3) {
                let++;
            }

            if (let == 2) {                     // si 2 Let, faute
                str = 2;
                a = 0;
            }

            Arbitre.annonce(str, joueur);           //Annonce de l'arbitre le resultat du service

        }
        return str;
    }

    /**
     * La méthode simule le service et son résultat aléatoirement
     *
     * @param match
     * @param nbService
     * @param nbMatch
     * @return
     */
    public static int serviceAuto(Match match, int nbService, int nbMatch) {            //joue le service automatiquement, le résultat du service est aléatoirement

        int a = 1;
        int nb = 0;
        int let = 0;
        String joueur;

        if (nbService == 1) {
            joueur = match.joueur1.getNomNaissance();
        } else {
            joueur = match.joueur2.getNomNaissance();
        }

        System.out.println("Le joueur " + joueur + " sert : ");
        Random random = new Random();

        int borne1 = 100;
        int borne2 = 0;
        nb = 1 + random.nextInt(borne1 - borne2);

        if ((1 <= nb) & (nb < 45)) {                     //probabilité de 0.45 d'avoir marqué, de 0.45 de faire faute et de 0.10 de faire un let
            nb = 1;

        }
        if ((45 <= nb) & (nb < 90)) {
            nb = 2;

        }
        if ((90 <= nb) & (nb <= 100)) {
            nb = 3;

        }
        while (a != 0) {

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
            switch (nb) {
                case 1:
                    Spectateur.applaudir();
                    break;
                case 2:
                    Spectateur.huer();
                    break;
                case 3:
                    Spectateur.crier();
                    break;
            }
        }

        return nb;
    }

}
