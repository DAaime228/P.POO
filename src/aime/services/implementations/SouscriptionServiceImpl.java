/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aime.services.implementations;

import aime.entities.Sms;
import aime.services.SmsService;
import aime.utils.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author DELL
 */
public class SmsServiceImpl implements SmsService {

    @Override
    public void ajouterSms(Sms sms) {
        Connection conn = null;
        try {
            conn = Connexion.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(SmsServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement ps = null;

        try {
            String query = "INSERT INTO Sms (idClient, libelle) VALUES (?, ?)";
            ps = conn.prepareStatement(query);
            ps.setInt(1, sms.getIdClient());
            ps.setString(2, sms.getLibelle());

            ps.executeUpdate();
            System.out.println("SMS ajouté avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connexion.close(conn, ps, null);
        }
    }

    @Override
    public Sms trouverSmsParId(int id) {
        Connection conn;
        try {
            conn = Connexion.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(SmsServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        Sms sms = null;

        try {
            String query = "SELECT * FROM Sms WHERE id = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                sms = new Sms();
                sms.setId(rs.getInt("id"));
                sms.setIdClient(rs.getInt("idClient"));
                sms.setLibelle(rs.getString("libelle"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connexion.close(conn, ps, rs);
        }

        return sms;
    }

    // Autres méthodes CRUD à implémenter (mettreAJourSms, supprimerSms, obtenirTousLesSms, etc.)
}
