/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aime.entities;

/**
 *
 * @author DELL
 */
public class Produit {
      private int id;
    private String libelle;
    private String actif;

    // Constructeur par défaut
    public Produit() {
    }

    // Constructeur avec tous les attributs
    public Produit(int id, String libelle, String actif) {
        this.id = id;
        this.libelle = libelle;
        this.actif = actif;
    }

    // Getters et setters pour tous les attributs
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getActif() {
        return actif;
    }

    public void setActif(String actif) {
        this.actif = actif;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", actif='" + actif + '\'' +
                '}';
    }
    
}
