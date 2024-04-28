/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aime.services;


import aime.entities.Client;
import java.util.List;


/**
 *
 * @author DELL
 */
public interface ClientService {
    void ajouterClient(Client client);
    Client trouverClientParId(int id);
    void mettreAJourClient(Client client);
    void supprimerClient(int id);
    List<Client> obtenirTousLesClients();
}
