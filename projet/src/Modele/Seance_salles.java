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
   
  public Seance_salles(int id, int nom) {
    this.ID_SEANCE = id;
    this.ID_SALLE = nom;
  }
  public Seance_salles(){};
     
  public int getID_SALLE() {
    return ID_SALLE;
  }

  public void setID_SALLE(int ID) {
    this.ID_SALLE = ID;
  }

  public int getID_SEANCE() {
    return ID_SEANCE;
  }

  public void setID_SEANCE(int ID_SEANCE) {
    this.ID_SEANCE = ID_SEANCE;
  }
}
