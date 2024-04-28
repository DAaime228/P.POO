/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aime.services;

import aime.entities.Produit;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface ProduitService {
    void ajouterProduit(Produit produit);
    Produit trouverProduitParId(int id);
    void mettreAJourProduit(Produit produit);
    void supprimerProduit(int id);
    List<Produit> obtenirTousLesProduits();
    
}
