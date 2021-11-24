/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projettennis;


import java.util.Random;

/**
 *La class Match permet déterminer de facon aléatoire qui commence à servir dans le match, de gérer le nombre de Set (donc de gérer l'avancement du match), et les statistiques joueurs (nombre de set gagné) 
 * @author axand
 */
public class Match {

    Joueur joueur1 = new Joueur();
    Joueur joueur2 = new Joueur();

    Arbitre arbitre = new Arbitre();
    private int resultat = 0;                               //savoir si le match a deja été joué ou non, 1 oui 2 non
    private int dernierService = 0;                         //sert a savoir qui va servir au debut du prochain jeu
    private int perdant = 0;                                //perdant du match

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
    

    public static Match jouerM(Match match, int n, Tournoi objTournoi, int auto) {
        Set set = new Set();
        int nbrSetMax = 0;

        if (objTournoi.getGenre().equals("Masculin")) {                 //En 2 set gagnant pour les femmes et 3 pour les hommes
            nbrSetMax = 3;
        } else {
            nbrSetMax = 2;
        }
        System.out.println("Debut du match n*" + n + " : " + match.joueur1.getNomNaissance() + " " + match.joueur1.getPrenom()+ " contre " + match.joueur2.getNomNaissance() + " " + match.joueur1.getPrenom());

        while ((set.getSetJoueur1() != nbrSetMax) & (set.getSetJoueur2() != nbrSetMax)) {                       //Continue a jouer de nouveau set tant que aucun joueur n'a gagné nbrSetMax set
            match.dernierService=Match.determinationService(match, n);                                          // Determine qui sert au debut du match
            match = Set.gestionSet(match, objTournoi, n, match.dernierService, auto, set.getSetJoueur1(), set.getSetJoueur2());    //joue un nouveau set 

            if (match.joueur1.getWinSet()== 1) {                        // si le joueur 1 gagne un set, on incremente la variable setjoueur1 pour l'avancement du match
                set.incrementeSetJoueur1();;                            // et la statistique SetJoueur
                match.joueur1.incrementeSetJoueur();;
            } else {
                set.incrementeSetJoueur2();;                    // si le joueur 1 gagne un set, on incremente la variable setjoueur1 pour l'avancement du match
                match.joueur2.incrementeSetJoueur();;           // et la statistique SetJoueur
               
            }
        }
        if (set.getSetJoueur1() == nbrSetMax) {                 //Si un joueur a gagné le nbrSetMax, fin du match, ici Joueur 1 est le gagnant
            if (objTournoi.getNbTour() == 7) {                  //NbTour=7 correspond a la petite finale

                System.out.println("Fin du Match, Le joueur 1 " + match.joueur1.getNomNaissance() + " est le gagnant de la petite finale.");
                System.out.println("Le joueur 2 " + match.joueur2.getNomNaissance() + " est éliminé.");
                match.joueur1.setQualification("Gagnant PF");               

            } else {

                System.out.println("Fin du Match, Le joueur 1 " + match.joueur1.getNomNaissance() + " est qualifié pour le tour suivant.");
                System.out.println("Le joueur 2 " + match.joueur2.getNomNaissance() + " est éliminé.");
            }
            match.joueur2.setQualification(objTournoi.getTour());                 // L'attribut qualification du joueur perdant est égal au tour dans lequel il a perdu
            match.perdant = 2;                                                    // Le perdant est le joueur 2

        } else {
            if (objTournoi.getNbTour() == 7) {                                    // pareil qu'au dessus mais avec le joueur 2 gagnant

                System.out.println("Fin du Match, Le joueur 2 " + match.joueur2.getNomNaissance() + " est le gagnant de la petite finale.");
                System.out.println("Le joueur 1 " + match.joueur1.getNomNaissance() + " est éliminé.");
                match.joueur2.setQualification("Gagnant PF");

            } else {

                System.out.println("Fin du Match, Le joueur 2 " + match.joueur2.getNomNaissance() + " est qualifié pour le tour suivant.");
                System.out.println("Le joueur 1 " + match.joueur1.getNomNaissance() + " est éliminé.");
            }

            match.joueur1.setQualification(objTournoi.getTour());
            match.perdant = 1;
        }
        System.out.println("\n\n");
        match.resultat = 1;
// on retourne le match pour mettre à jour l'avancement du tournoi, recuperer le gagnant et le perdant pour la liste de qualification, le classement, et la petite finale
        return match; 
    }

    public static int determinationService(Match match, int n) {            //dertmine qui commence avec le service

        Random random = new Random();
        int nb;
        int borne1 = 2;
        int borne2 = 0;
        String joueur;
        nb = 1 + random.nextInt(borne1 - borne2);                   // nombre aléatoire 1 ou 2
        if (nb == 1) {
            joueur = match.joueur1.getNomNaissance();
        } else {
            joueur = match.joueur2.getNomNaissance();
        }
        System.out.println("Le joueur " + joueur + " commence avec le service");
        return nb;
    }

}
