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
public class Statistiques {
    public static void AffichageStat(ArrayList<Joueur> ListJoueur) {
        System.out.println("Statistiques joueurs :\n");
        System.out.println("Numéro    Nom       Prénom       Point     Jeu       Set      Service    Faute");
        System.out.println("                                                               Réussi");
        for (int i = 0; i < ListJoueur.size(); i++) {

            System.out.println(Tournoi.affichageTxt(String.valueOf(i + 1),10) + Tournoi.affichageTxt(ListJoueur.get(i).nomNaissance,10) + Tournoi.affichageTxt(ListJoueur.get(i).prenom,10) + ":    " + Tournoi.affichageTxt(String.valueOf(ListJoueur.get(i).pointJoueur),10) + Tournoi.affichageTxt(String.valueOf(ListJoueur.get(i).JeuJoueur),10) + Tournoi.affichageTxt(String.valueOf(ListJoueur.get(i).SetJoueur),10) + Tournoi.affichageTxt(String.valueOf(ListJoueur.get(i).Service),10)+ Tournoi.affichageTxt(String.valueOf(ListJoueur.get(i).Faute),10));

            System.out.println("\n");

        }
    }
}
