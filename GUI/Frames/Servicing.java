package GUI.Frames;

import javax.swing.*;//class not needed
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import GUI.Checkpoint.*;
import src.Main;

public class Servicing extends JFrame{
    private JPanel jpanel;
    private JLabel jlabel,jlabel1,jlabelback;
    private JTextField jtextfield;

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
        jtextfield.setBackground(new Color(235, 235, 235, 255));
        jtextfield.setOpaque(true);
        jtextfield.setBounds(145,328,270,30);
        jpanel.add(jtextfield);

        jlabel1 = new JLabel("");//submits validation request
        jlabel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Servicing");

                String productId = jtextfield.getText();

                String MFD = Main.ProductsDatabase.getQueryResult(productId, "manufactureDate");
                String EXP = Main.ProductsDatabase.getQueryResult(productId, "expireDate");

                if (MFD == null || EXP == null) {
                    JOptionPane.showMessageDialog(null, "Invalid Product ID");
                    return;
                }

                boolean isExpired = isProductExpired(MFD, EXP);
                System.out.println("Product expired: " + isExpired);
                if (isExpired){
                    JOptionPane.showMessageDialog(null, "Product is expired");
                    return;
                }
                JOptionPane.showMessageDialog(null, "Product is not expired");
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

        jlabelback=new GUI.ButtonDesigner("Back", Color.white, new Color(0, 0, 0), new Color(40, 40, 40), 16).getLabel();
        jlabelback.setBounds(40,39,120,40);
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

        setBounds(0,0,1016,637);
        setLocationRelativeTo(null);
        setVisible(true);
        //JOptionPane.showMessageDialog(null, "This feature is under development 💔");

    }

    private boolean isProductExpired(String mfdString, String expString) {
        // Parsing the manufacturing date
        LocalDate mfd = LocalDate.parse(mfdString, DateTimeFormatter.ofPattern("d.M.yyyy"));

        // Parsing the expiration period
        int expValue = Integer.parseInt(expString.replaceAll("[^0-9]", ""));
        String expUnit = expString.replaceAll("[^a-zA-Z]", "").toLowerCase();

        // Calculating the expiration date based on the unit of time
        LocalDate expDate;
        switch (expUnit) {
            case "day":
            case "days":
                expDate = mfd.plusDays(expValue);
                break;
            case "month":
            case "months":
                expDate = mfd.plusMonths(expValue);
                break;
            case "year":
            case "years":
                expDate = mfd.plusYears(expValue);
                break;
            default:
                throw new IllegalArgumentException("Invalid expiration unit: " + expUnit);
        }

        // Checking if the current date is after the expiration date
        return LocalDate.now().isAfter(expDate);
    }
}
