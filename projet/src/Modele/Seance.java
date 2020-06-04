/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;


import java.time.*;
import java.time.temporal.IsoFields;

public class Seance {
  //ID
  private int ID = 0;
  private int SEMAINE = 0;
  private LocalDate DATE;
  private LocalTime HEURE_DEBUT;
  private LocalTime HEURE_FIN;
  private int ETAT = 0;
  private int ID_COURS = 0;
  private int ID_TYPE = 0;
  
    //Plus simple d'utiliser ces var. que de s'encombrer de liste supp.
  private String ENSEIGNANT = "";
  private String TYPE = "";
  private String SALLE = "";
  private String SITE = "";
  private String COURS = "";
   
  public Seance(int id, int SEMAINE, LocalDate DATE, LocalTime HEURE_DEBUT, LocalTime HEURE_FIN, int ETAT,int ID_COURS,int ID_TYPE) {
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

  public void setSEMAINE(LocalDate date) {
    this.SEMAINE = date.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR );
  }

  public LocalDate getDATE() {
    return DATE;
  }

  public void setDATE(int annee, int mois, int jour) {
    this.DATE = LocalDate.of(annee, mois, jour);
  }  
  
    public LocalTime getHEURE_DEBUT() {
    return HEURE_DEBUT;
  }

  public void setHEURE_DEBUT(int H_DEBUT, int MIN_D) {
    this.HEURE_DEBUT = LocalTime.of(H_DEBUT, MIN_D);
  }   
  
    public LocalTime getHEURE_FIN() {
    return HEURE_FIN;
  }

  public void setHEURE_FIN(int H_FIN,int MIN_F) {
    this.HEURE_FIN = LocalTime.of(H_FIN, MIN_F);
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
  
   public String getTYPE(int ID_TYPE) {
       if(ID_TYPE==1)
           return "COURS";
       if(ID_TYPE==1)
           return "TD";
       if(ID_TYPE==1)
           return "EXAMEN";
       else
           return "Inconnu";
    
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
  
   public String getCOURS(int ID_C) {
      if(ID_C ==1)
        return "Mathematiques";
      if(ID_C ==2)
        return "Physique";
      if(ID_C ==3)
        return "Electronique";
      else
          return "Matière incoonnue";
  }
  
  public void setCOURS(int ID_C) {
      if(ID_C ==1)
        this.COURS = "Mathematiques";
      if(ID_C ==2)
        this.COURS = "Physique";
      if(ID_C ==3)
        this.COURS = "Electronique";
   
  }
}
