/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aime.entities;

/**
 *
 * @author DELL
 */
public class Sms {
      private int id;
    private int idClient;
    private String libelle;

    // Constructeur par défaut
    public Sms() {
    }

    // Constructeur avec tous les attributs
    public Sms(int id, int idClient, String libelle) {
        this.id = id;
        this.idClient = idClient;
        this.libelle = libelle;
    }

    // Getters et setters pour tous les attributs
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Sms{" +
                "id=" + id +
                ", idClient=" + idClient +
                ", libelle='" + libelle + '\'' +
                '}';
    }
    
}
