/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;
import jdbc2020.Connexion;
import Modele.Seance_enseignants;

/**
 *
 * @author Vivien
 */
//CTRL + SHIFT + O pour générer les imports
public class Seance_enseignantsDAO extends DAO<Seance_enseignants> {
  public Seance_enseignantsDAO(Connexion conn) {
    super(conn);
  }

  public boolean create(Seance_enseignants obj) {
      try {
       this.connect.executeUpdate("INSERT INTO `seance_enseignants`(`ID_SEANCE`,`ID_ENSEIGNANT`) VALUES ("+obj.getID_SEANCE()+","+obj.getID_ENSEIGNANT()+")"); 
    } catch (SQLException e)
        { e.printStackTrace(); }
    return true;
  }

  public boolean delete(Seance_enseignants obj) {
    return false;
  }
   
  public boolean update(Seance_enseignants obj) {
    return false;
  }
   
  public Seance_enseignants find(int id) {
    Seance_enseignants seance_enseignants = new Seance_enseignants();      
      
    try {
      ResultSet result = this.connect.executeQuery("SELECT * FROM seance_enseignants WHERE ID_PROFESSEUR = " + id);
      if(result.first())
        seance_enseignants = new Seance_enseignants(id, result.getInt("ID_SEANCE"));         
    } catch (SQLException e)
        { e.printStackTrace(); }
    return seance_enseignants;
  }
}