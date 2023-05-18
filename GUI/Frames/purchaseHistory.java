package GUI.Frames;

import GUI.ButtonDesigner;
import Types.Product;
import src.Main;

import javax.swing.*;//class not needed
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
public class purchaseHistory extends JFrame{
        protected JPanel jpanel;
        protected JLabel backgroundImageLabel, jlabelback;
        protected JTable table;
        private ArrayList<Product> purchasedItems;
        public purchaseHistory() {

            setTitle("Purchase History");
            setSize(new Dimension(1016, 638));
            jpanel = new JPanel();
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            getContentPane().add(jpanel);
            jpanel.setLayout(null);
            setResizable(false);
            setExtendedState(JFrame.MAXIMIZED_HORIZ);

            JLabel title = new JLabel("Purchase History");
            title.setFont(new Font("Arial", Font.BOLD, 30));
            title.setBounds(40, 50, 300, 50);
            jpanel.add(title);


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

            purchasedItems = Main.purchaseHistoryDatabase.getCart();

            for (Product p : purchasedItems) {
                System.out.println("Product ID: " + p.productID);
                System.out.println("Product Name: " + p.productName);
                System.out.println("Product Price: " + p.productPrice);
                System.out.println("Product Quantity: " + p.productQuantity);

                model.addRow(new Object[]{p.productID, p.productName, p.productPrice, p.productQuantity}); // Set initial quantity to 1
            }


            table.setBounds(100, 140, 800, 340);
            jpanel.add(table);

            //Todo Back button
            JLabel backButton = new ButtonDesigner("Back", Color.white, new Color(0, 0, 0), new Color(40, 40, 40), 16).getLabel();
            backButton.setBounds(20, 520, 120, 40);
            backButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    dispose();
                    new Menu();
                }
            });
            jpanel.add(backButton);

            backgroundImageLabel = new JLabel();
            backgroundImageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            backgroundImageLabel.setSize(1000, 600);
            //backgroundImageLabel.setIcon(new ImageIcon("res\\Cart.png"));
            jpanel.add(backgroundImageLabel);
            setBounds(0, 0, 1016, 637);
            setLocationRelativeTo(null);
            setVisible(true);
        }
}