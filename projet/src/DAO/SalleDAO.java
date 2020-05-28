/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;
import jdbc2020.Connexion;
import Modele.Salle;

/**
 *
 * @author Vivien
 */
//CTRL + SHIFT + O pour générer les imports
public class SalleDAO extends DAO<Salle> {
  public SalleDAO(Connexion conn) {
    super(conn);
  }

  public boolean create(Salle obj) {
    return false;
  }

  public boolean delete(Salle obj) {
    return false;
  }
   
  public boolean update(Salle obj) {
    return false;
  }
   
  public Salle find(int id) {
    Salle salle = new Salle();      
      
    try {
      ResultSet result = this.connect.executeQuery("SELECT * FROM cours WHERE ID = " + id);
      if(result.first())
        salle = new Salle(id, result.getString("NOM"),result.getInt("CAPACITE"),result.getInt("ID_SITE"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return salle;
  }
}