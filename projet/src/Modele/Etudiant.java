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
   /**
     * Constructeur avec 3 paramètres : nom, prénom et ID
     *
     * @param nameDatabase
     * @param ID
     * @param prénom
     */
  public Etudiant(int id, String nom, int prenom) {
    this.ID_UTILISATEUR = id;
    this.NUMERO = nom;
    this.ID_GROUPE = prenom;
  }
  public Etudiant(){};
     /**
     * Methode qui retourne l'ID de l'utilisateur
     * @return ID
     */
  public int getID_UTILISATEUR() {
    return ID_UTILISATEUR;
  }
/**
     * Methode qui définit l'ID de l'utilisateur
     * @param ID_Utilisateur
     */
  public void setID_UTILISATEUR(int ID_UTILISATEUR) {
    this.ID_UTILISATEUR = ID_UTILISATEUR;
  }
/**
     * Methode qui retourne le numéro
     * @return NUMERO
     */
  public String getNUMERO() {
    return NUMERO;
  }
/**
     * Methode qui définit le numéro
     * @param NUMERO
     */
  public void setNUMERO(String NUMERO) {
    this.NUMERO = NUMERO;
  }
/**
     * Methode qui retourne l'ID du groupe
     * @return ID_GROUPE
     */
  public int getID_GROUPE() {
    return ID_GROUPE;
  }
/**
     * Methode qui définit l'ID du groupe
     * @param ID_Groupe
     */
  public void setID_GROUPE(int ID_GROUPE) {
    this.ID_GROUPE = ID_GROUPE;
  }   
}
