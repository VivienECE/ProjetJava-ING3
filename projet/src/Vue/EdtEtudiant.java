
package Vue;

import Controleur.ControleurEtudiant;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EdtEtudiant extends JFrame{
    private JPanel panel1;
    //private JPanel panel2;
    
    public EdtEtudiant(ControleurEtudiant controleur) {
        this.setTitle("Emploi du temps");
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        Menu m = new Menu(3);
        this.setJMenuBar(m);
        //this.setLayout(new GridLayout(0,1));
        EdtPanel(controleur);
        this.add(panel1, BorderLayout.NORTH);
        //this.add(panel2, BorderLayout.SOUTH);
        setVisible(true);
    }
    
    private void EdtPanel(ControleurEtudiant controleur){
        panel1 = new JPanel();
        JLabel infos = new JLabel(controleur.getUtilisateur().getNOM()+" "
                                +controleur.getUtilisateur().getPRENOM()+" "
                                +controleur.getGroupe().getNOM()+" "
                                +controleur.getPromotion().getNOM()+" ");
        panel1.add(infos);
    }
    
    //Lancer la fenetre depuis ControleurEtudiant
    public static void main(String[] args) {
       // new EdtEtudiant();
    }
}
