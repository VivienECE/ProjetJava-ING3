
package Vue;

import Controleur.Controleur;
import Controleur.ControleurAdmin;
import Modele.Cours;
import Modele.Enseignant;
import Modele.Seance;
import Modele.Seance_enseignants;
import Modele.Seance_groupes;
import Modele.Seance_salles;
import Modele.Utilisateur;
//import Controleur.ControleurEtudiant;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.IsoFields;
import java.util.Calendar;
import javax.swing.JMenu;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.Border;
import java.sql.*;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;

public class Ajout extends JFrame{
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    private JPanel panel6;
    private final JButton btn;
    private JPanel content;
    private DateTextField picker;
    private JTextField heureD;
    private JTextField heureF;
    private JTextField minD;
    private JTextField minF;
    private JComboBox cours;
    private JRadioButton td1;
    private JRadioButton td2;
    private JRadioButton td3;
    private JRadioButton e1;
    private JRadioButton e2;
    private JRadioButton e3;
    private JRadioButton e6;
    private JComboBox txt2;
    private JComboBox prom;
    private int id;
    private ArrayList<Utilisateur> profs;
    private Controleur controleur;
    
    public Ajout(ControleurAdmin controleur){
        this.setTitle("Ajout d'un cours");
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        Menu m = new Menu(1);
        this.setJMenuBar(m);
        this.controleur=controleur;
        //this.setLayout(new GridLayout(6,2));
        Form();
        
        this.add(content, BorderLayout.NORTH);
        btn = new JButton("Ajouter");
        btn.setSize(100, 20);
        btn.addActionListener(new AddButtonListener());
        profs = controleur.getUtilisateurEnseignants();
        id = (controleur.getSeances().size())+1;
        this.add(btn, BorderLayout.SOUTH);
        
    }
        
