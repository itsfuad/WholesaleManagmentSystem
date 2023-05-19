package GUI.Frames;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import GUI.ButtonDesigner;
@SuppressWarnings("serial")
public class BKash1 extends JFrame{
	
	private JPanel mainPanel;
	private JTextField phoneField;
	BKash1(){
		
		createFrame("Payment by Bkash",0,0,1016,638);
		initializePaymentMethodComponents();

		mainPanel.add(phoneField);//phone no
		setLabel("back",mainPanel,"","",42, 41, 120, 40);//back
		setLabel("sendcode",mainPanel,"","",625, 300, 170, 30);//sendcode
		setLabel("bg",mainPanel, "", "res\\BKash1.png", 0, 0, 1000, 600);//bg


		this.setVisible(true);
	}


	public void setLabel(String selectedLabel,JPanel setPanel,String setText,String imageDirectory,int x_axis,int y_axis,int width,int height) {
		JLabel jlabel=new JLabel(new ImageIcon(imageDirectory));
		jlabel.setText(setText);
		if(selectedLabel.equals("back")) {
			jlabel = new ButtonDesigner("Back", Color.white, new Color(0, 0, 0), new Color(40, 40, 40), 16).getLabel();}
        jlabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
		            	

		            	if(selectedLabel.equals("back")){
		                    dispose();
		                    new PaymentMethod2();
		            	}
		            	if(selectedLabel.equals("sendcode")){
		                    dispose();
		                    new BKash2();
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
		
			phoneField=new JTextField();
			phoneField.setBounds(360,300,250,30);
			phoneField.setBorder(null);
			phoneField.setOpaque(false);

			
			
	}
	
	 public static void main(String[] args){
	     new BKash1 ();
	    }
    
	    
}