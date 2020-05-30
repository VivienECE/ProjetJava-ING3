/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;
import jdbc2020.Connexion;
import Modele.Seance_groupes;
import java.util.ArrayList;

/**
 *
 * @author Vivien
 */
//CTRL + SHIFT + O pour générer les imports
public class Seance_groupesDAO extends DAO<Seance_groupes> {
  public Seance_groupesDAO(Connexion conn) {
    super(conn);
  }

  public boolean create(Seance_groupes obj) {
    return false;
  }

  public boolean delete(Seance_groupes obj) {
    return false;
  }
   
  public boolean update(Seance_groupes obj) {
    return false;
  }
   
  public Seance_groupes find(int id) {
    Seance_groupes seance_groupes = new Seance_groupes();      
      
    try {
      ResultSet result = this.connect.executeQuery("SELECT * FROM seance_groupes WHERE ID_SEANCE = " + id);
      if(result.first())
        seance_groupes = new Seance_groupes(id, result.getInt("ID_GROUPE"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return seance_groupes;
  }
  
  public ArrayList<Seance_groupes> findAll(int ID_GROUPE) {
    ArrayList<Seance_groupes> seance_groupes = new ArrayList<>();      
      
    try {
      ResultSet result = this.connect.executeQuery("SELECT ID_SEANCE FROM seance_groupes WHERE ID_GROUPE  = " + ID_GROUPE);
      while(result.next())
        {
            seance_groupes.add(new Seance_groupes(result.getInt("ID_SEANCE"),ID_GROUPE));
        }      
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return seance_groupes;
  }
}