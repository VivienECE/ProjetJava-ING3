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
import Modele.Salle;
import Modele.Seance;
import Modele.Site;
import Modele.Type_cours;
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
    Connexion connection;

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
                    controleur= new ControleurAdmin(ID_UTILISATEUR);
                break;
                case 2:
                    controleur= new ControleurAdmin(ID_UTILISATEUR);
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
    
     public ArrayList<Salle> getSalles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     public ArrayList<Cours> getCours() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
      public ArrayList<Utilisateur> getUtilisateurEnseignants(){
                      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList<Site> getSites(){
                      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      
    public Utilisateur findUtilisateurEtudiant(String NOM, String PRENOM) {
    return null;
    }
     public void display(){}

    public Utilisateur findUtilisateurEnseignant(String NOM, String PRENOM) {
        return null;
    }

    public Groupe findTD(String NOM, String PROMO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Groupe findGroupe(String NOM, String PROMO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Promotion findPromotion(String NOM) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Salle findSalle(String NOM) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNOM() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getPROMO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getSITE() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Site getSite() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Salle getSalle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList<Groupe> getGroupes() { throw new UnsupportedOperationException("Not supported yet."); }
    public ArrayList<Type_cours> getType_cours(){throw new UnsupportedOperationException("Not supported yet.");}
}

