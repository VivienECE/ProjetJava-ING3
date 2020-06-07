
package Vue;

import Controleur.Controleur;
import Controleur.ControleurEnseignant;
import Modele.Seance;
import Controleur.ControleurEtudiant;
import Controleur.ControleurGroupe;
import Controleur.ControleurPromotion;
import Controleur.ControleurSalle;
import Modele.Cours;
import java.awt.BorderLayout;
import java.awt.GridLayout;
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
    

    
    public Recap(Controleur controleur) {
        this.setTitle("Récapitilatif des cours");
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        Menu m = new Menu(3,controleur);
        this.setJMenuBar(m);
        
        panelB = new JPanel();
        
        JButton btn = new JButton("Statistiques");
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                DefaultPieDataset piedataset = new DefaultPieDataset ( ) ;
                for (Cours cours :controleur.getCours())
                {
                     piedataset.setValue(cours.getNOM(),1);
                }
                JFreeChart chart = ChartFactory.createPieChart("Répartition", piedataset);
                PiePlot P=(PiePlot)chart.getPlot();
                ChartFrame frame = new ChartFrame("Camembert", chart);
                frame.setVisible(true);
                frame.setSize(450, 500);
            }

            /*@Override
            public void actionPerformed(ActionEvent ae) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }*/
        });
        panelB.add(btn);
        this.setLayout(new GridLayout(0,1));
        Infos(controleur);
        this.add(panel1, BorderLayout.NORTH);
        ResultPanel(controleur);
        this.add(panel2, BorderLayout.SOUTH);
        this.add(panelB, BorderLayout.SOUTH);
        setVisible(true);
 
    }     
    
    private void Infos(Controleur controleur){
        panel1 = new JPanel();
        String informations="";
        if((controleur instanceof ControleurEtudiant)== true)//SI ETUDIANT
            informations = "Récapitulatif des cours de "+controleur.getUtilisateur().getNOM()+" "
                    +controleur.getUtilisateur().getPRENOM()+" "
                    +controleur.getGroupe().getNOM()+" "
                    +controleur.getPromotion().getNOM()+" ";
        
        if((controleur instanceof ControleurEnseignant)== true)//SI ENSEIGNANT
            informations = "Récapitulatif des cours de "+controleur.getUtilisateur().getNOM()+" "+controleur.getUtilisateur().getPRENOM()+" ";
        
        if((controleur instanceof ControleurGroupe)==true)//SI TD
            informations = "Récapitulatif des cours du "+controleur.getGroupe().getNOM()+" "+controleur.getPromotion().getNOM()+" ";
        
        JLabel infos = new JLabel(informations);
        panel1.add(infos);
    }
    
    private void ResultPanel(Controleur controleur) {
       
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
    
    
    public Object[][] Tri(Controleur controleur){
        
      
        ArrayList<Seance> Seances = controleur.getSeances();

        ArrayList<Cours> cours = controleur.getCours();

        ArrayList<Seance> chaqueCours = new ArrayList<Seance>();
        LocalDate dO;
        LocalDate dF;
        int n;
        int nb = 0;
        int nC;
        String nom;
        
        //Trier par matiere
        for(int k=1; k<=10; k++){
            for(int i=0; i<Seances.size();i++){
                if(Seances.get(i).getID_COURS()==k)
                    chaqueCours.add(Seances.get(i));
            }
        }
        
        Object[][] data = new Object[10][4];    
        
        for(int y=1; y<=10; y++){
            nC = 0;
            for(int i=0; i<chaqueCours.size();i++){
                if(chaqueCours.get(i).getID_COURS()==y)
                    nC++;
            }
            if(nC>1)
                nC=1;
            nb=nb+nC;
        }
        
        for(int x=1; x<=nb; x++){
            dO = LocalDate.of(2020, 07, 30);
            dF = LocalDate.of(2020, 01, 01);
            n=0;
            nom = cours.get(x-1).getNOM();
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
