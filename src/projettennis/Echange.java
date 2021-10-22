/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projettennis;

import java.util.Random;

/**
 *
 * @author axand
 */
public class Echange {

    int ScoreJoueur1;
    int ScoreJoueur2;

    public static Echange echange() {

        Echange ScoreEchange = new Echange();

        return ScoreEchange;
    }

    public static int Service(int nb, String Joueur1, String Joueur2) {
        System.out.println("Service du joueur " + nb);                                                          //Détermine qui va servir en random

        return nb;//ScoreEchange;

        // determine qui a gagné, si 
        //return ;
    }
}
