package GUI.Checkpoint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import GUI.Frames.Menu;
import Validator.*;
import src.Main;

public class Login extends JFrame {
    protected JPanel jpanel;
    protected JLabel jlabel,jlabel1,jlabel2,jlabel3,jlabel4;
    protected JTextField jtextfield;
    protected JPasswordField jpasswordfield;
    private String username, password;

    public Login() {
        
        setTitle("LogIn");//
        setSize(new Dimension(1016,638));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jpanel=new JPanel();
        getContentPane().add(jpanel);
        jpanel.setLayout(null);
        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_HORIZ);

        //setIcon
        ImageIcon icon = new ImageIcon("res\\icon.png");
        setIconImage(icon.getImage());


        jlabel1 = new JLabel("");
        jlabel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new Signup();
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

        jtextfield = new JTextField();
        jtextfield.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                jlabel3.setText("");
            }
        });

        jlabel3=new JLabel();
        jlabel3.setText("Enter UserID");
        jlabel3.setBounds(415, 260, 214, 29);
        jpanel.add(jlabel3);

        jlabel4=new JLabel();
        jlabel4.setText("Enter Password");
        jlabel4.setBounds(415, 331, 214, 29);
        jpanel.add(jlabel4);
        jtextfield.setFont(new Font("Tahoma", Font.BOLD, 11));
        jtextfield.setBorder(null);
        jtextfield.setCaretColor(new Color(30, 144, 255));
        jtextfield.setDisabledTextColor(new Color(240, 240, 240));
        jtextfield.setOpaque(false);
        jtextfield.setBounds(415, 260, 214, 29);
        jpanel.add(jtextfield);
        jtextfield.setColumns(10);
        jlabel1.setBounds(455, 392, 118, 29);
        jpanel.add(jlabel1);

        jlabel2 = new JLabel("");
        jlabel2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                username = jtextfield.getText();
                password = jpasswordfield.getText();

                if (new Validator().validate(username, password) == false){
                    return;
                }else {
                    System.out.println("username=" + username + ",password=" + password);
                    System.out.println(Main.UsersDatabase.getQueryResult("fuad", "password"));
                    if (Main.UsersDatabase.match("username=" + username + ",password=" + password)) {
                        Main.LoggedInDatabase.add(username);
                        Main.USERNAME = username;
                        Main.fullName = Main.UsersDatabase.getQueryResult(username, "fullName");
                        JOptionPane.showMessageDialog(null, "Login successful");
                        dispose();
                        new Menu();
                    } else {
                        JOptionPane.showMessageDialog(null, "Username or password is incorrect");
                    }
                }
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
        jlabel2.setBounds(586, 392, 70, 29);
        jpanel.add(jlabel2);

        jpasswordfield = new JPasswordField();
        jpasswordfield.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                jlabel4.setText("");
            }
        });
        jpasswordfield.setCaretColor(new Color(30, 144, 255));
        jpasswordfield.setBorder(null);
        jpasswordfield.setOpaque(false);
        jpasswordfield.setBounds(415, 331, 214, 29);
        jpanel.add(jpasswordfield);


        jlabel=new JLabel();
        jlabel.setSize(1000, 600);
        jlabel.setIcon(new ImageIcon("res\\LogIn.png"));
        jpanel.add(jlabel);
        setBounds(0,0,1016,637);
        setLocationRelativeTo(null);
        setVisible(true);


    }
}



