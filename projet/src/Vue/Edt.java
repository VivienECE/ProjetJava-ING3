
package Vue;

import Controleur.ControleurEtudiant;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Edt extends JFrame{
    private JPanel panel1;
    //private JPanel panel2;
    
    public Edt() {
        this.setTitle("Emploi du temps");
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        Menu m = new Menu(3);
        this.setJMenuBar(m);
        //this.setLayout(new GridLayout(0,1));
        EdtPanel();
        this.add(panel1, BorderLayout.NORTH);
        //this.add(panel2, BorderLayout.SOUTH);
        setVisible(true);
    }
    
    private void EdtPanel(){
        panel1 = new JPanel();
        JLabel infos = new JLabel("Prénom + Nom + TD + Promo ");
        panel1.add(infos);
    }
    
    public static void main(String[] args) {
        new Edt();
    }
}
