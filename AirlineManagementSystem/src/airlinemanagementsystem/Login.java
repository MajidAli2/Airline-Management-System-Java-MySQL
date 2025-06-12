package airlinemanagementsystem;

import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JLabel userLabel, passLabel;
    JTextField userText;
    JPasswordField passText;
    JButton resetButton, submitButton, closeButton;

    public Login() {
        setTitle("Login");
        setSize(350, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        userLabel = new JLabel("Username");
        userLabel.setBounds(40, 30, 100, 25);
        add(userLabel);

        userText = new JTextField();
        userText.setBounds(150, 30, 120, 25);
        add(userText);

        passLabel = new JLabel("Password");
        passLabel.setBounds(40, 70, 100, 25);
        add(passLabel);

        passText = new JPasswordField();
        passText.setBounds(150, 70, 120, 25);
        add(passText);

        resetButton = new JButton("Reset");
        resetButton.setBounds(20, 120, 80, 25);
        resetButton.addActionListener(this);
        add(resetButton);

        submitButton = new JButton("Submit");
        submitButton.setBounds(120, 120, 80, 25);
        submitButton.addActionListener(this);
        add(submitButton);

        closeButton = new JButton("Close");
        closeButton.setBounds(220, 120, 80, 25);
        closeButton.addActionListener(this);
        add(closeButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetButton) {
            userText.setText("");
            passText.setText("");
        } else if (e.getSource() == submitButton) {
            String username = userText.getText();
            String password = new String(passText.getPassword());
           try {
               ConnectionDBMS c=new ConnectionDBMS();
               String query="Select*from login where username = '"+username+"' and password = '"+password+"' ";
               ResultSet rs=c.s.executeQuery(query);
               if(rs.next()){
                   new Home();
                   setVisible(false);

               }
               else {
                   JOptionPane.showMessageDialog(null,"Invalid Username or Password");
                   setVisible(false);
               }

           } catch (Exception ex) {
               ex.getStackTrace();
           }

        } else if (e.getSource() == closeButton) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}

