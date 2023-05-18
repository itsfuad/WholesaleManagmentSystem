package GUI.Frames;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Types.Product;
import Database.Database;
import GUI.Checkpoint.DefaultPage;

public class Shopping extends JFrame {

    private JLabel jlabelsearch,cartButtonLabel,jlabelback,jlabelsignout;
    private JTextField jtextfield;
    private JLabel backgroundImageLabel,addtocart,productlabel;
    private JPanel mainPanel;
    private List<Rectangle> labelBounds;
    private Product selectedProduct;
  //  Database cartDatabase;
   // ArrayList<Product> cartItems;


    private HashMap<Product, Boolean> Cart = new HashMap<>();

    public Shopping() {


        setTitle("Shopping");
        setSize(new Dimension(1016,638));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_HORIZ);

        //setIcon
        ImageIcon icon = new ImageIcon("res\\icon.png");
        setIconImage(icon.getImage());

        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        labelBounds = new ArrayList<>();
        int x = 100;
        int y = 166;


        JLabel selected1=new JLabel ();
        selected1.setText("NO PRODUCTS SELECTED 🙃");
        selected1.setBounds(100, 500, 400, 50);
        mainPanel.add(selected1);



        ArrayList<Product> products = new Database("products.txt").getAllProducts();

		/*
		System.out.println(products.size());
		for (int i = 0; i < products.size(); i++){
			System.out.println("-------------------------------------------");
			System.out.println("ID: " + products.get(i).productID);
			System.out.println("Name: " + products.get(i).productName);
			System.out.println("Price: " + products.get(i).productPrice);
			System.out.println("MFD: " + products.get(i).manufacturingDate);
			System.out.println("EXP: " + products.get(i).expiryDate);
			System.out.println("-------------------------------------------");
		}
		*/
        
        productlabel=new JLabel(new ImageIcon("E:\\Git\\WholesaleManagmentSystem\\res\\productlabel.png"));
        productlabel.setBounds(99,164, 140, 160);
        mainPanel.add(productlabel);
        productlabel.setVisible(false);
        for (int i = 0; i < 10; i++) {
            Rectangle bounds = new Rectangle(x, y, 140, 160);
           
            labelBounds.add(bounds);

            JLabel label = new JLabel(products.get(i).productName);//fuad ekhane tui 10 ta Product er nam boshabi from Database
            label.setBounds(bounds);

            int finalI = i;

            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println(label.getText() + " clicked!");
                    selected1.setText(label.getText() + " Selected");

                    //selected="";//productid or Product name that was selected
                    //selected = products.get(i).productName + " | " + products.get(i).productPrice + " " + products.get(i).productQuantity;
                    selectedProduct = products.get(finalI);
                }
                @Override
                public void mouseEntered(MouseEvent e) {
                	
                	productlabel.setVisible(true);
           
                }
                @Override
                public void mouseExited(MouseEvent e) {
                	productlabel.setVisible(false);
              
                }
            });

            mainPanel.add(label);

            x += 166;
            if (i == 4) {
                x = 100;
                y += 171;
            }
        }

        JLabel selected=new JLabel ();
        selected.setText("No products");
        selected.setBounds(100, 900, 400, 50);
        mainPanel.add(selected);

        addtocart = new JLabel("");
        addtocart.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (selectedProduct == null){
                    System.out.println("no Product selected");
                    JOptionPane.showMessageDialog(null, "Please select a Product");
                    return;
                }

                boolean found = false;

                for (Product item : Cart.keySet()){
                    System.out.println(item.productID + " | " + selectedProduct.productID);
                    if (item.productID.equals(selectedProduct.productID)){
                        found = true;
                        break;
                    }
                }

                if (found){

                    System.out.println("Product already in cart");

                    JOptionPane.showMessageDialog(null, "Product is already in cart");
                    return;
                }

                //adds Product to cart
                System.out.println("Product added to cart:\n"+ selectedProduct.productName);//fuad step1: select a Product step 2 : click on add to cart button step3: cart.txt Product is added with quantity 1
                //addedProducts.add(new Product(selected, 1));
                Cart.put(selectedProduct, true);
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
        addtocart.setBounds(751, 530, 165, 34);
        mainPanel.add(addtocart);


        getContentPane().add(mainPanel, BorderLayout.CENTER);
        jlabelsearch = new JLabel("\r\n");
        jlabelsearch.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //searches for Product

                String queryString = jtextfield.getText();

                System.out.println(queryString);

                //search for Product
                Database producDatabase = new Database("products.txt");

                for (Product item : producDatabase.getProducts(queryString)){
                    System.out.println("-------------------------------------------");
                    System.out.println("ID: " + item.productID);
                    System.out.println("Name: " + item.productName);
                    System.out.println("Price: " + item.productPrice);
                    System.out.println("MFD: " + item.manufacturingDate);
                    System.out.println("EXP: " + item.expiryDate);
                    System.out.println("-------------------------------------------");
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
        jlabelsearch.setBounds(636, 107, 41, 43);
        mainPanel.add(jlabelsearch);


        cartButtonLabel = new JLabel("\r\n");
        cartButtonLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                updateCartDatabase();

                dispose();
                System.out.println("Cart button clicked");
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
        cartButtonLabel.setBounds(684, 107, 41, 43);
        mainPanel.add(cartButtonLabel);

        jlabelback=new JLabel("");
        jlabelback.setIcon(new ImageIcon(""));
        jlabelback.setBounds(39,40,60,60);
        jlabelback.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                updateCartDatabase();
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
        mainPanel.add(jlabelback);


        jlabelsignout=new JLabel("");
        jlabelsignout.setIcon(new ImageIcon(""));
        jlabelsignout.setBounds(802,48,160,43);


        jlabelsignout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Database db = new Database("loggedIn.txt");
                db.clear();
                Database db1 = new Database("cart.txt");
                db1.clear();
                dispose();
                new DefaultPage();
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
        mainPanel.add(jlabelsignout);

        jtextfield=new JTextField();
        //jtextfield.setOpaque(false);
        jtextfield.setCaretColor(Color.ORANGE);
        jtextfield.setBorder(null);
        jtextfield.setBounds(343,118,243,20);
        mainPanel.add(jtextfield);

        getContentPane().add(mainPanel);
        backgroundImageLabel =new JLabel();
        backgroundImageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        backgroundImageLabel.setSize(1000, 600);
        backgroundImageLabel.setIcon(new ImageIcon("res\\Shopping1.png"));
        mainPanel.add(backgroundImageLabel);
        this.setBounds(0,0,1016,637);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        readExistingCart();

        for (Product item : Cart.keySet()){
            System.out.println("Product: " + item.productName);
        }
    }

    public void readExistingCart(){
        //read cart from database and put values in the cart map
    	Database cartDatabase= new Database("cart.txt");
    	ArrayList<Product> cartItems= cartDatabase.getCart();

        for (Product item : cartItems){
            Cart.put(item, true);
        }
    }

    public void updateCartDatabase(){
    	Database cartDatabase = new Database("cart.txt");
        cartDatabase.clear();
        //add products to cart database
        for (Product item : Cart.keySet()){
            //System.out.println(item.productID + " | " + item.productName + " | " + item.productPrice + " | " + item.productQuantity + " | " + item.manufacturingDate + " | " + item.expiryDate);
            cartDatabase.add("productId=" + item.productID + ",productName=" + item.productName + ",productPrice=" + item.productPrice + ",quantity=" + (item.productQuantity == null ? "1" : item.productQuantity) + ",manufactureDate=" + item.manufacturingDate + ",expireDate=" + item.expiryDate);
        }
    }
}

