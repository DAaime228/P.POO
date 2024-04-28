/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aime.services.implementations;

import aime.entities.Client;
import aime.services.ClientService;
import aime.utils.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author DELL
 */
public class ClientServiceImpl implements ClientService {

    /**
     *
     * @param client
     * @throws SQLEXCEPTION
     */
    @Override
    public void ajouterClient(Client client){
        Connection conn = null;
        try {
            conn = Connexion.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ClientServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement ps = null;

        try {
            String query = "INSERT INTO Client (nom, prenom, telephone) VALUES (?, ?, ?)";
            ps = conn.prepareStatement(query);
            ps.setString(1, client.getNom());
            ps.setString(2, client.getPrenom());
            ps.setString(3, client.getTelephone());

            ps.executeUpdate();
            System.out.println("Client ajouté avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connexion.close(conn, ps, null);
        }
    }

    @Override
    public Client trouverClientParId(int id) {
        Connection conn = null;
        try {
            conn = Connexion.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ClientServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        Client client = null;

        try {
            String query = "SELECT * FROM Client WHERE id = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                client = new Client();
                client.setId(rs.getInt("id"));
                client.setNom(rs.getString("nom"));
                client.setPrenom(rs.getString("prenom"));
                client.setTelephone(rs.getString("telephone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connexion.close(conn, ps, rs);
        }

        return client;
    }

    // Autres méthodes CRUD à implémenter (mettreAJourClient, supprimerClient, obtenirTousLesClients, etc.)

    @Override
    public void mettreAJourClient(Client client) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void supprimerClient(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Client> obtenirTousLesClients() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}