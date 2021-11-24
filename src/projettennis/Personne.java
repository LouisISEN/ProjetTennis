/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projettennis;

/**
 *La Class contient les attributs d'une personne (Nom, prenom, age...)
 * @author axand
 */
public abstract class Personne { 
 
    private String nomNaissance;    
    private String dateNaissance;   
    private String lieuNaissance;   
    private String dateDeces;      
    private String genre;          
    private String nomCourant;
    private String prenom;
    private String surnom;
    private String nationalite;
    private int taille;
    private int poids;


    public String getNomNaissance() {
        return this.nomNaissance;
    }

    public void setNomNaissance(String nomNaissance) {
        this.nomNaissance = nomNaissance;
    }

    public String getDateNaissance() {
        return this.dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return this.lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public String getDateDeces() {
        return this.dateDeces;
    }

    public void setDateDeces(String dateDeces) {
        this.dateDeces = dateDeces;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getNomCourant() {
        return this.nomCourant;
    }

    public void setNomCourant(String nomCourant) {
        this.nomCourant = nomCourant;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSurnom() {
        return this.surnom;
    }

    public void setSurnom(String surnom) {
        this.surnom = surnom;
    }

    public String getNationalite() {
        return this.nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public int getTaille() {
        return this.taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public int getPoids() {
        return this.poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }


}