    private void Form(){
        panel1= new JPanel();
        JLabel nom = new JLabel("Intitulé de la séance : ");
        panel1.add(nom);
        cours = new JComboBox();
        for(Cours i: controleur.getCours())
                    cours.addItem(i.getNOM());

        panel1.add(cours);
        
        panel2= new JPanel();
        JLabel prof = new JLabel("Professeur : ");
        txt2 = new JComboBox();
        for(Enseignant j: controleur.getEnseignants())
        {
             if(j.getID_COURS()==1)
                    txt2.addItem(controleur.getUtilisateurEnseignants().get(controleur.getEnseignants().indexOf(j)).getNOM());
        }
        
        panel2.add(txt2);
        
        
        panel3= new JPanel();
        JLabel promo = new JLabel("Promotion : ");
        panel3.add(promo);
        prom = new JComboBox();
        prom.addItem("ING1");
        prom.addItem("ING2");
        prom.addItem("ING3");
        prom.addItem("ING4");
        prom.addItem("ING5");
        panel3.add(prom);
        
        panel4= new JPanel();
        td1 = new JRadioButton("TD1");
        td2 = new JRadioButton("TD2");
        td3 = new JRadioButton("TD3");
        panel4.add(td1);
        panel4.add(td2);
        panel4.add(td3);
        
        panel5 = new JPanel();
        JLabel date = new JLabel("Créneau : ");
        panel5.add(date);
        picker = new DateTextField();
        panel5.add(picker);
        JLabel a = new JLabel("  de  ");
        panel5.add(a);
        heureD = new JTextField(2);
        panel5.add(heureD);
        JLabel b = new JLabel(" h ");
        panel5.add(b);
        minD = new JTextField(2);
        panel5.add(minD);
        JLabel c = new JLabel("  à  ");
        panel5.add(c);
        heureF = new JTextField(2);
        panel5.add(heureF);
        JLabel d = new JLabel(" h ");
        panel5.add(d);
        minF = new JTextField(2);
        panel5.add(minF);
        
        panel6 = new JPanel();
        JLabel bat = new JLabel("Site : ");
        panel6.add(bat);
        JRadioButton e1 = new JRadioButton("E1");
        JRadioButton e2 = new JRadioButton("E2");
        JRadioButton e3 = new JRadioButton("E3");
        JRadioButton e6 = new JRadioButton("CNAM");
        panel6.add(e1);
        panel6.add(e2);
        panel6.add(e3);
        panel6.add(e6);
        
        content = new JPanel();
        content.add(panel1);
        content.add(panel2);
        content.add(panel3);
        content.add(panel4);
        content.add(panel5);
        content.add(panel6);
        
        content.setLayout(new GridLayout(6,2));
        
        setVisible(true);
        cours.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JComboBox comboBox = (JComboBox) event.getSource();
                Object selected = comboBox.getSelectedItem();
                txt2.removeAllItems();
                for(Enseignant j: controleur.getEnseignants())
                 {
                      if(controleur.findCours(j.getID_COURS()).getNOM().equals(selected.toString()))
                    txt2.addItem(controleur.getUtilisateurEnseignants().get(controleur.getEnseignants().indexOf(j)).getNOM());
                 }
            }
        });

    }
    

    
    private class AddButtonListener implements ActionListener {
         
        int sem;
        LocalDate date;
        LocalTime HEURE_DEBUT;
        LocalTime HEURE_FIN; 
        int etat=0;
        int IdCOURS=0;
        int IdTYPE, idEnseignant, idSalle, idGroupe, idProm;
        String type;
        
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btn) {
                
                date = Instant.ofEpochMilli(picker.getDate().getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
                
                sem = date.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR );
                
                HEURE_DEBUT = LocalTime.of(Integer.parseInt(heureD.getText()), Integer.parseInt(minD.getText()), 0);
                
                HEURE_FIN = LocalTime.of(Integer.parseInt(heureF.getText()), Integer.parseInt(minF.getText()), 0);
                
                //IdCOURS
                for(Cours i: controleur.getListeCours())
                    if(cours.getSelectedItem()==i.getNOM())
                        IdCOURS = i.getID();
                
                /*if(cours.getSelectedItem()=="Mathematiques")
                    IdCOURS = 1;
                if(cours.getSelectedItem()=="Physique")
                    IdCOURS = 2;
                if(cours.getSelectedItem()=="Electronique")
                    IdCOURS = 3;
                if(cours.getSelectedItem()=="Informatique")
                    IdCOURS = 4;
                if(cours.getSelectedItem()=="Anglais")
                    IdCOURS = 5;
                if(cours.getSelectedItem()=="Théorie des Graphes")
                    IdCOURS = 6;
                if(cours.getSelectedItem()=="Analyse")
                    IdCOURS = 7;
                if(cours.getSelectedItem()=="PSTE")
                    IdCOURS = 8;
                if(cours.getSelectedItem()=="Arabe")
                    IdCOURS = 9;
                if(cours.getSelectedItem()=="Droit du Travail")
                    IdCOURS = 10;*/
                
                //IdTYPE
                if(td1.isSelected()&&td2.isSelected()&&td3.isSelected()){
                    IdTYPE = 3;//On considere que si tous les TDs sont selectionnes, il s'agit d'un examen
                    type = "EXAMEN";
                }

                int nb =0;
                if(td1.isSelected())nb++;
                if(td2.isSelected())nb++;
                if(td3.isSelected())nb++;
                if(nb>1){
                    IdTYPE = 2;
                    type = "TD";
                }
                    
                else{
                    IdTYPE = 1;
                    type = "COURS";
                }
                
                //Prof
                /*for(int i=0; i<profs.size(); i++){
                    if(txt2.getText().toLowerCase()== profs.get(i).getNOM().toLowerCase())
                        idEnseignant = profs.get(i).getID();
                }*/
                
                //PROMO
                if(prom.getSelectedItem()=="ING1")
                    idProm=1;
                if(prom.getSelectedItem()=="ING2")
                    idProm=2;
                if(prom.getSelectedItem()=="ING3")
                    idProm=3;
                if(prom.getSelectedItem()=="ING4")
                    idProm=4;
                if(prom.getSelectedItem()=="ING5")
                    idProm=5;
                  
                //TD
                if(td1.isSelected()){
                    if(idProm==1)
                        idGroupe=1;
                    if(idProm==2)
                        idGroupe=4;
                    if(idProm==3)
                        idGroupe=7;
                    if(idProm==4)
                        idGroupe=10;
                    if(idProm==5)
                        idGroupe=13;
                    Seance_groupes NvGroupes = new Seance_groupes(id,idGroupe);
                }
                if(td2.isSelected()){
                    if(idProm==1)
                        idGroupe=2;
                    if(idProm==2)
                        idGroupe=5;
                    if(idProm==3)
                        idGroupe=8;
                    if(idProm==4)
                        idGroupe=11;
                    if(idProm==5)
                        idGroupe=14;
                    Seance_groupes NvGroupes = new Seance_groupes(id,idGroupe);
                }

                if(td3.isSelected()){
                    if(idProm==1)
                        idGroupe=3;
                    if(idProm==2)
                        idGroupe=6;
                    if(idProm==3)
                        idGroupe=9;
                    if(idProm==4)
                        idGroupe=12;
                    if(idProm==5)
                        idGroupe=15;
                    Seance_groupes NvGroupes = new Seance_groupes(id,idGroupe);
                }
                
                
                
                
                //Salle
                if(e1.isSelected())
                    idSalle = (int)Math.random() * ( 7 - 1 );
                if(e2.isSelected())
                    idSalle = (int)Math.random() * ( 13 - 8 );
                if(e3.isSelected())
                    idSalle = (int)Math.random() * ( 21 - 14 );
                if(e6.isSelected())
                    idSalle = 22;
                
                Seance NvCours = new Seance(id, sem, date, HEURE_DEBUT, HEURE_FIN, etat, IdCOURS, IdTYPE);
                
                Seance_enseignants NvEnseignant = new Seance_enseignants(id, idEnseignant);
                
                Seance_salles NvSalles = new Seance_salles(id, idSalle);
                
                //NvCours.setEnseignant(txt2.getText());
                //NvCours.setType(type);
                //NvCours.setSalle();
                //NvCours.setSite();
                //NvCours.setCours(cours.getSelectedItem());
                System.out.println(id);
                System.out.println(sem);
                System.out.println(date);
                System.out.println(HEURE_DEBUT);
                System.out.println(HEURE_FIN);
                System.out.println(etat);
                System.out.println(IdCOURS);
                System.out.println(IdTYPE);
                System.out.println(type);
            }

        }
    }
    
}
