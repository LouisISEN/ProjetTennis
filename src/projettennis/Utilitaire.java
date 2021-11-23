/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projettennis;

/**
 *
 * @author axand
 */
public class Utilitaire {
    
    public static String affichageTxt(String txt, int nb) {
        for (int i = txt.length(); i < nb; i++) {
            txt = txt + " ";
        }
        return txt;
    }
    
    public static void delay(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

}
