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

public class Seance_groupes {
  //ID
  private int ID_SEANCE = 0;
  //Nom de l'élève
  private int ID_GROUPE = 0;
    /**
     * Constructeur avec 2 paramètres : nom et ID
     *
     * @param nom
     * @param ID
     */
  public Seance_groupes(int id, int nom) {
    this.ID_SEANCE = id;
    this.ID_GROUPE = nom;
  }
  public Seance_groupes(){};
      /**
     * Methode qui retourne ID du groupe
     * @return ID_GROUPE
     */
  public int getID_GROUPE() {
    return ID_GROUPE;
  }
/**
     * Methode qui définit ID du groupe
     * @param ID
     */
  public void setID_GROUPE(int ID) {
    this.ID_GROUPE = ID;
  }
/**
     * Methode qui retourne ID de la séance
     * @return ID_SEANCE
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
