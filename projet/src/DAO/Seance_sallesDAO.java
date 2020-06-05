/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;
import jdbc2020.Connexion;
import Modele.Seance_salles;
import java.util.ArrayList;

/**
 *
 * @author Vivien
 */
//CTRL + SHIFT + O pour générer les imports
public class Seance_sallesDAO extends DAO<Seance_salles> {
  public Seance_sallesDAO(Connexion conn) {
    super(conn);
  }

  public boolean create(Seance_salles obj) {
      try {
       this.connect.executeUpdate("INSERT INTO `seance_salles`(`ID_SEANCE`,`ID_SALLE`) VALUES ("+obj.getID_SEANCE()+","+obj.getID_SALLE()+")"); 
    } catch (SQLException e)
        { e.printStackTrace(); }
    return false;
  }

  public boolean delete(Seance_salles obj) {
    return false;
  }
   
  public boolean update(Seance_salles obj) {
    return false;
  }
   
  public Seance_salles find(int id) {
    Seance_salles seance_groupes = new Seance_salles();      
      
    try {
      ResultSet result = this.connect.executeQuery("SELECT * FROM seance_salles WHERE ID_SEANCE = " + id);
      if(result.first())
        seance_groupes = new Seance_salles(id, result.getInt("ID_SALLE"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return seance_groupes;
  }

    @Override
    public ArrayList<Seance_salles> findAll(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Seance_salles> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}