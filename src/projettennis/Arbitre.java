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
public class Arbitre extends Personne
{
    public static void score(int scoreUN, int scoreDEUX){                  
            System.out.println("Le score est de"+scoreUN+"-"+scoreDEUX);
        }
        
    public static void faute(){
        System.out.println("dire faute");
    }
    
    
        
         public static void ListeArbitre(int NbrArbitre, String AdrFile) throws FileNotFoundException, IOException{
              
    File file = new File(AdrFile);
    FileReader fr = new FileReader(file);
    BufferedReader br = new BufferedReader(fr);
    StringBuffer sb = new StringBuffer();
    String line;
    int l=1;
    int j=1;
    
    Arbitre[] arbitre = new Arbitre[NbrArbitre+1];     //<-- NOMBRE DE JOUEUR+1
    while((line = br.readLine()) != null){
             
        if (line.equals(";")){
                 
            l=0;
            j=j+1;
          //  System.out.println("Arbitre "+j+":");
           
        }
         arbitre[j-1] = new Arbitre();
        
         switch(l){
             
            
            case 1 : arbitre[j-1].prenom=line;  System.out.println("Arbitre "+j+":"); System.out.println("Prenom = "+ arbitre[j-1].prenom); break;
            case 2 : arbitre[j-1].nomNaissance =line;System.out.println("nom de naissance = "+arbitre[j-1].nomNaissance); break;
            case 3 : arbitre[j-1].dateNaissance =line;System.out.println("Date de naissance = "+arbitre[j-1].dateNaissance);System.out.println("\n"); break;
            
                                                              
        }
         
        l=l+1;
        
      }
    fr.close();
    }
        
        
    }

