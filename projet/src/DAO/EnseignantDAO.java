/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;
import jdbc2020.Connexion;
import Modele.Enseignant;
import java.util.ArrayList;

/**
 *
 * @author Vivien
 */
//CTRL + SHIFT + O pour générer les imports
public class EnseignantDAO extends DAO<Enseignant> {
  public EnseignantDAO(Connexion conn) {
    super(conn);
  }

  public boolean create(Enseignant obj) {
    return false;
  }

  public boolean delete(Enseignant obj) {
    return false;
  }
   
  public boolean update(Enseignant obj) {
    return false;
  }
   
  public Enseignant find(int id) {
    Enseignant enseignant = new Enseignant();      
      
    try {
      ResultSet result = this.connect.executeQuery("SELECT * FROM enseignant WHERE ID_UTILISATEUR = " + id);
      if(result.first())
        enseignant = new Enseignant(id, result.getString("ID_COURS"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return enseignant;
  }
  
  public Enseignant find(String NOM, String PRENOM) {
    Enseignant enseignant = new Enseignant();      
      
    try {
      ResultSet result = this.connect.executeQuery("SELECT * FROM utilisateur WHERE NOM = " + NOM + " AND PRENOM="+PRENOM);
      enseignant=this.find(result.getInt("ID"));
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return enseignant;
  }

    @Override
    public ArrayList<Enseignant> findAll(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Enseignant> getAll() {
         ArrayList<Enseignant> enseignants = new ArrayList<>();      
      
        try {
          ResultSet result = this.connect.executeQuery("SELECT * FROM enseignant");
          while(result.next())
            {
                enseignants.add(new Enseignant(result.getInt("ID_UTILISATEUR"),result.getString("ID_COURS")));
            }      
        } catch (SQLException e) {
          e.printStackTrace();
        }
        return enseignants;
    }

   /* @Override
    public Enseignant find(String NOM, String PRENOM) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/


}