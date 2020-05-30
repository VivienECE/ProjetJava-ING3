package DAO;
import java.sql.Connection;
import jdbc2020.Connexion;
//CTRL + SHIFT + O pour générer les imports
public class DAOFactory {
  protected static final Connexion conn = null;   
   
  /**
  * Retourne un objet Classe interagissant avec la BDD
  * @return DAO
  */
  public static DAO getEtudiantDAO(){
    return new EtudiantDAO(conn);
  }

  /**
  * Retourne un objet Professeur interagissant avec la BDD
  * @return DAO
  */
  public static DAO getCoursDAO(){
    return new CoursDAO(conn);
  }

  /**
  * Retourne un objet Eleve interagissant avec la BDD
  * @return DAO
  */
  public static DAO getEnseignantDAO(){
    return new EnseignantDAO(conn);
  }

  /**
  * Retourne un objet Matiere interagissant avec la BDD
  * @return DAO
  */
  public static DAO getGroupeDAO(){
    return new GroupeDAO(conn);
  }   
}