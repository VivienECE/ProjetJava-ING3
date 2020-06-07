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

public class Seance_salles {
  //ID
  private int ID_SEANCE = 0;
  //Nom de l'élève
  private int ID_SALLE = 0;
    /**
     * Constructeur avec 2 paramètres : nom et ID
     *
     * @param nom
     * @param ID
     */
  public Seance_salles(int id, int nom) {
    this.ID_SEANCE = id;
    this.ID_SALLE = nom;
  }
  
  public Seance_salles(){};
      /**
     * Methode qui retourne l'ID de la salle
     * @return ID_SALLE
     */
  public int getID_SALLE() {
    return ID_SALLE;
  }
 /**
     * Methode qui définit l'ID de la salle
     * @param ID_SALLE
     */
  public void setID_SALLE(int ID) {
    this.ID_SALLE = ID;
  }
 /**
     * Methode qui retourne l'ID de la séance
     * @return ID_Seance
     */
  public int getID_SEANCE() {
    return ID_SEANCE;
  }
/**
     * Methode qui définit ID_Seance
     * @param ID_SEANCE
     */
  public void setID_SEANCE(int ID_SEANCE) {
    this.ID_SEANCE = ID_SEANCE;
  }
}
