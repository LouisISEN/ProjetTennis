/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projettennis;
import java.util.Random;
import projettennis.Arbitre;

/**
 *
 * @author axand
 */
public class Match {
   String genre;
   int NbrSetMax=3;
   public String Joueur1; 
   public String Joueur2;
   
   public static int Match(String Joueur1, String Joueur2,int n){            //dertmine qui commence avec le service
      
       System.out.println("Debut du match "+n+" "+Joueur1+" contre "+Joueur2);
       Random random = new Random();
        int nb;
        int Borne1=2;
        int Borne2=0;
        nb = 1+random.nextInt(Borne1-Borne2);
        System.out.println("Le joueur "+nb+" commence avec le service");
        return nb;
   }
   
   
  
}