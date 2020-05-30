
package Vue;

/*import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;*/
import java.awt.Color;
import java.awt.BorderLayout;
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


public class Recap extends JFrame{
    private JPanel panel1;
    private JPanel panel2;
    
    public Recap() {
        this.setTitle("Récapitilatif des cours");
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        Menu m = new Menu(3);
        this.setJMenuBar(m);
        //this.setLayout(new GridLayout(0,1));
        ResultPanel();
        this.add(panel1, BorderLayout.NORTH);
        this.add(panel2, BorderLayout.SOUTH);
        setVisible(true);
        
    }
    
    private void ResultPanel() {
       
        panel1 = new JPanel();
        JLabel infos = new JLabel("Prénom + Nom + TD + Promo ");
        panel1.add(infos);
    //Les données du tableau
        Object[][] data = {
          {"Math", "28/03/19", "15/06/19", "5"},
          {"Physique", "24/03/19", "12/06/19", "5"},
          {"Elec", "26/03/19", "13/06/19", "5"},
          {"Info", "15/05/19", "15/05/19", "1"}
        };

        //Les titres des colonnes
        String  title[] = {"Matiere - Public", "Premiere seance", "Derniere seance", "Nb."};
        JTable tableau = new JTable(data, title);
        //Nous ajoutons notre tableau à notre contentPane dans un scroll
        //Sinon les titres des colonnes ne s'afficheront pas !
        panel2 = new JPanel();
        panel2.add(tableau);
        getContentPane().add(new JScrollPane(tableau));
        

    }
    
    public static void main(String[] args) {
        new Recap();
    }
}
