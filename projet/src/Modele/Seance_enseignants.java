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

public class Seance_enseignants {
  //ID
  private int ID_SEANCE = 0;
  //Nom de l'élève
  private int ID_ENSEIGNANT = 0;
   /**
     * Constructeur avec 2 paramètres : nom et ID
     *
     * @param nom
     * @param ID
     */
  public Seance_enseignants(int id, int nom) {
    this.ID_SEANCE = id;
    this.ID_ENSEIGNANT = nom;
  }
  public Seance_enseignants(){};
      /**
     * Methode qui retourne l'ID de l'enseignant
     * @return ID_ENSEIGNANT
     */
  public int getID_ENSEIGNANT() {
    return ID_ENSEIGNANT;
  }
 /**
     * Methode qui définit l'ID de l'enseignant
     * @param ID
     */
  public void setID_ENSEIGNANT(int ID) {
    this.ID_ENSEIGNANT = ID;
  }
 /**
     * Methode qui retourne l'ID de la séance
     * @return ID_Seance
     */
  public int getID_SEANCE() {
    return ID_SEANCE;
  }
 /**
     * Methode qui définit l'ID de la séance
     * @param ID_SEANCE
     */
  public void setID_SEANCE(int ID_SEANCE) {
    this.ID_SEANCE = ID_SEANCE;
  }
}
