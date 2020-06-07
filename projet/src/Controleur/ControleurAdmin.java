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
import Vue.Ajout;
import Vue.Edt;
import Vue.RechercheEdt;
import Vue.RechercheRecap;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc2020.Connexion;

/**
 *
 * @author Vivien
 */
public class ControleurAdmin extends Controleur {
    private Utilisateur utilisateur;
    private ArrayList<Seance> seances= new ArrayList<>();
    private ArrayList<Salle> salles= new ArrayList<>();
    private ArrayList<Site> sites= new ArrayList<>();
    private ArrayList<Cours> cours= new ArrayList<>();
    private ArrayList<Cours> listecours= new ArrayList<>();
    private ArrayList<Type_cours> type_cours= new ArrayList<>();
    private ArrayList<Groupe> groupes= new ArrayList<>();
    private ArrayList<Promotion> promotions= new ArrayList<>();
    private ArrayList<Enseignant> listeenseignants= new ArrayList<>();
    private ArrayList<Utilisateur> enseignants= new ArrayList<>(); //NOM DES ENSEIGNANTS
    private ArrayList<Utilisateur> enseignantsparseance= new ArrayList<>(); //NOM DES ENSEIGNANTS
    private ArrayList<Utilisateur> etudiants= new ArrayList<>(); //ETUDIANTS
    DAO<Seance> seanceDAO;
    DAO<Seance_enseignants> seance_enseignantsDAO;
    DAO<Seance_groupes> seance_groupesDAO;
    DAO<Seance_salles> seance_sallesDAO;
    
