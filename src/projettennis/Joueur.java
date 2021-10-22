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
import java.util.Scanner;

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
        
        public static Joueur [] GenerateurJoueur(String AdrFile, Joueur TabJoueur[], int NewJ) throws FileNotFoundException, IOException{
              
            File file = new File(AdrFile);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            //StringBuffer sb = new StringBuffer();
            String line;
            int l=1;
            int j=NewJ;
                    
            TabJoueur[j] = new Joueur();
            //System.out.println("Joueur"+j+":");

            while((line = br.readLine()) != null){
                
                if (line.equals(";")){
                    TabJoueur[j].classement=j+1;
                    l=0;
                    j=j+1;    
                   if (j==TabJoueur.length){
                   break;
                   }
                //    System.out.println("Joueur "+j+":");
                    TabJoueur[j] = new Joueur();
                    
                }
                
                 switch(l){

                    case 1 : TabJoueur[j].bras=line; break;
                    case 2 : TabJoueur[j].prenom=line; break;
                    case 3 : TabJoueur[j].entraineur=line; ;break;
                  /*case 4 : TabJoueur[j-1].nomNaissance= ;
                    case 5 : TabJoueur[j-1].sponsor= ;
                    case 6 : TabJoueur[j-1].nationalite= ;
                    case 7 : TabJoueur[j-1].nomCourant= ;
                    case 8 : TabJoueur[j-1].poids= ;
                    case 9 : TabJoueur[j-1].taille=    ;
                     
                    case 10 :TabJoueur[j-1].surnom= ;
                                                                      */
                }
                
                l=l+1;
                
                
              }
            
            
            fr.close();         
         return TabJoueur;
        } 
        
       public static void AffichageJoueur(Joueur TabJoueur[]) {
           
           
           System.out.println("Liste des Joueurs : \n");
           int j=0;
           int compteur=0;
           while (TabJoueur[j]!=null&j!=TabJoueur.length-1){
               
            j++;
            compteur++;
               
        }
           
           
           for (int i = 0; i <compteur ; i++) {
            System.out.println("Joueur " + (i + 1));
            System.out.println("Bras =" + TabJoueur[i].bras);
            System.out.println("Prenom =" + TabJoueur[i].prenom);
            System.out.println("Entraineur =" + TabJoueur[i].entraineur);
            System.out.println("Classement ="+TabJoueur[i].classement);
            System.out.println("Qualification ="+TabJoueur[i].qualification);
            System.out.println("\n");    
           }
    }
       
       public static Joueur[] NewJoueur(int n, Joueur[] TabJoueur){
           TabJoueur[n] = new Joueur();
           Scanner sc = new Scanner(System.in);
           System.out.println("Bras de votre Joueur (droitier/gaucher):");
           String str = sc.nextLine();
           TabJoueur[n].bras=str;
           System.out.println("Prenom de votre Joueur :");
           str = sc.nextLine();
           TabJoueur[n].prenom=str;
           System.out.println("Entraineur de votre Joueur :");
           str = sc.nextLine();
           TabJoueur[n].entraineur=str;
           TabJoueur[n].classement=n+1;
           TabJoueur[n].qualification="qualifie";
           
           return TabJoueur;
       }
}