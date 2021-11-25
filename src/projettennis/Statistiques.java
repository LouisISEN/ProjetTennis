/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projettennis;

import java.util.ArrayList;

/**
 *La Class Statistiques affiche les statistiques joueurs (Point, Jeu, Set, service reussi et les fautes)
 * @author axand
 */
public class Statistiques {
    /**
     * Affichage des statistiques joueurs (numero, nom, prenom, point, jeu, set, service réussi, faute)
     * @param listJoueur 
     */
    public static void afficherStat(ArrayList<Joueur> listJoueur) {             //Affiche les statistiques joueurs           
        System.out.println("Statistiques joueurs :\n");
        System.out.println("Numéro    Nom       Prénom       Point     Jeu       Set      Service    Faute");
        System.out.println("                                                               Réussi");
        for (int i = 0; i < listJoueur.size(); i++) {

            System.out.println(Utilitaire.affichageTxt(String.valueOf(listJoueur.get(i).getNumero()),10) + Utilitaire.affichageTxt(listJoueur.get(i).getNomNaissance(),10) + Utilitaire.affichageTxt(listJoueur.get(i).getPrenom(),10) + ":    " + Utilitaire.affichageTxt(String.valueOf(listJoueur.get(i).getPointJoueur()),10) + Utilitaire.affichageTxt(String.valueOf(listJoueur.get(i).getJeuJoueur()),10) + Utilitaire.affichageTxt(String.valueOf(listJoueur.get(i).getSetJoueur()),10) + Utilitaire.affichageTxt(String.valueOf(listJoueur.get(i).getService()),10)+ Utilitaire.affichageTxt(String.valueOf(listJoueur.get(i).getFaute()),10));
            // Affiche les differents attributs que nous voulons voir avec la méthode de l'utlitaire qui permet d'avoir un affichage aligné
            System.out.println("\n");

        }
    }
}
