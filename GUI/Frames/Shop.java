package GUI.Frames;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;

import Database.Database;
import GUI.Checkpoint.DefaultPage;
import Types.Product;

public class Shop extends JFrame{
	
	private JPanel mainPanel,productPanel,notificationPanel;

	
	Shop(){
		
		//frameStart();

		
	}
	
	
	public void jlabel(JPanel setPanel,String setText,String imageDirectory,int x_axis,int y_axis,int width,int height) {
		JLabel jlabel=new JLabel();
		jlabel = new JLabel("");
        jlabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

             
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
        jlabel.setBounds(751, 530, 165, 34);
        mainPanel.add(jlabel);
		
	}
	
	public void frameStart() {
		setTitle("Shopping");
        setSize(new Dimension(1016,638));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_HORIZ);
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        this.setBounds(0,0,1016,637);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
	}
	
	 public static void main(String[] args){
	     new Shop();
	    }

}
