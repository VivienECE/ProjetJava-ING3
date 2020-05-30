
package Vue;


import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JMenu;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class RechercheEdt extends JFrame{
    private JPanel panel1;
    private JPanel panel2;
    
    public RechercheEdt() {
        this.setTitle("Emploi du temps");
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        Menu m = new Menu(1);
        this.setJMenuBar(m);
        RecherchePanel();
        this.add(panel1, BorderLayout.NORTH);
        ResultPanel();
        this.add(panel2, BorderLayout.SOUTH);
    }
    
    private void RecherchePanel() {
       JLabel mess1 = new JLabel("Emploi du temps de : ");
       
       JComboBox type = new JComboBox();
       type.addItem("Saisie du nom");
       type.addItem("Saisie du TD");
       type.addItem("Saisie de la promo");
       type.addItem("Saisie de la salle");
       type.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent arg0){
        }
        });
       JTextField UTextField = new JTextField(10);
       JLabel mess2 = new JLabel(" pendant la semaine du : ");
       DateTextField picker = new DateTextField();
       JButton Submit = new JButton("Rechercher");
       
       JComboBox affichage = new JComboBox();
       affichage.addItem("en grille");
       affichage.addItem("en liste");
       affichage.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent arg0){
        }
        });

        panel1 = new JPanel();
        panel1.add(mess1);
        panel1.add(type);
        panel1.add(UTextField);
        panel1.add(mess2);
        panel1.add(picker);
        panel1.add(affichage);
        panel1.add(Submit);

        pack();
        setVisible(true);

    }
    
    private void ResultPanel() {
       
  
        panel2 = new JPanel();

    }
    
    public static void main(String[] args) {
        new RechercheEdt();
    }
}