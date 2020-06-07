package Vue;

import Controleur.Controleur;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.*;
import java.awt.event.*;

/**
 * 
 * Bar Menu
 * @author Clemence
 */
public class Menu  extends JMenuBar{
    //Admin
    private final JMenuItem m1 = new JMenuItem("Emploi du temps");
    private final JMenuItem m2 = new JMenuItem("Récapitulatif cours");
    private final JMenuItem m3 = new JMenuItem("Ajouter un cours");
   
    //Referent pedagogique
    private JMenu m4 = new JMenu("Recherche");
    private JMenu m5 = new JMenu("Mes horaires");
    private JMenuItem RechEdt = new JMenuItem("Emploi du temps");
    private JMenuItem RechRecap = new JMenuItem("Récapitulatif cours");
    private JMenuItem MonEdt = new JMenuItem("Emploi du temps");
    private JMenuItem MonRecap = new JMenuItem("Récapitulatif cours");
    
    //Profs et élèves
    private JMenuItem m1bis = new JMenuItem("Emploi du temps");
    private JMenuItem m2bis = new JMenuItem("Récapitulatif cours");
    
    public Menu(int droits, Controleur controleur){///1:admin; 2:Ref. pedag.; 3: profs et élève
        
        this.m1.setBackground(new Color(0,128,128));
        //this.m1.addActionListener(new EnterButtonListener());
        this.m1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                new RechercheEdt(controleur);
            }
        });
        
        this.m2.setBackground(new Color(0,128,128));
        //this.m2.addActionListener(new EnterButtonListener());
        this.m2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                new RechercheRecap(controleur);
            }
        });
        
        this.m3.setBackground(new Color(0,128,128));
        //this.m3.addActionListener(new EnterButtonListener());
        this.m3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                new Ajout(controleur);
            }
        });
        
        this.m1bis.setBackground(new Color(0,128,128));
        //this.m1bis.addActionListener(new EnterButtonListener());
        this.m1bis.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                new Edt(controleur,false);
            }
        });
        
        this.m2bis.setBackground(new Color(0,128,128));
        //this.m2bis.addActionListener(new EnterButtonListener());
        this.m2bis.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                new Recap(controleur);
            }
        });
        
        //this.RechEdt.addActionListener(new EnterButtonListener());
        this.RechEdt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                new RechercheEdt(controleur);
            }
        });
        
        //this.RechRecap.addActionListener(new EnterButtonListener());
        this.RechRecap.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                new RechercheRecap(controleur);
            }
        });
        //this.MonEdt.addActionListener(new EnterButtonListener());
        this.MonEdt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                new Edt(controleur, false);
            }
        });
        //this.MonRecap.addActionListener(new EnterButtonListener());
        this.MonRecap.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                new Recap(controleur);
            }
        });
        
        if(droits==1){//Admin
            this.add(m1);
            this.add(m2);
            this.add(m3);
        }
        
        if(droits==2){//Referent pedagogique
            this.m4.add(RechEdt);            
            this.m4.add(RechRecap);
            this.m5.add(MonEdt);            
            this.m5.add(MonRecap);

            this.add(m4);
            this.add(m5);
        }
        
        if(droits==3){//Profs et élèves
            this.add(m1bis);
            this.add(m2bis);
        }
        
        this.setBackground(new Color(0,128,128));
        this.setForeground(Color.WHITE);

        setVisible(true);
    }
    
    /*private class EnterButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if ((e.getSource() == m1) || (e.getSource() == RechEdt)) {
                new RechercheEdt();
            }

            if ((e.getSource() == m2) || (e.getSource() == RechRecap)) {
                new RechercheRecap();
            }
            
            if (e.getSource() == m3) {
                new Ajout();
            }
            
            if ((e.getSource() == m1bis) || (e.getSource() == MonEdt)) {
                new Edt();
            }
            if ((e.getSource() == m2bis) || (e.getSource() == MonRecap)) {
                new Recap();
            }
            
            

        }
    }*/
    
    //public static void main(String[] args) {}
}
