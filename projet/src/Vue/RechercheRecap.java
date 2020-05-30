/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

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

public class RechercheRecap extends JFrame {

    private JPanel panel1;
    private JPanel panel2;
    
    public RechercheRecap() {
        this.setTitle("Recapitilatif des cours");
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        Menu m = new Menu(1);
        this.setJMenuBar(m);
        this.setLayout(new GridLayout(0,1));
        RecherchePanel();
        this.add(panel1);
        ResultPanel();
        this.add(panel2);
    }
    
    private void RecherchePanel() {
       JLabel mess1 = new JLabel("Recapitilatif des cours de : ");
       JTextField UTextField = new JTextField(10);
       JLabel mess2 = new JLabel(" pendant la semaine du : ");
       DateTextField picker = new DateTextField();
       JButton Submit = new JButton("Rechercher");

        panel1 = new JPanel();
        panel1.add(mess1);
        panel1.add(UTextField);
        panel1.add(mess2);
        panel1.add(picker);
        panel1.add(Submit);

        pack();
        setVisible(true);

    }
    
    private void ResultPanel() {
       
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

    /*private class EnterButtonListener implements ActionListener {
    okBouton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent arg0) {        
        zInfo = new ZDialogInfo(nom.getText(), (String)sexe.getSelectedItem(), getAge(), (String)cheveux.getSelectedItem() ,getTaille());
        setVisible(false);
      }

        @Override
        public void actionPerformed(ActionEvent e) {

            String u, p;
            int j = 0;

            if (e.getSource() == customer) {
                JOptionPane.showMessageDialog(null, "Connected As The Customer");
                new Customer();
            }

            if (e.getSource() == Submit) {

                u = UTextField.getText();
                p = PTextField.getText();
                try {

                    Scanner file = new Scanner(new File("/Users/baperondard/Downloads/ProjectBapeLarys/src/projectbapelarys/admin.txt"));

                    while (file.hasNextLine()) {
                        String scan1 = file.nextLine();
                        String scan2 = file.nextLine();

                        if (scan1.equals(u)) {
                            if (scan2.equals(p)) {
                                j = j + 1;

                            }
                        }
                    }

                    if (j > 0) {

                        JOptionPane.showMessageDialog(null, "connection succesful");
                        new admin();
                        setVisible(false);
                        dispose();

                    }

                    if (j < 1) {

                        JOptionPane.showMessageDialog(null, "wrong username or password");
                        UTextField.setText("");
                        PTextField.setText("");

                    }

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }*/

 
    public static void main(String[] args) {
        new RechercheRecap();
    }
}
