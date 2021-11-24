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
public class Match {

    Joueur joueur1 = new Joueur();
    Joueur joueur2 = new Joueur();

    Arbitre arbitre = new Arbitre();
    private int resultat = 0;                               //savoir si le match a deja été joué ou non, 1 oui 2 non
    private int dernierService = 0;
    private int perdant = 0;

    public int getResultat() {
        return this.resultat;
    }

    public void setResultat(int resultat) {
        this.resultat = resultat;
    }

    public int getDernierService() {
        return this.dernierService;
    }

    public void setDernierService(int dernierService) {
        this.dernierService = dernierService;
    }

    public int getPerdant() {
        return this.perdant;
    }

    public void setPerdant(int perdant) {
        this.perdant = perdant;
    }
    

    public static Match JouerM(Match match, int n, Tournoi ObjTournoi, int auto) {
        Set set = new Set();
        int NbrSetMax = 0;

        if (ObjTournoi.getGenre().equals("Masculin")) {
            NbrSetMax = 3;
        } else {
            NbrSetMax = 2;
        }
        System.out.println("Debut du match n*" + n + " : " + match.joueur1.getNomNaissance() + " " + match.joueur1.getPrenom()+ " contre " + match.joueur2.getNomNaissance() + " " + match.joueur1.getPrenom());

        while ((set.getSetJoueur1() != NbrSetMax) & (set.getSetJoueur2() != NbrSetMax)) {
            match.dernierService=Match.DeterminationService(match, n);
            match = Set.set(match, ObjTournoi, n, match.dernierService, auto, set.getSetJoueur1(), set.getSetJoueur2());

            if (match.joueur1.getWinSet()== 1) {
                set.IncrementeSetJoueur1();;
                match.joueur1.IncrementeSetJoueur();;
            } else {
                set.IncrementeSetJoueur2();;
                match.joueur2.IncrementeSetJoueur();;
            }
        }
        if (set.getSetJoueur1() == NbrSetMax) {
            if (ObjTournoi.getNbTour() == 7) {

                System.out.println("Fin du Match, Le joueur 1 " + match.joueur1.getNomNaissance() + " est le gagnant de la petite finale.");
                System.out.println("Le joueur 2 " + match.joueur2.getNomNaissance() + " est éliminé.");
                match.joueur1.setQualification("Gagnant PF");

            } else {

                System.out.println("Fin du Match, Le joueur 1 " + match.joueur1.getNomNaissance() + " est qualifié pour le tour suivant.");
                System.out.println("Le joueur 2 " + match.joueur2.getNomNaissance() + " est éliminé.");
            }
            match.joueur2.setQualification(ObjTournoi.getTour());
            match.perdant = 2;

        } else {
            if (ObjTournoi.getNbTour() == 7) {

                System.out.println("Fin du Match, Le joueur 2 " + match.joueur2.getNomNaissance() + " est le gagnant de la petite finale.");
                System.out.println("Le joueur 1 " + match.joueur1.getNomNaissance() + " est éliminé.");
                match.joueur2.setQualification("Gagnant PF");

            } else {

                System.out.println("Fin du Match, Le joueur 2 " + match.joueur2.getNomNaissance() + " est qualifié pour le tour suivant.");
                System.out.println("Le joueur 1 " + match.joueur1.getNomNaissance() + " est éliminé.");
            }

            match.joueur1.setQualification(ObjTournoi.getTour());
            match.perdant = 1;
        }
        System.out.println("\n\n");
        match.resultat = 1;

        return match;
    }

    public static int DeterminationService(Match match, int n) {            //dertmine qui commence avec le service

        Random random = new Random();
        int nb;
        int Borne1 = 2;
        int Borne2 = 0;
        String joueur;
        nb = 1 + random.nextInt(Borne1 - Borne2);
        if (nb == 1) {
            joueur = match.joueur1.getNomNaissance();
        } else {
            joueur = match.joueur2.getNomNaissance();
        }
        System.out.println("Le joueur " + joueur + " commence avec le service");
        return nb;
    }

}
