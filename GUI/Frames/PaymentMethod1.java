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
public class PaymentMethod1 extends JFrame{
	
	private JPanel mainPanel,productPanel, viewDetailsPanel;
	private int x_axis_product=0;
	private int y_axis_product=0;
	private int x_axis_productpanel=90;


	
	PaymentMethod1(){
		
		createFrame("Shopping",0,0,1016,638);
		initializePaymentMethodComponents();

		setLabel(mainPanel,"back","",42, 41, 60, 60);//back
		setLabel(mainPanel,"cash on delivery","",325, 285, 152, 30);//cash on delivery
		setLabel(mainPanel,"online payment","",525, 285, 152, 30);//online paymen
		setLabel(mainPanel, "", "res\\PaymentMethod1.png", 0, 0, 1000, 600);//bg


		this.setVisible(true);
	}


	public void setLabel(JPanel setPanel,String setText,String imageDirectory,int x_axis,int y_axis,int width,int height) {
		JLabel jlabel=new JLabel(new ImageIcon(imageDirectory));
		//jlabel.setText(setText);
        jlabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
		            	
		            	if(setText.equals("back")){
		                    dispose();
		                    new Cart();
		            	}
		            	if(setText.equals("cash on delivery")){
		                    dispose();
		                    new BoughtCOD();
		            	}
		            	if(setText.equals("online payment")){
		                    dispose();
		                    new PaymentMethod2();
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
		 	setTitle("PaymentMethod");
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
	     new PaymentMethod1();
	    }
    
	    
}