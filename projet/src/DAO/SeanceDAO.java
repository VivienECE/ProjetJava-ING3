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
             System.out.println("INSERT INTO `seance`(`SEMAINE`,`DATE`,`HEURE_DEBUT`,`HEURE_FIN`,`ETAT`,`ID_COURS`,`ID_TYPE`) "
                     + "VALUES ('"+obj.getSEMAINE()+"','"+obj.getDATE()+"','"+obj.getHEURE_DEBUT()+"','"+obj.getHEURE_FIN()+"','"+obj.getETAT()+"','"+obj.getID_COURS()+"','"+obj.getID_TYPE()+"'"+")");
             this.connect.executeUpdate("INSERT INTO `seance`(`SEMAINE`,`DATE`,`HEURE_DEBUT`,`HEURE_FIN`,`ETAT`,`ID_COURS`,`ID_TYPE`) "
                     + "VALUES ('"+obj.getSEMAINE()+"','"+obj.getDATE()+"','"+obj.getHEURE_DEBUT()+"','"+obj.getHEURE_FIN()+"','"+obj.getETAT()+"','"+obj.getID_COURS()+"','"+obj.getID_TYPE()+"'"+")");
             
            System.out.println("SELECT ID from seance"
                     + " WHERE SEMAINE='"+obj.getSEMAINE()+"' "
                             + " AND DATE = '"+obj.getDATE()+"' "
                                     + "AND HEURE_DEBUT='"+obj.getHEURE_DEBUT()+"' "
                                             + "AND HEURE_FIN='"+obj.getHEURE_FIN()+"' "
                                                     + "AND ETAT='"+obj.getETAT()+"' "
                                                                 + "AND ID_COURS='"+obj.getID_COURS()+"' "
                                                                        + "AND ID_TYPE='"+obj.getID_TYPE()+"' "); 
             ResultSet result = this.connect.executeQuery("SELECT ID from seance"
                     + " WHERE SEMAINE='"+obj.getSEMAINE()+"' "
                             + " AND DATE = '"+obj.getDATE()+"' "
                                     + "AND HEURE_DEBUT='"+obj.getHEURE_DEBUT()+"' "
                                             + "AND HEURE_FIN='"+obj.getHEURE_FIN()+"' "
                                                     + "AND ETAT='"+obj.getETAT()+"' "
                                                                 + "AND ID_COURS='"+obj.getID_COURS()+"' "
                                                                        + "AND ID_TYPE='"+obj.getID_TYPE()+"' "); 
             if(result.first())
                  obj.setID(result.getInt("ID"));
             else
                 obj.setID(0);
       } catch (SQLException e)
        { e.printStackTrace(); }
    return false;
  }

  public boolean delete(Seance obj) {
    return false;
  }
   
  public boolean update(Seance obj) {
     try {
             System.out.println("UPDATE `seance` SET `SEMAINE`='"+obj.getSEMAINE()+"',`DATE`='"+obj.getDATE()+"',`HEURE_DEBUT`='"+obj.getHEURE_DEBUT()+"',`HEURE_FIN`='"+obj.getHEURE_FIN()+"',`ETAT`='1',`ID_COURS`='"+obj.getID_COURS()+"',`ID_TYPE`='"+obj.getID_TYPE()+"' WHERE ID="+obj.getID());
             this.connect.executeUpdate("UPDATE `seance` SET `SEMAINE`='"+obj.getSEMAINE()+"',`DATE`='"+obj.getDATE()+"',`HEURE_DEBUT`='"+obj.getHEURE_DEBUT()+"',`HEURE_FIN`='"+obj.getHEURE_FIN()+"',`ETAT`='1',`ID_COURS`='"+obj.getID_COURS()+"',`ID_TYPE`='"+obj.getID_TYPE()+"' WHERE ID="+obj.getID());
       } catch (SQLException e)
        { e.printStackTrace(); }
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