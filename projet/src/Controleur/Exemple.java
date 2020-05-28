/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Modele.Etudiant;
import Modele.Seance_enseignants;
import Controleur.Controleur;
import DAO.DAO;
import DAO.Seance_enseignantsDAO;
import DAO.EtudiantDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc2020.Connexion;
import jdbc2020.Fenetre;

/**
 *
 * @author Vivien
 */
public class Exemple {
      public static void main(String[] s) {
        // creation de la fenetre
    try{
        //Connexion avec la bd
        Connexion connection = new Connexion("edt", "root", "");
        //Ce prépare a récupéré des infos de la table étudiant
        DAO<Etudiant> etudiantDao = new EtudiantDAO(connection);
        DAO<Seance_enseignants> seance_enseignantsDAO = new Seance_enseignantsDAO(connection);
        Seance_enseignants S1 = new Seance_enseignants(1,1);
        seance_enseignantsDAO.create(S1);
        //Recupère l'etudiant d'id:1 (Seul méthode impl.)
        Etudiant etudiant = etudiantDao.find(1);
        System.out.println("Elève N°" + etudiant.getID_UTILISATEUR() + "  - " + etudiant.getNUMERO() + " " + etudiant.getID_GROUPE());
        System.out.println("\n********************************\n");
        //L'idée est de passé tt en parametre dans new Fenetre(etudiant, ....)
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
