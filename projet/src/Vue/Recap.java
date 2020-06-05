
package Vue;

import Modele.Seance;
import Controleur.ControleurEtudiant;
import Modele.Cours;
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
        
      
        ArrayList<Seance> Seances = controleur.getSeances();
        ArrayList<Cours> cours = controleur.getCours();
        //ArrayList<Integer> lesIdCours = new ArrayList<Integer>();
        
        ArrayList<Seance> chaqueCours = new ArrayList<Seance>();
        LocalDate dO;
        LocalDate dF;
        int n;
        int[] nb = {0,0,0,0,0,0,0,0,0,0};
        String nom;
        
        //Trier par matiere
        for(int k=1; k<=10; k++){
            for(int i=0; i<Seances.size();i++){
                if(Seances.get(i).getID_COURS()==k)
                    chaqueCours.add(Seances.get(i));
            }
        }
        
        Object[][] data = new Object[10][4];    
        
        for(int x=1; x<=10; x++){
            dO = LocalDate.of(2020, 07, 30);
            dF = LocalDate.of(2020, 01, 01);
            n=0;
            nom = cours.get(x).getNOM();
            for(int j=0; j<chaqueCours.size(); j++){
                if(chaqueCours.get(j).getID_COURS()==x){//si c'est la meme matiere
                    if((chaqueCours.get(j).getDATE()).isBefore(dO))
                            dO = (chaqueCours.get(j).getDATE());
                        if((chaqueCours.get(j).getDATE()).isAfter(dF))
                            dF = (chaqueCours.get(j).getDATE());

                    nom = chaqueCours.get(j).getCOURS(chaqueCours.get(j).getID_COURS());
                    n++;//Une séance en plus
                }
            }
            data[x-1][0]= nom;
            data[x-1][1]= dO;
            data[x-1][2]= dF;
            data[x-1][3]= n;
        }
            //System.out.println(chaqueCours.get(j).getCOURS(chaqueCours.get(j).getID_COURS()));
        
        /*     nb[0]++;
            if(Seances.get(i).getID_COURS()==2)//phy
                nb[1]++;
            if(Seances.get(i).getID_COURS()==3)//elec
                nb[2]++;
            if(Seances.get(i).getID_COURS()==4)//info
                nb[2]++;
            if(Seances.get(i).getID_COURS()==5)//anglais
                nb[3]++;
            if(Seances.get(i).getID_COURS()==6)//TDG
                nb[4]++;
            if(Seances.get(i).getID_COURS()==7)//Analyse
                nb[5]++;
            if(Seances.get(i).getID_COURS()==8)//PSTE
                nb[6]++;
            if(Seances.get(i).getID_COURS()==9)//Arabe
                nb[7]++;
            if(Seances.get(i).getID_COURS()==10)//DDT
                nb[9]++;*/
        
        /*int cours1 = Seances.get(0).getID_COURS();
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
        System.out.println(Seances.size());
        System.out.println(lesIdCours.size());
        
        
        //Trier par matière
        for(int x=0; x<lesIdCours.size(); x++){
            
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
            
        }*/
        return data;
    }
    
    public static void main(String[] args) {
        //new Recap();
    }
}
