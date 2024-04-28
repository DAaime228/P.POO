/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aime.services.implementations;

import aime.entities.Produit;
import aime.services.ProduitService;
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
public class ProduitServiceImpl implements ProduitService {

    @Override
    public void ajouterProduit(Produit produit) {
        Connection conn;
        
        try {
            conn = Connexion.getConnection();
            String query = "INSERT INTO Produit (libelle, actif) VALUES (?, ?)";
            PreparedStatement ps=null;
            ps = conn.prepareStatement(query);
            ps.setString(1, produit.getLibelle());
            ps.setString(2, produit.getActif());

            ps.executeUpdate();
            System.out.println("Produit ajouté avec succès !");
        } catch (SQLException ex) {
            Logger.getLogger(ProduitServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement ps = null;

        
    }

    @Override
    public Produit trouverProduitParId(int id) {
        Produit produit = new Produit();
        try {
            Connection conn = Connexion.getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            
            try {
                String query = "SELECT * FROM Produit WHERE id = ?";
                ps = conn.prepareStatement(query);
                ps.setInt(1, id);
                rs = ps.executeQuery();
                
                if (rs.next()) {
                    produit.setId(rs.getInt("id"));
                    produit.setLibelle(rs.getString("libelle"));
                    produit.setActif(rs.getString("actif"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                Connexion.close(conn, ps, rs);
            }
            
            return produit;
        } catch (SQLException ex) {
            Logger.getLogger(ProduitServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produit;
    }

    // Autres méthodes CRUD à implémenter (mettreAJourProduit, supprimerProduit, obtenirTousLesProduits, etc.)


    @Override
    public void mettreAJourProduit(Produit produit) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void supprimerProduit(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Produit> obtenirTousLesProduits() {
      List<Produit> listeP=new ArrayList<>();
      return listeP;
    }
    
}
