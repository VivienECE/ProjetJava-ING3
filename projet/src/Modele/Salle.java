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

public class Salle {
  //ID
  private int ID = 0;
  //Nom de l'élève
  private String NOM = "";
  private int CAPACITE = 0;
  private int ID_SITE = 0;
  
  public Salle(int id, String nom, int CAPACITE, int ID_SITE) {
    this.ID = id;
    this.NOM = nom;
    this.CAPACITE = CAPACITE;
    this.ID_SITE = ID_SITE;
  }
  public Salle(){};
     
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

  public int getCAPACITE() {
    return CAPACITE;
  }

  public void setCAPACITE(int ID) {
    this.CAPACITE = ID;
  }

  public int getID_SITE() {
    return ID_SITE;
  }

  public void setID_SITE(int ID) {
    this.ID_SITE = ID;
  }
  
}