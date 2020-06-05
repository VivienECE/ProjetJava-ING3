/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;
import jdbc2020.Connexion;
import Modele.Utilisateur;
import java.util.ArrayList;

/**
 *
 * @author Vivien
 */
//CTRL + SHIFT + O pour générer les imports
public class UtilisateurDAO extends DAO<Utilisateur> {
  public UtilisateurDAO(Connexion conn) {
    super(conn);
  }

  public boolean create(Utilisateur obj) {
    return false;
  }

  public boolean delete(Utilisateur obj) {
    return false;
  }
   
  public boolean update(Utilisateur obj) {
    return false;
  }
   
  public Utilisateur find(int id) {
    Utilisateur seance_groupes = new Utilisateur();      
      
    try {
      ResultSet result = this.connect.executeQuery("SELECT * FROM utilisateur WHERE ID = " + id);
      if(result.first())
        seance_groupes = new Utilisateur(id, result.getString("EMAIL"),result.getString("PASSWD"),result.getString("NOM"),result.getString("PRENOM"),result.getInt("DROIT"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return seance_groupes;
  }

    @Override
    public ArrayList<Utilisateur> findAll(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Utilisateur> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Utilisateur find(String NOM, String PRENOM) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}