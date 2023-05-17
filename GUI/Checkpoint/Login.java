package GUI.Checkpoint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Database.*;
import GUI.Frames.Menu;
import Validator.*;

public class Login {

    protected JFrame jframe;
    protected JPanel jpanel;
    protected JLabel jlabel,jlabel1,jlabel2,jlabel3,jlabel4;
    protected JTextField jtextfield;
    protected JPasswordField jpasswordfield;
    private String username, password;

    public Login() {


        jframe=new JFrame();
        jframe.setTitle("LogIn");//
        jframe.setSize(new Dimension(1016,638));
        jpanel=new JPanel();
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jframe.getContentPane().add(jpanel);
        jpanel.setLayout(null);
        jframe.setResizable(false);
        jframe.setExtendedState(JFrame.MAXIMIZED_HORIZ);




        jlabel1 = new JLabel("");
        jlabel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jframe.dispose();
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
                    Database db = new Database("users.txt");
                    System.out.println("username=" + username + ",password=" + password);
                    System.out.println(db.getQueryResult("fuad", "password"));
                    if (db.match("username=" + username + ",password=" + password)) {
                        Database loggedIn = new Database("loggedIn.txt");
                        loggedIn.add(username);
                        JOptionPane.showMessageDialog(jframe, "Login successful");
                        jframe.dispose();

                        new Menu();
                    } else {
                        JOptionPane.showMessageDialog(jframe, "Username or password is incorrect");
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
        jframe.setBounds(0,0,1016,637);
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);


    }
}



