package GUI.Frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import src.*;

public class Menu extends JFrame {

    protected JPanel mainPanel;
    protected JLabel backgroundImageLabel, shoppingButtonLabel, cartButtonLabel, purchaseHistoryButtonLabel, servicingButtonLabel, changePasswordButtonLabel, jlabelsignout;

    protected JLabel avatarIconLabel, usernameLabel;

    public Menu() {

        setTitle("Menu");
        setSize(new Dimension(1016,638));
        mainPanel =new JPanel();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        mainPanel.setLayout(null);
        setResizable(false);
        setExtendedState(MAXIMIZED_HORIZ);

        //setIcon
        ImageIcon icon = new ImageIcon("res\\icon.png");
        setIconImage(icon.getImage());

        //set infoContainer

        //set avatar image icon
        ImageIcon avatarIcon = new ImageIcon("res\\avatarIcon.png");
        avatarIconLabel = new JLabel();
        avatarIconLabel.setIcon(avatarIcon);
        avatarIconLabel.setBounds(50, 60, 60, 60);
        avatarIconLabel.setVisible(true);
        mainPanel.add(avatarIconLabel);

        //set username
        usernameLabel = new JLabel("Welcome, " + Main.fullName);
        usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        //dark blue green color
        usernameLabel.setForeground(new Color(0, 128, 128));
        usernameLabel.setBounds(120, 60, 400, 60);
        usernameLabel.setVisible(true);
        mainPanel.add(usernameLabel);

        //action listener for avatarIconLabel
        avatarIconLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                //new editAccount();
                System.out.println("edit account");
                new ChangeInfo();
            }
            //show tooltip on hover
            @Override
            public void mouseEntered(MouseEvent e) {
                avatarIconLabel.setToolTipText("Edit Account");
            }

        });

        getContentPane().add(mainPanel);


        shoppingButtonLabel = new JLabel("");
        shoppingButtonLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new Shop();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
        });
        shoppingButtonLabel.setBounds(557, 138, 341, 60);
        mainPanel.add(shoppingButtonLabel);

        cartButtonLabel = new JLabel("");
        cartButtonLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new Cart();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
        });
        cartButtonLabel.setBounds(613, 233, 347, 60);
        mainPanel.add(cartButtonLabel);

        purchaseHistoryButtonLabel = new JLabel("");
        purchaseHistoryButtonLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                //new PurchaseHistory();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
        });
        purchaseHistoryButtonLabel.setBounds(533, 316, 341, 60);
        mainPanel.add(purchaseHistoryButtonLabel);

        servicingButtonLabel = new JLabel("");
        servicingButtonLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new Servicing();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
        });
        servicingButtonLabel.setBounds(347, 471, 347, 60);
        mainPanel.add(servicingButtonLabel);

        changePasswordButtonLabel = new JLabel("");
        changePasswordButtonLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                //new ChangePassword();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
        });

        changePasswordButtonLabel.setBounds(446, 397, 347, 60);
        mainPanel.add(changePasswordButtonLabel);


        backgroundImageLabel =new JLabel();
        backgroundImageLabel.setLocation(0, 0);
        backgroundImageLabel.setSize(1000, 600);
        backgroundImageLabel.setIcon(new ImageIcon("res\\Menu.png"));
        mainPanel.add(backgroundImageLabel);


        setBounds(0,0,1016,637);
        setLocationRelativeTo(null);
        setVisible(true);

    }
}


