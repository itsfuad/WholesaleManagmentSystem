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

import GUI.Checkpoint.DefaultPage;
import Types.Product;
import src.Main;
import GUI.ButtonDesigner;

public class Shop extends JFrame{
	
	private JPanel mainPanel,productPanel, viewDetailsPanel;
	private JTextField searchField;
	private List<Product> selectedProducts = new ArrayList<>();
	private int x_axis_product=0;
	private int y_axis_product=0;
	private int x_axis_productpanel=90;
	private ArrayList<Product> cart = new ArrayList<>();
	private ArrayList<Product> products = Main.ProductsDatabase.getAllProducts();
	private Timer swipeTimer;
    private int swipeDirection = 0;

	private Product selectedProduct;

	//round circle to show the number of items in the cart
	private JLabel notificationLabel;
	private JPanel circlePanel;

	Shop() throws InterruptedException {
		
		createFrame("Shopping",0,0,1016,638);
		initializeShopComponents();

		// Create the notification label and add it to the circle panel
		notificationLabel = new JLabel("0");
		notificationLabel.setFont(new Font("Arial", Font.BOLD, 16));
		notificationLabel.setBounds(710, 40, 20, 20);
		notificationLabel.setForeground(new Color(255, 10, 10));

		mainPanel.add(notificationLabel);

		mainPanel.add(searchField);
		//setLabel(mainPanel,"signout","",802,48,160,43);//signout

		JLabel backButton = new ButtonDesigner("Back", Color.white, new Color(0, 0, 0), new Color(40, 40, 40), 16).getLabel();
		backButton.setBounds(20, 520, 120, 40);

		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new Menu();
			}
		});

		mainPanel.add(backButton);

		/*
		setLabel(mainPanel,"cart","",684, 40, 60, 60);//cart
		setLabel(mainPanel,"search","",636, 40, 60, 60);//search
		*/

		JLabel searchLabel = new JLabel("");
		searchLabel.setBounds(620, 40, 60, 60);

		searchLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				search();
			}
		});

		mainPanel.add(searchLabel);

		JLabel cartLabel = new JLabel("");
		cartLabel.setBounds(684, 40, 60, 60);
		cartLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new Cart();
			}
		});

		mainPanel.add(cartLabel);

		JLabel addToCartButton = new ButtonDesigner("Add to Cart", Color.white, new Color(8, 135, 238), new Color(9, 117, 204), 16).getLabel();
		addToCartButton.setBounds(160, 520, 120, 40);
		addToCartButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					addToCart();
				} catch (InterruptedException ex) {
					throw new RuntimeException(ex);
				}
			}
		});

		mainPanel.add(addToCartButton);

		JLabel searchImage = new JLabel("", new ImageIcon("res\\search.png"), JLabel.CENTER);
		searchImage.setBounds(636, 40, 60, 60);
		mainPanel.add(searchImage);


		viewDetailsPanel = new JPanel();
		viewDetailsPanel.setBounds(0, 0, 300, 500);
		viewDetailsPanel.setBackground(new Color(68, 169, 246, 255));
		mainPanel.add(viewDetailsPanel);

		showDetails(products.get(0));

		productPanel = new JPanel();
		productPanel.setBounds(300, 120, 700, 450);
		//productPanel.setBackground(Color.MAGENTA);
		productPanel.setLayout(new GridLayout(0, 3, 20, 20));
		productPanel.setOpaque(true);
		productPanel.setBackground(new Color(68, 169, 246, 255));
		//make transparent
		productPanel.setOpaque(false);

		//mainPanel.add(productPanel);

		//make a grid layout whre each product is added, 3 products per row. Columns are added dynamically. productPanel is the panel where the products are added. each product has fixed size.
		//add a scroll bar to the productPanel for overflow
		JScrollPane scrollPane = new JScrollPane(productPanel);
		scrollPane.setBounds(300, 150, 700, 450);
		//remove border
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		//scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		//make transparent
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		mainPanel.add(scrollPane);

		showProducts(products);

		//setLabel(mainPanel, "", "res\\Shopping1.png", 0, 0, 1016, 638);//bg

		//mainPanel.setBackground(new Color(68, 169, 246, 255));
		JLabel backgroundImageLabel = new JLabel();
		backgroundImageLabel =new JLabel();
		backgroundImageLabel.setLocation(0, 0);
		backgroundImageLabel.setSize(1000, 600);
		backgroundImageLabel.setIcon(new ImageIcon("res\\AllFrames_Shopping2.png"));
		mainPanel.add(backgroundImageLabel);


		//setLabel(mainPanel,"","res\\Shopping1.png",0,0,1000,600);//bg

		readExistingCart();
		notifyUser();

		this.setVisible(true);
	}


	private void showProducts(ArrayList<Product> productList){
		//create products
		for (int i = 0; i < productList.size(); i++) {


			JPanel productItemPanel = new JPanel();
			productItemPanel.setLayout(new BoxLayout(productItemPanel, BoxLayout.Y_AXIS));
			productItemPanel.setBackground(new Color(255, 255, 255, 39));
			productItemPanel.setOpaque(true);
			productItemPanel.setPreferredSize(new Dimension(200, 200));
			productItemPanel.setMaximumSize(productItemPanel.getPreferredSize());

			final int finalI = i;

			System.out.println("Index: " + i + " Product: " + productList.get(i).productName);

			JLabel productImageLabel = new JLabel();

			ImageIcon imageIcon = new ImageIcon("res\\ProductImages\\20230210104817_original__media_385 (1).png");
			productImageLabel.setIcon(imageIcon);
			productImageLabel.setBounds(50, 60, 250, 250);
			productImageLabel.setVisible(true);
			//align
			productImageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
			productItemPanel.setAlignmentY(Component.CENTER_ALIGNMENT);

			JLabel productName = new JLabel(productList.get(i).productName);
			//set padding
			productName.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));