    //Recupère toute les données
    public ControleurAdmin(int ID_UTILISATEUR)
    {
        super();
                try {
            connection = new Connexion("edt", "root", "");
        DAO<Utilisateur> utilisateurDAO = new UtilisateurDAO(connection);
        DAO<Etudiant> etudiantDAO = new EtudiantDAO(connection);
        DAO<Groupe> groupeDAO = new GroupeDAO(connection);
        DAO<Promotion> promotionDAO = new PromotionDAO(connection);
        seance_groupesDAO = new Seance_groupesDAO(connection);
        seance_sallesDAO = new Seance_sallesDAO(connection);
        seanceDAO = new SeanceDAO(connection);
        DAO<Type_cours> type_coursDAO = new Type_coursDAO(connection);
        DAO<Cours> coursDAO = new CoursDAO(connection);
        DAO<Salle> salleDAO = new SalleDAO(connection);
        DAO<Seance_salles> seance_sallesDAO = new Seance_sallesDAO(connection);
        DAO<Site> siteDAO = new SiteDAO(connection);
        DAO<Enseignant> enseignantDAO = new EnseignantDAO(connection);
        seance_enseignantsDAO = new Seance_enseignantsDAO(connection);
        
        utilisateur= utilisateurDAO.find(ID_UTILISATEUR);
        int j=1;
        ArrayList<Etudiant> listeetudiants = etudiantDAO.getAll();
          listeetudiants.forEach((i) -> { etudiants.add(utilisateurDAO.find(i.getID_UTILISATEUR()));});
        listeenseignants = enseignantDAO.getAll();
          listeenseignants.forEach((i) -> { enseignants.add(utilisateurDAO.find(i.getID_UTILISATEUR()));});
        seances = seanceDAO.getAll();
        listecours = coursDAO.getAll();
        for (Seance i : seances)
        {
            Seance_enseignants temp_seance_enseignants = seance_enseignantsDAO.find(i.getID());
            enseignantsparseance.add(utilisateurDAO.find(temp_seance_enseignants.getID_ENSEIGNANT()));
            Salle temp_salle=salleDAO.find(seance_sallesDAO.find(i.getID()).getID_SALLE());
            salles.add(temp_salle);
            sites.add(siteDAO.find(temp_salle.getID_SITE()));
            cours.add(coursDAO.find(i.getID_COURS()));
            type_cours.add(type_coursDAO.find(i.getID_TYPE()));
            Groupe temp_group=groupeDAO.find(seance_groupesDAO.find(i.getID()).getID_GROUPE());
            groupes.add(temp_group);
            promotions.add(promotionDAO.find(temp_group.getID_PROMOTION()));
            
        }
                } catch (SQLException ex) {
            Logger.getLogger(ControleurAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControleurAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
       // System.out.println("Debug");
        this.display();
    }
    
    //CE MAIN SERT DE TEST -> ID_UT
    public static void main(String[] s) {
        // Recupère toutes les informations de l'étudiant avec ID_UTILISATEUR=1
        int ID_UTILISATEUR=1;
        Connexion connection = null;
        try {
            connection = new Connexion("edt", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(ControleurAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControleurAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        ControleurAdmin controleur = new ControleurAdmin(ID_UTILISATEUR);
        //RechercheEdt fenetre = new RechercheEdt(controleur);
        //RechercheRecap fenetre = new RechercheRecap(controleur);
        Ajout fenetre = new Ajout(controleur);
        

    }
    
    public Utilisateur getUtilisateur() {return utilisateur; }
    public ArrayList<Seance> getSeances() {return seances; }
    public ArrayList<Enseignant> getEnseignants() {return listeenseignants; }
    public ArrayList<Salle> getSalles() {return salles; }
    public ArrayList<Site> getSites() {return sites; }
    public ArrayList<Cours> getCours() {return cours; }
    public ArrayList<Cours> getListeCours() {return listecours; }
    public ArrayList<Type_cours> getType_cours(){return type_cours;}
    public ArrayList<Groupe> getGroupes(){return groupes;}
    public ArrayList<Promotion> getPromotions(){return promotions;}
    public ArrayList<Utilisateur> getUtilisateurEnseignants(){return enseignants;}
    public ArrayList<Utilisateur> getUtilisateurEtudiants(){return etudiants;}
    public Utilisateur findUtilisateurEtudiant(String NOM, String PRENOM) {
    for (Utilisateur i : etudiants) {
            if (i.getNOM().equals(NOM)&&i.getPRENOM().equals(PRENOM)) {
                return i;
            }
        }
        return null;   
    }
    public Utilisateur findUtilisateurEnseignant(String NOM, String PRENOM) {
    for (Utilisateur i : enseignants) {
            if (i.getNOM().equals(NOM)&&i.getPRENOM().equals(PRENOM)) {
                return i;
            }
        }
        return null;   
    }
    public Promotion findPromotion(String NOM) {
         for (Promotion i : promotions) {
            if (i.getNOM().equals(NOM)) {
                return i;
            }
        }
        return null;   
    }
    
    public Groupe findGroupe(String NOM, String PROMO) {
        for (Promotion i : promotions)
             for (Groupe j : groupes)
                 if (i.getNOM().equals(PROMO)&&j.getNOM().equals(NOM)) 
                       return j;
        return null;   
    }
    
      public Cours findCours(int ID) {
        for (Cours i : cours)
                 if (i.getID()==ID)
                       return i;
        return null;   
    }
    
     public Salle findSalle(String NOM) {
        for (Salle i : salles) 
            if (i.getNOM().equals(NOM)) 
                return i;

        return null;   
    }

    
    /*@Override
    public Utilisateur findUtilisateurEnseignant(String NOM, String PRENOM) {
    for (Utilisateur i : etudiants) {
            if (i.getNOM().equals(NOM)&&i.getPRENOM().equals(PRENOM)) {
                return i;
            }
        }
        return null;   
    }*/
    
    public void display(){
     System.out.println("Etudiants");
     etudiants.forEach((i) -> { System.out.println(i.getID());});
     
      System.out.println("Enseignants");
     enseignantsparseance.forEach((i) -> { System.out.println(i.getID());});
     
      System.out.println("Seance");
     seances.forEach((i) -> { System.out.println(i.getID());});
    }
    
    public int ajouterSeance(Seance seance)
    {
        seanceDAO.create(seance);
        return seance.getID();
    }
    
    public void ajouterSeance_groupes(Seance_groupes seance_groupes)
    {
         seance_groupesDAO.create(seance_groupes);
    }
    
    public void ajouterSeance_salles(Seance_salles seance_salles)
    {
         seance_sallesDAO.create(seance_salles);
    }
    
    public void ajouterSeance_enseignants(Seance_enseignants seance_enseignants)
    {
         seance_enseignantsDAO.create(seance_enseignants);
    }
}
