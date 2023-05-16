package GUI.Frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Menu extends JFrame {

    protected JPanel jpanel;
    protected JLabel backgroundImageLabel, shoppingButtonLabel, cartButtonLabel, purchaseHistoryButtonLabel, servicingButtonLabel, changePasswordButtonLabel, jlabelsignout;


    public Menu() {

        setTitle("Menu");
        setSize(new Dimension(1016,638));
        jpanel=new JPanel();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().add(jpanel);
        jpanel.setLayout(null);
        setResizable(false);
        setExtendedState(MAXIMIZED_HORIZ);


        shoppingButtonLabel = new JLabel("");
        shoppingButtonLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new Shopping();
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
        jpanel.add(shoppingButtonLabel);

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
        jpanel.add(cartButtonLabel);

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
        jpanel.add(purchaseHistoryButtonLabel);

        servicingButtonLabel = new JLabel("");
        servicingButtonLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
               // new Servicing();
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
        jpanel.add(servicingButtonLabel);

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
        jpanel.add(changePasswordButtonLabel);

        backgroundImageLabel =new JLabel();
        backgroundImageLabel.setLocation(0, 0);
        backgroundImageLabel.setSize(1000, 600);
        backgroundImageLabel.setIcon(new ImageIcon("res\\Menu.png"));
        jpanel.add(backgroundImageLabel);
        setBounds(0,0,1016,637);
        setLocationRelativeTo(null);
        setVisible(true);

    }
}


