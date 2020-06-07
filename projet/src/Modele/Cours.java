/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * 
 */

public class Cours {
  //ID
  private int ID = 0;
  //Nom de l'élève
  private String NOM = "";

/**
     * Constructeur avec 2 paramètres : nom et ID
     *
     * @param nom
     * @param id
     */
  
  public Cours(int id, String nom) {
    this.ID = id;
    this.NOM = nom;
  }
  public Cours(){};
     /**
     * Methode qui retourne l'ID
     * @return ID
     */
  public int getID() {
    return ID;
  }
/**
     * Methode qui définit l'ID
     * @param ID
     * @return 
     */
  public void setID(int ID) {
    this.ID = ID;
  }
/**
     * Methode qui retourne le nom
     * @return NOM
     */
  public String getNOM() {
    return NOM;
  }
/**
     * Methode qui définit le nom 
     * @param nom
     * @return 
     */
  public void setNOM(String NOM) {
    this.NOM = NOM;
  }
  
}
