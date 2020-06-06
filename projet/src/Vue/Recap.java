
package Vue;

import Modele.Seance;
import Controleur.ControleurEtudiant;
import Modele.Cours;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JTable;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;


public class Recap extends JFrame{
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panelB;
    

    
    public Recap(ControleurEtudiant controleur) {
        this.setTitle("Récapitilatif des cours");
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        Menu m = new Menu(3);
        this.setJMenuBar(m);
        JButton btn = new JButton("Stat");
        
        panelB = new JPanel();
        panelB.add(btn);
        //this.setLayout(new GridLayout(0,1));
        ResultPanel(controleur);
        this.add(panel1, BorderLayout.NORTH);
        this.add(panel2, BorderLayout.SOUTH);
        this.add(panel2, BorderLayout.EAST);
        setVisible(true);
        
        btn.addActionListener(new ActionListener() {
                
            public void ActionPerformed (java.awt.event.ActionEvent evt){
                DefaultPieDataset piedataset = new DefaultPieDataset ( ) ; 
        piedataset.setValue( "Physique" , 10);
        piedataset.setValue( "Physique" , 20);
        piedataset.setValue( "Physique" , 15);
        piedataset.setValue( "Physique" , 12);
        
        JFreeChart chart = ChartFactory.createPieChart("Répartition", piedataset);
        PiePlot P=(PiePlot)chart.getPlot();
        ChartFrame frame = new ChartFrame("Camembert", chart);
        frame.setVisible(true);
        frame.setSize(450, 500);
            }
        });
        
        
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
        
        return data;
    }
    
    public static void main(String[] args) {
        //new Recap();
    }
}
