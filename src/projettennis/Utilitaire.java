/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projettennis;

/**
 *La class Utilitaire contient des méthodes diverses utilisées dans certaines class
 * @author axand
 */
public class Utilitaire {
    
    public static String affichageTxt(String txt, int nb) {  // Gere l'affichage d'un texte ce qui permet d'avoir un affichage 
        for (int i = txt.length(); i < nb; i++) {            // bien aligné d'une ligne à l'autre
            txt = txt + " ";
        }
        return txt;
    }
    
    public static void delay(int time){                     // Met en pose le programme 
        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

}
