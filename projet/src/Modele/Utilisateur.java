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
   /*
     * Constructeur avec 6 paramètres : ID, Email, PASSWD, NOM, PRENOM, DROIT
     *
     * @param ID
     * @param EMAIL
     * @param PASSWD
     * @param NOM
     * @param PRENOM
     * @param DROIT
     */
  public Utilisateur(int ID, String EMAIL, String PASSWD, String NOM, String PRENOM, int DROIT) {
    this.ID = ID;
    this.EMAIL = EMAIL;
    this.PASSWD = PASSWD;
    this.NOM = NOM;
    this.PRENOM = PRENOM;
    this.DROIT = DROIT;
  }
  public Utilisateur(){};
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
     * Methode qui retourne l'email
     * @return EMAIL
     */
  public String getEMAIL() {
    return EMAIL;
  }
/**
     * Methode qui définit l'EMAIL
     * @param EMAIL
     */
  public void setEMAIL(String EMAIL) {
    this.EMAIL = EMAIL;
  }
 /**
     * Methode qui retourne le mot de passe
     * @return PASSWD
     */
  public String getPASSWD() {
    return PASSWD;
  }
/**
     * Methode qui définit le mot de passe
     * @param PASSWD
     */
  public void setPASSWD(String PASSWD) {
    this.PASSWD = PASSWD;
  }
 /**
     * Methode qui retourne le nom
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
/**
     * Methode qui retourne le prénom
     * @return PRENOM
     */
   public String getPRENOM() {
    return PRENOM;
  }
/**
     * Methode qui définit le PRENOM
     * @param PRENOM
     */
  public void setPRENOM(String PRENOM) {
    this.PRENOM = PRENOM;
  }
  /**
     * Methode qui retourne le droit
     * @return DROIT
     */
   public int getDROIT() {
    return DROIT;
  }
/**
     * Methode qui définit le DROIT
     * @param DROIT
     */
  public void setDROIT(int DROIT) {
    this.DROIT = DROIT;
  }
}