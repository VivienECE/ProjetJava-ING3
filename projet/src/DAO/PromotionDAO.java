/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;
import jdbc2020.Connexion;
import Modele.Promotion;

/**
 *
 * @author Vivien
 */
//CTRL + SHIFT + O pour générer les imports
public class PromotionDAO extends DAO<Promotion> {
  public PromotionDAO(Connexion conn) {
    super(conn);
  }

  public boolean create(Promotion obj) {
    return false;
  }

  public boolean delete(Promotion obj) {
    return false;
  }
   
  public boolean update(Promotion obj) {
    return false;
  }
   
  public Promotion find(int id) {
    Promotion promotion = new Promotion();      
      
    try {
      ResultSet result = this.connect.executeQuery("SELECT * FROM cours WHERE ID = " + id);
      if(result.first())
        promotion = new Promotion(id, result.getString("NOM"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return promotion;
  }
}