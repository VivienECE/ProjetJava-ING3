/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import DAO.DAO;
import DAO.EtudiantDAO;
import Modele.Cours;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc2020.Connexion;
import Modele.Etudiant;
import Modele.Groupe;
import Modele.Promotion;
import Modele.Seance;
import Modele.Utilisateur;
import Vue.Edt;
import Vue.Login;
import Vue.Menu;
import java.util.ArrayList;

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
        try
        {
            Connexion connection = new Connexion("edt", "root", "");
            Login log = new Login(connection);      
            int ID_UTILISATEUR = log.getID_UTILISATEUR();
            int DROIT = log.getDROIT();
            System.out.println(""+ID_UTILISATEUR+"+"+DROIT);
            Controleur controleur=new Controleur();
            switch(DROIT)
            {
                case 1:
                    //ControleurAdmin...
                break;
                case 2:
                    //ControleurReferent...
                break;
                case 3:
                      controleur= new ControleurEnseignant(ID_UTILISATEUR);
                break;
                case 4:
                     controleur= new ControleurEtudiant(ID_UTILISATEUR);
                break;
                default:
                break;
              }
              Edt fenetre = new Edt(controleur);
        }
        
        catch (SQLException e) {
          e.printStackTrace();
        }   
        catch (ClassNotFoundException ex) {
                Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
            Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
        }
        }

    public Utilisateur getUtilisateur() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Groupe getGroupe() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Promotion getPromotion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<Seance> getSeances() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     public ArrayList<Cours> getCours() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

