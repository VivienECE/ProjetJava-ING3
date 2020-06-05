/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;
import DAO.CoursDAO;
import DAO.DAO;
import DAO.EnseignantDAO;
import DAO.EtudiantDAO;
import DAO.GroupeDAO;
import DAO.PromotionDAO;
import DAO.SalleDAO;
import DAO.SeanceDAO;
import DAO.Seance_groupesDAO;
import DAO.Seance_sallesDAO;
import DAO.Seance_enseignantsDAO;
import DAO.SiteDAO;
import DAO.Type_coursDAO;
import DAO.UtilisateurDAO;
import java.util.ArrayList;
import Modele.Cours;
import Modele.Enseignant;
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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc2020.Connexion;

/**
 *
 * @author Vivien
 */
public class ControleurEnseignant extends Controleur {
    private Utilisateur utilisateur;
    private ArrayList<Seance> seance= new ArrayList<>();
    private ArrayList<Salle> salle= new ArrayList<>();
    private ArrayList<Site> site= new ArrayList<>();
    private ArrayList<Cours> cours= new ArrayList<>();
    private ArrayList<Type_cours> type_cours= new ArrayList<>();
    private ArrayList<Groupe> groupes= new ArrayList<>();
    private ArrayList<Promotion> promotions= new ArrayList<>();
    
    //Recupère toute les données
    public ControleurEnseignant(int ID_UTILISATEUR)
    {
    super();
    Connexion connection;
        try {
            connection = new Connexion("edt", "root", "");
            
            DAO<Utilisateur> utilisateurDAO = new UtilisateurDAO(connection);  
            DAO<Etudiant> etudiantDAO = new EtudiantDAO(connection);  
            DAO<Groupe> groupeDAO = new GroupeDAO(connection);  
            DAO<Promotion> promotionDAO = new PromotionDAO(connection);  
            DAO<Seance_groupes> seance_groupesDAO = new Seance_groupesDAO(connection);
            DAO<Seance> seanceDAO = new SeanceDAO(connection);
            DAO<Type_cours> type_coursDAO = new Type_coursDAO(connection);
            DAO<Cours> coursDAO = new CoursDAO(connection);
            DAO<Salle> salleDAO = new SalleDAO(connection);
            DAO<Seance_salles> seance_sallesDAO = new Seance_sallesDAO(connection);
            DAO<Site> siteDAO = new SiteDAO(connection);
            DAO<Enseignant> enseignantDAO = new EnseignantDAO(connection);
            DAO<Seance_enseignants> seance_enseignantsDAO = new Seance_enseignantsDAO(connection);
            
            utilisateur= utilisateurDAO.find(ID_UTILISATEUR);
            ArrayList<Seance_enseignants> seance_enseignants = seance_enseignantsDAO.findAll(ID_UTILISATEUR);
            for (Seance_enseignants i : seance_enseignants)
            {
                Seance temp_seance=seanceDAO.find(i.getID_SEANCE());
                Salle temp_salle=salleDAO.find(seance_sallesDAO.find(i.getID_SEANCE()).getID_SALLE());
                salle.add(temp_salle);
                site.add(siteDAO.find(temp_salle.getID_SITE()));
                cours.add(coursDAO.find(i.getID_SEANCE()));
                type_cours.add(type_coursDAO.find(i.getID_SEANCE()));
                seance.add(temp_seance);
                Groupe temp_group=groupeDAO.find(seance_groupesDAO.find(i.getID_SEANCE()).getID_GROUPE());
                groupes.add(temp_group);
                promotions.add(promotionDAO.find(temp_group.getID_PROMOTION()));    
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(ControleurEtudiant.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControleurEtudiant.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //CE MAIN SERT DE TEST -> ID_UT
    public static void main(String[] s) {
        // Recupère toutes les informations de l'étudiant avec ID_UTILISATEUR=1
        int ID_UTILISATEUR=1;
        ControleurEnseignant controleur = new ControleurEnseignant(ID_UTILISATEUR);
        //Edt fenetre = new Edt(controleur);
        //Recap fenetre = new Recap(controleur);

    }
    
    public Utilisateur getUtilisateur() {return utilisateur; }
    public ArrayList<Seance> getSeances() {return seance; }
    public ArrayList<Salle> getSalles() {return salle; }
    public ArrayList<Cours> getCours() {return cours; }
    public ArrayList<Type_cours> getType_cours(){return type_cours;}
    public ArrayList<Groupe> getGroupes(){return groupes;}
    public ArrayList<Promotion> getPromotions(){return promotions;}
    
}
