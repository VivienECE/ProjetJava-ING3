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

public class Enseignant {
  //ID
  private int ID_UTILISATEUR = 0;
  //Nom de l'élève
  private int ID_COURS = 0;
   /**
     * Constructeur avec 2 paramètres : nom et ID
     *
     * @param nameDatabase
     * @param ID
     */
  public Enseignant(int id, int nom) {
    this.ID_UTILISATEUR = id;
    this.ID_COURS = nom;
  }
  public Enseignant(){};
     /**
     * Methode qui retourne l'ID de l'utilisateur
     * @return ID
     */
  public int getID_UTILISATEUR() {
    return ID_UTILISATEUR;
  }
    /**
     * Methode qui définit l'ID Utilisateur
     * @param ID
     */
  public void setID_UTILISATEUR(int ID) {
    this.ID_UTILISATEUR = ID;
  }
/**
     * Methode qui retourne l'ID du cours
     * @return ID
     */
  public int getID_COURS() {
    return ID_COURS;
  }
/**
     * Methode qui définit l'ID du cours
     * @param ID
     */
  public void setID_COURS(int NOM) {
    this.ID_COURS = NOM;
  }
}
