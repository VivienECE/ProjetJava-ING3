/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;
import jdbc2020.Connexion;
import Modele.Site;
import java.util.ArrayList;

/**
 *
 * @author Vivien
 */
//CTRL + SHIFT + O pour générer les imports
public class SiteDAO extends DAO<Site> {
  public SiteDAO(Connexion conn) {
    super(conn);
  }

  public boolean create(Site obj) {
    return false;
  }

  public boolean delete(Site obj) {
    return false;
  }
   
  public boolean update(Site obj) {
    return false;
  }
   
  public Site find(int id) {
    Site seance_groupes = new Site();      
      
    try {
      ResultSet result = this.connect.executeQuery("SELECT * FROM seance_enseignants WHERE ID_PROFESSEUR = " + id);
      if(result.first())
        seance_groupes = new Site(id, result.getString("NOM"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return seance_groupes;
  }

    @Override
    public ArrayList<Site> findAll(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}