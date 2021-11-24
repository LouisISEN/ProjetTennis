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
    public static void AffichageStat(ArrayList<Joueur> ListJoueur) {             //Affiche les statistiques joueurs           
        System.out.println("Statistiques joueurs :\n");
        System.out.println("Numéro    Nom       Prénom       Point     Jeu       Set      Service    Faute");
        System.out.println("                                                               Réussi");
        for (int i = 0; i < ListJoueur.size(); i++) {

            System.out.println(Utilitaire.affichageTxt(String.valueOf(ListJoueur.get(i).getNumero()),10) + Utilitaire.affichageTxt(ListJoueur.get(i).getNomNaissance(),10) + Utilitaire.affichageTxt(ListJoueur.get(i).getPrenom(),10) + ":    " + Utilitaire.affichageTxt(String.valueOf(ListJoueur.get(i).getPointJoueur()),10) + Utilitaire.affichageTxt(String.valueOf(ListJoueur.get(i).getJeuJoueur()),10) + Utilitaire.affichageTxt(String.valueOf(ListJoueur.get(i).getSetJoueur()),10) + Utilitaire.affichageTxt(String.valueOf(ListJoueur.get(i).getService()),10)+ Utilitaire.affichageTxt(String.valueOf(ListJoueur.get(i).getFaute()),10));
            // Affiche les differents attributs que nous voulons voir avec la méthode de l'utlitaire qui permet d'avoir un affichage aligné
            System.out.println("\n");

        }
    }
}
