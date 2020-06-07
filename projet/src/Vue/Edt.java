
package Vue;


import Controleur.Controleur;
import Controleur.ControleurAdmin;

import Controleur.ControleurEnseignant;

import Controleur.ControleurEtudiant;
import Controleur.ControleurGroupe;
import Controleur.ControleurPromotion;
import Controleur.ControleurSalle;
import Modele.Groupe;
import Modele.Salle;
import Modele.Seance;
import Modele.Utilisateur;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Edt extends JFrame{
    private JPanel panel1;
    private JPanel panel2;
    private LocalDate ajd;
    private JPanel semaine;
    private JPanel Lundi;
    private JPanel Mardi;
    private JPanel Mercredi;
    private JPanel Jeudi;
    private JPanel Vendredi;
    private JPanel Samedi;
    
    public Edt(Controleur controleur, boolean admin) {
        this.setTitle("Emploi du temps");
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        Menu m = new Menu(3);
        this.setJMenuBar(m);
        
        ajd = LocalDate.now();
        semaine = new JPanel();
        
        JButton prec = new JButton("Semaine précédente");
        prec.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent event){
           if(ajd.getDayOfMonth()==1)
               ajd = LocalDate.of(ajd.getYear(), ajd.getMonth().getValue()-1, 24);
           if(ajd.getDayOfMonth()==2)
               ajd = LocalDate.of(ajd.getYear(), ajd.getMonth().getValue()-1, 25);
           if(ajd.getDayOfMonth()==3)
               ajd = LocalDate.of(ajd.getYear(), ajd.getMonth().getValue()-1, 26);
           if(ajd.getDayOfMonth()==4)
               ajd = LocalDate.of(ajd.getYear(), ajd.getMonth().getValue()-1, 27);
           if(ajd.getDayOfMonth()==5)
               ajd = LocalDate.of(ajd.getYear(), ajd.getMonth().getValue()-1, 28);
           if(ajd.getDayOfMonth()==6)
               ajd = LocalDate.of(ajd.getYear(), ajd.getMonth().getValue()-1, 29);
           if(ajd.getDayOfMonth()==7)
               ajd = LocalDate.of(ajd.getYear(), ajd.getMonth().getValue()-1, 30);
           else
               ajd = LocalDate.of(ajd.getYear(), ajd.getMonth(), ajd.getDayOfMonth()-7);
           
           panel2.setVisible(false);
           Liste(controleur, ajd, admin);
        }
        });
        
        JButton suiv = new JButton("Semaine suivante");
        suiv.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent event){
           if(ajd.getDayOfMonth()==24)
               ajd = LocalDate.of(ajd.getYear(), ajd.getMonth().getValue()+1, 1);
           if(ajd.getDayOfMonth()==25)
               ajd = LocalDate.of(ajd.getYear(), ajd.getMonth().getValue()+1, 2);
           if(ajd.getDayOfMonth()==26)
               ajd = LocalDate.of(ajd.getYear(), ajd.getMonth().getValue()+1, 3);
           if(ajd.getDayOfMonth()==27)
               ajd = LocalDate.of(ajd.getYear(), ajd.getMonth().getValue()+1, 4);
           if(ajd.getDayOfMonth()==28)
               ajd = LocalDate.of(ajd.getYear(), ajd.getMonth().getValue()+1, 5);
           if(ajd.getDayOfMonth()==29)
               ajd = LocalDate.of(ajd.getYear(), ajd.getMonth().getValue()+1, 6);
           if(ajd.getDayOfMonth()==30)
               ajd = LocalDate.of(ajd.getYear(), ajd.getMonth().getValue()+1, 7);
           else
                ajd = LocalDate.of(ajd.getYear(), ajd.getMonth(), ajd.getDayOfMonth()+7);
           
           panel2.setVisible(false);
           Liste(controleur, ajd, admin);
        }
        });
        semaine.add(prec);
        semaine.add(suiv);
        
        this.setLayout(new GridLayout(0,1));
        Infos(controleur);
        this.add(panel1, BorderLayout.NORTH);
        Liste(controleur, ajd, admin);
        //Grille(controleur);
        this.add(panel2, BorderLayout.SOUTH);
        this.add(semaine, BorderLayout.SOUTH);
    }
    
    private void Infos(Controleur controleur){
        panel1 = new JPanel();
        String informations="";
        if((controleur instanceof ControleurEtudiant)== true)//SI ETUDIANT
            informations = "Emploi du temps de "+controleur.getUtilisateur().getNOM()+" "
                    +controleur.getUtilisateur().getPRENOM()+" "
                    +controleur.getGroupe().getNOM()+" "
                    +controleur.getPromotion().getNOM()+" ";
        
        if((controleur instanceof ControleurEnseignant)== true)//SI ENSEIGNANT
            informations = "Emploi du temps de "+controleur.getUtilisateur().getNOM()+" "+controleur.getUtilisateur().getPRENOM()+" ";
        
        if((controleur instanceof ControleurGroupe)==true)//SI TD
            informations = "Emploi du temps du "+controleur.getGroupe().getNOM()+" "+controleur.getPromotion().getNOM()+" ";
        
        if((controleur instanceof ControleurPromotion)==true)//SI PROMO
            informations = "Emploi du temps de la "+controleur.getPromotion().getNOM()+" ";
        
        if((controleur instanceof ControleurSalle)== true)//SI SALLE
            informations = "Emploi du temps de la "+controleur.getSalle().getNOM()+" - "+controleur.getSite().getNOM()+" ";
        
        JLabel infos = new JLabel(informations);
        panel1.add(infos);
    }
    
    private void Liste(Controleur controleur,LocalDate ajd, boolean admin){
      
        
        DayOfWeek Dday = ajd.getDayOfWeek();
        
        if(Dday==DayOfWeek.TUESDAY)
            ajd = LocalDate.of(ajd.getYear(), ajd.getMonth(), ajd.getDayOfMonth()-1);
        if(Dday==DayOfWeek.WEDNESDAY)
            ajd = LocalDate.of(ajd.getYear(), ajd.getMonth(), ajd.getDayOfMonth()-2);
        if(Dday==DayOfWeek.THURSDAY)
            ajd = LocalDate.of(ajd.getYear(), ajd.getMonth(), ajd.getDayOfMonth()-3);
        if(Dday==DayOfWeek.FRIDAY)
            ajd = LocalDate.of(ajd.getYear(), ajd.getMonth(), ajd.getDayOfMonth()-4);
        if(Dday==DayOfWeek.SATURDAY)
            ajd = LocalDate.of(ajd.getYear(), ajd.getMonth(), ajd.getDayOfMonth()-5);
        if(Dday==DayOfWeek.SUNDAY)
            ajd = LocalDate.of(ajd.getYear(), ajd.getMonth(), ajd.getDayOfMonth()-6);
        
        Lundi = new JPanel();
        Object[][] TLundi = Journee(ajd, controleur, admin);
        String  titleL[] = {"Lundi " + ajd, "", "", "",""};
        JTable tableauL = new JTable(TLundi, titleL);
        tableauL.getTableHeader().setBackground(new Color(151,221,255));
        tableauL.setShowVerticalLines(false);
        Lundi.add(tableauL);
        getContentPane().add(new JScrollPane(tableauL));
        
        Mardi = new JPanel();
        LocalDate dateM = LocalDate.of(ajd.getYear(), ajd.getMonth(), ajd.getDayOfMonth()+1);
        Object[][] TMardi = Journee(dateM, controleur, admin);
        String  titleM[] = {"Mardi " + dateM, "", "", "",""};
        JTable tableauM = new JTable(TMardi, titleM);
        tableauM.getTableHeader().setBackground(new Color(151,221,255));
        tableauM.setShowVerticalLines(false);
        Mardi.add(tableauM);
        getContentPane().add(new JScrollPane(tableauM));
        
        Mercredi = new JPanel();
        LocalDate dateMe = LocalDate.of(ajd.getYear(), ajd.getMonth(), ajd.getDayOfMonth()+2);
        Object[][] TMercredi = Journee(dateMe, controleur, admin);
        String  titleMe[] = {"Mercredi "+ dateMe, "", "", "",""};
        JTable tableauMe = new JTable(TMercredi, titleMe);
        tableauMe.getTableHeader().setBackground(new Color(151,221,255));
        tableauMe.setShowVerticalLines(false);
        Mercredi.add(tableauMe);
        getContentPane().add(new JScrollPane(tableauMe));
        
        Jeudi = new JPanel();
        LocalDate dateJ = LocalDate.of(ajd.getYear(), ajd.getMonth(), ajd.getDayOfMonth()+3);
        Object[][] TJeudi = Journee(dateJ, controleur, admin);
        String  titleJ[] = {"Jeudi "+ dateJ, "", "", "",""};
        JTable tableauJ = new JTable(TJeudi, titleJ);
        tableauJ.getTableHeader().setBackground(new Color(151,221,255));
        tableauJ.setShowVerticalLines(false);
        Jeudi.add(tableauJ);
        getContentPane().add(new JScrollPane(tableauJ));
        
        Vendredi = new JPanel();
        LocalDate dateV = LocalDate.of(ajd.getYear(), ajd.getMonth(), ajd.getDayOfMonth()+4);
        Object[][] TVendredi = Journee(dateV, controleur, admin);
        String  titleV[] = {"Vendredi "+ dateV, "", "", "",""};
        JTable tableauV = new JTable(TVendredi, titleV);
        tableauV.getTableHeader().setBackground(new Color(151,221,255));
        tableauV.setShowVerticalLines(false);
        Vendredi.add(tableauV);
        getContentPane().add(new JScrollPane(tableauV));
        
        Samedi = new JPanel();
        LocalDate dateS = LocalDate.of(ajd.getYear(), ajd.getMonth(), ajd.getDayOfMonth()+5);
        Object[][] TSamedi = Journee(dateS, controleur, admin);
        String  titleS[] = {"Samedi "+ dateS, "", "", "",""};
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
    
    public Object[][]Journee(LocalDate date, Controleur controleur, boolean admin){
        
        
        Object[][] data;
        
        if((controleur instanceof ControleurEtudiant)== true ||(controleur instanceof ControleurGroupe)== true||
                (controleur instanceof ControleurPromotion)== true){
            
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
            
            if(admin==true)
                data = new Object[n][8];
            else
                data = new Object[n][6];
            
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


                //data[y][2]=Profs.get(triees[y].getID_COURS()).getNOM();
                //CETTE LIGNE MARCHE
                data[y][2]=controleur.getUtilisateurEnseignants().get(controleur.getSeances().indexOf(triees[y])).getNOM();
                
                if (controleur instanceof ControleurPromotion)
                    data[y][3]=  controleur.getGroupes().get(controleur.getSeances().indexOf(triees[y])).getNOM();
                else
                   data[y][3]= controleur.getType_cours().get(controleur.getSeances().indexOf(triees[y])).getNOM();

                String salle = controleur.getSalles().get(controleur.getSeances().indexOf(triees[y])).getNOM();
                String site = controleur.getSites().get(controleur.getSeances().indexOf(triees[y])).getNOM();
                String endroit = salle + " - " + site;
                data[y][4]= endroit;
                data[y][5]= controleur.getType_cours().get(controleur.getSeances().indexOf(triees[y])).getNOM();
                
               /* if(admin==true){
                    JButton mod = new JButton("Modifier");
                    mod.addActionListener(new ActionListener(){
                         public void actionPerformed(ActionEvent event){
                            modifier(triees[y].getID());
                         }});
                    JButton sup = new JButton("Supprimer");
                    sup.addActionListener(new ActionListener(){
                         public void actionPerformed(ActionEvent event){
                            JOptionPane jop = new JOptionPane();			
                            int option = jop.showConfirmDialog(null, "Etes-vous sûr de vouloir supprimer cette séance ?", 
                                    "Suppression d'une séance", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                            if(option == JOptionPane.OK_OPTION){
                              	//voir BDD Vivien
                                Seances.get(triees[y].getID()).setETAT(1);
                            }
                         }});
                    data[y][6]= mod;
                    data[y][7]= sup;
                }*/
            }
   
        }
        else if ((controleur instanceof ControleurEnseignant)== true){
                ArrayList<Seance> Seances = controleur.getSeances();
                ArrayList<Salle> Salles = controleur.getSalles();
                ArrayList<Seance> CoursAJD = new ArrayList<>();
                ControleurAdmin Cadmin = new ControleurAdmin(86);
                ArrayList<Utilisateur> Profs = Cadmin.getUtilisateurEnseignants();
                int n=0;

                //Voir combien de cours dans la journée;
                for(int i = 0; i < Seances.size(); i++)
                {
                    if(date.isEqual(Seances.get(i).getDATE())){
                        CoursAJD.add(Seances.get(i));
                        n++;
                    }  
                }

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
                data = new Object[n][5];

                for(int y=0; y<triees.length; y++){
                    String horaire = triees[y].getHEURE_DEBUT()+" - "+triees[y].getHEURE_FIN();
                    data[y][0]= horaire;

                    data[y][1]= triees[y].getCOURS(triees[y].getID_COURS());


                    data[y][2]= controleur.getGroupes().get(Profs.indexOf(Profs.get(triees[y].getID_COURS()))).getNOM();

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
                    data[y][3]= endroit;
                    data[y][4]= triees[y].getTYPE(triees[y].getID_TYPE());
                }
            }
            else if((controleur instanceof ControleurSalle)== true){

                ArrayList<Seance> Seances = controleur.getSeances();
                //ArrayList<Groupe> Groupes = controleur.getGroupes();
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

                data = new Object[n][5];
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

                   // data[y][2]= "Prof";//Profs.get(triees[y].getID_COURS()).getNOM();
                   //CETTE LIGNE MARCHE
                    data[y][2]=controleur.getUtilisateurEnseignants().get(controleur.getSeances().indexOf(triees[y])).getNOM();
                    data[y][3]= "TD";//controleur.getGroupe().getNOM();

                    data[y][4]= triees[y].getTYPE(triees[y].getID_TYPE());
                }
            }
            else
                data = new Object[1][1];
        return data;
    }
    
    public void modifier(int idSeance){
        
    }
    
              
    
    public static void main(String[] args) {
        //new Edt();
    }
}
