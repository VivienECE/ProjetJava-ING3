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
  private int ID_ENSEIGNANT = 0;
   
  public Seance_salles(int id, int nom) {
    this.ID_SEANCE = id;
    this.ID_ENSEIGNANT = nom;
  }
  public Seance_salles(){};
     
  public int getID_ENSEIGNANT() {
    return ID_ENSEIGNANT;
  }

  public void setID_ENSEIGNANT(int ID) {
    this.ID_ENSEIGNANT = ID;
  }

  public int getID_SEANCE() {
    return ID_SEANCE;
  }

  public void setID_SEANCE(int ID_SEANCE) {
    this.ID_SEANCE = ID_SEANCE;
  }
}