;
			//set background
			//productName.setBackground(new Color(255, 82, 82, 118));
			productName.setForeground(Color.WHITE);
			productName.setFont(new Font("Arial", Font.BOLD, 20));
			productName.setOpaque(false);

			JLabel productPrice = new JLabel("Price: " + productList.get(i).productPrice);
			productPrice.setForeground(Color.WHITE);
			//left padding
			productPrice.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));

			productItemPanel.add(productImageLabel);
			productItemPanel.add(productName);
			productItemPanel.add(productPrice);

			productItemPanel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					super.mouseClicked(e);
					selectedProduct = productList.get(finalI);
					System.out.println("Index: " + finalI + " Product: " + selectedProduct.productName);
					showDetails(selectedProduct);
				}
			});

			productPanel.add(productItemPanel);
		}
	}

	public void showDetails(Product product){
		viewDetailsPanel.removeAll();
		viewDetailsPanel.repaint();

		System.out.println("Showing details of: " + product.productName);

		selectedProduct = product;

		viewDetailsPanel.setLayout(null);

		JLabel productImageLabel = new JLabel();
		productImageLabel.setBounds(20, 40, 250, 250);
		productImageLabel.setIcon(new ImageIcon("res\\ProductImages\\aci_pure_salt.png"));
		viewDetailsPanel.add(productImageLabel);

		JLabel productName = new JLabel(product.productName);
		productName.setBounds(20, 260, 300, 50);
		productName.setFont(new Font("Arial", Font.BOLD, 20));
		productName.setForeground(Color.WHITE);
		viewDetailsPanel.add(productName);

		JLabel productPrice = new JLabel("Price: " + product.productPrice);
		productPrice.setBounds(20, 320, 300, 20);
		productPrice.setFont(new Font("Arial", Font.BOLD, 16));
		productPrice.setForeground(Color.WHITE);
		viewDetailsPanel.add(productPrice);

		JLabel productManufacturer = new JLabel("Manufacturer: " + product.productManufacturer);
		productManufacturer.setBounds(20, 350, 300, 20);
		productManufacturer.setFont(new Font("Arial", Font.BOLD, 16));
		productManufacturer.setForeground(Color.WHITE);
		viewDetailsPanel.add(productManufacturer);

		JLabel productManufactureDate = new JLabel("Manufacture Date: " + product.manufacturingDate);
		productManufactureDate.setBounds(20, 380, 300, 20);
		productManufactureDate.setFont(new Font("Arial", Font.BOLD, 16));
		productManufactureDate.setForeground(Color.WHITE);
		viewDetailsPanel.add(productManufactureDate);

		JLabel productExpiryDate = new JLabel("Expiry Date: " + product.expiryDate);
		productExpiryDate.setBounds(20, 410, 300, 20);
		productExpiryDate.setFont(new Font("Arial", Font.BOLD, 16));
		productExpiryDate.setForeground(Color.WHITE);
		viewDetailsPanel.add(productExpiryDate);

		mainPanel.revalidate();
	}


	private void search(){
		//searches for Product

		String queryString = searchField.getText();

		System.out.println(queryString);

		//search for Product

		products = Main.ProductsDatabase.getProducts(queryString);

		for (Product item : products){
			System.out.println("-------------- SEARCH RESULT --------------");
			System.out.println("ID: " + item.productID);
			System.out.println("Name: " + item.productName);
			System.out.println("Price: " + item.productPrice);
			System.out.println("Manufacturer: " + item.productManufacturer);
			System.out.println("MFD: " + item.manufacturingDate);
			System.out.println("EXP: " + item.expiryDate);
			System.out.println("-------------------------------------------");

			productPanel.removeAll();
			productPanel.repaint();

			showProducts(products);

			productPanel.revalidate();
		}
	}

	private void addToCart() throws InterruptedException {
		readExistingCart();

		if (selectedProduct == null){
			System.out.println("no product selected");
			JOptionPane.showMessageDialog(null, "Please select a product");
			return;
		}

		for (Product p : cart){

			System.out.println("Product in cart array: " + p.productName);
			if (p.productID.equals(selectedProduct.productID)){
				System.out.println("product already in cart");
				JOptionPane.showMessageDialog(null, "Product is already in cart");
				return;
			}
		}

		//adds product to cart
		System.out.println("product added to cart:\n"+ selectedProduct.productName);//fuad step1: select a product step 2 : click on add to cart button step3: cart.txt product is added with quantity 1
		JOptionPane.showMessageDialog(null, selectedProduct.productName + " added to cart");
		//addedProducts.add(new product(selected, 1));
		cart.add(selectedProduct);
		updateCartDatabase();
		notifyUser();
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
	        searchField.setBounds(343,60,243,20);
	}

	private void notifyUser() {
		//rounded red box shape
		// Create the red filled circle panel
		notificationLabel.setText("" + cart.size());

		System.out.println("cart size: " + cart.size());
	}
	 
	 public void readExistingCart(){
	        //read cart from database and put values in the cart map
	        ArrayList<Product> cartItems = Main.CartDatabase.getCart();

	        for (Product item : cartItems){
	            cart.add(item);
	        }
	    }

	    public void updateCartDatabase(){
	        Main.CartDatabase.clear();
	        //add products to cart database
	        for (Product item : cart){
	            System.out.println(item.productID + " | " + item.productName + " | " + item.productPrice + " | " + item.productQuantity + " | " + item.productManufacturer + " | " + item.manufacturingDate + " | " + item.expiryDate);
	            Main.CartDatabase.add("productId=" + item.productID + ",productName=" + item.productName + ",productPrice=" + item.productPrice + ",quantity=" + (item.productQuantity == null ? "1" : item.productQuantity) + ",manufacturer=" + item.productManufacturer + ",manufactureDate=" + item.manufacturingDate + ",expireDate=" + item.expiryDate);
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
