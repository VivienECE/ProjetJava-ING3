/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;
import jdbc2020.Connexion;
import Modele.Cours;
import java.util.ArrayList;

/**
 *
 * @author Vivien
 */
//CTRL + SHIFT + O pour générer les imports
public class CoursDAO extends DAO<Cours> {
  public CoursDAO(Connexion conn) {
    super(conn);
  }

  public boolean create(Cours obj) {
    return false;
  }

  public boolean delete(Cours obj) {
    return false;
  }
   
  public boolean update(Cours obj) {
    return false;
  }
   
  public Cours find(int id) {
    Cours cours = new Cours();      
      
    try {
      ResultSet result = this.connect.executeQuery("SELECT * FROM cours WHERE ID = " + id);
      if(result.first())
        cours = new Cours(id, result.getString("NOM"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return cours;
  }

    @Override
    public ArrayList<Cours> findAll(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Cours> getAll() {
           ArrayList<Cours> enseignants = new ArrayList<>();      
      
        try {
          ResultSet result = this.connect.executeQuery("SELECT * FROM cours");
          while(result.next())
            {
                enseignants.add(new Cours(result.getInt("ID"),result.getString("NOM")));
            }      
        } catch (SQLException e) {
          e.printStackTrace();
        }
        return enseignants;
    }

    @Override
    public Cours find(String NOM, String PRENOM) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}