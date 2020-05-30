/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;


public class Etudiant {
  //ID
  private int ID_UTILISATEUR = 0;
  //Nom de l'élève
  private String NUMERO = "";
  //Prénom de l'élève
  private int ID_GROUPE = 0;
   
  public Etudiant(int id, String nom, int prenom) {
    this.ID_UTILISATEUR = id;
    this.NUMERO = nom;
    this.ID_GROUPE = prenom;
  }
  public Etudiant(){};
     
  public int getID_UTILISATEUR() {
    return ID_UTILISATEUR;
  }

  public void setID_UTILISATEUR(int ID_UTILISATEUR) {
    this.ID_UTILISATEUR = ID_UTILISATEUR;
  }

  public String getNUMERO() {
    return NUMERO;
  }

  public void setNUMERO(String NUMERO) {
    this.NUMERO = NUMERO;
  }

  public int getID_GROUPE() {
    return ID_GROUPE;
  }

  public void setID_GROUPE(int ID_GROUPE) {
    this.ID_GROUPE = ID_GROUPE;
  }   
}
