
package Controleur;

import DAO.DAO;
import DAO.EtudiantDAO;
import Modele.Cours;
import Modele.Enseignant;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc2020.Connexion;
import Modele.Etudiant;
import Modele.Groupe;
import Modele.Promotion;
import Modele.Salle;
import Modele.Seance;
import Modele.Seance_enseignants;
import Modele.Seance_groupes;
import Modele.Seance_salles;
import Modele.Site;
import Modele.Type_cours;
import Modele.Utilisateur;
import Vue.Edt;
import Vue.Login;
import Vue.Menu;
import Vue.RechercheEdt;
import java.util.ArrayList;

/**
 * 
 * Recupère et modifie les données de la BDD
 * Envoie ces données aux Vues
 * @author Vivien & Baptiste
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
              Edt fenetreE;
              RechercheEdt fenetreA;
              if((controleur instanceof ControleurAdmin))
                  fenetreA = new RechercheEdt(controleur);
              else
                   fenetreE = new Edt(controleur, false);
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
    
    /**
     * Methode qui retourne l'utilisateur authentifier
     * @return utilisateur
     */
    public Utilisateur getUtilisateur() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

     /**
     * Methode qui retourne le groupe authentifier
     * @return groupe
     */
    public Groupe getGroupe() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

     /**
     * Methode qui retourne la promotion authentifier
     * @return promotion
     */
    public Promotion getPromotion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

     /**
     * Methode qui retourne la liste des séances récupérés par le controleur
     * @return seances
     */
    public ArrayList<Seance> getSeances() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Methode qui retourne la liste des salles récupérés par le controleur
     * @return salles
     */
     public ArrayList<Salle> getSalles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     /**
     * Methode qui retourne la liste des salles récupérés par le controleur
     * @return salles
     */
     public ArrayList<Cours> getCours() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
      /**
     * Methode qui retourne la liste des utilisateurs etant enseignants récupérés par le controleur
     * @return utilisateurenseignants
     */
      public ArrayList<Utilisateur> getUtilisateurEnseignants(){
                      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
    * Methode qui retourne la liste des sites récupérés par le controleur
    * @return sites
    */
    public ArrayList<Site> getSites(){
                      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     /**
    * Methode qui retourne la liste des utilisateurs etant étudiants récupérés par le controleur
    * @return utilisateuretudiants
    */
    public Utilisateur findUtilisateurEtudiant(String NOM, String PRENOM) {
    return null;
    }
    
    /**
    * Methode debugg
    */
     public void display(){}

      /**
    * Methode qui retourne un utilisateur en fonction de son nom et prenom
    * @param String NOM
    * @param String PRENOM
    * @return utilisateure
    */
    public Utilisateur findUtilisateurEnseignant(String NOM, String PRENOM) {
        return null;
    }

     /**
    * Methode qui retourne un groupe/TD en fonction de son nom et sa promo
    * @param String NOM
    * @param String PROMO
    * @return utilisateure
    */
    public Groupe findGroupe(String NOM, String PROMO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

     /**
    * Methode qui retourne une promotion en fonction de son nom
    * @param String NOM
    * @return promotion
    */
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
    public ArrayList<Enseignant> getEnseignants() { throw new UnsupportedOperationException("Not supported yet."); }
    public Cours findCours(int ID) {throw new UnsupportedOperationException("Not supported yet.");}
    public ArrayList<Cours> getListeCours() {throw new UnsupportedOperationException("Not supported yet.");}
    public int ajouterSeance(Seance seance)
         {throw new UnsupportedOperationException("Not supported yet.");}
    
    public void ajouterSeance_groupes(Seance_groupes seance_groupes)
        {throw new UnsupportedOperationException("Not supported yet.");}
    public void ajouterSeance_salles(Seance_salles seance_salles)
        {throw new UnsupportedOperationException("Not supported yet.");}
    
    public void ajouterSeance_enseignants(Seance_enseignants seance_enseignants)
     {throw new UnsupportedOperationException("Not supported yet.");}
    
    public Seance findSeance(int ID){throw new UnsupportedOperationException("Not supported yet.");}
    
    public void updateSeance(Seance seance)
    {
         throw new UnsupportedOperationException("Not supported yet.");
    }
}

