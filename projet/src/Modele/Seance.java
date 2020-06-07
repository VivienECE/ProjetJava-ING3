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
   /**
     * Constructeur avec 8 paramètres : ID, semaine, date, heure début, heure fin, état, id cours et id type
     *
     * @param id
     * @param semaine
     * @param date
     * @param heure_debut
     * @param heure_fin
     * @param etat
     * @param id_cours
     * @param id_type
     */
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
     * Methode qui retourne la semaine
     * @return SEMAINE
     */
  public int getSEMAINE() {
    return SEMAINE;
  }
/**
     * Methode qui définit la semaine
     * @param LocalDate date
     */
  public void setSEMAINE(LocalDate date) {
    this.SEMAINE = date.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR );
  }
/**
     * Methode qui retourne la Date
     * @return DATE
     */
  public LocalDate getDATE() {
    return DATE;
  }
/**
     * Methode qui définit la date
     * @param annee
     * @param mois
     * @param jour
     */
  public void setDATE(int annee, int mois, int jour) {
    this.DATE = LocalDate.of(annee, mois, jour);
  }  
  /**
     * Methode qui retourne l'heure de début
     * @return HEURE_DEBUT
     */
    public LocalTime getHEURE_DEBUT() {
    return HEURE_DEBUT;
  }
/**
     * Methode qui définit l'heure de début
     * @param H_DEBUT
     * @param MIN_D
     */
  public void setHEURE_DEBUT(int H_DEBUT, int MIN_D) {
    this.HEURE_DEBUT = LocalTime.of(H_DEBUT, MIN_D);
  }   
  /**
     * Methode qui retourne l'heure de fin
     * @return HEURE_FIN
     */
    public LocalTime getHEURE_FIN() {
    return HEURE_FIN;
  }
/**
     * Methode qui définit l'heure de fin
     * @param H_FIN
     * @param MIN_F
     */
  public void setHEURE_FIN(int H_FIN,int MIN_F) {
    this.HEURE_FIN = LocalTime.of(H_FIN, MIN_F);
  }   
  /**
     * Methode qui retourne l'Etat
     * @return ETAT
     */
   public int getETAT() {
    return ETAT;
  }
/**
     * Methode qui définit l'état
     * @param ETAT
     */
  public void setETAT(int ETAT) {
    this.ETAT = ETAT;
  }   
    /**
     * Methode qui retourne l'ID du cours
     * @return ID_COURS
     */
   public int getID_COURS() {
    return ID_COURS;
  }
   /**
     * Methode qui définit l'ID du cours
     * @param ID_COURS
     */

  public void setID_COURS(int ID_COURS) {
    this.ID_COURS = ID_COURS;
  }   
  /**
     * Methode qui retourne l'ID du type de cours
     * @return ID_TYPE
     */
   public int getID_TYPE() {
    return ID_TYPE;
  }
/**
     * Methode qui définit l'ID du type de cours
     * @param ID_TYpe
     */
  public void setID_TYPE(int ID_TYPE) {
    this.ID_TYPE = ID_TYPE;
  }   
  /**
     * Methode qui retourne l'enseignant
     * @return ENSEIGNANT
     */
     public String getENSEIGNANT() {
    return ENSEIGNANT;
  }
   /**
     * Methode qui définit l'Enseignant
     * @param ENSEIGNANT
     */
  public void setENSEIGNANT(String ENSEIGNANT) {
    this.ENSEIGNANT = ENSEIGNANT;
  }
  /**
     * Methode qui retourne le nom du type de cours en fonction de la valeur associée
     * @param ID_TYPE
     * @return COURS
     * @return TD
     * @return EXAMEN   
     * @return Inconnu
     */
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
   /**
     * Methode qui définit le nom du type
     * @param TYPE
     */
  public void setTYPE(String TYPE) {
    this.TYPE = TYPE;
  }
  /**
     * Methode qui retourne la salle
     * @return SALLE
     */
   public String getSALLE() {
    return SALLE;
  }
  /**
     * Methode qui définit le nom de la salle
     * @param SALLE
     */
  public void setSALLE(String SALLE) {
    this.SALLE = SALLE;
  }
   /**
     * Methode qui retourne la site
     * @return SITE
     */
   public String getSITE() {
    return SITE;
  }
   /**
     * Methode qui définit le site
     * @param SITE
     */
  public void setSITE(String SITE) {
    this.SITE = SITE;
  } /**
     * Methode qui retourne le cours en fonction de la valeur du cours
     * @param ID_C
     * @return Mathematiques
     * @return Physique
     * @return Electronique
     * @return Informatique
     * @return Anglais
     * @return Theorie des Graphes
     * @return Analyse
     * @return PSTE
     * @return Arabe
     * @return Droit du travail
     */
  
   public String getCOURS(int ID_C) {
      if(ID_C ==1)
        return "Mathematiques";
      if(ID_C ==2)
        return "Physique";
      if(ID_C ==3)
        return "Electronique";
      if(ID_C ==4)
        return "Informatique";
      if(ID_C ==5)
        return "Anglais";
      if(ID_C ==6)
        return "Théorie des Graphes";
      if(ID_C ==7)
        return "Analyse";
      if(ID_C ==8)
        return "PSTE";
      if(ID_C ==9)
        return "Arabe";
      if(ID_C ==10)
        return "Droit du travail";
      else
          return "Matière incoonnue";
  }
   /**
     * Methode qui définit le cours
     * @param ID_C
     */
  public void setCOURS(int ID_C) {
      if(ID_C ==1)
        this.COURS = "Mathematiques";
      if(ID_C ==2)
        this.COURS = "Physique";
      if(ID_C ==3)
        this.COURS = "Electronique";
      if(ID_C ==4)
        this.COURS = "Informatique";
      if(ID_C ==5)
        this.COURS = "Anglais";
      if(ID_C ==6)
        this.COURS = "Théorie des Graphes";
      if(ID_C ==7)
        this.COURS = "Analyse";
      if(ID_C ==8)
        this.COURS = "PSTE";
      if(ID_C ==9)
        this.COURS = "Arabe";
      if(ID_C ==10)
        this.COURS = "Droit du travail";
   
  }
}
