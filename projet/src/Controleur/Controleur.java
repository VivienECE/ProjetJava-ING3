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
import Vue.Menu;

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
            Connexion connection = new Connexion("edt", "root", "");
            /** 
            Fenetre login = new Login();
            droit=login.getDroit();
            switch(droit)
            {
                case 1:
                ControleurAdmin...
                break;
                case 2:
                ControleurReferent...
                break;
                case 3:
                ControleurEnseignant...
                break;
                case 4:
                ControleurEtudiant...
                break;
                default:
                break;
            }
             */
            }
        catch (SQLException e) {
          e.printStackTrace();
        }   
        catch (ClassNotFoundException ex) {
                Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}

