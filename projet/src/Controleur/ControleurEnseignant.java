/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;
import java.util.ArrayList;
import Modele.Cours;
import Modele.Enseignant;
import Modele.Etudiant;
import Modele.Groupe;
import Modele.Promotion;
import Modele.Seance;
import Modele.Seance_groupes;
import Modele.Seance_salles;

/**
 *
 * @author Vivien
 */
public class ControleurEnseignant {
    private Enseignant enseigant;
    private ArrayList<Seance> seance;
    private ArrayList<Cours> cours;
    private ArrayList<Seance_groupes> seance_groupes;
    private ArrayList<Seance_salles> seance_salles;
    
    //Recupère toute les données
    public ControleurEnseignant(int ID_UTILISATEUR)
    {
        
    }
    
}
