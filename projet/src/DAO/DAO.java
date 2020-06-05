/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Vivien
 */

import java.sql.Connection;
import java.util.ArrayList;
import jdbc2020.Connexion;

public abstract class DAO<T> {
  protected Connexion connect = null;
   
  public DAO(Connexion conn){
    this.connect = conn;
  }
   
  /**
  * Méthode de création
  * @param obj
  * @return boolean 
  */
  public abstract boolean create(T obj);

  /**
  * Méthode pour effacer
  * @param obj
  * @return boolean 
  */
  public abstract boolean delete(T obj);

  /**
  * Méthode de mise à jour
  * @param obj
  * @return boolean
  */
  public abstract boolean update(T obj);

  /**
  * Méthode de recherche des informations
  * @param id
  * @return T
  */
  public abstract T find(int id);
  public abstract T find(String NOM, String PRENOM);
  
  public abstract ArrayList<T> findAll(int id);
  
  public abstract ArrayList<T> getAll();
}


