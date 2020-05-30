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

public class Seance {
  //ID
  private int ID = 0;
  private int SEMAINE = 0;
  private String DATE = "";
  private String HEURE_DEBUT = "";
  private String HEURE_FIN = "";
  private int ETAT = 0;
  private int ID_COURS = 0;
  private int ID_TYPE = 0;
  
    //Plus simple d'utiliser ces var. que de s'encombrer de liste supp.
  private String ENSEIGNANT = "";
  private String TYPE = "";
  private String SALLE = "";
  private String SITE = "";
  private String COURS = "";
   
  public Seance(int id, int SEMAINE, String DATE, String HEURE_DEBUT, String HEURE_FIN ,int ETAT,int ID_COURS,int ID_TYPE) {
    this.ID = id;
    this.SEMAINE = SEMAINE;
    this.DATE = DATE;
    this.HEURE_DEBUT = HEURE_DEBUT;
    this.HEURE_FIN = HEURE_FIN;
    this.ETAT = ETAT;
    this.ID_COURS = ID_COURS;
    this.ID_TYPE = ID_TYPE;
  }
  public Seance(){};
     
  public int getID() {
    return ID;
  }

  public void setID(int ID) {
    this.ID = ID;
  }

  public int getSEMAINE() {
    return SEMAINE;
  }

  public void setSEMAINE(int SEMAINE) {
    this.SEMAINE = SEMAINE;
  }

  public String getDATE() {
    return DATE;
  }

  public void setDATE(String DATE) {
    this.DATE = DATE;
  }  
  
    public String getHEURE_DEBUT() {
    return HEURE_DEBUT;
  }

  public void setHEURE_DEBUT(String HEURE_DEBUT) {
    this.HEURE_DEBUT = HEURE_DEBUT;
  }   
  
    public String getHEURE_FIN() {
    return HEURE_FIN;
  }

  public void setHEURE_FIN(String HEURE_FIN) {
    this.HEURE_FIN = HEURE_FIN;
  }   
  
   public int getETAT() {
    return ETAT;
  }

  public void setETAT(int ETAT) {
    this.ETAT = ETAT;
  }   
  
   public int getID_COURS() {
    return ID_COURS;
  }

  public void setID_COURS(int ID_COURS) {
    this.ID_COURS = ID_COURS;
  }   
  
   public int getID_TYPE() {
    return ID_TYPE;
  }

  public void setID_TYPE(int ID_TYPE) {
    this.ID_TYPE = ID_TYPE;
  }   
  
     public String getENSEIGNANT() {
    return ENSEIGNANT;
  }
   
  public void setENSEIGNANT(String ENSEIGNANT) {
    this.ENSEIGNANT = ENSEIGNANT;
  }
  
   public String getTYPE() {
    return TYPE;
  }
   
  public void setTYPE(String TYPE) {
    this.TYPE = TYPE;
  }
  
   public String getSALLE() {
    return SALLE;
  }
  
  public void setSALLE(String SALLE) {
    this.SALLE = SALLE;
  }
  
   public String getSITE() {
    return SITE;
  }
  
  public void setSITE(String SITE) {
    this.SITE = SITE;
  }
  
   public String getCOURS() {
    return COURS;
  }
  
  public void setCOURS(String COURS) {
    this.COURS = COURS;
  }
}
