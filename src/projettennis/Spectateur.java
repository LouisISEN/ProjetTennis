/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projettennis;

/**
 *La class Spectateur contient les différents actions que peuvent faire les spectateurs durant le tournoi.
 * @author axand
 */
public class Spectateur extends Personne implements Vetement {

    public String emplacement;                  // emplacement du ticket du joueur
    /**
     *faire applaudir les joueurs
     */
    public static void applaudir() {       //action spectateur
        System.out.println("clap clap clap");
    }
    /**
     *faire crier les joueurs
     */
    public static void crier() {       //action spectatuer
        System.out.println("ALLEEEEEEEZ");
    }
    /**
     *faire huer les joueurs
     */
    public static void huer() {    //action spectatuer
        System.out.println("BOUUUUUUUH");
    }
    /**
     *faire dormir les joueurs
     */
    public static void dormir() { //action spectateur
        System.out.println("rompich");
    }
    
    @Override
    public void changerVetement() {
        System.out.println("Change de chemise");
}

}
