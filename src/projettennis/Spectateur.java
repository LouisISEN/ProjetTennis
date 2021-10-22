/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projettennis;

/**
 *
 * @author axand
 */
public class Spectateur extends Personne {

    public String emplacement;

    public void applaudir() {
        System.out.println("clap clap clap");
    }

    public void crier() {
        System.out.println("aller + nom du joueur");
    }

    public void huer() {
        System.out.println("BOUUUUUUUH");
    }

    public void dormir() {
        System.out.println("rompich");
    }

    public void test() {
        System.out.println("salut");
    }
}
