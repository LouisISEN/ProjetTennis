/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projettennis;

import java.util.ArrayList;

/**
 *
 * @author axand
 */
public class Set {
    
    private int setJoueur1;
    private int setJoueur2;

    public int getSetJoueur1() {
        return this.setJoueur1;
    }

    public void setSetJoueur1(int setJoueur1) {
        this.setJoueur1 = setJoueur1;
    }

    public int getSetJoueur2() {
        return this.setJoueur2;
    }

    public void setSetJoueur2(int setJoueur2) {
        this.setJoueur2 = setJoueur2;
    }

    public void IncrementeSetJoueur1() {
        setJoueur1++;
    }

    public void IncrementeSetJoueur2() {
        setJoueur2++;
    }

    

    
    public static Match set(Match match, Tournoi ObjTournoi, int n, int a, int auto, int setJoueur1, int setJoueur2) {

        System.out.println("Debut Set");
        
  
        Jeu jeu = new Jeu();
        match.joueur1.setWinSet(0);
        match.joueur2.setWinSet(0);

        while (((jeu.getJeuJoueur1() < 6) & (jeu.getJeuJoueur2() < 6)) | ((Math.abs(jeu.getJeuJoueur1() - jeu.getJeuJoueur2())) < 2)) {

            match = Jeu.jeu(match, ObjTournoi, n, match.getDernierService(), auto, jeu.getJeuJoueur1(), jeu.getJeuJoueur2(), setJoueur1, setJoueur2);
            if (match.getDernierService()== 1) {
                match.setDernierService(2);
            } else {
                match.setDernierService(1);
            }
            if (a == 1) {
                System.out.println("Le joueur " + match.joueur1.getNomNaissance() + " a le service");
            } else {
                System.out.println("Le joueur " + match.joueur2.getNomNaissance() + " a le service");
            }
            if (match.joueur1.getWinJeu() == 1) {
                jeu.IncrementeJeuJoueur1();;
                match.joueur1.IncrementeJeuJoueur();;
            } else {
                jeu.IncrementeJeuJoueur2();;

                match.joueur2.IncrementeJeuJoueur();;
            }
        }
        if (jeu.getJeuJoueur1() > jeu.getJeuJoueur2()) {

            match.joueur1.setWinSet(1);

        } else {

            match.joueur2.setWinSet(1);

        }

        System.out.println("Fin du Set");
        return match;
    }
}
