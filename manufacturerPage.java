import java.lang.*;
import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class manufacturerPage extends JFrame implements ActionListener{

    private JPanel panel;
    private JLabel welcomeLabel;
    private JButton logoutButton;

    public manufacturerPage(){
        super("Manufacturer");
        setSize(800, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // disable maximize button and resizable window
        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_HORIZ);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setSize(800, 450);

        welcomeLabel = new JLabel("Welcome to Wholesale Management System - Manufacturer");
        welcomeLabel.setBounds(260, 150, 300, 25);
        panel.add(welcomeLabel);

        logoutButton = new JButton("Logout");
        logoutButton.setBounds(260, 250, 100, 25);
        logoutButton.addActionListener(this);
        panel.add(logoutButton);

        this.add(panel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logoutButton) {
            new loginPage();
            this.dispose();
            database db = new database("loggedIn.txt");
            db.clear();
        }
    }
}
