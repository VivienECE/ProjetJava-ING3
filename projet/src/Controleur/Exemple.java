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
import DAO.Seance_groupesDAO;
import Modele.Seance_groupes;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc2020.Connexion;
import Vue.Fenetre;
import java.util.ArrayList;

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
        
        //Recupère l'etudiant d'id:1 (Seul méthode impl.)
        Etudiant etudiant = etudiantDao.find(1);
        System.out.println("Elève N°" + etudiant.getID_UTILISATEUR() + "  - " + etudiant.getNUMERO() + " " + etudiant.getID_GROUPE());
        System.out.println("\n********************************\n");
        //L'idée est de passé tt en parametre dans new Fenetre(etudiant, ....)
        
        //Recupere la liste des seances_groupes du groupe 1
        DAO<Seance_groupes> seance_groupesDAO = new Seance_groupesDAO(connection);
        ArrayList<Seance_groupes> liste = new ArrayList<Seance_groupes>();
        liste = seance_groupesDAO.findAll(1); //ID GROUPE = 1
        for (Seance_groupes i : liste) {System.out.println("SEANCE "+i.getID_SEANCE()+" du GROUPE:"+i.getID_GROUPE());}
        

        /** CREER UN OBJET DANS LA TABLE
        DAO<Seance_enseignants> seance_enseignantsDAO = new Seance_enseignantsDAO(connection);
        Seance_enseignants S1 = new Seance_enseignants(2,1);
        seance_enseignantsDAO.create(S1);
        *ATTENTION PREMIER PARAMETRE CLE PRIMAIRE, UN DOUBLON FERA PLANTER LE PROG A REVOIR
         */
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
