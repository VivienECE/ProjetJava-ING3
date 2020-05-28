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

public class Groupe {
  //ID
  private int ID = 0;
  private String NOM = "";
  private int ID_PROMOTION = 0;
   
  public Groupe(int id, String nom, int ID_PROMOTION ) {
    this.ID = id;
    this.NOM = nom;
    this.ID_PROMOTION = ID_PROMOTION ;
  }
  public Groupe(){};
     
  public int getID() {
    return ID;
  }

  public void setID(int ID) {
    this.ID = ID;
  }

  public String getNOM() {
    return NOM;
  }

  public void setNOM(String NOM) {
    this.NOM = NOM;
  }
  
   public int getID_PROMOTION() {
    return ID_PROMOTION;
  }

  public void setID_PROMOTION(int ID_PROMOTION) {
    this.ID_PROMOTION = ID_PROMOTION;
  }
}
