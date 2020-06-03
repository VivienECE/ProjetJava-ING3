
package Vue;

import Controleur.ControleurEtudiant;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
    }
    
    private void Liste(ControleurEtudiant controleur){
        panel2 = new JPanel();
        
        panel2.add();
    }
    
    public static void main(String[] args) {
        //new Edt();
    }
}
