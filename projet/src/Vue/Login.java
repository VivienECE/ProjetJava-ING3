
package Vue;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login extends JFrame {

    private JPanel panel;
    private JLabel messageLabel;
    private JLabel messageLabel1;
    private JLabel messageLabel2;
    private JTextField UTextField;
    private JTextField PTextField;
    private JButton Submit;
    private JButton exit;

    public Login() {
        setTitle("LogIn");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildPanel();
        add(panel);
        setVisible(true);
    }

    private void buildPanel() {
        messageLabel = new JLabel("Veuillez entrer vos "
                + "identifiants");
        messageLabel1 = new JLabel("Nom d'utilisateur");
        UTextField = new JTextField(10);
        messageLabel2 = new JLabel("Mot de Passe");
        PTextField = new JPasswordField(10);
        Submit = new JButton("Se Connecter");
        Submit.addActionListener(new EnterButtonListener());
        exit = new JButton("EXIT");
        exit.addActionListener(new EnterButtonListener());
        panel = new JPanel();

        panel.add(messageLabel);
        panel.add(messageLabel1);
        panel.add(UTextField);
        panel.add(messageLabel2);
        panel.add(PTextField);
        panel.add(Submit);
        panel.add(exit);

        panel.setLayout(new GridBagLayout());
        getContentPane().add(panel);
        GridBagConstraints left = new GridBagConstraints();
        left.anchor = GridBagConstraints.EAST;
        GridBagConstraints right = new GridBagConstraints();
        right.weightx = 2.0;
        right.fill = GridBagConstraints.HORIZONTAL;
        right.gridwidth = GridBagConstraints.REMAINDER;

        add(messageLabel, BorderLayout.NORTH);
        panel.add(messageLabel1, left);
        panel.add(UTextField, right);
        panel.add(messageLabel2, left);
        panel.add(PTextField, right);
        panel.add(Submit, left);    
        panel.add(exit, right);

        pack();
        setVisible(true);

    }

    private class EnterButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String u, p;
            int j = 0;


            if (e.getSource() == Submit) {
                JOptionPane.showMessageDialog(null, "Connexion à l'emploi du temps");
                new Edt();

           /*     u = UTextField.getText();
                p = PTextField.getText();
                try {

                    Scanner file = new Scanner(new File("/Users/baperondard/Downloads/ProjectBapeLarys/src/projectbapelarys/admin.txt"));

                    while (file.hasNextLine()) {
                        String scan1 = file.nextLine();
                        String scan2 = file.nextLine();

                        if (scan1.equals(u)) {
                            if (scan2.equals(p)) {
                                j = j + 1;

                            }
                        }
                    }

                    if (j > 0) {

                        JOptionPane.showMessageDialog(null, "connection succesful");
                       
                        setVisible(false);
                        dispose();

                    }

                    if (j < 1) {

                        JOptionPane.showMessageDialog(null, "Identifiants incorrects");
                        UTextField.setText("");
                        PTextField.setText("");

                    }

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }*/
            }

        }
    }

 
    public static void main(String[] args) {
        new Login();
    }
}
