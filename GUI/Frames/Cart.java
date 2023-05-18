package GUI.Frames;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import Database.*;
import Types.*;

public class Cart extends JFrame{

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
        
        setTitle("Cart");
        setSize(new Dimension(1016, 638));
        jpanel = new JPanel();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().add(jpanel);
        jpanel.setLayout(null);
        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_HORIZ);

        //setIcon
        ImageIcon icon = new ImageIcon("res\\icon.png");
        setIconImage(icon.getImage());

        purchaseButtonLabel = new JLabel("");
        purchaseButtonLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                db.clear();
                JOptionPane.showMessageDialog(null, "You have purchased products!");
                dispose();
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
                if (selectedRow == 0){
                    return;
                }
                if (selectedRow != -1) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    String productId = model.getValueAt(selectedRow, 0).toString();
                    deleteProduct(productId);
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
                if (selectedRow == 0){
                    return;
                }
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
                if (selectedRow == 0){
                    return;
                }
                if (selectedRow != -1) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int quantityInteger = Integer.parseInt(model.getValueAt(selectedRow, 3).toString());
                    quantityString = Integer.toString(quantityInteger);
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
                dispose();
                new Menu();
            }
        });
        jpanel.add(jlabelback);

        JLabel totalLabel = new JLabel("");
        totalLabel.setText("Total: underdevelopment");
        totalLabel.setBounds(133, 540, 150, 14);
        jpanel.add(totalLabel);

        addWindowListener(new WindowAdapter() {
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
        setBounds(0, 0, 1016, 637);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void deleteProduct(String productId){
        Database db = new Database("cart.txt");
        System.out.println("Product ID: " + productId + " has been deleted from the cart.");
        db.removeProduct(productId);
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