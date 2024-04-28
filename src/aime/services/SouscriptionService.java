/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aime.services;

import aime.entities.Souscription;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface SouscriptionService {
   void ajouterSouscription(Souscription souscription);
    Souscription trouverSouscriptionParId(int id);
    void mettreAJourSouscription(Souscription souscription);
    void supprimerSouscription(int id);
    List<Souscription> obtenirToutesLesSouscriptions();  
    
}
