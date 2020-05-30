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

public class Utilisateur {
  //ID
  private int ID = 0;
  private String EMAIL = "";
  private String PASSWD  = "";
  private String NOM  = "";
  private String PRENOM  = "";
  private int DROIT  = 0;
  
  public Utilisateur(int ID, String EMAIL, String PASSWD, String NOM, String PRENOM, int DROIT) {
    this.ID = ID;
    this.EMAIL = EMAIL;
    this.PASSWD = PASSWD;
    this.NOM = NOM;
    this.PRENOM = PRENOM;
    this.DROIT = DROIT;
  }
  public Utilisateur(){};
     
  public int getID() {
    return ID;
  }

  public void setID(int ID) {
    this.ID = ID;
  }

  public String getEMAIL() {
    return EMAIL;
  }

  public void setEMAIL(String EMAIL) {
    this.EMAIL = EMAIL;
  }

  public String getPASSWD() {
    return PASSWD;
  }

  public void setPASSWD(String PASSWD) {
    this.PASSWD = PASSWD;
  }

  public String getNOM() {
    return NOM;
  }

  public void setNOM(String NOM) {
    this.NOM = NOM;
  }
  
   public String getPRENOM() {
    return PRENOM;
  }

  public void setPRENOM(String PRENOM) {
    this.PRENOM = PRENOM;
  }
   public int getDROIT() {
    return DROIT;
  }

  public void setDROIT(int DROIT) {
    this.DROIT = DROIT;
  }
}