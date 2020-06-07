
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
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EventObject;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class Edt extends JFrame{
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();
    private LocalDate ajd;
    private JButton suiv = new JButton("Semaine suivante");
    private JButton prec = new JButton("Semaine précédente");
    private JPanel semaine = new JPanel();
    private JPanel Lundi;
    private JPanel Mardi;
    private JPanel Mercredi;
    private JPanel Jeudi;
    private JPanel Vendredi;
    private JPanel Samedi;
    Controleur controleur;
    
    public Edt(Controleur controleur, boolean admin) {
       
        this.controleur=controleur;
        Initialize();
        
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
           panel2.removeAll();
           panel2.revalidate();
           panel2.repaint(); 
           Liste(controleur, ajd, admin);
        }
        });
        
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
           
           panel2.removeAll();
           panel2.revalidate();
           panel2.repaint();
           Liste(controleur, ajd, admin);
        }
        });
        
        
        Liste(controleur, ajd, admin);
        //Grille(controleur);
    }
    
    private void Initialize ()
    {
        this.setTitle("Emploi du temps");
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        Menu m = new Menu(3,controleur);
        this.setJMenuBar(m);
        this.setLayout(new GridLayout(0,1));
        Infos(controleur);
        ajd = LocalDate.now();
    }
    
    private void Infos(Controleur controleur){
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
        getContentPane().removeAll();
        this.add(panel1, BorderLayout.NORTH);
        semaine.add(prec);
        semaine.add(suiv);
       
        
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
        JTable tableauL;
        if(admin==true){
            String  titleL[] = {"Lundi " + ajd, "", "", "","", ""," ","  "};
            tableauL = new JTable(TLundi, titleL);
            tableauL.getColumn(" ").setCellRenderer(new MyRendererAndEditorMod(tableauL));
            tableauL.getColumn(" ").setCellEditor(new MyRendererAndEditorMod(tableauL));
            tableauL.getSelectionModel().addListSelectionListener(new ListSelectionListener(){ 
                @Override
                public void valueChanged(ListSelectionEvent lse) {
                   // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });
            tableauL.getColumn("  ").setCellRenderer(new MyRendererAndEditorSup(tableauL));
            tableauL.getColumn("  ").setCellEditor(new MyRendererAndEditorSup(tableauL));
            tableauL.getSelectionModel().addListSelectionListener(new ListSelectionListener(){ 
                @Override
                public void valueChanged(ListSelectionEvent lse) {
                    //throw new UnsupportedOperationException("Not supported yet.")
                            
                             //To change body of generated methods, choose Tools | Templates.
                }
            });
        }
        else{
            String  titleL[] = {"Lundi " + ajd, "", "", "",""};
            tableauL = new JTable(TLundi, titleL);
        }     
        tableauL.getTableHeader().setBackground(new Color(151,221,255));
        tableauL.setShowVerticalLines(false);
        Lundi.add(tableauL);
        getContentPane().add(new JScrollPane(tableauL));
        
        Mardi = new JPanel();
        LocalDate dateM = LocalDate.of(ajd.getYear(), ajd.getMonth(), ajd.getDayOfMonth()+1);
        Object[][] TMardi = Journee(dateM, controleur, admin);
        JTable tableauM;
        if(admin==true){
            String  titleM[] = {"Mardi " + ajd, "", "", "","", ""," ","  "};
            tableauM = new JTable(TMardi, titleM);
            tableauM.getColumn(" ").setCellRenderer(new MyRendererAndEditorMod(tableauM));
            tableauM.getColumn(" ").setCellEditor(new MyRendererAndEditorMod(tableauM));
            tableauM.getSelectionModel().addListSelectionListener(new ListSelectionListener(){ 
                @Override
                public void valueChanged(ListSelectionEvent lse) {
                   // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });
            tableauM.getColumn("  ").setCellRenderer(new MyRendererAndEditorSup(tableauM));
            tableauM.getColumn("  ").setCellEditor(new MyRendererAndEditorSup(tableauM));
            tableauM.getSelectionModel().addListSelectionListener(new ListSelectionListener(){ 
                @Override
                public void valueChanged(ListSelectionEvent lse) {
                   // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });
        }
        else{
            String  titleM[] = {"Mardi " + ajd, "", "", "",""};
            tableauM = new JTable(TMardi, titleM);
        } 
        tableauM.getTableHeader().setBackground(new Color(151,221,255));
        tableauM.setShowVerticalLines(false);
        Mardi.add(tableauM);
        getContentPane().add(new JScrollPane(tableauM));
        
        Mercredi = new JPanel();
        LocalDate dateMe = LocalDate.of(ajd.getYear(), ajd.getMonth(), ajd.getDayOfMonth()+2);
        Object[][] TMercredi = Journee(dateMe, controleur, admin);
        JTable tableauMe;
        if(admin==true){
            String  titleMe[] = {"Mardi " + ajd, "", "", "","", ""," ","  "};
            tableauMe = new JTable(TMercredi, titleMe);
            tableauMe.getColumn(" ").setCellRenderer(new MyRendererAndEditorMod(tableauMe));
            tableauMe.getColumn(" ").setCellEditor(new MyRendererAndEditorMod(tableauMe));
            tableauMe.getSelectionModel().addListSelectionListener(new ListSelectionListener(){ 
                @Override
                public void valueChanged(ListSelectionEvent lse) {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });
            tableauMe.getColumn("  ").setCellRenderer(new MyRendererAndEditorSup(tableauMe));
            tableauMe.getColumn("  ").setCellEditor(new MyRendererAndEditorSup(tableauMe));
            tableauMe.getSelectionModel().addListSelectionListener(new ListSelectionListener(){ 
                @Override
                public void valueChanged(ListSelectionEvent lse) {
                   // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });
        }
        else{
            String  titleMe[] = {"Mercredi " + ajd, "", "", "",""};
            tableauMe = new JTable(TMercredi, titleMe);
        } 
        tableauMe.getTableHeader().setBackground(new Color(151,221,255));
        tableauMe.setShowVerticalLines(false);
        Mercredi.add(tableauMe);
        getContentPane().add(new JScrollPane(tableauMe));
        
        Jeudi = new JPanel();
        LocalDate dateJ = LocalDate.of(ajd.getYear(), ajd.getMonth(), ajd.getDayOfMonth()+3);
        Object[][] TJeudi = Journee(dateJ, controleur, admin);
        JTable tableauJ;
        if(admin==true){
            String  titleJ[] = {"Jeudi " + ajd, "", "", "","", ""," ","  "};
            tableauJ = new JTable(TJeudi, titleJ);
            tableauJ.getColumn(" ").setCellRenderer(new MyRendererAndEditorMod(tableauJ));
            tableauJ.getColumn(" ").setCellEditor(new MyRendererAndEditorMod(tableauJ));
            tableauJ.getSelectionModel().addListSelectionListener(new ListSelectionListener(){ 
                @Override
                public void valueChanged(ListSelectionEvent lse) {
                    ; //To change body of generated methods, choose Tools | Templates.
                }
            });
            tableauJ.getColumn("  ").setCellRenderer(new MyRendererAndEditorSup(tableauJ));
            tableauJ.getColumn("  ").setCellEditor(new MyRendererAndEditorSup(tableauJ));
            tableauJ.getSelectionModel().addListSelectionListener(new ListSelectionListener(){ 
                @Override
                public void valueChanged(ListSelectionEvent lse) {
                     //To change body of generated methods, choose Tools | Templates.
                }
            });
        }
        else{
            String  titleJ[] = {"Jeudi " + ajd, "", "", "",""};
            tableauJ = new JTable(TJeudi, titleJ);
        } 
        tableauJ.getTableHeader().setBackground(new Color(151,221,255));
        tableauJ.setShowVerticalLines(false);
        Jeudi.add(tableauJ);
        getContentPane().add(new JScrollPane(tableauJ));
        
        Vendredi = new JPanel();
        LocalDate dateV = LocalDate.of(ajd.getYear(), ajd.getMonth(), ajd.getDayOfMonth()+4);
        Object[][] TVendredi = Journee(dateV, controleur, admin);
        JTable tableauV;
        if(admin==true){
            String  titleV[] = {"Vendredi " + ajd, "", "", "","", ""," ","  "};
            tableauV = new JTable(TVendredi, titleV);
            tableauV.getColumn(" ").setCellRenderer(new MyRendererAndEditorMod(tableauV));
            tableauV.getColumn(" ").setCellEditor(new MyRendererAndEditorMod(tableauV));
            tableauV.getSelectionModel().addListSelectionListener(new ListSelectionListener(){ 
                @Override
                public void valueChanged(ListSelectionEvent lse) {
                   // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });
            tableauV.getColumn("  ").setCellRenderer(new MyRendererAndEditorSup(tableauV));
            tableauV.getColumn("  ").setCellEditor(new MyRendererAndEditorSup(tableauV));
            tableauV.getSelectionModel().addListSelectionListener(new ListSelectionListener(){ 
                @Override
                public void valueChanged(ListSelectionEvent lse) {
                   // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });
        }
        else{
            String  titleV[] = {"Vendredi " + ajd, "", "", "",""};
            tableauV = new JTable(TVendredi, titleV);
        } 
        tableauV.getTableHeader().setBackground(new Color(151,221,255));
        tableauV.setShowVerticalLines(false);
        Vendredi.add(tableauV);
        getContentPane().add(new JScrollPane(tableauV));
        
        Samedi = new JPanel();
        LocalDate dateS = LocalDate.of(ajd.getYear(), ajd.getMonth(), ajd.getDayOfMonth()+5);
        Object[][] TSamedi = Journee(dateS, controleur, admin);
        JTable tableauS;
        if(admin==true){
            String  titleS[] = {"Samedi " + ajd, "", "", "","", ""," ","  "};
            tableauS = new JTable(TSamedi, titleS);
            tableauS.getColumn(" ").setCellRenderer(new MyRendererAndEditorMod(tableauS));
            tableauS.getColumn(" ").setCellEditor(new MyRendererAndEditorMod(tableauS));
            tableauS.getSelectionModel().addListSelectionListener(new ListSelectionListener(){ 
                @Override
                public void valueChanged(ListSelectionEvent lse) {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });
            tableauS.getColumn("  ").setCellRenderer(new MyRendererAndEditorSup(tableauS));
            tableauS.getColumn("  ").setCellEditor(new MyRendererAndEditorSup(tableauS));
            tableauS.getSelectionModel().addListSelectionListener(new ListSelectionListener(){ 
                @Override
                public void valueChanged(ListSelectionEvent lse) {
                   // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });
        }
        else{
            String  titleS[] = {"Samedi " + ajd, "", "", "",""};
            tableauS = new JTable(TSamedi, titleS);
        } 
        tableauS.getTableHeader().setBackground(new Color(151,221,255));
        tableauS.setShowVerticalLines(false);
        Samedi.add(tableauS);
        getContentPane().add(new JScrollPane(tableauS));
          
        panel2.add(Lundi);
        panel2.add(Mardi);
        panel2.add(Mercredi);
        panel2.add(Jeudi);
        panel2.add(Vendredi);
        panel2.add(Samedi);
        
        panel2.setLayout(new GridLayout(0,1,0,10));
        this.add(panel2, BorderLayout.SOUTH);
        this.add(semaine, BorderLayout.SOUTH);

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
            ArrayList<Integer> annule = new ArrayList<>();

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
                data = new Object[n][9];
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

	       if(triees[y].getETAT()==1)
                    data[y][5] = "ANNULEE";
                else
                    data[y][5]= controleur.getType_cours().get(controleur.getSeances().indexOf(triees[y])).getNOM();
                
                if(admin==true)
                    data[y][6]=controleur.getSeances().get(controleur.getSeances().indexOf(triees[y])).getID();             
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
                    
                    if(triees[y].getETAT()==1)
                        data[y][4] = "ANNULEE";
                    else
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

                   //CETTE LIGNE MARCHE
                    data[y][2]=controleur.getUtilisateurEnseignants().get(controleur.getSeances().indexOf(triees[y])).getNOM();
                    data[y][3]= "TD";//controleur.getGroupe().getNOM();
                    
                    if(triees[y].getETAT()==1)
                        data[y][4] = "ANNULEE";
                    else
                        data[y][4]= triees[y].getTYPE(triees[y].getID_TYPE());
                }
            }
            else
                data = new Object[1][1];
        return data;
    }
    
    
   class MyRendererAndEditorSup implements TableCellRenderer, TableCellEditor 
    {
      private JButton btn;
      private int row;
      MyRendererAndEditorSup(JTable table) {
        btn = new JButton("Supprimer");
        btn.setBackground(Color.red);
        btn.setForeground(Color.white);
        btn.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            JOptionPane jop = new JOptionPane();			
            int option = jop.showConfirmDialog(null, "Etes-vous sûr de vouloir supprimer cette séance ?", 
                    "Suppression d'une séance", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(option == JOptionPane.OK_OPTION){
               Seance seance = controleur.findSeance((int)table.getValueAt(table.getSelectedRow(), 6));
               seance.setETAT(1);
               controleur.updateSeance(seance);
            }
          }
        });
      }
      @Override
      public Component getTableCellRendererComponent(JTable table, Object 
      value, boolean isSelected, boolean hasFocus, int row, int column) 
      {
        return btn;
      }
      @Override
      public Component getTableCellEditorComponent(JTable table, Object 
      value, boolean isSelected, int row, int column) 
      {
        this.row = row;
        return btn;
      }
      @Override
      public Object getCellEditorValue() { return true; }
      
      public boolean isCellEditable(EventObject anEvent) { return true; }
      
      public boolean shouldSelectCell(EventObject anEvent) { return true; }
      @Override
      public boolean stopCellEditing() { return true; }
      @Override
      public void cancelCellEditing() {}
      
      public void addCellEditorListener(CellEditorListener l) {}
      
      public void removeCellEditorListener(CellEditorListener l) {}
    }
   
   public class TableComponent extends DefaultTableCellRenderer {

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
      //Si la valeur de la cellule est un JButton, on transtype cette valeur
      if (value instanceof JButton)
        return (JButton) value;
      else
        return this;
    }
  } 
  class MyRendererAndEditorMod implements TableCellRenderer, TableCellEditor 
    {
      private JButton btn;
      private int row;
      MyRendererAndEditorMod(JTable table) {
        btn = new JButton("Modifier");
        btn.addActionListener(new ActionListener() {@Override
          public void actionPerformed(ActionEvent e) {
            Seance seance = controleur.findSeance((int)table.getValueAt(table.getSelectedRow(), 6));
            
            JFrame f = new JFrame();
            f.setTitle("Modification d'un cours");
            f.setSize(600, 600);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setLocationRelativeTo(null);
            JPanel p = new JPanel();
            JLabel mess1 = new JLabel("Veuillez sélectionner un nouveau crécaux pour cette séance :");
            p.add(mess1);
            JPanel panel5 = new JPanel();
            DateTextField picker = new DateTextField();
            panel5.add(picker);
            JLabel a = new JLabel("  de  ");
            panel5.add(a);
            JTextField heureD = new JTextField(2);
            panel5.add(heureD);
            JLabel b = new JLabel(" h ");
            panel5.add(b);
            JTextField minD = new JTextField(2);
            panel5.add(minD);
            JLabel c = new JLabel("  à  ");
            panel5.add(c);
            JTextField heureF = new JTextField(2);
            panel5.add(heureF);
            JLabel d = new JLabel(" h ");
            panel5.add(d);
            JTextField minF = new JTextField(2);
            panel5.add(minF);
            
            JPanel panelB = new JPanel();
            JButton ok = new JButton("Valider");
            ok.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    LocalDate date = Instant.ofEpochMilli(picker.getDate().getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
                    seance.setDATE(date);
                    seance.setHEURE_DEBUT(Integer.parseInt(heureD.getText()), Integer.parseInt(minD.getText()));
                    seance.setHEURE_FIN(Integer.parseInt(heureF.getText()), Integer.parseInt(minF.getText()));
                    seance.setETAT(0);
                    controleur.updateSeance(seance);
                    f.setVisible(false);
                }});
            JButton no = new JButton("Annuler");
            no.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                f.setVisible(false);
            }});
            panelB.add(ok);
            panelB.add(no);
            f.add(p);
            f.add(panel5);
            f.add(panelB);
            f.setLayout(new GridLayout(0,1));
            f.setVisible(true);
          }
        });
      }
      
      public void modifier(ControleurAdmin controleur, int idSeance){
        
        ArrayList<Seance> Seances = controleur.getSeances();
        
        JFrame f = new JFrame();
        f.setTitle("Modification d'un cours");
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        JPanel p = new JPanel();
        JLabel mess1 = new JLabel("Veuillez sélectionner un nouveau crécaux pour cette séance :");
        p.add(mess1);
        DateTextField picker = new DateTextField();
        p.add(picker);
        JLabel a = new JLabel("  de  ");
        p.add(a);
        JTextField heureD = new JTextField(2);
        p.add(heureD);
        JLabel b = new JLabel(" h ");
        p.add(b);
        JTextField minD = new JTextField(2);
        p.add(minD);
        JLabel c = new JLabel("  à  ");
        p.add(c);
        JTextField heureF = new JTextField(2);
        p.add(heureF);
        JLabel d = new JLabel(" h ");
        p.add(d);
        JTextField minF = new JTextField(2);
        p.add(minF);
        
        JButton ok = new JButton("Valider");
        ok.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                LocalDate date = Instant.ofEpochMilli(picker.getDate().getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
                Seances.get(idSeance).setDATE(date);
                Seances.get(idSeance).setHEURE_DEBUT(Integer.parseInt(heureD.getText()), Integer.parseInt(minD.getText()));
                Seances.get(idSeance).setHEURE_FIN(Integer.parseInt(heureF.getText()), Integer.parseInt(minF.getText()));
                controleur.updateSeance(Seances.get(idSeance));
            }});
        JButton no = new JButton("Annuler");
        no.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent event){
            f.setVisible(false);
        }});
        p.add(ok);
        p.add(no);
        p.setLayout(new GridLayout(6,2));
        f.add(p);
        f.setVisible(true);
        
    }
      @Override
      public Component getTableCellRendererComponent(JTable table, Object 
      value, boolean isSelected, boolean hasFocus, int row, int column) 
      {
        return btn;
      }
      @Override
      public Component getTableCellEditorComponent(JTable table, Object 
      value, boolean isSelected, int row, int column) 
      {
        this.row = row;
        return btn;
      }
      @Override
      public Object getCellEditorValue() { return true; }
      
      public boolean isCellEditable(EventObject anEvent) { return true; }
      
      public boolean shouldSelectCell(EventObject anEvent) { return true; }
      @Override
      public boolean stopCellEditing() { return true; }
      @Override
      public void cancelCellEditing() {}
      
      public void addCellEditorListener(CellEditorListener l) {}
      
      public void removeCellEditorListener(CellEditorListener l) {}
    }
   
  /*public class TableComponent extends DefaultTableCellRenderer {

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
      //Si la valeur de la cellule est un JButton, on transtype cette valeur
      if (value instanceof JButton)
        return (JButton) value;
      else
        return this;
    }
  }*/
    
    public static void main(String[] args) {
        //new Edt();
    }
}
