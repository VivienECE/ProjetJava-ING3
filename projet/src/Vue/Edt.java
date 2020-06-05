
package Vue;


import Controleur.Controleur;

import Controleur.ControleurEnseignant;

import Controleur.ControleurEtudiant;
import Modele.Salle;
import Modele.Seance;
import Modele.Utilisateur;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Edt extends JFrame{
    private JPanel panel1;
    private JPanel panel2;
    private JPanel Lundi;
    private JPanel Mardi;
    private JPanel Mercredi;
    private JPanel Jeudi;
    private JPanel Vendredi;
    private JPanel Samedi;
    
    public Edt(Controleur controleur) {
        this.setTitle("Emploi du temps");
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        Menu m = new Menu(3);
        this.setJMenuBar(m);
        this.setLayout(new GridLayout(0,1));
        Infos(controleur);
        this.add(panel1, BorderLayout.NORTH);
        Liste(controleur);
        //Grille(controleur);
        this.add(panel2, BorderLayout.SOUTH);
    }
    
    private void Infos(Controleur controleur){
        panel1 = new JPanel();
        //SI ETUDIANT
        JLabel infos = new JLabel("Emploi du temps de "+controleur.getUtilisateur().getNOM()+" "
                                +controleur.getUtilisateur().getPRENOM()+" "
                                +controleur.getGroupe().getNOM()+" "
                                +controleur.getPromotion().getNOM()+" ");
        panel1.add(infos);
    }
    
    private void Liste(Controleur controleur){
      
        Lundi = new JPanel();
        LocalDate dateL = LocalDate.of(2020, 06, 01);
        Object[][] TLundi = Journee(dateL, controleur);
        String  titleL[] = {"Lundi", "", "", "",""};
        JTable tableauL = new JTable(TLundi, titleL);
        tableauL.getTableHeader().setBackground(new Color(151,221,255));
        tableauL.setShowVerticalLines(false);
        Lundi.add(tableauL);
        getContentPane().add(new JScrollPane(tableauL));
        
        Mardi = new JPanel();
        LocalDate dateM = LocalDate.of(2020, 06, 02);
        Object[][] TMardi = Journee(dateM, controleur);
        String  titleM[] = {"Mardi", "", "", "",""};
        JTable tableauM = new JTable(TMardi, titleM);
        tableauM.getTableHeader().setBackground(new Color(151,221,255));
        tableauM.setShowVerticalLines(false);
        Mardi.add(tableauM);
        getContentPane().add(new JScrollPane(tableauM));
        
        Mercredi = new JPanel();
        LocalDate dateMe = LocalDate.of(2020, 06, 03);
        Object[][] TMercredi = Journee(dateMe, controleur);
        String  titleMe[] = {"Mercredi", "", "", "",""};
        JTable tableauMe = new JTable(TMercredi, titleMe);
        tableauMe.getTableHeader().setBackground(new Color(151,221,255));
        tableauMe.setShowVerticalLines(false);
        Mercredi.add(tableauMe);
        getContentPane().add(new JScrollPane(tableauMe));
        
        Jeudi = new JPanel();
        LocalDate dateJ = LocalDate.of(2020, 06, 04);
        Object[][] TJeudi = Journee(dateJ, controleur);
        String  titleJ[] = {"Jeudi", "", "", "",""};
        JTable tableauJ = new JTable(TJeudi, titleJ);
        tableauJ.getTableHeader().setBackground(new Color(151,221,255));
        tableauJ.setShowVerticalLines(false);
        Jeudi.add(tableauJ);
        getContentPane().add(new JScrollPane(tableauJ));
        
        Vendredi = new JPanel();
        LocalDate dateV = LocalDate.of(2020, 06, 05);
        Object[][] TVendredi = Journee(dateV, controleur);
        String  titleV[] = {"Vendredi", "", "", "",""};
        JTable tableauV = new JTable(TVendredi, titleV);
        tableauV.getTableHeader().setBackground(new Color(151,221,255));
        tableauV.setShowVerticalLines(false);
        Vendredi.add(tableauV);
        getContentPane().add(new JScrollPane(tableauV));
        
        Samedi = new JPanel();
        LocalDate dateS = LocalDate.of(2020, 06, 06);
        Object[][] TSamedi = Journee(dateS, controleur);
        String  titleS[] = {"Samedi", "", "", "",""};
        JTable tableauS = new JTable(TSamedi, titleS);
        tableauS.getTableHeader().setBackground(new Color(151,221,255));
        tableauS.setShowVerticalLines(false);
        Lundi.add(tableauS);
        getContentPane().add(new JScrollPane(tableauS));
        
        panel2 = new JPanel();
        
        panel2.add(Lundi);
        panel2.add(Mardi);
        panel2.add(Mercredi);
        panel2.add(Jeudi);
        panel2.add(Vendredi);
        panel2.add(Samedi);
        
        panel2.setLayout(new GridLayout(0,1,0,10));
        setVisible(true);
    }
    
    private void Grille(Controleur controleur){
        
        Lundi = new JPanel();
        LocalDate dateL = LocalDate.of(2020, 06, 01);
        //Object[][] TLundi = Journee(dateL, controleur);
        Object[][] TLundi = {{"Cours",""},{"Cours",""},{"Cours",""},{"Cours",""},{"Cours",""},{"Cours",""}};
        String[]  titleL = {"8h-10h","10h-12h","12h-14h","14h-16h","16h-18h","18h-20h"};
        //String  titleL[] = {"Lundi", "", "", "",""};
        JTable tableauL = new JTable(TLundi, titleL);
        //tableauL.setGridColor(Color.white);
        Lundi.add(tableauL);
        getContentPane().add(new JScrollPane(tableauL));
        
        panel2 = new JPanel();
        
        panel2.add(Lundi);
        
        //panel2.setLayout(new GridLayout(0,1));
        setVisible(true);
    }
    
    public Object[][]Journee(LocalDate date, Controleur controleur){
        ArrayList<Seance> Seances = controleur.getSeances();
        ArrayList<Salle> Salles = controleur.getSalles();
        ArrayList<Utilisateur> Profs = controleur.getUtilisateurEnseignants();
        ArrayList<Seance> CoursAJD = new ArrayList<>();
        int n=0;
        
        //Voir combien de cours dans la journée;
        for(int i = 0; i < Seances.size(); i++)
        {
            if(date.isEqual(Seances.get(i).getDATE())){
                CoursAJD.add(Seances.get(i));
                n++;
            }  
        }
        
        Object[][] data = new Object[n][6];
        Seance [] triees = new Seance [CoursAJD.size()];
        
        //Trier par heure
        for(int k=0; k<CoursAJD.size(); k++)
            triees[k]=CoursAJD.get(k);
        
        for(int x=0; x<(triees.length-1); x++){
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
            
            
            data[y][2]=Profs.get(triees[y].getID_COURS()).getNOM();
            
            data[y][3]= controleur.getGroupe().getNOM();
            String salle = Salles.get(triees[y].getID_COURS()).getNOM();
            
            String site = "";
            if(Salles.get(triees[y].getID_COURS()).getID_SITE()==1)
                site="E1";
            if(Salles.get(triees[y].getID_COURS()).getID_SITE()==2)
                site="E2";
            if(Salles.get(triees[y].getID_COURS()).getID_SITE()==3)
                site="E3";
            if(Salles.get(triees[y].getID_COURS()).getID_SITE()==4)
                site="E4";
            if(Salles.get(triees[y].getID_COURS()).getID_SITE()==5)
                site="E5";
            if(Salles.get(triees[y].getID_COURS()).getID_SITE()==6)
                site="CNAM";
            
            String endroit = salle + " - " + site;
            data[y][4]= endroit;
            data[y][5]= triees[y].getTYPE(triees[y].getID_TYPE());
        }
         
        return data;   
    }
    
              
    
    public static void main(String[] args) {
        //new Edt();
    }
}
