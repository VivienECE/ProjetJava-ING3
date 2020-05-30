/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;
import jdbc2020.Connexion;
import Modele.Type_cours;

/**
 *
 * @author Vivien
 */
//CTRL + SHIFT + O pour générer les imports
public class Type_coursDAO extends DAO<Type_cours> {
  public Type_coursDAO(Connexion conn) {
    super(conn);
  }

  public boolean create(Type_cours obj) {
    return false;
  }

  public boolean delete(Type_cours obj) {
    return false;
  }
   
  public boolean update(Type_cours obj) {
    return false;
  }
   
  public Type_cours find(int id) {
    Type_cours seance_groupes = new Type_cours();      
      
    try {
      ResultSet result = this.connect.executeQuery("SELECT * FROM seance_enseignants WHERE ID_PROFESSEUR = " + id);
      if(result.first())
        seance_groupes = new Type_cours(id, result.getString("NOM"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return seance_groupes;
  }
}