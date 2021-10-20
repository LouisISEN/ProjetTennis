/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projettennis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author axand
 */
public class Joueur extends Personne{
    
        public String bras;
        public String entraineur;
        public String sponsor;
        public int classement;
        public String qualification="qualifie";
        //public int NbrJoueur=8;
        
        public static Joueur [] ListeJoueur(String AdrFile, Joueur Player[]) throws FileNotFoundException, IOException{
              
            File file = new File(AdrFile);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            StringBuffer sb = new StringBuffer();
            String line;
            int l=1;
            int j=1;
            Player[j-1] = new Joueur();
            //System.out.println("Joueur"+j+":");

            while((line = br.readLine()) != null){

                if (line.equals(";")){
                    Player[j-1].classement=j;System.out.println("Classement : "+j);
                    l=0;
                    j=j+1;    
                    System.out.println("\n");
                //    System.out.println("Joueur "+j+":");
                    Player[j-1] = new Joueur();
                    
                }
                
                 switch(l){

                    case 1 : Player[j-1].bras=line; System.out.println("Joueur "+j+":"); System.out.println("bras = "+Player[j-1].bras);; break;
                    case 2 : Player[j-1].prenom=line;System.out.println("Prenom = "+Player[j-1].prenom); break;
                    case 3 : Player[j-1].entraineur=line; System.out.println("Entraineur = "+Player[j-1].entraineur);break;
                  /*case 4 : Player[j-1].nomNaissance= ;
                    case 5 : Player[j-1].sponsor= ;
                    case 6 : Player[j-1].nationalite= ;
                    case 7 : Player[j-1].nomCourant= ;
                    case 8 : Player[j-1].poids= ;
                    case 9 : Player[j-1].taille=    ;
                     
                    case 10 :Player[j-1].surnom= ;
                                                                      */
                }
                
                l=l+1;
           
              }
            System.out.println("\n"); //<--- a mettre au dernier parametre case11 une fois fini
            fr.close();         
         return Player;
        } 
        
       
        
    }
