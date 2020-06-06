
package Vue;

import Controleur.Controleur;
import Modele.Seance;
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
    private JRadioButton td4;
    private JRadioButton td5;
    private JRadioButton td6;
    private JRadioButton td7;
    private JRadioButton td8;
    private JRadioButton td9;
    private JRadioButton td10;
    private JTextField txt2;
    private int id;
    
    public Ajout(Controleur controleur){
        this.setTitle("Ajout d'un cours");
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        Menu m = new Menu(1);
        this.setJMenuBar(m);
        //this.setLayout(new GridLayout(6,2));
        Form();
        
        this.add(content, BorderLayout.NORTH);
        btn = new JButton("Ajouter");
        btn.setSize(100, 20);
        btn.addActionListener(new AddButtonListener());
        id = (controleur.getSeances().size())+1;
        this.add(btn, BorderLayout.SOUTH);
        
    }
        
    private void Form(){
        panel1= new JPanel();
        JLabel nom = new JLabel("Intitulé de la séance : ");
        panel1.add(nom);
        cours = new JComboBox();
        cours.addItem("Mathematiques");
        cours.addItem("Physique");
        cours.addItem("Electronique");
        panel1.add(cours);
        
        panel2= new JPanel();
        JLabel prof = new JLabel("Professeur : ");
        panel2.add(prof);
        txt2 = new JTextField(10);
        panel2.add(txt2);
        
        
        panel3= new JPanel();
        JLabel promo = new JLabel("Promotion : ");
        panel3.add(promo);
        JComboBox prom = new JComboBox();
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
        td4 = new JRadioButton("TD4");
        td5 = new JRadioButton("TD5");
        td6 = new JRadioButton("TD6");
        td7 = new JRadioButton("TD7");
        td8 = new JRadioButton("TD8");
        td9 = new JRadioButton("TD9");
        td10 = new JRadioButton("TD10");
        panel4.add(td1);
        panel4.add(td2);
        panel4.add(td3);
        panel4.add(td4);
        panel4.add(td5);
        panel4.add(td6);
        panel4.add(td7);
        panel4.add(td8);
        panel4.add(td9);
        panel4.add(td10);
        
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
        JRadioButton e4 = new JRadioButton("E4");
        JRadioButton e5 = new JRadioButton("E5");
        JRadioButton e6 = new JRadioButton("CNAM");
        panel6.add(e1);
        panel6.add(e2);
        panel6.add(e3);
        panel6.add(e4);
        panel6.add(e5);
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
    }
    

    
    private class AddButtonListener implements ActionListener {
         
        int sem;
        LocalDate date;
        LocalTime HEURE_DEBUT;
        LocalTime HEURE_FIN; 
        int etat=0;
        int IdCOURS=0;
        int IdTYPE;
        String type;
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            if (e.getSource() == btn) {
                
                date = picker.getDate().toLocalDate();
                
                sem = date.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR );
                
                HEURE_DEBUT = LocalTime.of(Integer.parseInt(heureD.getText()), Integer.parseInt(minD.getText()), 0);
                
                HEURE_FIN = LocalTime.of(Integer.parseInt(heureF.getText()), Integer.parseInt(minF.getText()), 0);
                
                //IdCOURS
                if(cours.getSelectedItem()=="Mathematiques")
                    IdCOURS = 1;
                if(cours.getSelectedItem()=="Physique")
                    IdCOURS = 2;
                if(cours.getSelectedItem()=="Electronique")
                    IdCOURS = 3;
                
                //IdTYPE
                if(td1.isSelected()&&td2.isSelected()&&td3.isSelected()&&td4.isSelected()&&td5.isSelected()
                        &&td6.isSelected()&&td7.isSelected()&&td8.isSelected()&&td9.isSelected()&&td10.isSelected()){
                    IdTYPE = 3;//On considere que si tous les TDs sont selectionnes, il s'agit d'un examen
                    type = "EXAMEN";
                }

                int nb =0;
                if(td1.isSelected())nb++;
                if(td2.isSelected())nb++;
                if(td3.isSelected())nb++;
                if(td4.isSelected())nb++;
                if(td5.isSelected())nb++;
                if(td6.isSelected())nb++;
                if(td7.isSelected())nb++;
                if(td8.isSelected())nb++;
                if(td9.isSelected())nb++;
                if(td10.isSelected())nb++;
                if(nb>1){
                    IdTYPE = 2;
                    type = "TD";
                }
                    
                else{
                    IdTYPE = 1;
                    type = "COURS";
                }
                    
                
                
                //Seance NvCours = new Seance(id, sem, date, HEURE_DEBUT, HEURE_FIN, etat, IdCOURS, IdTYPE);
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
    
    public static void main(String[] args) {
        new Ajout();
    }
}
