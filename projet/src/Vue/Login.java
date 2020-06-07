
package Vue;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc2020.Connexion;

/**
 * 
 * Vue authentifie l'utilisateur
 * @author Clemence
 */
public class Login extends JFrame {

    private JPanel panel;
    private JLabel messageLabel;
    private JLabel messageLabel1;
    private JLabel messageLabel2;
    private JTextField UTextField;
    private JTextField PTextField;
    private JButton Submit;
    private JButton exit;
    private Connexion conn;
    private int ID_UTILISATEUR;
    private int DROIT;

    public Login(Connexion conn) throws InterruptedException {
        this.conn=conn;
        setTitle("LogIn");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildPanel();
        add(panel);
        setVisible(true);
        while(ID_UTILISATEUR==0)
        {
             TimeUnit.SECONDS.sleep(1);
        }
        
    }

    private void buildPanel() throws InterruptedException {
        messageLabel = new JLabel("Veuillez entrer vos identifiants");
        
        messageLabel1 = new JLabel("Nom d'utilisateur");
        UTextField = new JTextField(10);
        messageLabel2 = new JLabel("Mot de Passe");
        PTextField = new JPasswordField(10);
        Submit = new JButton("Se Connecter");
        Submit.addActionListener(new EnterButtonListener());
        exit = new JButton("EXIT");
        exit.addActionListener(new EnterButtonListener());
        panel = new JPanel();
        panel.setBackground(new Color(0,178,178));

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
            System.out.println("SELECT * FROM utilisateur WHERE EMAIL ='"+ UTextField.getText() +"' AND PASSWD ='"+String.valueOf(PTextField.getText())+"'");
            try{
                if (e.getSource() == Submit) {
                     ResultSet result = conn.executeQuery("SELECT * FROM utilisateur WHERE EMAIL ='"+ UTextField.getText() +"' AND PASSWD ='"+String.valueOf(PTextField.getText())+"'");
                     if(result.first())
                     {
                          ID_UTILISATEUR=result.getInt("ID"); 
                          DROIT=result.getInt("DROIT"); 
                          setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                          setVisible(false); //you can't see me!
                          dispose(); //Destroy the JFrame object
                          //JOptionPane.showMessageDialog(null, "Connexion à l'emploi du temps");
                     }
                     else
                     {
                         JOptionPane.showMessageDialog(null, "Email ou mot de passe incorrect");
                     }
                }
                else if (e.getSource() == exit)
                {
                     setVisible(false); //you can't see me!
                     dispose(); //Destroy the JFrame object
                     System.exit(0);
                }
            }
             catch (SQLException error) {
                 error.printStackTrace();
              }
            
            
           /* ResultSet rs=stmt.executeQuery("SELECT * FROM login WHERE USERNAME ='"+ username.getText() +"' AND PASSWORD ='"+String.valueOf(password.getPassword())+"'");
          System.out.println("SELECT * FROM login WHERE USERNAME ='"+ username.getText() +"' AND PASSWORD ='"+String.valueOf(password.getPassword())+"'");
          if(rs.next())
          {
            JOptionPane.showMessageDialog(null, "Login Sucessfull");
            userStatut=rs.getString("STA");
            infoLog=new String[2];
            infoLog[0]=rs.getString("ID");  //System.out.println( infoLog[0]);
            infoLog[1]=rs.getString("STA"); //System.out.println( infoLog[1]);
            setVisible(false);
          }else
          {
            JOptionPane.showMessageDialog(null, "Invalid Username or Password");
            
            return;
          }*/

        }
    }
    public int getID_UTILISATEUR()
    {
        return ID_UTILISATEUR;
    }
    
        public int getDROIT()
    {
        return DROIT;
    }
    
    public int Log() throws InterruptedException
    {
        
        return getID_UTILISATEUR();
    }

 
    public static void main(String[] args) {
        //new Login();
    }
}
