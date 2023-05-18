package GUI;


import javax.swing.*;
import java.awt.*;

public class ButtonDesigner {
    private JLabel label;

   public ButtonDesigner(String text, Color textColor, Color backgroundColor, Color hoverColor, int fontSize){
        label = new JLabel(text);
        label.setForeground(textColor);
        label.setBackground(backgroundColor);
        label.setOpaque(true);
        label.setFont(new Font("Tahoma", Font.BOLD, fontSize));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        //action listener for avatarIconLabel hover
        label.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                //make the background color darker
                label.setBackground(hoverColor);
                //change cursor to pointer
                label.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                //reset the background color
                label.setBackground(backgroundColor);
                //change cursor to default
                label.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

    }

    public JLabel getLabel(){
        return label;
    }
}
