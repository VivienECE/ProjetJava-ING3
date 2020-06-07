
package Vue;

import Controleur.Controleur;
import Controleur.ControleurEnseignant;
import Controleur.ControleurEtudiant;
import Controleur.ControleurGroupe;
import Controleur.ControleurPromotion;
import Controleur.ControleurSalle;
import DAO.DAO;
import DAO.EtudiantDAO;
import Modele.Etudiant;
import Modele.Groupe;
import Modele.Promotion;
import Modele.Salle;
import Modele.Utilisateur;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.IsoFields;
import java.util.Calendar;
import javax.swing.JMenu;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import jdbc2020.Connexion;


public class RechercheEdt extends JFrame{
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panelB;
    private JButton Eleve;
    private JButton Professeur;
    private JButton TD;
    private JButton Promotion;
    private JButton Salle;
    private JButton Submit;
    private JTextField nom;
    private JTextField prenom;
    private JComboBox affichage;
    private JComboBox promo;
    private DateTextField picker;
    private Controleur controleur;
    
    public RechercheEdt(Controleur controleur) {
        this.controleur = controleur;
        this.setTitle("Emploi du temps");
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(0,1));
        Menu m = new Menu(1);
        this.setJMenuBar(m);
        
        panelB = new JPanel();
        JLabel mess1 = new JLabel("Recherche d'emploi du temps d'un(e) : ");
        panelB.add(mess1);
        
        Eleve = new JButton("Elève");
        Eleve.addActionListener(new RechercheEdt.AddButtonListener());
        panelB.add(Eleve);
        Professeur = new JButton("Professeur");
        Professeur.addActionListener(new RechercheEdt.AddButtonListener());
        panelB.add(Professeur);
        TD = new JButton("TD");
        TD.addActionListener(new RechercheEdt.AddButtonListener());
        panelB.add(TD);
        Promotion = new JButton("Promotion");
        Promotion.addActionListener(new RechercheEdt.AddButtonListener());
        panelB.add(Promotion);
        Salle = new JButton("Salle");
        Salle.addActionListener(new RechercheEdt.AddButtonListener());
        panelB.add(Salle);
        this.add(panelB, BorderLayout.NORTH);
        
        panel1 = new JPanel();
        panel2 = new JPanel();
        //RecherchePanel();
        //ResultPanel();
        this.add(panel1, BorderLayout.NORTH);
        this.add(panel2, BorderLayout.SOUTH);
        this.setVisible(true);
    }
    
    private void RecherchePanel(int type) {
      
       if(type==3){
           JLabel mess1ter = new JLabel("Promotion : ");
           promo = new JComboBox();
           promo.addItem("2022");
           promo.addItem("2023");
           promo.addItem("2024");
           promo.addItem("2025");
           promo.addItem("2026");
           panel1.add(mess1ter);
           panel1.add(promo);
       }
           
       JLabel mess1bis = new JLabel("Nom : ");
       nom = new JTextField(10);
       panel1.add(mess1bis);
       panel1.add(nom);
       
       if(type==1 || type==2){
            JLabel mess1bisP = new JLabel("Prenom : ");
            prenom = new JTextField(10);
            panel1.add(mess1bisP);
            panel1.add(prenom);
       }
       
       Submit = new JButton("Rechercher");
       Submit.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent event){
           try {
               ResultPanel(type);
           } catch (SQLException ex) {
               Logger.getLogger(RechercheEdt.class.getName()).log(Level.SEVERE, null, ex);
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(RechercheEdt.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
      });
       
       affichage = new JComboBox();
       affichage.addItem("en grille");
       affichage.addItem("en liste");
       
        
        
        panel1.add(affichage);
        panel1.add(Submit);

        pack();
        setVisible(true);

    }
    public class AddButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            
            if (e.getSource() == Eleve) {
                RecherchePanel(1);
                panelB.setVisible(false);   
            }
            if (e.getSource() == Professeur) {
                RecherchePanel(2);
                panelB.setVisible(false);
            }
            if (e.getSource() == TD) {
                RecherchePanel(3);
                panelB.setVisible(false);
            }
            if (e.getSource() == Promotion) {
                RecherchePanel(4);
                panelB.setVisible(false);
            }
            if (e.getSource() == Salle) {
                RecherchePanel(5);
                panelB.setVisible(false);
            }
        }
    }
    
    private void ResultPanel(int type) throws SQLException, ClassNotFoundException {
        
        if(type == 1){//ETUDIANT
            String NOM = nom.getText().toUpperCase();
            String PRENOM = prenom.getText(); 
            Utilisateur utilisateurEtudiant= new Utilisateur();
            utilisateurEtudiant= controleur.findUtilisateurEtudiant(NOM,PRENOM);
            if(utilisateurEtudiant!=null)
            {
                System.out.println("Recherche"+utilisateurEtudiant.getID());
                Controleur controleurRechercheEtudiant = new ControleurEtudiant(utilisateurEtudiant.getID());
                Edt fenetre = new Edt(controleurRechercheEtudiant,true);
            }
            else
                 JOptionPane.showMessageDialog(null, "Etudiant introuvable");
        }
        
        if(type == 2){//ENSEIGNANT
            String NOM = nom.getText().toUpperCase();
            String PRENOM = prenom.getText(); 
            Utilisateur utilisateurEnseignant= new Utilisateur();
            utilisateurEnseignant= controleur.findUtilisateurEnseignant(NOM,PRENOM);
            if(utilisateurEnseignant!=null)
            {
                System.out.println("Recherche"+utilisateurEnseignant.getID());
                Controleur controleurRechercheEnseignant = new ControleurEnseignant(utilisateurEnseignant.getID());
                Edt fenetre = new Edt(controleurRechercheEnseignant,true);
            }
            else
                 JOptionPane.showMessageDialog(null, "Enseignant introuvable");
        }
        
        if(type == 3){//TD
            String NOM = nom.getText().toUpperCase();
            String PROMO = "Promo " + promo.getSelectedItem().toString();
            System.out.println(NOM + PROMO);
            
            Groupe td = new Groupe();
            td = controleur.findGroupe(NOM,PROMO);
            if(td!=null)
            {
                System.out.println("Recherche"+td.getID());
                Controleur controleurRechercheTD = new ControleurGroupe(td.getID());
                Edt fenetre = new Edt(controleurRechercheTD,true);
            }
            else
                 JOptionPane.showMessageDialog(null, "TD introuvable");
        }
        
        if(type == 4){//PROMO
            String NOM = nom.getText(); 
            Promotion promo = new Promotion();
            promo = controleur.findPromotion(NOM);
            if(promo!=null)
            {
                System.out.println("Recherche"+promo.getID());
                Controleur controleurRecherchePromo = new ControleurPromotion(promo.getID());
                Edt fenetre = new Edt(controleurRecherchePromo,true);
            }
            else
                 JOptionPane.showMessageDialog(null, "Promotion introuvable");
        }
        
        if(type == 5){//SALLE
            String NOM = nom.getText();
            Salle salle = new Salle();
            salle = controleur.findSalle(NOM);
            if(salle!=null)
            {
                System.out.println("Recherche"+salle.getID());
                Controleur controleurRechercheSalle = new ControleurSalle(salle.getID());
                Edt fenetre = new Edt(controleurRechercheSalle,true);
            }
            else
                 JOptionPane.showMessageDialog(null, "Salle introuvable");
        }
        
        
    }
    
}