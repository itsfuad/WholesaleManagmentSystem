package GUI.Checkpoint;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Validator.*;
import src.Main;


public class Signup extends JFrame implements MouseListener {

    protected JFrame jframe;
    protected JLabel backgroundImageLabel, usernameLabel, userAddressLabel, userPhoneNumberLabel, shopNameLabel, shopAddressLabel, shopPhoneNumberLabel, userIdLabel,
            createPasswordLabel, confirmPasswordLabel, nextButton, backButtonLabel;
    private JTextField usernameField, userAddressField, userPhoneNumberField, shopNameField, shopAddressField, shopPhoneNumberField, userIdField,
            createPasswordField, confirmPasswordField;
    private JPanel jpanel1, jpanel2, jpanel3, jpanel4;
    private String username, password, confirmpassword, fullName, ownerAddress, ownerPhone,
            entityName,
            entityAddress, entityPhone;
    private int step = 1;

    Signup() {
        setTitle("SignUp");
        setSize(new Dimension(1016, 638));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane();
        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_HORIZ);
        setLocationRelativeTo(null);
        setVisible(true);

        //setIcon
        ImageIcon icon = new ImageIcon("res\\icon.png");
        setIconImage(icon.getImage());

        showStep1();
    }

    /**
     * Step 2. Second panel on the same frame
     * Takes the Name, Address, Phone, and Email from the user
     */
    private void showStep1() {// signup1

        step = 1;

        jpanel1 = new JPanel();
        jpanel1.setLayout(null);
        jpanel1.setSize(1000, 600);

        nextButton = new JLabel("");// next
        nextButton.addMouseListener(this);
        nextButton.setBounds(435, 432, 131, 34);
        jpanel1.add(nextButton);

        backButtonLabel = new JLabel("");// back
        backButtonLabel.addMouseListener(this);
        backButtonLabel.setBounds(37, 38, 67, 64);
        jpanel1.add(backButtonLabel);

        usernameLabel = new JLabel();
        usernameLabel.setText("Your Name");
        usernameLabel.setBounds(401, 247, 194, 20);
        jpanel1.add(usernameLabel);
        userAddressLabel = new JLabel();
        userAddressLabel.setText("Your Address");
        userAddressLabel.setBounds(401, 304, 194, 20);
        jpanel1.add(userAddressLabel);
        userPhoneNumberLabel = new JLabel();
        userPhoneNumberLabel.setText("Enter Phone no.");
        userPhoneNumberLabel.setBounds(401, 361, 194, 20);
        jpanel1.add(userPhoneNumberLabel);

        usernameField = new JTextField();

        usernameField.setFont(new Font("Tahoma", Font.BOLD, 11));
        usernameField.setCaretColor(new Color(30, 144, 255));
        usernameField.setBorder(null);
        usernameField.setOpaque(false);
        usernameField.setBounds(401, 267, 194, 20);
        jpanel1.add(usernameField);
        usernameField.setColumns(10);

        userAddressField = new JTextField();

        userAddressField.setFont(new Font("Tahoma", Font.BOLD, 11));
        userAddressField.setOpaque(false);
        userAddressField.setBorder(null);
        userAddressField.setBounds(401, 324, 194, 20);
        jpanel1.add(userAddressField);
        userAddressField.setColumns(10);

        userPhoneNumberField = new JTextField();

        userPhoneNumberField.setFont(new Font("Tahoma", Font.BOLD, 11));
        userPhoneNumberField.setOpaque(false);
        userPhoneNumberField.setCaretColor(new Color(30, 144, 255));
        userPhoneNumberField.setBorder(null);
        userPhoneNumberField.setBounds(401, 381, 194, 20);
        jpanel1.add(userPhoneNumberField);
        userPhoneNumberField.setColumns(10);

        backgroundImageLabel = new JLabel();
        backgroundImageLabel.setSize(1000, 600);
        backgroundImageLabel.setIcon(new ImageIcon("res\\SignUp1.png"));
        jpanel1.add(backgroundImageLabel);
        setBounds(0, 0, 1016, 637);
        setLocationRelativeTo(null);


        if (jpanel2 != null) {
            jpanel2.setVisible(false);
            remove(jpanel2);
            System.out.println("removed panel3");
        }

        getContentPane().add(jpanel1);
    }

    /**
     * Step 3. Third panel on the same frame
     * Takes info about Shop or Company depending on the account type
     */
    private void showStep2() {

        step = 2;

        jpanel2 = new JPanel();
        jpanel2.setLayout(null);
        jpanel2.setSize(1000, 600);

        nextButton = new JLabel("");// next
        nextButton.addMouseListener(this);
        nextButton.setBounds(435, 432, 131, 34);
        jpanel2.add(nextButton);

        backButtonLabel = new JLabel("");// back
        backButtonLabel.addMouseListener(this);
        backButtonLabel.setBounds(37, 38, 67, 64);
        jpanel2.add(backButtonLabel);

        shopNameLabel = new JLabel();
        shopNameLabel.setText("Shop Name");
        shopNameLabel.setBounds(401, 247, 194, 20);
        jpanel2.add(shopNameLabel);
        shopAddressLabel = new JLabel();
        shopAddressLabel.setText("Shop Address");
        shopAddressLabel.setBounds(401, 304, 194, 20);
        jpanel2.add(shopAddressLabel);
        shopPhoneNumberLabel = new JLabel();
        shopPhoneNumberLabel.setText("Shop Phone no.");
        shopPhoneNumberLabel.setBounds(401, 361, 194, 20);
        jpanel2.add(shopPhoneNumberLabel);

        shopNameField = new JTextField();

        shopNameField.setFont(new Font("Tahoma", Font.BOLD, 11));
        shopNameField.setCaretColor(new Color(30, 144, 255));
        shopNameField.setBorder(null);
        shopNameField.setOpaque(false);
        shopNameField.setBounds(401, 267, 194, 20);
        jpanel2.add(shopNameField);
        shopNameField.setColumns(10);

        shopAddressField = new JTextField();

        shopAddressField.setFont(new Font("Tahoma", Font.BOLD, 11));
        shopAddressField.setOpaque(false);
        shopAddressField.setBorder(null);
        shopAddressField.setBounds(401, 324, 194, 20);
        jpanel2.add(shopAddressField);
        shopAddressField.setColumns(10);

        shopPhoneNumberField = new JTextField();

        shopPhoneNumberField.setFont(new Font("Tahoma", Font.BOLD, 11));
        shopPhoneNumberField.setOpaque(false);
        shopPhoneNumberField.setCaretColor(new Color(30, 144, 255));
        shopPhoneNumberField.setBorder(null);
        shopPhoneNumberField.setBounds(401, 381, 194, 20);
        jpanel2.add(shopPhoneNumberField);
        shopPhoneNumberField.setColumns(10);

        backgroundImageLabel = new JLabel();
        backgroundImageLabel.setSize(1000, 600);
        backgroundImageLabel.setIcon(new ImageIcon("res\\SignUp2.png"));
        jpanel2.add(backgroundImageLabel);
        setBounds(0, 0, 1016, 637);
        setLocationRelativeTo(null);
        if (jpanel1 != null) {
            jpanel1.setVisible(false);
            remove(jpanel1);
            System.out.println("removed panel2");
        }

        if (jpanel3 != null) {
            jpanel3.setVisible(false);
            remove(jpanel3);
            System.out.println("removed panel4");
        }

        add(jpanel2);

    }

    /**
     * Step 4. Fourth panel on the same frame
     * Takes the Username and Password from the user
     */
    private void showStep3() {

        step = 3;

        jpanel3 = new JPanel();
        jpanel3.setLayout(null);
        jpanel3.setSize(1000, 600);

        nextButton = new JLabel("");// next
        nextButton.addMouseListener(this);
        nextButton.setBounds(435, 432, 131, 34);
        jpanel3.add(nextButton);

        backButtonLabel = new JLabel("");// back
        backButtonLabel.addMouseListener(this);
        backButtonLabel.setBounds(37, 38, 67, 64);
        jpanel3.add(backButtonLabel);

        userIdLabel = new JLabel();
        userIdLabel.setText("UserID");
        userIdLabel.setBounds(401, 247, 194, 20);
        jpanel3.add(userIdLabel);
        createPasswordLabel = new JLabel();
        createPasswordLabel.setText("Create Password");
        createPasswordLabel.setBounds(401, 304, 194, 20);
        jpanel3.add(createPasswordLabel);
        confirmPasswordLabel = new JLabel();
        confirmPasswordLabel.setText("Confirm Password");
        confirmPasswordLabel.setBounds(401, 361, 194, 20);
        jpanel3.add(confirmPasswordLabel);

        userIdField = new JTextField();

        userIdField.setFont(new Font("Tahoma", Font.BOLD, 11));
        userIdField.setCaretColor(new Color(30, 144, 255));
        userIdField.setBorder(null);
        userIdField.setOpaque(false);
        userIdField.setBounds(401, 267, 194, 20);
        jpanel3.add(userIdField);
        userIdField.setColumns(10);

        createPasswordField = new JTextField();

        createPasswordField.setFont(new Font("Tahoma", Font.BOLD, 11));
        createPasswordField.setOpaque(false);
        createPasswordField.setBorder(null);
        createPasswordField.setBounds(401, 324, 194, 20);
        jpanel3.add(createPasswordField);
        createPasswordField.setColumns(10);

        confirmPasswordField = new JTextField();

        confirmPasswordField.setFont(new Font("Tahoma", Font.BOLD, 11));
        confirmPasswordField.setOpaque(false);
        confirmPasswordField.setCaretColor(new Color(30, 144, 255));
        confirmPasswordField.setBorder(null);
        confirmPasswordField.setBounds(401, 381, 194, 20);
        jpanel3.add(confirmPasswordField);
        confirmPasswordField.setColumns(10);

        backgroundImageLabel = new JLabel();
        backgroundImageLabel.setSize(1000, 600);
        backgroundImageLabel.setIcon(new ImageIcon("res\\SignUp3.png"));
        jpanel3.add(backgroundImageLabel);
        setBounds(0, 0, 1016, 637);
        setLocationRelativeTo(null);
        System.out.println("figures");
        if (jpanel2 != null) {
            jpanel2.setVisible(false);
            remove(jpanel2);
            System.out.println("removed panel3");
        }

        if (jpanel3 != null) {
            jpanel2.setVisible(false);
            remove(jpanel2);
            System.out.println("removed panel3");
        }

        add(jpanel3);
    }

    public void showStep4() {
        step = 4;
        jpanel4 = new JPanel();
        jpanel4.setLayout(null);
        jpanel4.setSize(1000, 600);

        nextButton = new JLabel("");// go to login
        nextButton.addMouseListener(this);
        nextButton.setBounds(424, 285, 152, 30);
        jpanel4.add(nextButton);

        backgroundImageLabel = new JLabel();
        backgroundImageLabel.setSize(1000, 600);
        backgroundImageLabel.setIcon(new ImageIcon("res\\SignUp4.png"));
        jpanel4.add(backgroundImageLabel);
        setBounds(0, 0, 1016, 637);
        setLocationRelativeTo(null);

        jpanel1.setVisible(false);
        jpanel2.setVisible(false);
        jpanel3.setVisible(false);

        add(jpanel4);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        System.out.println("Clicked on " + /* e.getActionCommand() + */ " button");
        if (e.getSource() == nextButton) {

            if (step == 1) {

                fullName = usernameField.getText();
                ownerAddress = userAddressField.getText();
                ownerPhone = userPhoneNumberField.getText();

                //validate phone number
                if (ownerPhone.length() != 11) {
                    JOptionPane.showMessageDialog(jframe, "Invalid Phone Number");
                    return;
                }

                //check if phone number is a number
                try {
                    Long.parseLong(ownerPhone);
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(jframe, "Invalid Phone Number");
                    return;
                }

                // ownerEmail = emailField.getText();

                if (fullName.equals("") || ownerAddress.equals("") || ownerPhone.equals("")) {
                    JOptionPane.showMessageDialog(jframe, "Please fill all the fields");
                    return;
                }

                // email validation
                // if (!ownerEmail.contains("@") || !ownerEmail.contains(".")) {
                // JOptionPane.showMessageDialog(jframe, "Please enter a valid email address");
                // return;
                // }

                showStep2();
            } else if (step == 2) {

                entityName = shopNameField.getText();
                entityAddress = shopAddressField.getText();
                entityPhone = shopPhoneNumberField.getText();
                // entityEmail = entityEmailField.getText();
                // entityLicense = jtextfield5.getText();

                //validate phone number
                if (entityPhone.length() != 11) {
                    JOptionPane.showMessageDialog(jframe, "Invalid Phone Number");
                    return;
                }

                //check if phone number is a number
                try {
                    Long.parseLong(entityPhone);
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(jframe, "Invalid Phone Number");
                    return;
                }


                if (entityName.equals("") || entityAddress.equals("") || entityPhone.equals("")
                    /* || entityEmail.equals("") || entityLicense.equals("") */) {
                    JOptionPane.showMessageDialog(jframe, "Please fill all the fields");
                    return;
                }

                // email validation
                // if (!entityEmail.contains("@") || !entityEmail.contains(".")) {
                // JOptionPane.showMessageDialog(jframe, "Please enter a valid email address");
                // return;
                // }

                showStep3();
            } else if (step == 3) {

                System.out.println("Last step");

                username = userIdField.getText();
                password = createPasswordField.getText();
                confirmpassword = confirmPasswordField.getText();

                if (new Validator().validate(username, password) == false) {
                    return;
                }

                if (new Validator().validatePassword(confirmpassword) == false) {
                    return;
                }

                // find if username already exists
                if (Main.UsersDatabase.match("username=" + username)) {

                    JOptionPane.showMessageDialog(jframe, "Username already exists");
                    return;
                }

                if (!password.equals(confirmpassword)) {
                    JOptionPane.showMessageDialog(jframe, "Passwords do not match");
                    return;
                }

                String record = "username=" + username + ",password=" + password
                        + ",fullName=" + fullName + ",ownerAddress=" + ownerAddress + ",ownerPhone=" + ownerPhone
                        + /* ",ownerEmail=" + ownerEmail + */ ",entityName=" + entityName + ",entityAddress="
                        + entityAddress
                        + ",entityPhone=" + entityPhone;


                Main.UsersDatabase.add(record);

                // JOptionPane.showMessageDialog(jframe, "Account created successfully");
                showStep4();
            } else if (step == 4) {
                dispose();
                new Login();
            }

        } else if (e.getSource() == backButtonLabel) {

            if (step == 1) {
                dispose();
                new Login();
            }else if (step == 2) {
                showStep1();
            } else if (step == 3) {
                showStep2();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {


    }

    @Override
    public void mouseReleased(MouseEvent e) {


    }

    @Override
    public void mouseEntered(MouseEvent e) {


    }

    @Override
    public void mouseExited(MouseEvent e) {


    }
}
