package Validator;

import javax.swing.*;

public class Validator extends JFrame {
    public boolean validate(String username, String password){
        if (username.equals("") || password.equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill all the fields");
            return false;
        }

        // username validation
        if (username.contains(" ")) {
            JOptionPane.showMessageDialog(null, "Username cannot contain spaces");
            return false;
        }

        if (username.length() < 4) {
            JOptionPane.showMessageDialog(null, "Username must be at least 4 characters long");
            return false;
        }

        return validatePassword(password);
    }

    public boolean validateAll(String[] fields){
        for (String field : fields){
            if (field.equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill all the fields");
                return false;
            }
        }
        return true;
    }

    public boolean validatePassword(String password){
        // password validation [cannot contain spaces. Can use only letters and numbers
        if (password.equals("")) {
            JOptionPane.showMessageDialog(null, "Please fillup the form");
            return false;
        }
        // and must be at least 8 characters long]
        if (password.contains(" ")) {
            JOptionPane.showMessageDialog(null, "Password cannot contain spaces");
            return false;
        }

        if (password.contains(",") || password.contains("=") || password.contains(";")) {
            JOptionPane.showMessageDialog(null, "Password cannot contain , = ;");
            return false;
        }

        if (password.length() < 8) {
            JOptionPane.showMessageDialog(null, "Password must be at least 8 characters long");
            return false;
        }

        if (!password.matches(".*[a-zA-Z]+.*")) {
            JOptionPane.showMessageDialog(null, "Password must contain at least one letter");
            return false;
        }

        if (!password.matches(".*[0-9]+.*")) {
            JOptionPane.showMessageDialog(null, "Password must contain at least one number");
            return false;
        }

        return true;
    }
}
