
package Vue;

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
import java.util.Calendar;
import javax.swing.JMenu;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.Border;

public class Ajout extends JFrame{
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    private JPanel panel6;
    private JButton btn;
    private JPanel content;
    
    public Ajout(){
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
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {        
              Seance NvCours = new Seance(nom.getText(), (String)sexe.getSelectedItem(), getAge(), (String)cheveux.getSelectedItem() ,getTaille());
            }});
        this.add(btn, BorderLayout.SOUTH);
        
    }
        
    private void Form(){
        panel1= new JPanel();
        JLabel nom = new JLabel("Intitulé de la séance : ");
        panel1.add(nom);
        JTextField txt1 = new JTextField(10);
        panel1.add(txt1);
        
        panel2= new JPanel();
        JLabel prof = new JLabel("Professeur : ");
        panel2.add(prof);
        JTextField txt2 = new JTextField(10);
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
        prom.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
        }
        });
        panel3.add(prom);
        
        panel4= new JPanel();
        JRadioButton td1 = new JRadioButton("TD1");
        JRadioButton td2 = new JRadioButton("TD2");
        JRadioButton td3 = new JRadioButton("TD3");
        JRadioButton td4 = new JRadioButton("TD4");
        JRadioButton td5 = new JRadioButton("TD5");
        JRadioButton td6 = new JRadioButton("TD6");
        JRadioButton td7 = new JRadioButton("TD7");
        JRadioButton td8 = new JRadioButton("TD8");
        JRadioButton td9 = new JRadioButton("TD9");
        JRadioButton td10 = new JRadioButton("TD10");
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
        DateTextField picker = new DateTextField();
        panel5.add(picker);
        JLabel a = new JLabel("  de  ");
        panel5.add(a);
        JTextField heureD = new JTextField(2);
        panel5.add(heureD);
        JLabel b = new JLabel(" h ");
        panel5.add(b);
        JTextField minD = new JTextField(2);
        panel5.add(minD);
        JLabel c = new JLabel("  à  ");
        panel5.add(c);
        JTextField heureF = new JTextField(2);
        panel5.add(heureF);
        JLabel d = new JLabel(" h ");
        panel5.add(d);
        JTextField minF = new JTextField(2);
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
    
    
    public static void main(String[] args) {
        new Ajout();
    }
}
