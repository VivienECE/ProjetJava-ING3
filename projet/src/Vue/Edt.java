
package Vue;

import Controleur.ControleurEtudiant;
import Modele.Seance;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

public class Edt extends JFrame{
    private JPanel panel1;
    private JPanel panel2;
    
    public Edt(ControleurEtudiant controleur) {
        this.setTitle("Emploi du temps");
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        Menu m = new Menu(3);
        this.setJMenuBar(m);
        //this.setLayout(new GridLayout(0,1));
        Infos(controleur);
        this.add(panel1, BorderLayout.NORTH);
        Grille(controleur);
        this.add(panel2, BorderLayout.SOUTH);
        setVisible(true);
    }
    
    private void Infos(ControleurEtudiant controleur){
        panel1 = new JPanel();
        JLabel infos = new JLabel("Emploi du temps de "+controleur.getUtilisateur().getNOM()+" "
                                +controleur.getUtilisateur().getPRENOM()+" "
                                +controleur.getGroupe().getNOM()+" "
                                +controleur.getPromotion().getNOM()+" ");
        panel1.add(infos);
    }
    
    private void Grille(ControleurEtudiant controleur){
        panel2 = new JPanel();
        
        JPanel Lundi = new JPanel();
        LocalDate date = LocalDate.of(2020, 06, 01);
        Object[][] TLundi = Journee(date, controleur);
        String jour = "Lundi";
        String  title[] = {jour, "", "", ""};
        JTable tableau = new JTable(TLundi, title);
        
        JPanel Mardi = new JPanel();
        JPanel Mercredi = new JPanel();
        JPanel Jeudi = new JPanel();
        JPanel Vendredi = new JPanel();
        JPanel Samedi = new JPanel();
        
        panel2.add(Lundi);
        panel2.add(Mardi);
        panel2.add(Mercredi);
        panel2.add(Jeudi);
        panel2.add(Vendredi);
        panel2.add(Samedi);
        
        panel2.setLayout(new GridLayout(6,1));
        
        //setVisible(true);
    }
    
    /*private void Liste(ControleurEtudiant controleur){
        panel2 = new JPanel();
        
        panel2.add();
    }*/
    
    public Object[][]Journee(LocalDate date, ControleurEtudiant controleur){
        ArrayList<Seance> Seances = controleur.getSeances();
        ArrayList<Seance> CoursAJD = new ArrayList<Seance>();
        int n=0;
        
        //Voir combien de cours dans la journée;
        for(int i = 1; i < Seances.size(); i++)
        {
            if(Seances.get(i).getDATE()==date){
                 CoursAJD.add(Seances.get(i));
                n++;
            }
               
        } 
        
        Object[][] data = new Object[n][5];
        Seance [] triees = new Seance [CoursAJD.size()];
        
        //Trier par heure
        for(int k=0; k<CoursAJD.size(); k++)
            triees[k]=CoursAJD.get(k);
        
        for(int x=0; x<triees.length; x++){
            if((triees[x+1].getHEURE_DEBUT()).isBefore(triees[x].getHEURE_DEBUT())){
                Seance temp;
		temp = triees[x];
		triees[x] = triees[x+1];
		triees[x+1] = temp;
            }            
        }
        
        for(int y=0; y<triees.length; y++){
            String horaire = triees[y].getHEURE_DEBUT()+" - "+triees[y].getHEURE_FIN();
            
            data[y][0]= horaire;
            data[y][1]= triees[y].getCOURS(triees[y].getID_COURS());
            data[y][2]= controleur.getGroupe();
            String endroit = triees[y].getSALLE() + " - " + triees[y].getSITE();
            data[y][3]= endroit;
            data[y][4]= triees[y].getTYPE();
        }
         
        return data;   
    }
              
    
    public static void main(String[] args) {
        //new Edt();
    }
}
