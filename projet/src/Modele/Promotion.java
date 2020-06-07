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

public class Promotion {
  //ID
  private int ID = 0;
  //Nom de l'élève
  private String NOM = "";
   /**
     * Constructeur avec 2 paramètres : nom et ID
     *
     * @param nom
     * @param ID
     */
  public Promotion(int id, String nom) {
    this.ID = id;
    this.NOM = nom;
  }
  public Promotion(){};

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
     */
  public void setID(int ID) {
    this.ID = ID;
  }
/**
     * Methode qui retourne le NOM
     * @return NOM
     */
  public String getNOM() {
    return NOM;
  }
/**
     * Methode qui définit le NOM
     * @param NOM
     */
  public void setNOM(String NOM) {
    this.NOM = NOM;
  }
}
