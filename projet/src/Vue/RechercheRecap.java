/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controleur.Controleur;
import Controleur.ControleurEnseignant;
import Controleur.ControleurEtudiant;
import Controleur.ControleurGroupe;
import Controleur.ControleurPromotion;
import Controleur.ControleurSalle;
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
import java.util.Calendar;
import javax.swing.JMenu;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class RechercheRecap extends JFrame {

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
    private JComboBox promo;
    private DateTextField picker;
    private Controleur controleur;
    
    public RechercheRecap(Controleur controleur) {
        this.controleur = controleur;
        this.setTitle("Récapitulatif des cours");
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(0,1));
        Menu m = new Menu(1,controleur);
        this.setJMenuBar(m);
        
        panelB = new JPanel();
        JLabel mess1 = new JLabel("Récapitulatif des cours d'un(e) : ");
        panelB.add(mess1);
        
        Eleve = new JButton("Elève");
        Eleve.addActionListener(new RechercheRecap.AddButtonListener());
        panelB.add(Eleve);
        Professeur = new JButton("Professeur");
        Professeur.addActionListener(new RechercheRecap.AddButtonListener());
        panelB.add(Professeur);
        TD = new JButton("TD");
        TD.addActionListener(new RechercheRecap.AddButtonListener());
        panelB.add(TD);
        
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
                Recap fenetre = new Recap(controleurRechercheEtudiant);
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
                Recap fenetre = new Recap(controleurRechercheEnseignant);
            }
            else
                 JOptionPane.showMessageDialog(null, "Enseignant introuvable");
        }
        
        if(type == 3){//TD
            String NOM = nom.getText().toUpperCase();
            String PROMO = promo.getSelectedItem().toString();
            
            Groupe td = new Groupe();
            td = controleur.findGroupe(NOM,PROMO);
            if(td!=null)
            {
                System.out.println("Recherche"+td.getID());
                Controleur controleurRechercheTD = new ControleurGroupe(td.getID());
                Recap fenetre = new Recap(controleurRechercheTD);
            }
            else
                 JOptionPane.showMessageDialog(null, "TD introuvable");
        }
        
    }

}
