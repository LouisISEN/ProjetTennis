/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projettennis;

import java.util.ArrayList;

/**
 * La class Set permet de gérer les nombre de Jeu dans un set, ainsi que les
 * statistiques joueurs (nombre de jeu gagné)
 *
 * @author axand
 */
public class Set {

    private int setJoueur1;             // attributs faisant avancer le match 
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

        Jeu jeu = new Jeu();                //créer un nouveau jeu
        match.joueur1.setWinSet(0);
        match.joueur2.setWinSet(0);

        while (((jeu.getJeuJoueur1() < 6) & (jeu.getJeuJoueur2() < 6)) | ((Math.abs(jeu.getJeuJoueur1() - jeu.getJeuJoueur2())) < 2)) {
    // Le set se joue jusqu'à ce que l'un des 2 joueurs gagnent 6 jeux à condition qu'il y ait 2 jeux d'ecarts, sinon on continue
            if (a == 1) {                                                                       //Affichage du joueur qui a le service a chaque jeu
                System.out.println("Le joueur " + match.joueur1.getNomNaissance() + " a le service");
            } else {
                System.out.println("Le joueur " + match.joueur2.getNomNaissance() + " a le service");
            }
            
            match = Jeu.jeu(match, ObjTournoi, n, match.getDernierService(), auto, jeu.getJeuJoueur1(), jeu.getJeuJoueur2(), setJoueur1, setJoueur2);
            if (match.getDernierService() == 1) {                                                //appel de la fonction jeu qui gére les affichages scores et les échanges
                match.setDernierService(2);                                                     // Permet d'alterner les services à chaque jeu
            } else {
                match.setDernierService(1);
            }

            if (match.joueur1.getWinJeu() == 1) {                                               //si le joueur1 gagne le jeu on incremente sa statistiques jeu gagné
                jeu.IncrementeJeuJoueur1();;                                                    //et la variable jeujoueur1 qui permet l'avancement du set
                match.joueur1.IncrementeJeuJoueur();;
            } else {                                                                             //si le joueur2 gagne le jeu on incremente sa statistiques jeu gagné
                jeu.IncrementeJeuJoueur2();;                                                     //et la variable jeujoueur1 qui permet l'avancement du set

                match.joueur2.IncrementeJeuJoueur();;
            }
        }
        if (jeu.getJeuJoueur1() > jeu.getJeuJoueur2()) {                                         // Détermine qui a gagné le set
            
            match.joueur1.setWinSet(1);

        } else {

            match.joueur2.setWinSet(1);

        }
        Spectateur.applaudir();
        System.out.println("Fin du Set");
        return match;
    }
}
