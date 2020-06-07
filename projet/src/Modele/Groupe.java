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

public class Groupe {
  //ID
  private int ID = 0;
  private String NOM = "";
  private int ID_PROMOTION = 0;
   /**
     * Constructeur avec 3 paramètres : nom, prénom et ID
     *
     * @param nom
     * @param ID
     * @param prénom
     */
  public Groupe(int id, String nom, int ID_PROMOTION ) {
    this.ID = id;
    this.NOM = nom;
    this.ID_PROMOTION = ID_PROMOTION ;
  }
  public Groupe(){};
     
  /**
     * Methode qui retounre l'ID
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
  /**
     * Methode qui retourne l'ID de la promotion
     * @return ID_PROMOTION
     */
   public int getID_PROMOTION() {
    return ID_PROMOTION;
  }
/**
     * Methode qui définit l'ID de la promotion
     * @param ID_PROMOTION
 */
  public void setID_PROMOTION(int ID_PROMOTION) {
    this.ID_PROMOTION = ID_PROMOTION;
  }
}
