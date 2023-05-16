package GUI.Frames;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import Database.*;
import Types.*;

public class Cart {

    protected JFrame jframe;
    protected JPanel jpanel;
    protected JLabel backgroundImageLabel, purchaseButtonLabel, jlabelback;
    protected JTable table;
    private int quantity;
    private JButton addButton,subtractButton;
    private ArrayList<Product> cartItems;
    private Database db;
    String quantityString;
    public Cart() {

        cartItems = new ArrayList<Product>();
        db = new Database("cart.txt");

        jframe = new JFrame();
        jframe.setTitle("Cart");
        jframe.setSize(new Dimension(1016, 638));
        jpanel = new JPanel();
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jframe.getContentPane().add(jpanel);
        jpanel.setLayout(null);
        jframe.setResizable(false);
        jframe.setExtendedState(JFrame.MAXIMIZED_HORIZ);

        purchaseButtonLabel = new JLabel("");
        purchaseButtonLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                db.clear();
                JOptionPane.showMessageDialog(null, "You have purchased products!");
                jframe.dispose();
                new Menu();

            }
        });
        purchaseButtonLabel.setBounds(426, 527, 153, 40);
        jpanel.add(purchaseButtonLabel);

        JButton removeButton = new JButton("Remove");
        removeButton.setBounds(702, 482, 82, 27);
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.removeRow(selectedRow);
                }
            }
        });
        jpanel.add(removeButton);

        addButton = new JButton("+");
        addButton.setBounds(794, 482, 67, 27);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int quantityInteger = Integer.parseInt(model.getValueAt(selectedRow, 3).toString());
                    System.out.println("Quantity: " + quantityInteger);
                    quantityString = Integer.toString(quantityInteger);
                    if (quantityString != null && !quantityString.isEmpty() && !quantityString.equals("null")) {
                        quantity = Integer.parseInt(quantityString);
                        model.setValueAt(quantity + 1, selectedRow, 3); // Increase quantity by 1
                    }
                }
            }
        });
        jpanel.add(addButton);

        subtractButton = new JButton("-");
        subtractButton.setBounds(625, 482, 67, 27);
        subtractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    Integer quantityInteger = (Integer) model.getValueAt(selectedRow, 3);
                    quantityString = quantityInteger.toString();
                    if (quantityString != null && !quantityString.isEmpty()) {
                        quantity = Integer.parseInt(quantityString);
                        if (quantity > 1) {
                            model.setValueAt(quantity - 1, selectedRow, 3); // Decrease quantity by 1
                        }
                    }
                }
            }
        });
        jpanel.add(subtractButton);

        // Get cart products from the Database
        Database db = new Database("cart.txt");
        ArrayList<Product> products = db.getCart();

        table = new JTable();
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        DefaultTableModel model = new DefaultTableModel(
                new Object[][]{{"Product ID","Product Name", "Product Price", "Product Quantity"}},
                new String[]{"Product ID", "Product Name", "Product Price", "Product Quantity"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table.setModel(model);

        for (Product p : products) {
            model.addRow(new Object[]{p.productID, p.productName, p.productPrice, p.productQuantity}); // Set initial quantity to 1
        }


        table.setBounds(100, 140, 800, 340);
        jpanel.add(table);

        jlabelback = new JLabel("");
        jlabelback.setIcon(new ImageIcon(""));
        jlabelback.setBounds(42, 41, 59, 60);
        jlabelback.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                updateCart();
                jframe.dispose();
                new Menu();
            }
        });
        jpanel.add(jlabelback);

        JLabel totalLabel = new JLabel("");
        totalLabel.setText("Total: underdevelopment");
        totalLabel.setBounds(133, 540, 150, 14);
        jpanel.add(totalLabel);

        jframe.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                updateCart();
            }
        });

        backgroundImageLabel = new JLabel();
        backgroundImageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        backgroundImageLabel.setSize(1000, 600);
        backgroundImageLabel.setIcon(new ImageIcon("res\\Cart.png"));
        jpanel.add(backgroundImageLabel);
        jframe.setBounds(0, 0, 1016, 637);
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
    }

    public void updateCart() {
        try{
            Database db = new Database("cart.txt");
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            //get the first column of the table row
            int selectedRow = table.getSelectedRow();

            if (selectedRow == -1) {
                return;
            }

            String productID = model.getValueAt(selectedRow, 0).toString();
            String productCount = model.getValueAt(selectedRow, 3).toString();

            //update the cart
            db.update(productID, "quantity", productCount);
        }catch (Exception e){
            System.out.println("Error: " + e);
        }
    }

}