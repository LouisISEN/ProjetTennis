/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projettennis;
import java.io.*;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collections;
import java.util.ArrayList;


/**
 *
 * @author axand
 */
public class Tournoi {
    
    String lieu;
    String surface;
    int etape;
    String Joueur1="";
    public  String Joueur2="";
    
    
    
    public static String [] ListeQualif(Joueur Player[], String TabQualif[], int NbrJoueur){
        int i=0;
                for (int k=0; k<NbrJoueur; k++){                  
            if (Player[k].qualification.equals("qualifie")){
                TabQualif[i]=Player[k].prenom;
                i++;
               
            }
            
        }
                return TabQualif;
    }
    
    
    
    
    
    public static void AffichageQualif(String TabQualif[], int NbrJoueur){
        for (int i=0; i<NbrJoueur; i++){
            
           System.out.println("Joueur numero "+(i+1)+" qualifié = "+ TabQualif[i]);
       }
        System.out.println("\n");
    }
    
    
    
    
    
    
    
       public static Tournoi [] CompoMatch(String TabQualif[]){
        
        ArrayList numbers = new ArrayList();
        int NbrQualif=TabQualif.length;
        Tournoi TabMatch[] = new Tournoi[NbrQualif/2];     //NbrQualif/2=Nbr de match
              
        
        for (int i=0; i<=NbrQualif-1; i++){
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        int n=1;
        for (int k=0; k<(NbrQualif-1); k++){               //Creation d'un tableau TabMatch, chaque case contient deux adversaires aléatoires
            
          //  System.out.println(numbers.get(k));
            TabMatch[n-1] = new Tournoi();
            
            System.out.println("Match n*"+n+" :"+(TabQualif[(int) numbers.get(k)])+" VS "+(TabQualif[(int) numbers.get(k+1)]));
            TabMatch[n-1].Joueur1=TabQualif[(int) numbers.get(k)];
            TabMatch[n-1].Joueur2=TabQualif[(int) numbers.get(k+1)];
            System.out.println("Tabmatch["+(n-1)+"] ok");
         
           n++;k++;    
            }
           System.out.println("\n");
        for (int i=0; i<=(NbrQualif/2)-1;i++){
            System.out.println("TabMatch["+i+"] contient "+TabMatch[i].Joueur1+" contre "+TabMatch[i].Joueur2);
            
        }
           System.out.println("\n");
        return TabMatch;
       }
}
    

    

