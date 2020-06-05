
package Vue;

import Controleur.Controleur;
import Controleur.ControleurEnseignant;
import Controleur.ControleurEtudiant;
import DAO.DAO;
import DAO.EtudiantDAO;
import Modele.Etudiant;
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
    
    public RechercheEdt(Controleur controleur) {
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
    
    private void RecherchePanel(int type, Controleur controleur) {
      
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
       JLabel mess1bisP = new JLabel("Prenom : ");
       prenom = new JTextField(10);
       //JLabel mess2 = new JLabel(" pendant la semaine du : ");
       //picker = new DateTextField();
       Submit = new JButton("Rechercher");
       Submit.addActionListener(new RechercheEdt.AddButtonListener());
       
       affichage = new JComboBox();
       affichage.addItem("en grille");
       affichage.addItem("en liste");
       
        panel1.add(mess1bis);
        panel1.add(nom);
        panel1.add(prenom);
        //panel1.add(mess2);
        //panel1.add(picker);
        panel1.add(affichage);
        panel1.add(Submit);

        pack();
        setVisible(true);

    }
    public class AddButtonListener implements ActionListener {
        Controleur controleur;
        Connexion connection;
        public void actionPerformed(ActionEvent e) {
            
            if (e.getSource() == Eleve) {
                RecherchePanel(1, controleur);
                panelB.setVisible(false);   
            }
            if (e.getSource() == Professeur) {
                RecherchePanel(2, controleur);
                panelB.setVisible(false);
            }
            if (e.getSource() == TD) {
                RecherchePanel(3, controleur);
                panelB.setVisible(false);
            }
            if (e.getSource() == Promotion) {
                RecherchePanel(4, controleur);
                panelB.setVisible(false);
            }
            if (e.getSource() == Salle) {
                RecherchePanel(5, controleur);
                panelB.setVisible(false);
            }
            if (e.getSource() == Submit){
                    picker.getDate();
                }
            if (e.getSource() == Submit){
                try {
                    ResultPanel(controleur);
                } catch (SQLException ex) {
                    Logger.getLogger(RechercheEdt.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(RechercheEdt.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    private void ResultPanel(Controleur controleur) throws SQLException, ClassNotFoundException {
        String NOM = nom.getText();
        String PRENOM = prenom.getText();
        DAO<Etudiant> etudiantDAO = new EtudiantDAO(controleur.getConnexion());  
        Etudiant etudiant = etudiantDAO.find(NOM,PRENOM);
    }
    
    /*public static void main(String[] args) {
        new RechercheEdt();
    }*/
}