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
import DAO.Seance_enseignantsDAO;
import DAO.Seance_groupesDAO;
import DAO.Seance_sallesDAO;
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
import Vue.Recap;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc2020.Connexion;

/**
 *
 * @author Vivien
 */
public class ControleurPromotion extends Controleur {
    private Utilisateur utilisateur;
    private Etudiant etudiant;
    private Groupe groupe;
    private Promotion promotion;
    private ArrayList<Seance> seances= new ArrayList<>();
    private ArrayList<Groupe> groupes= new ArrayList<>();
    private ArrayList<Groupe> groupesparseance= new ArrayList<>();
    private ArrayList<Salle> salles= new ArrayList<>();
    private ArrayList<Site> sites= new ArrayList<>();
    private ArrayList<Cours> cours= new ArrayList<>();
    private ArrayList<Type_cours> type_cours= new ArrayList<>();
    private ArrayList<Utilisateur> utilisateurs= new ArrayList<>(); //NOM DES ENSEIGNANTS
    
    //Recupère toute les données de l'étudiant ayant le numero d'utilisateur en parametre
    public ControleurPromotion(int ID_PROMOTION)
    {
        super();
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
            
            promotion= promotionDAO.find(ID_PROMOTION);
            groupes = groupeDAO.findAll(promotion.getID());
           
            for (Groupe j : groupes)
            {
                 ArrayList<Seance_groupes> seance_groupes = seance_groupesDAO.findAll(j.getID());
                 for (Seance_groupes i : seance_groupes)
                {
                    Seance temp_seance=seanceDAO.find(i.getID_SEANCE());
                    Seance_enseignants temp_seance_enseignants = seance_enseignantsDAO.find(i.getID_SEANCE());
                    Salle temp_salle=salleDAO.find(seance_sallesDAO.find(i.getID_SEANCE()).getID_SALLE());
                    salles.add(temp_salle);
                    sites.add(siteDAO.find(temp_salle.getID_SITE()));
                    cours.add(coursDAO.find(temp_seance.getID_COURS()));
                    type_cours.add(type_coursDAO.find(temp_seance.getID_TYPE()));
                    seances.add(temp_seance);
                    utilisateurs.add(utilisateurDAO.find(enseignantDAO.find(temp_seance_enseignants.getID_ENSEIGNANT()).getID_UTILISATEUR()));
                    groupesparseance.add(groupeDAO.find(seance_groupesDAO.find(i.getID_SEANCE()).getID_GROUPE()));
                }
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(ControleurPromotion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControleurPromotion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.display();
    }
    
    //CE MAIN SERT DE TEST -> ID_UT
    public static void main(String[] s) {
        // Recupère toutes les informations de l'étudiant avec ID_UTILISATEUR=1
        int ID_PROMOTION=1;
         Connexion connection = null;
        ControleurPromotion controleur = new ControleurPromotion(ID_PROMOTION);
        Edt fenetre = new Edt(controleur, false);
        //Recap fenetre = new Recap(controleur);

    }
    
    public Utilisateur getUtilisateur() {return utilisateur; }
    public Etudiant getEtudiant() {return etudiant; }
    public Groupe getGroupe() {return groupe; }
    public ArrayList<Groupe> getGroupes() {return groupesparseance; }
    public Promotion getPromotion() {return promotion; }
    public ArrayList<Seance> getSeances() {return seances; }
    public ArrayList<Salle> getSalles() {return salles; }
    public ArrayList<Site> getSites() {return sites; }
    public ArrayList<Cours> getCours() {return cours; }
    public ArrayList<Type_cours> getType_cours(){return type_cours;}
    public ArrayList<Utilisateur> getUtilisateurEnseignants(){return utilisateurs;}
    public void display(){
        System.out.println("Groupe");
        groupesparseance.forEach((i) -> { System.out.println(i.getID());});
        
        System.out.println("Enseignants");
        utilisateurs.forEach((i) -> { System.out.println(i.getID());});

         System.out.println("Seance");
         seances.forEach((i) -> { System.out.println(i.getID());});
    }
    public Seance findSeance(int ID) {
        for (Seance i : seances)
                 if (i.getID()==ID)
                       return i;
        return null;   
    }
}

