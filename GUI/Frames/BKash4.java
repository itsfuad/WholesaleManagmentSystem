package GUI.Frames;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.util.*;
import src.*;
import Types.*;


@SuppressWarnings("serial")
public class BKash4 extends JFrame{
	
	private JPanel mainPanel;


	
	BKash4(){
		
		createFrame("Payment Successful",0,0,1016,638);
		initializePaymentMethodComponents();

		setLabel("paymentdetails",mainPanel,"Payment successful. Deducted balance -"+Cart.total+"tk.","",275, 250, 450, 30);//paymentdetails
		setLabel("menu",mainPanel,"","",405, 285, 170, 30);//go to menu
		setLabel("bg",mainPanel, "", "res\\BKash4.png", 0, 0, 1000, 600);//bg

		ArrayList<Product> addedProducts = Main.CartDatabase.getCart();
		for (Product item : addedProducts) {
			System.out.println("Quantity: " + item.productQuantity);
			Main.purchaseHistoryDatabase.add("productId=" + item.productID + ",productName=" + item.productName + ",productPrice=" + item.productPrice + ",quantity=" + (item.productQuantity == null ? "1" : item.productQuantity) + ",manufacturer=" + item.productManufacturer + ",manufactureDate=" + item.manufacturingDate + ",expireDate=" + item.expiryDate);
		}
		Main.CartDatabase.clear();

		this.setVisible(true);
	}


	public void setLabel(String selectedLabel,JPanel setPanel,String setText,String imageDirectory,int x_axis,int y_axis,int width,int height) {
		JLabel jlabel=new JLabel(new ImageIcon(imageDirectory));
		jlabel.setText(setText);
		if(selectedLabel.equals("paymentdetails")) { 
			jlabel.setFont(new Font("Tahoma", Font.BOLD, 18));
			jlabel.setHorizontalAlignment(SwingConstants.CENTER);
			jlabel.setVerticalAlignment(SwingConstants.CENTER);
		    jlabel.setForeground(Color.white);}
        jlabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
		            
	
            	if(selectedLabel.equals("menu")){
                    dispose();
                    new Menu();
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
        jlabel.setBounds(x_axis,y_axis,width,height);
        setPanel.add(jlabel);
		
	}
	
	public void createFrame(String setTitle,int x_axis,int y_axis,int width,int height) {
		 	setTitle(setTitle);
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
	public void initializePaymentMethodComponents() {
		
			
			
			
	}
	
	 public static void main(String[] args){
	     new BKash4 ();
	    }
    
	    
}