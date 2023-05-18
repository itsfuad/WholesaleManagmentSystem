package GUI.Frames;

import javax.swing.*;//class not needed
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;

import GUI.Checkpoint.*;
import src.Main;

public class Servicing extends JFrame{
    private JPanel jpanel;
    private JLabel jlabel,jlabel1,jlabelback,jlabelsignout;
    private JTextField jtextfield,jtextfield1,jtextfield2;
    private JTextArea textArea;

    Servicing(){
        setTitle("Servicing");
        setSize(new Dimension(1016,638));
        jpanel=new JPanel();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().add(jpanel);
        jpanel.setLayout(null);
        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_HORIZ);

        //setIcon
        ImageIcon icon = new ImageIcon("res\\icon.png");
        setIconImage(icon.getImage());



        jtextfield=new JTextField();
        jtextfield.setCaretColor(new Color(30, 144, 255));
        jtextfield.setBorder(null);
        jtextfield.setFont(new Font("Tahoma", Font.PLAIN, 11));
        jtextfield.setBounds(190,224,275,30);
        jpanel.add(jtextfield);
        jtextfield1=new JTextField();//date of purchase
        jtextfield1.setCaretColor(new Color(30, 144, 255));
        jtextfield1.setBorder(null);
        jtextfield1.setBounds(190,277,275,30);
        jpanel.add(jtextfield1);
        jtextfield2=new JTextField();//product details
        jtextfield2.setCaretColor(new Color(30, 144, 255));
        jtextfield2.setBorder(null);
        jtextfield2.setBounds(190,329,275,70);
        jpanel.add(jtextfield2);
        textArea = new JTextArea();
        textArea.setRows(4);
        textArea.setBounds(190, 329, 275, 70);


        jlabel1 = new JLabel("");//submits validation request
        jlabel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                //new Servicing1();


                //suppose product Id is 0001
                String manufactureDate = Main.ProductsDatabase.getQueryResult("0001", "manufactureDate");

                System.out.println(manufactureDate);

                String[] manufactureDateArray = manufactureDate.split(".");
                String expireDate = Main.ProductsDatabase.getQueryResult("0001", "expireDate");

                int manufactureDay = Integer.parseInt(manufactureDateArray[0]);
                int manufactureMonth = Integer.parseInt(manufactureDateArray[1]);
                int manufactureYear = Integer.parseInt(manufactureDateArray[2]);

                Date currentDate = new Date(new Date().getTime());
                int currentDay = currentDate.getDay();
                int currentMonth = currentDate.getMonth();
                int currentYear = currentDate.getYear();

                System.out.println("Manufacture Date: " + manufactureDay + " | " + manufactureMonth + " | " + manufactureYear);
                System.out.println("Current Date: " + currentDay + " | " + currentMonth + " | " + currentYear);


                //or new Servicing2();
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
        jlabel1.setBounds(183, 441, 282, 39);
        jpanel.add(jlabel1);

        jlabelback=new JLabel("");
        jlabelback.setIcon(new ImageIcon(""));
        jlabelback.setBounds(40,39,64,62);
        jlabelback.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new Menu();
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
        jpanel.add(jlabelback);




        jlabel=new JLabel();
        jlabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        jlabel.setSize(1000, 600);
        jlabel.setIcon(new ImageIcon("res\\Servicing.png"));
        jpanel.add(jlabel);


        jpanel.add(textArea);
        setBounds(0,0,1016,637);
        setLocationRelativeTo(null);
        setVisible(true);
        JOptionPane.showMessageDialog(null, "This feature is under development 💔");

    }
}
