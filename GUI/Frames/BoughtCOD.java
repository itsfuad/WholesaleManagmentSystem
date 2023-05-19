package GUI.Frames;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
@SuppressWarnings("serial")
public class BoughtCOD extends JFrame{
	
	private JPanel mainPanel;



	
	BoughtCOD(){
		
		createFrame("Cash On Delivery",0,0,1016,638);
		initializePaymentMethodComponents();

		setLabel("paymentdetails",mainPanel,/*name*/" your product will be delivered to "/*+shopaddress*/+"soon.","",350, 230, 300, 30);//coddetails
		setLabel("paymentdetails",mainPanel,"Please have "/*+total*/+" tk at ready.","",300, 250, 400, 30);//coddetails
		setLabel("menu",mainPanel,"","",405, 285, 170, 30);//go to menu
		setLabel("bg",mainPanel, "", "res\\BoughtCOD.png", 0, 0, 1000, 600);//bg


		this.setVisible(true);
	}


	public void setLabel(String selectedLabel,JPanel setPanel,String setText,String imageDirectory,int x_axis,int y_axis,int width,int height) {
		JLabel jlabel=new JLabel(new ImageIcon(imageDirectory));
		jlabel.setText(setText);
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
	     new BoughtCOD();
	    }
    
	    
}