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
  /**
     * Constructeur avec 4 paramètres : nom, ID nom, Capacité et ID du site
     *
     * @param nameDatabase
     * @param ID
     * @param prénom
     */
  public Salle(int id, String nom, int CAPACITE, int ID_SITE) {
    this.ID = id;
    this.NOM = nom;
    this.CAPACITE = CAPACITE;
    this.ID_SITE = ID_SITE;
  }
  public Salle(){};
     /**
     * Methode qui retourne l'ID
     * @return ID
     */
  public int getID() {
    return ID;
  }
/**
     * Methode qui définit l'ID
     * @return ID
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
     * Methode qui définit le nom
     * @param NOM
     */
  public void setNOM(String NOM) {
    this.NOM = NOM;
  }
/**
     * Methode qui retourne la capacité
     * @return CAPACITE
     */
  public int getCAPACITE() {
    return CAPACITE;
  }
/**
     * Methode qui définit la capacité
     * @param ID
     */
  public void setCAPACITE(int ID) {
    this.CAPACITE = ID;
  }
/**
     * Methode qui retourne l'ID du site
     * @return ID_SITE
     */
  public int getID_SITE() {
    return ID_SITE;
  }
/**
     * Methode qui définit l'ID du site
     * @param ID
     */
  public void setID_SITE(int ID) {
    this.ID_SITE = ID;
  }
  
}