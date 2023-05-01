package utils;

import javax.swing.*;

public class validator extends JFrame {
    public boolean validate(String username, String password){
        if (username.equals("") || password.equals("")) {
            JOptionPane.showMessageDialog(this, "Please fill all the fields");
            return false;
        }

        // username validation
        if (username.contains(" ")) {
            JOptionPane.showMessageDialog(this, "Username cannot contain spaces");
            return false;
        }

        if (username.length() < 4) {
            JOptionPane.showMessageDialog(this, "Username must be at least 4 characters long");
            return false;
        }

        // password validation [cannot contain spaces. Can use only letters and numbers
        // and must be at least 8 characters long]
        if (password.contains(" ")) {
            JOptionPane.showMessageDialog(this, "Password cannot contain spaces");
            return false;
        }

        if (password.contains(",") || password.contains("=") || password.contains(";")) {
            JOptionPane.showMessageDialog(this, "Password cannot contain , = ;");
            return false;
        }

        if (password.length() < 8) {
            JOptionPane.showMessageDialog(this, "Password must be at least 8 characters long");
            return false;
        }

        if (!password.matches(".*[a-zA-Z]+.*")) {
            JOptionPane.showMessageDialog(this, "Password must contain at least one letter");
            return false;
        }

        if (!password.matches(".*[0-9]+.*")) {
            JOptionPane.showMessageDialog(this, "Password must contain at least one number");
            return false;
        }

        return true;
    }
}
