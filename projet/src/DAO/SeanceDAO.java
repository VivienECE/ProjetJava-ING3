/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;
import jdbc2020.Connexion;
import Modele.Seance;
import java.util.ArrayList;

/**
 *
 * @author Vivien
 */
//CTRL + SHIFT + O pour générer les imports
public class SeanceDAO extends DAO<Seance> {
  public SeanceDAO(Connexion conn) {
    super(conn);
  }

  public boolean create(Seance obj) {
       try {
       ResultSet result = this.connect.executeQuery("SELECT * from seance WHERE VALUES ("+obj.getID()+","+obj.getSEMAINE()+","+obj.getDATE()+","+obj.getHEURE_DEBUT()+","+obj.getHEURE_FIN()+","+obj.getETAT()+")"); 
        if(!result.first()) // Si aucun resultat
             this.connect.executeUpdate("INSERT INTO `seance`(`SEMAINE`,`DATE`,`HEURE_DEBUT`,`HEURE_FIN`,`ETAT`,`ID_COURS`,`ID_TYPE`) VALUES ("+obj.getID()+","+obj.getSEMAINE()+","+obj.getDATE()+","+obj.getHEURE_DEBUT()+","+obj.getHEURE_FIN()+","+obj.getETAT()+")"); 
    } catch (SQLException e)
        { e.printStackTrace(); }
    return false;
  }

  public boolean delete(Seance obj) {
    return false;
  }
   
  public boolean update(Seance obj) {
    return false;
  }
   
  public Seance find(int id) {
    Seance seance = new Seance();      
      
    try {
      ResultSet result = this.connect.executeQuery("SELECT * FROM seance WHERE ID = " + id);
      if(result.first())
        seance = new Seance(id, result.getInt("SEMAINE"),result.getDate("DATE").toLocalDate(),result.getTime("HEURE_DEBUT").toLocalTime(), result.getTime("HEURE_FIN").toLocalTime(),result.getInt("ETAT"),result.getInt("ID_COURS"),result.getInt("ID_TYPE")); 
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return seance;
  }

    @Override
    public ArrayList<Seance> findAll(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Seance> getAll() {
          ArrayList<Seance> seances = new ArrayList<>();      
        try {
          ResultSet result = this.connect.executeQuery("SELECT * FROM seance");
          while(result.next())
            {
                seances.add(new Seance(result.getInt("ID"), result.getInt("SEMAINE"),result.getDate("DATE").toLocalDate(),result.getTime("HEURE_DEBUT").toLocalTime(), result.getTime("HEURE_FIN").toLocalTime(),result.getInt("ETAT"),result.getInt("ID_COURS"),result.getInt("ID_TYPE")));
            }      
        } catch (SQLException e) {
          e.printStackTrace();
        }
       // System.out.println("SeanceDAO");
       //  seances.forEach((i) -> { System.out.println(i.getID());});
        return seances;
    }

    @Override
    public Seance find(String NOM, String PRENOM) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}