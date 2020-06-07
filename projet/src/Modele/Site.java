/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author Vivien
 */

public class Site {
  //ID
  private int ID = 0;
  //Nom
  private String NOM = "";
    /**
     * Constructeur avec 2 paramètres : nom et ID
     *
     * @param nom
     * @param ID
     */
  public Site(int id, String nom) {
    this.ID = id;
    this.NOM = nom;
  }
  public Site(){};
     /**
     * Methode qui retourne l'ID
     * @return ID
     */
  public int getID() {
    return ID;
  }
/**
     * Methode qui définit ID
     * @param ID
     */
  public void setID(int ID) {
    this.ID = ID;
  }
/**
     * Methode qui retourne le nom
     * @return nom
     */
  public String getNOM() {
    return NOM;
  }
/**
     * Methode qui définit le nom
     * @param NOM
     */
  public void setNOM(String NOM) {
    this.NOM = NOM;
  }
}
