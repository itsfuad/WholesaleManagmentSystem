package GUI.Frames;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import Database.Database;
import GUI.Checkpoint.DefaultPage;
import Types.Product;

public class Shop extends JFrame{
	
	private JPanel mainPanel,productPanel,notificationPanel;
	private JTextField searchField;
	private List<Product> selectedProducts = new ArrayList<>();
	private int x_axis_product=0;
	private int y_axis_product=0;
	private int x_axis_productpanel=90;
	private HashMap<Product, Boolean> Cart = new HashMap<>();
	private ArrayList<Product> products;
	private int finalI;
	private Timer swipeTimer;
    private int swipeDirection = 0;


	
	

	
	Shop(){
		
		createFrame("Shopping",0,0,1016,638);
		initializeShopComponents();
		for (int i = 0; i < 10; i++) {
            setLabel(productPanel,products.get(i).productName,""/*products.get(i).productImage@fuad*/,x_axis_product,y_axis_product,140,160);//@fuad add image
            x_axis_product += 166;
            finalI = i;
            if (i == 4) {
            	x_axis_product = 0;
                y_axis_product += 171;
            }
        }
		
		mainPanel.add(productPanel);
		mainPanel.add(notificationPanel);
		mainPanel.add(searchField);
		setLabel(mainPanel,"signout","",802,48,160,43);//signout
		setLabel(mainPanel,"back","",39,40,60,60);//back
		setLabel(mainPanel,"cart","",684, 107, 41, 43);//cart
		setLabel(mainPanel,"search","",636, 107, 41, 43);//search
		setLabel(mainPanel,"addtocart","",751, 530, 165, 34);//addtocart
		setLabel(mainPanel,"swipeleft","",0,100,100,500);//swipeleft
		setLabel(mainPanel,"swiperight","",900,100,100,500);//swiperight
		setLabel(mainPanel,"","E:\\\\Git\\\\WholesaleManagmentSystem\\\\res\\\\Shopping1.png",0,0,1000,600);//bg
		readExistingCart();

        
        
        
		this.setVisible(true);
	}
	
	
	
	public void setLabel(JPanel setPanel,String setText,String imageDirectory,int x_axis,int y_axis,int width,int height) {
		JLabel jlabel=new JLabel(new ImageIcon(imageDirectory));
		jlabel.setText(setText);
		
        jlabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
		            	//System.out.println(setText);
		            	if(setText.equals("signout")) {
		        			Database db = new Database("loggedIn.txt");
		                    db.clear();
		                    Database db1 = new Database("cart.txt");
		                    db1.clear();
		                    dispose();
		                    new DefaultPage();
		        		}
		            	if(setText.equals("back")){
		            		updateCartDatabase();
		                    dispose();
		                    new Menu();
		            	}
		            	if(setText.equals("cart")){
		            		 updateCartDatabase();
		
		                     dispose();
		                     System.out.println("Cart button clicked");
		                     new Cart();
		            	}
		            	if(setText.equals("search")){
		            		//searches for Product
		
		                    String queryString = searchField.getText();
		
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
		            	if (setText.equals("addtocart")) {//@fuad check
		            		
		            	    if (selectedProducts.isEmpty()) {
		            	        System.out.println("No product selected");
		            	        JOptionPane.showMessageDialog(null, "Please select a product");
		            	        return;
		            	    }

		            	    for (Product selectedProduct : selectedProducts) {
		            	        boolean found = false;

		            	        for (Product item : Cart.keySet()) {
		            	            if (item.productID.equals(selectedProduct.productID)) {
		            	                found = true;
		            	                break;
		            	            }
		            	        }

		            	        if (!found) {
		            	            Cart.put(selectedProduct, true);
		            	            System.out.println("Product added to cart: " + selectedProduct.productName);
		            	        }
		            	    }

		            	    // Clear the selected products list after adding to the cart
		            	    selectedProducts.clear();
		            	} else {
		            	    // Add the selected product to the list
		            	    selectedProducts.add(products.get(finalI));
		            	    System.out.println(selectedProducts);
		            	}
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            	if (setText.equals("swipeleft")) {
                    startSwipeAnimation(-1, 20); // Move 5 pixels to the left every 0.25 seconds
                }
                if (setText.equals("swiperight")) {
                    startSwipeAnimation(1, 20); // Move 5 pixels to the right every 0.25 seconds
                }
        	
            }
            @Override
            public void mouseExited(MouseEvent e) {
            	 System.out.println(setText + " exited");
            	 if (setText.equals("swipeleft") || setText.equals("swiperight")) {
                     stopSwipeAnimation();
                 }
             }
  
        	
         
            
            @Override
            public void mousePressed(MouseEvent e) {
            	
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            	
            }
        });
        jlabel.setBounds(x_axis,y_axis,width,height);
        setPanel.add(jlabel);
		
	}
	
	public void createFrame(String setTitle,int x_axis,int y_axis,int width,int height) {
		 	setTitle("Shopping");
	        setSize(new Dimension(width,height));
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        setResizable(false);
	        setExtendedState(JFrame.MAXIMIZED_HORIZ);
	        mainPanel = new JPanel();
	        mainPanel.setLayout(null);
	        getContentPane().add(mainPanel);
	        this.setBounds(x_axis,y_axis,width,height);
	        this.setLocationRelativeTo(null);
	        
	        
	        
	       
	}
	public void initializeShopComponents() {
			searchField=new JTextField();
	        searchField.setCaretColor(Color.ORANGE);
	        searchField.setBorder(null);
	        searchField.setBounds(343,118,243,20);
			productPanel = new JPanel();
			productPanel.setOpaque(false);
	        productPanel.setBounds(x_axis_productpanel, 166, 2000, 360);
	        productPanel.setLayout(null);
	        notificationPanel = new JPanel();
	        notificationPanel.setBounds(90, 535, 216, 27);
	        notificationPanel.setLayout(null);
	        products = new Database("products.txt").getAllProducts();
	       
	        
	}
	
	 public static void main(String[] args){
	     new Shop();
	    }
	 
	 public void readExistingCart(){
	        //read cart from database and put values in the cart map
	        Database cartDatabase = new Database("cart.txt");
	        ArrayList<Product> cartItems = cartDatabase.getCart();

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
	    
	    public void setupSwipeTimer() {
	        int delay = 1; // 0.25 seconds
	        swipeTimer = new Timer(delay, new ActionListener() {
	        	@Override
	            public void actionPerformed(ActionEvent e) {
	                moveProductPanel(swipeDirection * 5); // Move the panel by 5 pixels in the swipe direction
	            }

	        });
	    }
	    public void startSwipeAnimation(int distance, int interval) {
	        swipeTimer = new Timer(interval, new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                moveProductPanel(distance);
	            }
	        });
	        swipeTimer.start();
	    }

	    public void stopSwipeAnimation() {
	        if (swipeTimer != null && swipeTimer.isRunning()) {
	            swipeTimer.stop();
	        }
	    }
	    public void moveProductPanel(int distance) {
	        Rectangle bounds = productPanel.getBounds();
	        int newX = bounds.x + distance;
	        productPanel.setBounds(newX, bounds.y, bounds.width, bounds.height);
	    }

}
