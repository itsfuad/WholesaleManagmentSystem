package GUI.Frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Database.Database;
import GUI.Checkpoint.*;
import Validator.Validator;
import src.*;


public class ChangeInfo extends JFrame{
    private JPanel mainPanel, changeInfoPanel, changePasswordPanel;
    private JLabel avatarIconLabel, backgroundImageLabel, changeInfoButton, changePasswordButton, userFullNameLabel, userAddressLabel, shopNameLabel, shopAddressLabel, oldPasswordLabel, newPasswordLabel, confirmPasswordLabel, saveChangesButtonLabel, logoutButtonLabel, backButtonLabel;
    private JTextField userFullNameTextField, userAddressTextField, shopNameTextField, shopAddressTextField, oldPasswordField, newPasswordField, confirmPasswordField;

    boolean isPasswordPanelVisible = false;

    public ChangeInfo(){
        setTitle("Change Info");
        setSize(new Dimension(1000, 600));
        mainPanel =new JPanel();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        mainPanel.setLayout(null);
        setResizable(false);
        setExtendedState(MAXIMIZED_HORIZ);
        setLocationRelativeTo(null);

        //backbutton
        backButtonLabel = new JLabel("Back");
        backButtonLabel.setForeground(new Color(255, 255, 255));
        backButtonLabel.setBounds(800, 500, 120, 40);
        backButtonLabel.setHorizontalAlignment(JLabel.CENTER);
        backButtonLabel.setVerticalAlignment(JLabel.CENTER);
        backButtonLabel.setBackground(new Color(0, 0, 0));
        backButtonLabel.setOpaque(true);
        backButtonLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Menu();
                dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                backButtonLabel.setBackground(new Color(40, 40, 40));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                backButtonLabel.setBackground(new Color(0, 0, 0));
            }
        });
        mainPanel.add(backButtonLabel);

        Database db = new Database("users.txt");
        String address = db.getQueryResult(Main.USERNAME, "ownerAddress");
        String shopName = db.getQueryResult(Main.USERNAME, "entityName");
        String shopAddress = db.getQueryResult(Main.USERNAME, "entityAddress");

        changeInfoPanel = new JPanel();
        changeInfoPanel.setLayout(null);
        changeInfoPanel.setBounds(280, 0, 720, 600);
        changeInfoPanel.setBackground(new Color(148, 200, 248));

        //childs of changeInfoPanel


        /**
         * |------------------------------------|
         * | Your info         | Shop info      |
         * |------------------------------------|
         * | Full name         | Shop name      |
         * | Address           | Shop address   |
         * |------------------------------------|
         * | Save changes      |                |
         */

        JLabel yourInfoLabel = new JLabel("Your Info");
        yourInfoLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        yourInfoLabel.setForeground(Color.white);
        yourInfoLabel.setBounds(50, 50, 200, 60);
        yourInfoLabel.setVisible(true);
        changeInfoPanel.add(yourInfoLabel);

        userFullNameLabel = new JLabel("Full Name");
        userFullNameLabel.setForeground(Color.white);
        userFullNameLabel.setBounds(50, 100, 200, 30);
        changeInfoPanel.add(userFullNameLabel);

        userFullNameTextField = new JTextField();
        userFullNameTextField.setBounds(50, 130, 200, 30);
        userFullNameTextField.setText(Main.fullName);
        //border none
        userFullNameTextField.setBorder(BorderFactory.createEmptyBorder());
        changeInfoPanel.add(userFullNameTextField);

        userAddressLabel = new JLabel("Address");
        userAddressLabel.setForeground(Color.white);
        userAddressLabel.setBounds(50, 170, 200, 30);
        changeInfoPanel.add(userAddressLabel);

        userAddressTextField = new JTextField();
        userAddressTextField.setBounds(50, 200, 200, 30);
        userAddressTextField.setText(address);
        //border none
        userAddressTextField.setBorder(BorderFactory.createEmptyBorder());
        changeInfoPanel.add(userAddressTextField);

        JLabel shopInfoLabel = new JLabel("Shop Info");
        shopInfoLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        shopInfoLabel.setForeground(Color.white);
        shopInfoLabel.setBounds(50, 260, 200, 60);
        shopInfoLabel.setVisible(true);
        changeInfoPanel.add(shopInfoLabel);

        shopNameLabel = new JLabel("Shop Name");
        shopNameLabel.setForeground(Color.white);
        shopNameLabel.setBounds(50, 310, 200, 30);
        changeInfoPanel.add(shopNameLabel);

        shopNameTextField = new JTextField();
        shopNameTextField.setBounds(50, 340, 200, 30);
        shopNameTextField.setText(shopName);
        //border none
        shopNameTextField.setBorder(BorderFactory.createEmptyBorder());
        changeInfoPanel.add(shopNameTextField);

        shopAddressLabel = new JLabel("Shop Address");
        shopAddressLabel.setForeground(Color.white);
        shopAddressLabel.setBounds(50, 380, 200, 30);
        changeInfoPanel.add(shopAddressLabel);

        shopAddressTextField = new JTextField();
        shopAddressTextField.setBounds(50, 410, 200, 30);
        shopAddressTextField.setText(shopAddress);
        //border none
        shopAddressTextField.setBorder(BorderFactory.createEmptyBorder());
        changeInfoPanel.add(shopAddressTextField);



        //saveChangesButtonLabel
        saveChangesButtonLabel = new JLabel("Save Changes");
        saveChangesButtonLabel.setForeground(new Color(255, 255, 255));
        saveChangesButtonLabel.setBounds(330, 500, 120, 40);
        saveChangesButtonLabel.setHorizontalAlignment(JLabel.CENTER);
        saveChangesButtonLabel.setVerticalAlignment(JLabel.CENTER);
        saveChangesButtonLabel.setBackground(new Color(8, 135, 238));
        saveChangesButtonLabel.setOpaque(true);

        mainPanel.add(saveChangesButtonLabel);
        saveChangesButtonLabel.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){

                if (!isPasswordPanelVisible){
                    System.out.println("Saving changes...");
                    String fullName = userFullNameTextField.getText();
                    String address = userAddressTextField.getText();
                    String shopName = shopNameTextField.getText();
                    String shopAddress = shopAddressTextField.getText();

                    if (new Validator().validateAll(new String[]{fullName, address, shopName, shopAddress})){
                        System.out.println("All fields are valid");
                        Database db = new Database("users.txt");
                        db.update(Main.USERNAME, "fullName", fullName);
                        db.update(Main.USERNAME, "ownerAddress", address);
                        db.update(Main.USERNAME, "entityName", shopName);
                        db.update(Main.USERNAME, "entityAddress", shopAddress);
                        JOptionPane.showMessageDialog(null, "Changes saved successfully");
                    }
                }else{
                    System.out.println("Saving password...");
                    String oldPassword = oldPasswordField.getText();
                    String newPassword = newPasswordField.getText();
                    String confirmPassword = confirmPasswordField.getText();

                    Database db = new Database("users.txt");
                    String password = db.getQueryResult(Main.USERNAME, "password");

                    Validator validator = new Validator();
                    if (!validator.validatePassword(oldPassword)){
                        return;
                    }
                    if (!validator.validatePassword(newPassword)){
                        return;
                    }
                    if (!validator.validatePassword(confirmPassword)){
                        return;
                    }
                    if (!oldPassword.equals(password)){
                        JOptionPane.showMessageDialog(null, "Old password is incorrect");
                        return;
                    }
                    if (!newPassword.equals(confirmPassword)){
                        JOptionPane.showMessageDialog(null, "New password and confirm password do not match");
                        return;
                    }

                    System.out.println("All fields are valid");

                    db.update(Main.USERNAME, "password", newPassword);
                    JOptionPane.showMessageDialog(null, "Password changed successfully");
                }

            }

            public void mouseEntered(MouseEvent e){
                saveChangesButtonLabel.setBackground(new Color(9, 117, 204));
            }

            public void mouseExited(MouseEvent e){
                saveChangesButtonLabel.setBackground(new Color(8, 135, 238));
            }
        });





        changePasswordPanel = new JPanel();
        changePasswordPanel.setLayout(null);
        changePasswordPanel.setBounds(280, 0, 720, 600);
        changePasswordPanel.setBackground(new Color(148, 200, 248));

        //childs of changePasswordPanel
        JLabel changePasswordLabel = new JLabel("Change Password");
        changePasswordLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        changePasswordLabel.setForeground(Color.white);
        changePasswordLabel.setBounds(50, 50, 300, 60);
        changePasswordPanel.add(changePasswordLabel);

        oldPasswordLabel = new JLabel("Old Password");
        oldPasswordLabel.setForeground(Color.white);
        oldPasswordLabel.setBounds(50, 150, 200, 30);
        changePasswordPanel.add(oldPasswordLabel);

        oldPasswordField = new JTextField();
        oldPasswordField.setBounds(50, 180, 200, 30);
        oldPasswordField.setBorder(BorderFactory.createEmptyBorder());
        changePasswordPanel.add(oldPasswordField);

        newPasswordLabel = new JLabel("New Password");
        newPasswordLabel.setForeground(Color.white);
        newPasswordLabel.setBounds(50, 220, 200, 30);
        changePasswordPanel.add(newPasswordLabel);

        newPasswordField = new JTextField();
        newPasswordField.setBounds(50, 250, 200, 30);
        newPasswordField.setBorder(BorderFactory.createEmptyBorder());
        changePasswordPanel.add(newPasswordField);

        confirmPasswordLabel = new JLabel("Confirm Password");
        confirmPasswordLabel.setForeground(Color.white);
        confirmPasswordLabel.setBounds(50, 290, 200, 30);
        changePasswordPanel.add(confirmPasswordLabel);

        confirmPasswordField = new JTextField();
        confirmPasswordField.setBounds(50, 320, 200, 30);
        confirmPasswordField.setBorder(BorderFactory.createEmptyBorder());
        changePasswordPanel.add(confirmPasswordField);





        changeInfoPanel.setVisible(true);
        changePasswordPanel.setVisible(false);

        mainPanel.add(changeInfoPanel);
        mainPanel.add(changePasswordPanel);

        //setIcon
        ImageIcon icon = new ImageIcon("res\\icon.png");
        setIconImage(icon.getImage());

        ImageIcon avatarIcon = new ImageIcon("res\\avatarIcon.png");
        avatarIconLabel = new JLabel();
        avatarIconLabel.setIcon(avatarIcon);
        avatarIconLabel.setBounds(50, 60, 60, 60);
        mainPanel.add(avatarIconLabel);

        //navigation buttons
        //change info button
        changeInfoButton = new JLabel("General Info");
        changeInfoButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        changeInfoButton.setForeground(new Color(250, 250, 250));
        changeInfoButton.setBounds(50, 150, 200, 60);
        mainPanel.add(changeInfoButton);
        //action listener for changeInfoButton
        changeInfoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                changeInfoButton.setForeground(new Color(255, 255, 255));
            }
            //mouse exit
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (isPasswordPanelVisible){
                    changeInfoButton.setForeground(new Color(230, 230, 230));
                }
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                //show changeInfoPanel
                System.out.println("change info");
                changeInfoButton.setForeground(new Color(255, 255, 255));
                changePasswordButton.setForeground(new Color(230, 230, 230));
                isPasswordPanelVisible = false;
                changeInfoPanel.setVisible(true);
                changePasswordPanel.setVisible(false);
            }
        });

        //change password button,
        changePasswordButton = new JLabel("Change Password");
        changePasswordButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        changePasswordButton.setForeground(new Color(230, 230, 230));
        changePasswordButton.setBounds(50, 200, 200, 60);
        mainPanel.add(changePasswordButton);
        //action listener for changePasswordButton
        changePasswordButton.addMouseListener(new java.awt.event.MouseAdapter() {

            //hover effect
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                changePasswordButton.setForeground(new Color(255, 255, 255));
            }
            //mouse exit
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (!isPasswordPanelVisible){
                    changePasswordButton.setForeground(new Color(230, 230, 230));
                }
            }

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                //show changePasswordPanel
                changeInfoPanel.setVisible(false);
                changePasswordPanel.setVisible(true);
                isPasswordPanelVisible = true;
                System.out.println("change password");
                changePasswordButton.setForeground(new Color(255, 255, 255));
                changeInfoButton.setForeground(new Color(230, 230, 230));
            }
        });


        //logout button
        logoutButtonLabel = new JLabel("Logout");
        logoutButtonLabel.setForeground(new Color(255, 255, 255));
        logoutButtonLabel.setBackground(new Color(230, 0, 0));
        logoutButtonLabel.setBounds(50, 500, 120, 40);
        //align text to center
        logoutButtonLabel.setHorizontalAlignment(JLabel.CENTER);
        logoutButtonLabel.setOpaque(true);
        mainPanel.add(logoutButtonLabel);

        logoutButtonLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dispose();
                new DefaultPage();
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutButtonLabel.setBackground(new Color(255, 0, 0));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutButtonLabel.setBackground(new Color(230, 0, 0));
            }
        });


        mainPanel.setBackground(new Color(123, 182, 245));
        add(mainPanel);
        setVisible(true);

    }
}
