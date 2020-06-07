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

public class Enseignant {
  //ID
  private int ID_UTILISATEUR = 0;
  //Nom de l'élève
  private int ID_COURS = 0;
   
  public Enseignant(int id, int nom) {
    this.ID_UTILISATEUR = id;
    this.ID_COURS = nom;
  }
  public Enseignant(){};
     
  public int getID_UTILISATEUR() {
    return ID_UTILISATEUR;
  }

  public void setID_UTILISATEUR(int ID) {
    this.ID_UTILISATEUR = ID;
  }

  public int getID_COURS() {
    return ID_COURS;
  }

  public void setID_COURS(int NOM) {
    this.ID_COURS = NOM;
  }
}
