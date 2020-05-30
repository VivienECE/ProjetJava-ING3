/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import DAO.DAO;
import DAO.EtudiantDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc2020.Connexion;
import Modele.Etudiant;
import Vue.Fenetre;

/**
 *
 * Contrôle l'interrogation de la BDD dans la Fenetre
 *
 * @author segado + Openclassroom
 */
public class Controleur {

    /**
     *
     * une methode principal (main) pour lancer l'application
     *
     * @param s
     */
    public static void main(String[] s) {
        // creation de la fenetre
    try{
        //Testons des élèves
        Connexion connection = new Connexion("edt", "root", "");
        DAO<Etudiant> etudiantDao = new EtudiantDAO(connection);
        for(int i = 1; i < 5; i++){
          Etudiant etudiant = etudiantDao.find(i);
          System.out.println("Elève N°" + etudiant.getID_UTILISATEUR() + "  - " + etudiant.getNUMERO() + " " + etudiant.getID_GROUPE());
        }

        System.out.println("\n********************************\n");
            Fenetre f = new Fenetre();
        }
    catch (SQLException e) {
      e.printStackTrace();
    }   
    catch (ClassNotFoundException ex) {
            Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
}
