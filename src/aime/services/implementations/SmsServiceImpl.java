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
        try {
            Connection conn = Connexion.getConnection();
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
        } catch (SQLException ex) {
            Logger.getLogger(SmsServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void mettreAJourSms(Sms sms) {
        try {
            Connection conn = Connexion.getConnection();
            PreparedStatement ps = null;
            
            try {
                String query = "UPDATE Sms SET idClient = ?, libelle = ? WHERE id = ?";
                ps = conn.prepareStatement(query);
                ps.setInt(1, sms.getIdClient());
                ps.setString(2, sms.getLibelle());
                ps.setInt(3, sms.getId());
                
                ps.executeUpdate();
                System.out.println("SMS mis à jour avec succès !");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                Connexion.close(conn, ps, null);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SmsServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimerSms(int id) {
        Connection conn = null;
        try {
            conn = Connexion.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(SmsServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement ps = null;

        try {
            String query = "DELETE FROM Sms WHERE id = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);

            ps.executeUpdate();
            System.out.println("SMS supprimé avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connexion.close(conn, ps, null);
        }
    }

    @Override
    public List<Sms> obtenirTousLesSms() {
        Connection conn = null;
        try {
            conn = Connexion.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(SmsServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Sms> listeSms = new ArrayList<>();

        try {
            String query = "SELECT * FROM Sms";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Sms sms = new Sms();
                sms.setId(rs.getInt("id"));
                sms.setIdClient(rs.getInt("idClient"));
                sms.setLibelle(rs.getString("libelle"));
                listeSms.add(sms);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connexion.close(conn, ps, rs);
        }

        return listeSms;
    }
}
