import java.lang.*;
import java.util.*;
import java.io.*;
import javax.swing.*;

import utils.components;
import utils.validator;

import java.awt.*;
import java.awt.event.*;

public class loginPage extends JFrame implements ActionListener {
    private JLabel userLabel, passLabel;
    private JTextField userField;
    private JPasswordField passField;
    private JButton loginButton;
    private JPanel panel;
    private String username, password;

    public loginPage() {
        super("Login");

        setSize(800, 450);

        // disable maximize button and resizable window
        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_HORIZ);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        panel = new JPanel();
        panel.setLayout(null);
        
        panel.setSize(800, 450);
        panel.setBackground(new Color(123, 182, 248));


        userLabel = new JLabel("Username");
        userLabel.setBounds(260, 150, 80, 25);
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(components.font);
        panel.add(userLabel);

        userField = new JTextField(20);
        userField.setBounds(350, 150, 160, 25);
        userField.setBackground(getBackground());
        userField.setOpaque(true);
        userField.setFont(components.font);
        panel.add(userField);

        passLabel = new JLabel("Password");
        passLabel.setBounds(260, 200, 80, 50);
        panel.add(passLabel);

        passField = new JPasswordField(20);
        passField.setBounds(350, 200, 160, 25);
        panel.add(passField);

        loginButton = new JButton("Login");
        loginButton.setBounds(260, 250, 100, 25);
        loginButton.addActionListener(this);
        panel.add(loginButton);

        this.add(panel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            
            username = userField.getText();
            password = passField.getText();

            if (new validator().validate(username, password) == false){
                return;
            }else {
                database db = new database("users.txt");
                if (db.match("username=" + username + ",password=" + password)) {
                    this.dispose();
                    // new mainPage(username);
                    database loggedIn = new database("loggedIn.txt");
                    loggedIn.add(username);
                    JOptionPane.showMessageDialog(this, "Login successful");
                    
                    String type = db.getQueryResult(username, "accountType");
                    if (type.equals("Merchant")){
                        new merchantPage(username);
                    }else if (type.equals("Manufacturer")){
                        new manufacturerPage();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Username or password is incorrect");
                }
            }
        }
    }
}
