/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projettennis;
import java.io.IOException;
import java.util.Random;
import projettennis.Joueur;
import projettennis.Set;


/**
 *
 * @author axand
 */
public class ProjetTennis {
    
    public static void main(String[] args) throws IOException {
        
       
       int NbrArbitre = 10;
       int NbrJoueur = 12;
       int nb;
       String AdrFileJ="info-joueur.txt";
       String AdrFileA="info-arbitre.txt";
               
       Joueur[] Player = new Joueur[NbrJoueur+1];     //<-- NOMBRE DE JOUEUR+1
       String [] TabQualif= new String[NbrJoueur];
       Tournoi [] TabMatch= new Tournoi[NbrJoueur/2];// creation tableau pour nom des qualifiés
         
       Arbitre.ListeArbitre(NbrArbitre, AdrFileA);           //Récupération info arbitre + creation tableau arbitre
       Player = Joueur.ListeJoueur(AdrFileJ, Player);  //Récupération info Joueur + creation tableau Joueur (=Player[])
       
       TabQualif = Tournoi.ListeQualif(Player, TabQualif, NbrJoueur);       //Création Tableau des joueurs qualifiés à partir du tableau des joueurs + du parametre qualification
       
       //Tournoi.AffichageQualif(TabQualif, NbrJoueur);                       // Affichage des joueurs qualifiés
       
      TabMatch=Tournoi.CompoMatch(TabQualif); 
      for (int k=0; k<(TabQualif.length)/2;k++){
          nb = Match.Match(TabMatch[k].Joueur1,TabMatch[k].Joueur2, k+1);        //determine qui commence avec le service
          
          Echange.Service(nb, TabMatch[k].Joueur1, TabMatch[k].Joueur2);
          System.out.println("\n");
      }
        
        
      
          Echange.echange();
          
          
      
      
    }
    
}
