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

public class Cours {
  //ID
  private int ID = 0;
  //Nom de l'élève
  private String NOM = "";
   
  public Cours(int id, String nom) {
    this.ID = id;
    this.NOM = nom;
  }
  public Cours(){};
     
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
}
