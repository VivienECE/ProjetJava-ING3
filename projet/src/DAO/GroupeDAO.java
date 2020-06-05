/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;
import jdbc2020.Connexion;
import Modele.Groupe;
import java.util.ArrayList;

/**
 *
 * @author Vivien
 */
//CTRL + SHIFT + O pour générer les imports
public class GroupeDAO extends DAO<Groupe> {
  public GroupeDAO(Connexion conn) {
    super(conn);
  }

  public boolean create(Groupe obj) {
    return false;
  }

  public boolean delete(Groupe obj) {
    return false;
  }
   
  public boolean update(Groupe obj) {
    return false;
  }
   
  public Groupe find(int id) {
    Groupe promotion = new Groupe();      
      
    try {
      ResultSet result = this.connect.executeQuery("SELECT * FROM groupe WHERE ID = " + id);
      if(result.first())
        promotion = new Groupe(id, result.getString("NOM"), result.getInt("ID_PROMOTION"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return promotion;
  }

    @Override
    public ArrayList<Groupe> findAll(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Groupe> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Groupe find(String NOM, String PRENOM) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}