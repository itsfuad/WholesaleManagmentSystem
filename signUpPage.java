import java.lang.*;
import java.util.*;
import java.util.regex.Pattern;
import java.io.*;
import javax.swing.*;

import utils.validator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class signUpPage extends JFrame implements ActionListener {
    private JLabel usernameLabel, passwordLabel, nameLabel, addressLabel, phoneLabel, emailLabel, stepCount,
            entityNameLabel, entityAddressLabel, entityPhoneLabel, entityEmailLabel, entityLicenseLabel;
    private JTextField usernameField, nameField, addressField, phoneField, emailField, entityNameField,
            entityAddressField, entityPhoneField, entityEmailField, entityLicenseField;
    private JPasswordField passwordField;
    private JButton nexButton, previousButton, merchantButton, manufacturerButton, cancelButton;
    private JPanel panel1, panel2, panel3, panel4;
    private String username, password, fullName, ownerAddress, ownerPhone, ownerEmail, accountType, entityName,
            entityAddress, entityPhone, entityEmail, entityLicense;
    private int step = 1;

    signUpPage() {
        super("Sign Up");

        initComponents();

        setSize(800, 450);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // disable maximize button and resizable window
        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_HORIZ);

        showStep1();
    }

    private void initComponents() {
        usernameLabel = new JLabel();
        passwordLabel = new JLabel();
        nameLabel = new JLabel();
        addressLabel = new JLabel();
        phoneLabel = new JLabel();
        emailLabel = new JLabel();
        stepCount = new JLabel();
        entityNameLabel = new JLabel();
        entityAddressLabel = new JLabel();
        entityPhoneLabel = new JLabel();
        entityEmailLabel = new JLabel();
        entityLicenseLabel = new JLabel();
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        nameField = new JTextField(20);
        addressField = new JTextField(20);
        phoneField = new JTextField(20);
        emailField = new JTextField(20);
        entityNameField = new JTextField(20);
        entityAddressField = new JTextField(20);
        entityPhoneField = new JTextField(20);
        entityEmailField = new JTextField(20);
        entityLicenseField = new JTextField(20);
        nexButton = new JButton();
        nexButton.addActionListener(this);
        previousButton = new JButton();
        previousButton.addActionListener(this);
        cancelButton = new JButton();
        cancelButton.addActionListener(this);
    }

    /**
     * Step 1. Fisrt panel on the same frame
     * Label: Create account as a,
     * two buttons: Merchant and Manufacturer
     */
    private void showStep1() {

        step = 1;

        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setSize(800, 450);

        stepCount.setBounds(10, 10, 80, 25);
        panel1.add(stepCount);

        JLabel createLabel = new JLabel("Create account as a,");
        createLabel.setBounds(260, 150, 150, 25);
        panel1.add(createLabel);

        merchantButton = new JButton("Merchant");
        merchantButton.setBounds(260, 200, 100, 25);
        merchantButton.addActionListener(this);
        panel1.add(merchantButton);

        manufacturerButton = new JButton("Manufacturer");
        manufacturerButton.setBounds(400, 200, 100, 25);
        manufacturerButton.addActionListener(this);
        panel1.add(manufacturerButton);
        
        if (panel2 != null) {
            panel2.setVisible(false);
            this.remove(panel2);
            System.out.println("removed panel2");
        }


        this.add(panel1);
    }

    /**
     * Step 2. Second panel on the same frame
     * Takes the Name, Address, Phone, and Email from the user
     */
    private void showStep2() {

        step = 2;

        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setSize(800, 450);

        stepCount.setText("Step 2/4");
        stepCount.setBounds(10, 10, 80, 25);
        panel2.add(stepCount);

        nameLabel.setText("Name");
        nameLabel.setBounds(260, 100, 80, 25);
        panel2.add(nameLabel);

        nameField.setBounds(350, 100, 160, 25);
        panel2.add(nameField);

        addressLabel.setText("Address");
        addressLabel.setBounds(260, 150, 80, 25);
        panel2.add(addressLabel);

        addressField.setBounds(350, 150, 160, 25);
        panel2.add(addressField);

        phoneLabel.setText("Phone");
        phoneLabel.setBounds(260, 200, 80, 25);
        panel2.add(phoneLabel);

        phoneField.setBounds(350, 200, 160, 25);
        panel2.add(phoneField);

        emailLabel.setText("Email");
        emailLabel.setBounds(260, 250, 80, 25);
        panel2.add(emailLabel);

        emailField.setBounds(350, 250, 160, 25);
        panel2.add(emailField);

        previousButton.setText("Previous");
        previousButton.setBounds(260, 300, 100, 25);
        panel2.add(previousButton);

        nexButton.setText("Next");
        nexButton.setBounds(400, 300, 100, 25);
        panel2.add(nexButton);



        if (panel1 != null) {
            panel1.setVisible(false);
            this.remove(panel1);
            System.out.println("removed panel1");
        }

        if (panel3 != null) {
            panel3.setVisible(false);
            this.remove(panel3);
            System.out.println("removed panel3");
        }

        this.add(panel2);
    }

    /**
     * Step 3. Third panel on the same frame
     * Takes info about Shop or Company depending on the account type
     */
    private void showStep3() {

        step = 3;

        panel3 = new JPanel();
        panel3.setLayout(null);
        panel3.setSize(800, 450);

        stepCount.setBounds(10, 10, 80, 25);
        panel3.add(stepCount);

        entityNameLabel.setBounds(260, 50, 80, 25);
        panel3.add(entityNameLabel);

        entityNameField.setBounds(350, 50, 160, 25);
        panel3.add(entityNameField);
        entityAddressLabel.setBounds(260, 100, 80, 25);
        panel3.add(entityAddressLabel);
        entityAddressField.setBounds(350, 100, 160, 25);
        panel3.add(entityAddressField);
        entityPhoneLabel.setBounds(260, 150, 80, 25);
        panel3.add(entityPhoneLabel);
        entityPhoneField.setBounds(350, 150, 160, 25);
        panel3.add(entityPhoneField);
        entityEmailLabel.setBounds(260, 200, 80, 25);
        panel3.add(entityEmailLabel);
        entityEmailField.setBounds(350, 200, 160, 25);
        panel3.add(entityEmailField);
        entityLicenseLabel.setBounds(260, 250, 80, 25);
        panel3.add(entityLicenseLabel);
        entityLicenseField.setBounds(350, 250, 160, 25);
        panel3.add(entityLicenseField);
        previousButton.setBounds(260, 300, 100, 25);
        panel3.add(previousButton);
        nexButton.setBounds(400, 300, 100, 25);
        panel3.add(nexButton);
        if (accountType.equals("Manufacturer")) {

            stepCount.setText("Step 3/4");

            entityNameLabel.setText("Company Name");

            entityAddressLabel.setText("Company Address");

            entityPhoneLabel.setText("Company Phone");

            entityEmailLabel.setText("Company Email");

            entityLicenseLabel.setText("Company License");

            previousButton.setText("Previous");

            nexButton.setText("Next");
        
            if (panel2 != null) {
                panel2.setVisible(false);
                this.remove(panel2);
                System.out.println("removed panel2");
            }
    
            if (panel4 != null) {
                panel4.setVisible(false);
                this.remove(panel4);
                System.out.println("removed panel4");
            }
    
            this.add(panel3);
            
        } else if (accountType.equals("Merchant")) {

            stepCount.setText("Step 3/4");

            entityNameLabel.setText("Shop Name");

            entityAddressLabel.setText("Shop Address");

            entityPhoneLabel.setText("Shop Phone");

            entityEmailLabel.setText("Shop Email");

            entityLicenseLabel.setText("Shop License");

            previousButton.setText("Previous");

            nexButton.setText("Next");

            if (panel2 != null) {
                panel2.setVisible(false);
                this.remove(panel2);
                System.out.println("removed panel2");
            }
    
            if (panel4 != null) {
                panel4.setVisible(false);
                this.remove(panel4);
                System.out.println("removed panel4");
            }
    
            this.add(panel3);

        } else {
            System.out.println("Error: Account type not found");
        }
    }

    /**
     * Step 4. Fourth panel on the same frame
     * Takes the Username and Password from the user
     */
    private void showStep4() {
        
        step = 4;

        panel4 = new JPanel();
        panel4.setLayout(null);
        panel4.setSize(800, 450);

        stepCount.setText("Step 4/4");
        stepCount.setBounds(10, 10, 80, 25);
        panel4.add(stepCount);

        usernameLabel.setText("Username");
        usernameLabel.setBounds(260, 150, 80, 25);
        panel4.add(usernameLabel);

        usernameField = new JTextField(20);
        usernameField.setBounds(350, 150, 160, 25);
        panel4.add(usernameField);

        passwordLabel.setText("Password");
        passwordLabel.setBounds(260, 200, 80, 25);
        panel4.add(passwordLabel);

        passwordField = new JPasswordField(20);
        passwordField.setBounds(350, 200, 160, 25);
        panel4.add(passwordField);

        previousButton.setText("Previous");
        previousButton.setBounds(120, 250, 100, 25);
        panel4.add(previousButton);

        nexButton.setText("Finish");
        nexButton.setBounds(260, 250, 100, 25);
        panel4.add(nexButton);

        cancelButton.setText("Cancel");
        cancelButton.setBounds(400, 250, 100, 25);
        panel4.add(cancelButton);

        if (panel3 != null) {
            panel3.setVisible(false);
            this.remove(panel3);
            System.out.println("removed panel3");
        }

        this.add(panel4);
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("Clicked on " + e.getActionCommand() + " button");
        if (e.getSource() == nexButton) {
            if (step == 2) {
                fullName = nameField.getText();
                ownerAddress = addressField.getText();
                ownerPhone = phoneField.getText();
                ownerEmail = emailField.getText();

                if (fullName.equals("") || ownerAddress.equals("") || ownerPhone.equals("") || ownerEmail.equals("")) {
                    JOptionPane.showMessageDialog(this, "Please fill all the fields");
                    return;
                }

                // email validation
                if (!ownerEmail.contains("@") || !ownerEmail.contains(".")) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid email address");
                    return;
                }

                showStep3();
            } else if (step == 3) {
                entityName = entityNameField.getText();
                entityAddress = entityAddressField.getText();
                entityPhone = entityPhoneField.getText();
                entityEmail = entityEmailField.getText();
                entityLicense = entityLicenseField.getText();

                if (entityName.equals("") || entityAddress.equals("") || entityPhone.equals("")
                        || entityEmail.equals("") || entityLicense.equals("")) {
                    JOptionPane.showMessageDialog(this, "Please fill all the fields");
                    return;
                }

                // email validation
                if (!entityEmail.contains("@") || !entityEmail.contains(".")) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid email address");
                    return;
                }

                showStep4();
            } else if (step == 4) {
                System.out.println("Last step");

                username = usernameField.getText();
                password = passwordField.getText();


                if (new validator().validate(username, password) == false){
                    return;
                }


                // database write
                database db = new database("users.txt");

                // find if username already exists
                if (db.match("username=" + username)) {
                    JOptionPane.showMessageDialog(this, "Username already exists");
                    return;
                }

                String record = "username=" + username + ",password=" + password + ",accountType=" + accountType
                        + ",fullName=" + fullName + ",ownerAddress=" + ownerAddress + ",ownerPhone=" + ownerPhone
                        + ",ownerEmail=" + ownerEmail + ",entityName=" + entityName + ",entityAddress=" + entityAddress
                        + ",entityPhone=" + entityPhone + ",entityEmail=" + entityEmail + ",entityLicense="
                        + entityLicense + "\n";

                db.add(record);

                JOptionPane.showMessageDialog(this, "Account created successfully");
                this.dispose();
                new loginPage();
            }

        }else if (e.getSource() == previousButton){
            if (step == 2){
                showStep1();
            }else if (step == 3){
                showStep2();
            }else if (step == 4){
                showStep3();
            }
        } else if (e.getSource() == merchantButton) {
            accountType = "Merchant";
            panel1.setVisible(false);
            showStep2();
        } else if (e.getSource() == manufacturerButton) {
            accountType = "Manufacturer";
            panel1.setVisible(false);
            showStep2();
        } else if (e.getSource() == cancelButton) {
            this.setVisible(false);
            new signUpPage();
        }
    }
}
