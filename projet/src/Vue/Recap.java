
package Vue;

import Modele.Seance;
import Controleur.ControleurEtudiant;
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
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JMenu;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class Recap extends JFrame{
    private JPanel panel1;
    private JPanel panel2;
    
    public Recap(ControleurEtudiant controleur) {
        this.setTitle("Récapitilatif des cours");
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        Menu m = new Menu(3);
        this.setJMenuBar(m);
        //this.setLayout(new GridLayout(0,1));
        ResultPanel(controleur);
        this.add(panel1, BorderLayout.NORTH);
        this.add(panel2, BorderLayout.SOUTH);
        setVisible(true);
        
    }
    
    private void ResultPanel(ControleurEtudiant controleur) {
       
        panel1 = new JPanel();
        JLabel infos = new JLabel("Récapitulatif des cours de "+controleur.getUtilisateur().getNOM()+" "
                                +controleur.getUtilisateur().getPRENOM()+" "
                                +controleur.getGroupe().getNOM()+" "
                                +controleur.getPromotion().getNOM()+" ");
        panel1.add(infos);
    //Les données du tableau
        Object[][] data = Tri(controleur);

        //Les titres des colonnes
        String  title[] = {"Matiere - Public", "Premiere seance", "Derniere seance", "Nb."};
        JTable tableau = new JTable(data, title);
        //Nous ajoutons notre tableau à notre contentPane dans un scroll
        //Sinon les titres des colonnes ne s'afficheront pas !
        panel2 = new JPanel();
        panel2.add(tableau);
        getContentPane().add(new JScrollPane(tableau));
        

    }
    
    public Object[][] Tri(ControleurEtudiant controleur){
        
        //Seance[] total = new Seance[size]; 
        ArrayList<Seance> Seances = controleur.getSeances();
        ArrayList<Integer> lesIdCours = new ArrayList<Integer>();
        LocalDate dO;
        LocalDate dF;
        int n;
        String nom;
        
        //Voir combien de matiere differentes
        int cours1 = Seances.get(0).getID_COURS();
        lesIdCours.add(0,cours1);
        
        for(int i = 1; i < Seances.size(); i++)
        {
            for(int j=0; j<lesIdCours.size(); j++){
                if(Seances.get(i).getID_COURS()!= lesIdCours.get(j))
                {
                    lesIdCours.add(Seances.get(i).getID_COURS());
                }
            }
        } 
        
        Object[][] data = new Object[lesIdCours.size()][4];
        //Trier par matière
        for(int x=0; x<lesIdCours.size(); x++){
            dO = LocalDate.of(2020, 07, 30);
            dF = LocalDate.of(2020, 01, 01);
            n=0;
            nom = "";
            for(int k=0; k<Seances.size(); k++){
                if(Seances.get(k).getID_COURS()== lesIdCours.get(x)){
                    if((Seances.get(k).getDATE()).isBefore(dO))
                        dO = (Seances.get(k).getDATE());
                    if((Seances.get(k).getDATE()).isAfter(dF))
                        dF = (Seances.get(k).getDATE());
                    
                    nom = Seances.get(k).getCOURS(lesIdCours.get(x));
                    n++;//Une séance en plus
                }
            }
            data[x][0]= nom;
            data[x][1]= dO;
            data[x][2]= dF;
            data[x][3]= n;
            
        }
        return data;
    }
    
    public static void main(String[] args) {
        //new Recap();
    }
}
