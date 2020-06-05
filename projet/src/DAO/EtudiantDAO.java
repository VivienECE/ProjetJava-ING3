/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;
import jdbc2020.Connexion;
import Modele.Etudiant;
import java.util.ArrayList;

/**
 *
 * @author Vivien
 */
//CTRL + SHIFT + O pour générer les imports
public class EtudiantDAO extends DAO<Etudiant> {
  public EtudiantDAO(Connexion conn) {
    super(conn);
  }

  public boolean create(Etudiant obj) {
    return false;
  }

  public boolean delete(Etudiant obj) {
    return false;
  }
   
  public boolean update(Etudiant obj) {
    return false;
  }
   
  public Etudiant find(int id) {
    Etudiant etudiant = new Etudiant();      
      
    try {
      ResultSet result = this.connect.executeQuery("SELECT * FROM etudiant WHERE ID_UTILISATEUR = " + id);
      if(result.first())
        etudiant = new Etudiant(
          id,
          result.getString("NUMERO"),
          result.getInt("ID_GROUPE"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return etudiant;
  }
  
   public Etudiant find(String NOM, String PRENOM) {
    Etudiant etudiant = new Etudiant();      
      
    try {
      ResultSet result = this.connect.executeQuery("SELECT * FROM utilisateur WHERE NOM = " + NOM + " AND PRENOM="+PRENOM);
      etudiant=this.find(result.getInt("ID"));
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return etudiant;
  }

    @Override
    public ArrayList<Etudiant> findAll(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Etudiant> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}